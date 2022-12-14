package com.example.hitogrupalserver.controller;

import com.example.hitogrupalserver.model.MusicaEntity;
import com.example.hitogrupalserver.model.UsuarioEntity;
import com.example.hitogrupalserver.repositoryCategoria.CategoriaService;
import com.example.hitogrupalserver.repositoryMusica.MusicaService;
import com.example.hitogrupalserver.repositoryUsuario.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class Controlador {

    private Login login;
    @Autowired private UsuarioService usuarioService;
    @Autowired private MusicaService musicaService;
    @Autowired private CategoriaService categoriaService;
    @Autowired public void setLogin(Login login) {this.login = login;}



    /*-----------------------------------------------------------------------------------------Ruta inicial-----------------------------*/
    //te lleva a la pagina principal
    @RequestMapping("/")
    public String index(ModelMap model){

        model.addAttribute("usuarioActual", login.getLogin());

        return "index";
    }

    /*--------------------------------------------------------------- Funciones que tienen que ver con el Usuario ----------------*/
    //te lleva al Formulario de registro
    @RequestMapping("/loginRegister")
    public String loginRegister(ModelMap model){

        model.addAttribute("loginRegister", new UsuarioEntity());

        return "loginRegister";
    }

    @PostMapping("/comprobarRegistro") //Comprobar si el Usuario existe, si no existe, se registra
    public String ComprobarRegistro(UsuarioEntity user) {

        //comprobar si el usuario esta registrado en la base de datos(comprobando si el email existe)
        //si no esta registrado, se registra
        if(usuarioService.findByEmail(user.getEmail())){
            System.out.println("El Correo: "+user.getEmail()+" ya existe");

            return "redirect:/loginRegister"; // lo reenvio a la ruta 'loginRegister'
        }
        else{
            System.out.println("El usuario no existe");
            usuarioService.guardarUsuario(user); //Guarda el Usuario en la base de datos
            inicarUsuarioLogin(user);
            return "redirect:/"; // lo reenvio a la ruta '/'
        }
    }

    @RequestMapping("/comprobarLogin")//comprobar si el usuario existe, si no existe se le redirige a la pagina de registerLogin
    public String ComprobarLogin(UsuarioEntity user) {

        //comprobar si el usuario esta registrado en la base de datos (comprobando si el email existe)
        //que pueda introducir el email o el nombre del usuario //comprobar si la contrase??a es correcta
        if(usuarioService.confirmarUsuario(user.getIniciar(), user.getPassw())){

            this.login.setLogin(usuarioService.findUsuario(user.getIniciar()));
            return "redirect:/"; // lo reenvio a la ruta '/'

        }
        else{
            System.out.println("El usuario no existe");
            return "redirect:/loginRegister"; // lo reenvio a la ruta 'loginRegister'
        }
    }

    private void inicarUsuarioLogin(UsuarioEntity user){this.login.setLogin(user);} //crea el login

    @RequestMapping("/cerrarSesion")
    public void peticionCerrar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        this.login.setLogin(null);
        response.sendRedirect("/");
    }

    /*--------------------------------------------------------------- Funciones que tienen que ver con las canciones ----------------*/
    @RequestMapping("/addMusic")
    public String addMusic(ModelMap model){

        model.addAttribute("loginRegister", new UsuarioEntity());

        return "loginRegister";
    }

    @RequestMapping("/myMusic")
    public String myMusic(ModelMap model){

        model.addAttribute("loginRegister", new UsuarioEntity());

        return "loginRegister";
    }

    @RequestMapping("/allMusic")
    public String allMusic(ModelMap model){

        model.addAttribute("usuarioActual", login.getLogin());
        model.addAttribute("allMusic", musicaService.mostrarMusica());

        return "allmusic";
    }

}
