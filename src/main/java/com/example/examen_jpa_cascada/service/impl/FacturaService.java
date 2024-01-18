package com.example.examen_jpa_cascada.service.impl;

import com.example.examen_jpa_cascada.controller.dto.FacturaOutputDto;
import com.example.examen_jpa_cascada.controller.dto.LineaInputDto;
import com.example.examen_jpa_cascada.entity.Cliente;

import java.util.List;

public interface FacturaService {

    List<FacturaOutputDto> getFacturas();

    String deleteFactura(Long idFactura);

    FacturaOutputDto addLineToFra(LineaInputDto lineaInputDto, Long idFra);

    void insertarFacturaDePrueba(Cliente cliente);
}
