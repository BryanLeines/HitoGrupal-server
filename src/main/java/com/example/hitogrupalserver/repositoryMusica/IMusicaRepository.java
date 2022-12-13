package com.example.hitogrupalserver.repositoryMusica;

import com.example.hitogrupalserver.model.MusicaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IMusicaRepository extends CrudRepository<MusicaEntity, Integer> {
    @Query("select m from MusicaEntity m where m.idusuario.id=?1")
    public List<MusicaEntity> mostrarMiMusica(int id_user);

    @Query("select m from MusicaEntity m where m.nombre=?1")
    public List<MusicaEntity> findByNombre(String nombre);

}

