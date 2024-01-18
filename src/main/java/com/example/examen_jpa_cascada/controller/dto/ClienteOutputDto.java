package com.example.examen_jpa_cascada.controller.dto;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteOutputDto {

    private Long id;

    private String nombre;
}
