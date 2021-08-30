package com.implancec.dto;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Solicitud {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    private Date fechaRec;

    private Date fechaServ;

    private Time hora;

    private int estado;

    @ManyToOne
    @JoinColumn(name = "id_afiliado")
    private Afiliado afiliado;

    public Solicitud() {

    }

    public Solicitud(Date fechaRec, Date fechaServ, Time hora, int estado,Afiliado afiliado) {
        this.fechaRec = fechaRec;
        this.fechaServ = fechaServ;
        this.hora = hora;
        this.estado = estado;
        this.afiliado = afiliado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaRec() {
        return fechaRec;
    }

    public void setFechaRec(Date fechaRec) {
        this.fechaRec = fechaRec;
    }

    public Date getFechaServ() {
        return fechaServ;
    }

    public void setFechaServ(Date fechaServ) {
        this.fechaServ = fechaServ;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
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
