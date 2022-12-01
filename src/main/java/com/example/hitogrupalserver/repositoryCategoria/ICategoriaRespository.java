package com.example.hitogrupalserver.repositoryCategoria;

import com.example.hitogrupalserver.model.CategoriaEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICategoriaRespository extends CrudRepository<CategoriaEntity, Integer> {
}

