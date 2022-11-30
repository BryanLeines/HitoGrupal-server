package com.example.hitogrupalserver.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "musica", schema = "hito", catalog = "")
public class MusicaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "audio")
    private String audio;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "tipo")
    private String tipo;

   /* @Basic
    @Column(name = "idcategoria")
    private Integer idcategoria;

    @Basic
    @Column(name = "idusuario")
    private Integer idusuario;*/

    @Basic
    @Column(name = "valoracion")
    private Integer valoracion;

    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private CategoriaEntity idcategoria;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private UsuarioEntity idusuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public CategoriaEntity getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer CategoriaEntity) {
        this.idcategoria = idcategoria;
    }

    public UsuarioEntity getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(UsuarioEntity idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicaEntity that = (MusicaEntity) o;
        return id == that.id && Objects.equals(audio, that.audio) && Objects.equals(nombre, that.nombre) && Objects.equals(tipo, that.tipo) && Objects.equals(idcategoria, that.idcategoria) && Objects.equals(idusuario, that.idusuario) && Objects.equals(valoracion, that.valoracion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, audio, nombre, tipo, idcategoria, idusuario, valoracion);
    }
}
