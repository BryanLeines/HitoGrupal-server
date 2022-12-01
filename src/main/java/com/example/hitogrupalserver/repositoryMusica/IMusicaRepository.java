package com.example.hitogrupalserver.repositoryMusica;

import com.example.hitogrupalserver.model.MusicaEntity;
import org.springframework.data.repository.CrudRepository;

public interface IMusicaRepository extends CrudRepository<MusicaEntity, Integer> {
}

