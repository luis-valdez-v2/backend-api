package com.implancec.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.implancec.dao.SolicitudRepository;
import com.implancec.dto.Solicitud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;

    @Autowired
    public SolicitudService(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    public List<Solicitud> getSolicitudList(Optional<Long> id, Optional<Integer> estado, Optional<Long> idAfiliado) {
        List<Solicitud> solicitudList = solicitudRepository.getAll();

        if(id.isPresent()) {
            solicitudList = solicitudList.stream()
                    .filter(solicitud -> solicitud.getId().equals(id.get()))
                    .collect(Collectors.toList());
        }

        if(estado.isPresent()) {
            solicitudList = solicitudList.stream()
                    .filter(solicitud -> solicitud.getEstado() == (estado.get()))
                    .collect(Collectors.toList());
        }

        if(idAfiliado.isPresent()) {
            solicitudList = solicitudList.stream()
                    .filter(solicitud -> solicitud.getAfiliado().getId().equals(idAfiliado.get()))
                    .collect(Collectors.toList());
        }
        return solicitudList;
    }
}
