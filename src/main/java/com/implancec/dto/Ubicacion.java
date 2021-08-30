package com.implancec.dto;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ubicacion {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    private Date fecha;

    private double geo_lat;

    private double geo_lng;

    @ManyToOne
    @JoinColumn(name = "id_afiliado")
    private Afiliado afiliado;

    public Ubicacion() {
    }

    public Ubicacion(Long id, Date fecha, double geo_lat, double geo_lng, Afiliado afiliado) {
        this.id = id;
        this.fecha = fecha;
        this.geo_lat = geo_lat;
        this.geo_lng = geo_lng;
        this.afiliado = afiliado;
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

    public double getGeo_lat() {
        return geo_lat;
    }

    public void setGeo_lat(double geo_lat) {
        this.geo_lat = geo_lat;
    }

    public double getGeo_lng() {
        return geo_lng;
    }

    public void setGeo_lng(double geo_lng) {
        this.geo_lng = geo_lng;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ubicacion ubicacion = (Ubicacion) o;
        return Double.compare(ubicacion.geo_lat, geo_lat) == 0 && Double.compare(ubicacion.geo_lng, geo_lng) == 0 && Objects.equals(id, ubicacion.id) && Objects.equals(fecha, ubicacion.fecha) && Objects.equals(afiliado, ubicacion.afiliado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, geo_lat, geo_lng, afiliado);
    }
}
