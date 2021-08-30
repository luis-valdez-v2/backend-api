package com.implancec.dao;

import com.implancec.dto.Solicitud;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
}
