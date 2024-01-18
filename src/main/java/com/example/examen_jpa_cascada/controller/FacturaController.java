package com.example.examen_jpa_cascada.controller;

import com.example.examen_jpa_cascada.controller.dto.FacturaOutputDto;
import com.example.examen_jpa_cascada.controller.dto.LineaInputDto;
import com.example.examen_jpa_cascada.service.impl.FacturaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping("/factura")
    public ResponseEntity<List<FacturaOutputDto>> getFacturas(){
        return ResponseEntity.ok(facturaService.getFacturas());
    }

    @PostMapping("/factura/linea/{idFra}")
    public ResponseEntity<FacturaOutputDto> addLineaToFra(@PathVariable Long idFra, @RequestBody LineaInputDto lineaInputDto){
        return ResponseEntity.ok(facturaService.addLineToFra(lineaInputDto, idFra));
    }

    @DeleteMapping("/factura/{idFra}")
    public ResponseEntity<String> deleteFactura(@PathVariable Long idFra){
        return ResponseEntity.ok(facturaService.deleteFactura(idFra));
    }
}
