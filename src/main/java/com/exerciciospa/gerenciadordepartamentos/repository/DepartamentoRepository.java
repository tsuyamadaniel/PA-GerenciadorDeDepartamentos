package com.exerciciospa.gerenciadordepartamentos.repository;

import com.exerciciospa.gerenciadordepartamentos.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}