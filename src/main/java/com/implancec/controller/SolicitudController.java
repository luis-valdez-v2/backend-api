package com.implancec.controller;

import java.util.List;

import com.implancec.controller.exception.SolicitudNotFoundException;
import com.implancec.dao.SolicitudRepository;
import com.implancec.dto.Solicitud;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SolicitudController {

    private final SolicitudRepository repository;

    SolicitudController(SolicitudRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/solicitudes")
    List<Solicitud> all() {
        return repository.findAll();
    }

    @PostMapping("/solicitudes")
    Solicitud newSolicitud(@RequestBody Solicitud newSolicitud) {
        return repository.save(newSolicitud);
    }

    // Single item
    @GetMapping("/solicitudes/{id}")
    Solicitud one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new SolicitudNotFoundException(id));
    }

//    @PutMapping("/solicitudes/{id}")
//    Solicitud replaceSolicitud(@RequestBody Solicitud newSolicitud, @PathVariable Long id) {
//
//        return repository.findById(id)
//                .map(solicitud -> {
//                    solicitud.setCalle(newSolicitud.getCalle());
//                    solicitud.setCodPost(newSolicitud.getCodPost());
//                    solicitud.setDob(newSolicitud.getDob());
//                    return repository.save(solicitud);
//                })
//                .orElseGet(() -> {
//                    newSolicitud.setId(id);
//                    return repository.save(newSolicitud);
//                });
//    }

    @DeleteMapping("/solicitud/{id}")
    void deleteUbicacion(@PathVariable Long id) {
        repository.deleteById(id);
    }
}