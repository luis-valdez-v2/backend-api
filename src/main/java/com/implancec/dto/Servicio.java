package com.implancec.dto;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Servicio {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "solicitud_folio")
    private Solicitud solicitud;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_recolector")
    private Afiliado recolector;

    private OffsetDateTime fecha;

    private String observaciones;

    private int cantidad;

    private int puntosAfiliado;

    private int puntosRecolector;

    private int codMaterial;

    public Servicio() {

    }

    public Servicio(Long id, Solicitud solicitud, Afiliado recolector, OffsetDateTime fecha, String observaciones, int cantidad, int puntosAfiliado, int puntosRecolector, int codMaterial) {
        this.id = id;
        this.solicitud = solicitud;
        this.recolector = recolector;
        this.fecha = fecha;
        this.observaciones = observaciones;
        this.cantidad = cantidad;
        this.puntosAfiliado = puntosAfiliado;
        this.puntosRecolector = puntosRecolector;
        this.codMaterial = codMaterial;
    }

    public OffsetDateTime getFecha() {
        return fecha;
    }

    public void setFecha(OffsetDateTime fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observacion) {
        this.observaciones = observacion;
    }

    public int getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(int cod_material) {
        this.codMaterial = cod_material;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPuntosAfiliado() {
        return puntosAfiliado;
    }

    public void setPuntosAfiliado(int puntos_afiliado) {
        this.puntosAfiliado = puntos_afiliado;
    }

    public int getPuntosRecolector() {
        return puntosRecolector;
    }

    public void setPuntosRecolector(int puntos_recolector) {
        this.puntosRecolector = puntos_recolector;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Afiliado getRecolector() {
        return recolector;
    }

    public void setRecolector(Afiliado recolector) {
        this.recolector = recolector;
    }
}
