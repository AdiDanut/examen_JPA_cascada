package com.example.examen_jpa_cascada.service;

import com.example.examen_jpa_cascada.controller.dto.ClienteOutputDto;
import com.example.examen_jpa_cascada.controller.dto.FacturaOutputDto;
import com.example.examen_jpa_cascada.controller.dto.LineaInputDto;
import com.example.examen_jpa_cascada.controller.dto.LineaOutputDto;
import com.example.examen_jpa_cascada.entity.CabeceraFra;
import com.example.examen_jpa_cascada.entity.Cliente;
import com.example.examen_jpa_cascada.entity.LineasFra;
import com.example.examen_jpa_cascada.repository.CabeceraFraRepo;
import com.example.examen_jpa_cascada.repository.LineasFraRepo;
import com.example.examen_jpa_cascada.service.impl.FacturaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private CabeceraFraRepo cabeceraFraRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LineasFraRepo lineaFraRepo;

    @Override
    public List<FacturaOutputDto> getFacturas() {
        List<CabeceraFra> cabeceraFraList = cabeceraFraRepo.findAll();
        List<FacturaOutputDto> facturaOutputDtoList = new ArrayList<>();
        cabeceraFraList.forEach(cabeceraFra -> {
            facturaOutputDtoList.add(modelMapper.map(cabeceraFra, FacturaOutputDto.class));
        });
        return facturaOutputDtoList;
    }

    @Override
    public String deleteFactura(Long idFactura) {
        cabeceraFraRepo.deleteById(idFactura);
        return "La factura se ha borrado correctamente";
    }


    public FacturaOutputDto addLineToFra(LineaInputDto lineaInputDto, Long idFra) {
        Optional<CabeceraFra> cabeceraFraOptional = cabeceraFraRepo.findById(idFra);

        if (cabeceraFraOptional.isPresent()) {
            CabeceraFra cabeceraFra = cabeceraFraOptional.get();
            LineasFra linea = modelMapper.map(lineaInputDto, LineasFra.class);
            linea.setCabeceraFra(cabeceraFra);
            cabeceraFra.getLineas().add(linea);
            cabeceraFra.setImporteFra(calculateImporteFra(cabeceraFra.getLineas()));

            cabeceraFraRepo.save(cabeceraFra);

            FacturaOutputDto facturaOutputDto = new FacturaOutputDto();

            facturaOutputDto.setImporteFra(cabeceraFra.getImporteFra());

            ClienteOutputDto clienteOutputDto = modelMapper.map(cabeceraFra.getCliente(), ClienteOutputDto.class);
            facturaOutputDto.setClienteOutputDto(clienteOutputDto);

            List<LineaOutputDto> lineaOutputDtos = new ArrayList<>();
            cabeceraFra.getLineas().forEach(lineasFra -> {
                lineaOutputDtos.add(modelMapper.map(lineasFra, LineaOutputDto.class));
            });
            facturaOutputDto.setLineas(lineaOutputDtos);

            facturaOutputDto.setId(cabeceraFra.getId());

            return facturaOutputDto;
        }
        return null;
    }

    private double calculateImporteFra(List<LineasFra> lineas) {
        return lineas.stream().mapToDouble(LineasFra::getPrecio).sum();
    }

    @Override
    public void insertarFacturaDePrueba(Cliente cliente) {
        CabeceraFra cabeceraFra = new CabeceraFra();
        cabeceraFra.setCliente(cliente);

        LineasFra linea1 = new LineasFra("Linea1", 5, 10);
        LineasFra linea2 = new LineasFra("Linea2", 5, 22);

        List<LineasFra> lineasFras = Arrays.asList(linea1, linea2);
        double importeFra = lineasFras.stream().mapToDouble(LineasFra::getPrecio).sum();

        cabeceraFra.setImporteFra(importeFra);
        cabeceraFra.setLineas(lineasFras);
        linea1.setCabeceraFra(cabeceraFra);
        linea2.setCabeceraFra(cabeceraFra);

        cabeceraFraRepo.save(cabeceraFra);
    }
}
