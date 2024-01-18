package com.example.examen_jpa_cascada.repository;

import com.example.examen_jpa_cascada.entity.LineasFra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineasFraRepo extends JpaRepository<LineasFra, Long> {
}
