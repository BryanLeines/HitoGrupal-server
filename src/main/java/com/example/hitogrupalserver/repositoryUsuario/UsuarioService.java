package com.example.hitogrupalserver.repositoryUsuario;

import com.example.hitogrupalserver.model.UsuarioEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class UsuarioService {

    private IUsuarioRepository usuarioRepo;

    public UsuarioService(IUsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }


    //Guarda el usuario en la base de datos
    public void guardarUsuario(UsuarioEntity user) {
        usuarioRepo.save(user);
    }



}
