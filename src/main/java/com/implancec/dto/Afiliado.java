package com.implancec.dto;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Afiliado {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    private String nombre;

    private Date dob;

    private String calle;

    private int extnum;

    private int intnum;

    private String colonia;

    private int codPost;

    private double geoLat;

    private double geoLng;

    private int tipo;

    private String email;

    private int phone;

    public Afiliado() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getExtnum() {
        return extnum;
    }

    public void setExtnum(int extnum) {
        this.extnum = extnum;
    }

    public int getIntnum() {
        return intnum;
    }

    public void setIntnum(int intnum) {
        this.intnum = intnum;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCodPost() {
        return codPost;
    }

    public void setCodPost(int codPost) {
        this.codPost = codPost;
    }

    public double getGeoLat() {
        return geoLat;
    }

    public void setGeoLat(double geo_lat) {
        this.geoLat = geo_lat;
    }

    public double getGeoLng() {
        return geoLng;
    }

    public void setGeoLng(double geo_lng) {
        this.geoLng = geo_lng;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Afiliado(String nombre, Date dob, String calle, int extnum, int intnum, String colonia, int codPost, double geoLat, double geoLng, int tipo, String email, int phone) {

        this.nombre = nombre;
        this.dob = dob;
        this.calle = calle;
        this.extnum = extnum;
        this.intnum = intnum;
        this.colonia = colonia;
        this.codPost = codPost;
        this.geoLat = geoLat;
        this.geoLng = geoLng;
        this.tipo = tipo;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Afiliado afiliado = (Afiliado) o;
        return extnum == afiliado.extnum && intnum == afiliado.intnum && codPost == afiliado.codPost && Double.compare(afiliado.geoLat, geoLat) == 0 && Double.compare(afiliado.geoLng, geoLng) == 0 && tipo == afiliado.tipo && phone == afiliado.phone && Objects.equals(id, afiliado.id) && Objects.equals(nombre, afiliado.nombre) && Objects.equals(dob, afiliado.dob) && Objects.equals(calle, afiliado.calle) && Objects.equals(colonia, afiliado.colonia) && Objects.equals(email, afiliado.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, dob, calle, extnum, intnum, colonia, codPost, geoLat, geoLng, tipo, email, phone);
    }
}
