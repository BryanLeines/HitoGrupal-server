package com.example.hitogrupalserver.controller;

import com.example.hitogrupalserver.model.MusicaEntity;
import com.example.hitogrupalserver.model.UsuarioEntity;
import com.example.hitogrupalserver.repositoryMusica.MusicaService;
import com.example.hitogrupalserver.repositoryUsuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {

    @Autowired private UsuarioService usuarioService;
    @Autowired private MusicaService musicaService;


    @RequestMapping("/")
    public String index(){

        MusicaEntity musica = new MusicaEntity();
        musica.setNombre("Blood//Water");


        musicaService.guardarMusica(musica);

        return "index";
    }

}
