package com.implancec.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Servicio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;

    private String observacion;

    private int codMaterial;

    private int cantidad;

    private int puntosAfiliado;

    private int puntosRecolector;

    @ManyToOne
    @JoinColumn(name = "solicitud_id")
    private Solicitud solicitud;

    @ManyToOne
    @JoinColumn(name = "id_recolector")
    private Afiliado recolector;

    public Servicio() {

    }

    public Servicio(Long id, Date fecha, String observacion, int cod_material, int cantidad, int puntos_afiliado, int puntos_recolector, Solicitud solicitud, Afiliado recolector) {
        this.id = id;
        this.fecha = fecha;
        this.observacion = observacion;
        this.codMaterial = cod_material;
        this.cantidad = cantidad;
        this.puntosAfiliado = puntos_afiliado;
        this.puntosRecolector = puntos_recolector;
        this.solicitud = solicitud;
        this.recolector = recolector;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
