package com.implancec.utils;

import java.sql.Time;
import java.util.Date;

import com.implancec.dao.AfiliadoRepository;
import com.implancec.dto.Solicitud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SolicitudUtils {

    private final AfiliadoRepository afiliadoRepository;

    @Autowired
    SolicitudUtils(AfiliadoRepository afiliadoRepository) {
        this.afiliadoRepository = afiliadoRepository;
    }

    public Solicitud createDummySolicitud() {
        return new Solicitud(new Date(), new Date(), new Time(1L), 1, afiliadoRepository.getById(1L));
    }
}
