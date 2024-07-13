package com.yhonrivera.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    private String nit;
    private String nombre;
    private String libre;
    private int estado;

    public Empresa() {
    }
    public Empresa(String nit) {
        this.nit = nit;
    }
    public Empresa(String nit, String nombre, String libre, int estado ) {
        this.nit = nit;
        this.nombre = nombre;
        this.libre = libre;
        this.estado = estado;
//        this.usuario = usuario;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLibre() {
        return libre;
    }

    public void setLibre(String libre) {
        this.libre = libre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

//    public List<Usuario> getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(List<Usuario> usuario) {
//        this.usuario = usuario;
//    }
//
//    @Override
//    public String toString() {
//        return "Empresa{" +
//                ", nit='" + nit + '\'' +
//                ", nombre='" + nombre + '\'' +
//                ", libre='" + libre + '\'' +
//                ", estado=" + estado +
//                ", usuario=" + usuario +
//                '}';
//    }
}
