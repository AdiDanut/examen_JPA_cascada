package com.example.examen_jpa_cascada.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CabeceraFra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cli_codi")
    private Cliente cliente;

    @OneToMany(mappedBy="cabeceraFra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineasFra> lineas;

    private double importeFra;

}
