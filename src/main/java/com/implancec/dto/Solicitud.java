package com.implancec.dto;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Solicitud {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long folio;

    private OffsetDateTime fechaRec;

    private OffsetDateTime fechaServ;

    private int estado;

    @ManyToOne
    @JoinColumn(name = "id_afiliado")
    private Afiliado afiliado;

    public Solicitud() {
    }

    public Solicitud(OffsetDateTime fechaRec, OffsetDateTime fechaServ, int estado, Afiliado afiliado) {
        this.fechaRec = fechaRec;
        this.fechaServ = fechaServ;
        this.estado = estado;
        this.afiliado = afiliado;
    }

    public Long getFolio() {
        return folio;
    }

    public void setFolio(Long folio) {
        this.folio = folio;
    }

    public OffsetDateTime getFechaRec() {
        return fechaRec;
    }

    public void setFechaRec(OffsetDateTime fechaRec) {
        this.fechaRec = fechaRec;
    }

    public OffsetDateTime getFechaServ() {
        return fechaServ;
    }

    public void setFechaServ(OffsetDateTime fechaServ) {
        this.fechaServ = fechaServ;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
