package com.example.examen_jpa_cascada.controller.dto;

import com.example.examen_jpa_cascada.entity.CabeceraFra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacturaOutputDto {

    private Long id;

    private double importeFra;

    private ClienteOutputDto clienteOutputDto;

    private List<LineaOutputDto> lineas;

}
