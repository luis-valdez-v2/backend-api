package com.implancec.dao;

import java.util.List;

import com.implancec.dto.Servicio;
import com.implancec.dto.Solicitud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    @Query(value = "SELECT * FROM servicio", nativeQuery = true)
    List<Servicio> getAll();
}
