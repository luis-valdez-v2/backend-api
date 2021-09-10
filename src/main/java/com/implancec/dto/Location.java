package com.implancec.dto;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Location {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    private OffsetDateTime date;

    private double geo_lat;

    private double geo_lng;

    @ManyToOne
    @JoinColumn(name = "id_afiliado")
    private Afiliado afiliado;

    public Location() {
    }

    public Location(Long id, OffsetDateTime date, double geo_lat, double geo_lng, Afiliado afiliado) {
        this.id = id;
        this.date = date;
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

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime fecha) {
        this.date = fecha;
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
        Location location = (Location) o;
        return Double.compare(location.geo_lat, geo_lat) == 0 && Double.compare(location.geo_lng, geo_lng) == 0 && Objects.equals(id, location.id) && Objects.equals(date, location.date) && Objects.equals(afiliado, location.afiliado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, geo_lat, geo_lng, afiliado);
    }
}
