package com.implancec.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.implancec.dao.ServicioRepository;
import com.implancec.dto.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioService {

    public final ServicioRepository repository;

    @Autowired
    public ServicioService(ServicioRepository repository) {
        this.repository = repository;
    }

    public List<Servicio> getServicioList(Optional<Long> folio,
                                          Optional<Integer> codMaterial,
                                          Optional<Long> idRecolector,
                                          Optional<Long> idSolicitud) {
        List<Servicio> servicioList = repository.getAll();

        if(folio.isPresent()) {
            servicioList = servicioList.stream()
                    .filter(servicio -> Objects.equals(servicio.getSolicitud().getFolio(), folio.get()))
                    .collect(Collectors.toList());
        }

        if(codMaterial.isPresent()) {
            servicioList = servicioList.stream()
                    .filter(servicio -> servicio.getCodMaterial() == (codMaterial.get()))
                    .collect(Collectors.toList());
        }

        if(idRecolector.isPresent()) {
            servicioList = servicioList.stream()
                    .filter(servicio -> Objects.equals(servicio.getRecolector().getId(), idRecolector.get()))
                    .collect(Collectors.toList());
        }

        if(idSolicitud.isPresent()) {
            servicioList = servicioList.stream()
                    .filter(servicio -> servicio.getSolicitud().getFolio().equals(idSolicitud.get()))
                    .collect(Collectors.toList());
        }
        return servicioList;
    }
}
