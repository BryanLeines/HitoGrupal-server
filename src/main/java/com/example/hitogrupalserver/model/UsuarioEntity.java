package com.example.hitogrupalserver.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "usuario", schema = "hito", catalog = "")
public class UsuarioEntity {

    @Transient
    private String iniciar;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "contraseña")
    private String passw;

    @OneToMany(mappedBy = "id")
    private Collection<MusicaEntity> musicas;

    public String getIniciar() {
        return iniciar;
    }

    public void setIniciar(String iniciar) {
        this.iniciar = iniciar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String contraseña) {
        this.passw = contraseña;
    }


    public Collection<MusicaEntity> getMusicas() {
        return musicas;
    }

    public void setMusicas(Collection<MusicaEntity> musicas) {
        this.musicas = musicas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(email, that.email) && Objects.equals(passw, that.passw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, email, passw);
    }
}
