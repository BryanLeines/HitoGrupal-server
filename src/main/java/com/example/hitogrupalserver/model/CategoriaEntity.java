package com.example.hitogrupalserver.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "categoria", schema = "hito", catalog = "")
public class CategoriaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "genero")
    private String genero;

    @OneToMany(mappedBy = "id")
    private Collection<MusicaEntity> musicasC;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    public Collection<MusicaEntity> getMusicasC() {
        return this. musicasC;
    }

    public void setMusicasC(Collection<MusicaEntity> musicasC) {
        this.musicasC = musicasC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaEntity that = (CategoriaEntity) o;
        return id == that.id && Objects.equals(genero, that.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genero);
    }
}
