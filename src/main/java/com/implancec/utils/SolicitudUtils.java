package com.implancec.utils;

import com.implancec.dao.AfiliadoRepository;
import com.implancec.dao.SolicitudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SolicitudUtils {

    private final AfiliadoRepository afiliadoRepository;
    private final SolicitudRepository solicitudRepository;

    @Autowired
    public SolicitudUtils(AfiliadoRepository afiliadoRepository, SolicitudRepository solicitudRepository) {
        this.afiliadoRepository = afiliadoRepository;
        this.solicitudRepository = solicitudRepository;
    }

//    public Servicio createServicio() {
//
////           Optional<Afiliado> afiliado = afiliadoRepository.findById(1L);
////        Optional<Solicitud> solicitud = solicitudRepository.findById(1L);
////
////        System.out.println("wwoewd");
////        return new Servicio(new ServicioId(
////                solicitud.orElse(null),
////                afiliado.orElse(null)),
////                OffsetDateTime.now(), "", 1, 1, 1, 1
////                );
////    }
}

