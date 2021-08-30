package com.implancec.controller;

import java.util.List;

import com.implancec.controller.exception.ServicioNotFoundException;
import com.implancec.dao.ServicioRepository;
import com.implancec.dto.Servicio;

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

    ServicioController(ServicioRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/servicios")
    List<Servicio> all() {
        return repository.findAll();
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

