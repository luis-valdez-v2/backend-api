package com.implancec.dao;

import java.time.Instant;
import java.util.List;

import com.implancec.dto.Solicitud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    @Query(value = "SELECT * FROM solicitud", nativeQuery = true)
    List<Solicitud> getAll();

    @Query(value = "select * from solicitud s where id_afiliado = :id", nativeQuery = true)
    List<Solicitud> getAll(int id);

    @Query(value = "select * from solicitud s WHERE s.id = :fl", nativeQuery = true)
    List<Solicitud> getByFolio(int fl);

    @Query(value = "select * from solicitud s WHERE s.fecha_serv BETWEEN :di AND :df", nativeQuery = true)
    List<Solicitud> getByFecha(Instant di, Instant df);
}
