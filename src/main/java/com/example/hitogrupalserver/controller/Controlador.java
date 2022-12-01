package com.example.hitogrupalserver.controller;

import com.example.hitogrupalserver.model.UsuarioEntity;
import com.example.hitogrupalserver.repositoryUsuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {

    @Autowired private UsuarioService usuarioService;
    @RequestMapping("/")
    public String index(){

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNombre("juan");
        usuario.setEmail("juan@gmail.com");
        usuario.setPassw("1234");


        usuarioService.guardarUsuario(usuario);

        return "index";
    }

}
