package com.yhonrivera.test.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rol;
    private int estado;
//    @OneToMany(targetEntity = Usuario.class,fetch = FetchType.LAZY,mappedBy = "roles")
//    private List<Usuario> usuarios;

    public Roles() {
    }

    public Roles(Long id, String rol, int estado) {
        this.id = id;
        this.rol = rol;
        this.estado = estado;
//        this.usuarios = usuarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getEstado() {
        return estado;
    }

//    public void setEstado(int estado) {
//        this.estado = estado;
//    }
//
//    public List<Usuario> getUsuarios() {
//        return usuarios;
//    }
//
//    public void setUsuarios(List<Usuario> usuarios) {
//        this.usuarios = usuarios;
//    }

//    @Override
//    public String toString() {
//        return "Rol{" +
//                "id=" + id +
//                ", rol='" + rol + '\'' +
//                ", estado=" + estado +
//                ", usuarios=" + usuarios +
//                '}';
//    }
}
