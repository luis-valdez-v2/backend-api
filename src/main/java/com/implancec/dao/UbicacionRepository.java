package com.implancec.dao;

import com.implancec.dto.Location;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UbicacionRepository extends JpaRepository<Location, Long> {
}
