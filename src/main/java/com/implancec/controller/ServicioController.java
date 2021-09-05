package com.implancec.controller;

import java.util.List;
import java.util.Optional;

import com.implancec.controller.exception.ServicioNotFoundException;
import com.implancec.dao.ServicioRepository;
import com.implancec.dto.Servicio;
import com.implancec.service.ServicioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicioController {
    private final ServicioRepository repository;
    private final ServicioService service;

    @Autowired
    ServicioController(ServicioRepository repository, ServicioService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/servicios")
    List<Servicio> all(Optional<Long> id,
                       Optional<Integer> codMaterial,
                       Optional<Long> idRecolector,
                       Optional<Long> idSolicitud) {
        return service.getServicioList(id, codMaterial, idRecolector, idSolicitud);
    }

    @PostMapping("/servicios")
    Servicio newServicio(@RequestBody Servicio newServicio) {
        return repository.save(newServicio);
    }

    // Single item
    @GetMapping("/servicios/{id}")
    Servicio one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ServicioNotFoundException(id));
    }

    @PutMapping("/servicios/{id}")
    Servicio replaceServicio(@RequestBody Servicio newServicio, @PathVariable Long id) {

        return repository.findById(id)
                .map(servicio -> {
                    servicio.setRecolector(newServicio.getRecolector());
                    servicio.setCantidad(newServicio.getCantidad());
                    servicio.setFecha(newServicio.getFecha());
                    servicio.setCodMaterial(newServicio.getCodMaterial());
                    servicio.setObservacion(newServicio.getObservacion());
                    servicio.setPuntosAfiliado(newServicio.getPuntosAfiliado());
                    servicio.setPuntosRecolector(newServicio.getPuntosRecolector());
                    servicio.setSolicitud(newServicio.getSolicitud());
                    return repository.save(servicio);
                })
                .orElseGet(() -> {
                    newServicio.setId(id);
                    return repository.save(newServicio);
                });
    }

    @DeleteMapping("/servicios/{id}")
    void deleteServicio(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

