package com.implancec.controller;

import java.util.List;

import com.implancec.controller.exception.UbicacionNotFoundException;
import com.implancec.dao.UbicacionRepository;
import com.implancec.dto.Ubicacion;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UbicacionController {

    private final UbicacionRepository repository;

    UbicacionController(UbicacionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/ubicaciones")
    List<Ubicacion> all() {
        return repository.findAll();
    }

    @PostMapping("/ubicaciones")
    Ubicacion newUbicacion(@RequestBody Ubicacion newUbicacion) {
        return repository.save(newUbicacion);
    }

    // Single item
    @GetMapping("/ubicaciones/{id}")
    Ubicacion one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new UbicacionNotFoundException(id));
    }

//    @PutMapping("/ubicaciones/{id}")
//    Ubicacion replaceUbicacion(@RequestBody Ubicacion newUbicacion, @PathVariable Long id) {
//
//        return repository.findById(id)
//                .map(ubicacion -> {
//                    ubicacion.setCalle(newUbicacion.getCalle());
//                    ubicacion.setCodPost(newUbicacion.getCodPost());
//                    ubicacion.setDob(newUbicacion.getDob());
//                    return repository.save(ubicacion);
//                })
//                .orElseGet(() -> {
//                    newUbicacion.setId(id);
//                    return repository.save(newUbicacion);
//                });
//    }

    @DeleteMapping("/ubicaciones/{id}")
    void deleteUbicacion(@PathVariable Long id) {
        repository.deleteById(id);
    }
}