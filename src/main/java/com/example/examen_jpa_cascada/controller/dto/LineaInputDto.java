package com.example.examen_jpa_cascada.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LineaInputDto {

    private String producto;

    private double cantidad;

    private double precio;

    private Long idFra;
}
