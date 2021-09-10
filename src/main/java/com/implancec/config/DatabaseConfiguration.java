package com.implancec.config;

import com.implancec.dao.AfiliadoRepository;
import com.implancec.dao.ServicioRepository;
import com.implancec.dao.SolicitudRepository;
import com.implancec.dto.Servicio;
import com.implancec.utils.AfiliadoUtils;
import com.implancec.utils.SolicitudUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {

    private static final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);

    private final SolicitudUtils solicitudUtils;

    @Autowired
    public DatabaseConfiguration(SolicitudUtils solicitudUtils) {
        this.solicitudUtils = solicitudUtils;
    }

    @Bean
    CommandLineRunner initDatabase(AfiliadoRepository afiliadoRepository,
                                   SolicitudRepository solicitudRepository,
                                   ServicioRepository servicioRepository) {

        return args -> {
//            SolicitudUtils solicitudUtils = new SolicitudUtils(afiliadoRepository, solicitudRepository);
//            Servicio servicio = solicitudUtils.createServicio();
//            System.out.println(servicio);
//            servicioRepository.save(servicio);
        };
    }
}