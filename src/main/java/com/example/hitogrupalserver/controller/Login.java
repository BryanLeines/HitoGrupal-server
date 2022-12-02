package com.example.hitogrupalserver.controller;

import com.example.hitogrupalserver.model.UsuarioEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class Login {
    private UsuarioEntity login;

    public Login() {
        this.login = null;
        // Sin inicio de sesión por el momento.
    }

    public UsuarioEntity getLogin() {
        return login;
    }

    public void setLogin(UsuarioEntity login) {
        this.login = login;
    }

}
