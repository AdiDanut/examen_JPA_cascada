package com.example.examen_jpa_cascada.repository;

import com.example.examen_jpa_cascada.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Long> {
}
