package com.implancec.dao;

import java.util.List;

import com.implancec.dto.Afiliado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AfiliadoRepository extends JpaRepository<Afiliado, Long> {
    @Query(value = "SELECT * FROM afiliado", nativeQuery = true)
    List<Afiliado> getAll();
}
