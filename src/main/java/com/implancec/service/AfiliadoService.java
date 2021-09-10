package com.implancec.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.implancec.dao.AfiliadoRepository;
import com.implancec.dto.Afiliado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AfiliadoService {

    private final AfiliadoRepository repository;

    @Autowired
    public AfiliadoService(AfiliadoRepository repository) {
        this.repository = repository;
    }

    public List<Afiliado> getAfiliadoList(Optional<String> nombre,
                                          Optional<Long> id,
                                          Optional<Integer> tipo) {
        List<Afiliado> afiliadoList = repository.getAll();

        if(id.isPresent()) {
            afiliadoList = afiliadoList.stream()
                    .filter(afiliado -> Objects.equals(afiliado.getId(), id.get()))
                    .collect(Collectors.toList());
        }

        if(nombre.isPresent()) {
            afiliadoList = afiliadoList.stream()
                    .filter(afiliado -> Objects.equals(afiliado.getName(), nombre.get()))
                    .collect(Collectors.toList());
        }

        if(tipo.isPresent()) {
            afiliadoList = afiliadoList.stream()
                    .filter(afiliado -> afiliado.getTipo() == (tipo.get()))
                    .collect(Collectors.toList());
        }

        return afiliadoList;
    }
}
