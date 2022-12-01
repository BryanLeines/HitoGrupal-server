package com.example.hitogrupalserver.repositoryUsuario;


import com.example.hitogrupalserver.model.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioRepository extends CrudRepository<UsuarioEntity, Integer> {}

