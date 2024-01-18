package com.example.examen_jpa_cascada.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LineasFra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cabeceraFra_id")
    private CabeceraFra cabeceraFra;

    @Nonnull
    private String producto;

    private double cantidad;

    private double precio;

    public LineasFra(@Nonnull String proNomb, double cantidad, double precio) {
        this.producto = proNomb;
        this.cantidad = cantidad;
        this.precio = precio;
    }
}
