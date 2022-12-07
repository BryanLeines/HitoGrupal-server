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

    public UsuarioEntity findUsuario(String inicio){

        out:
        for(UsuarioEntity u: usuarioRepo.findAll()){
            if(u.getNombre().equals(inicio) || u.getEmail().equals(inicio)){
                return u;
            }
        }

        return null;
    }

    /*-------------- para Register --------------*/
    public Boolean findByEmail(String email){

        for(UsuarioEntity u: usuarioRepo.findAll()){
            if(u.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }


    /*-------------- para Login --------------*/
    public boolean confirmarUsuario(String inicio, String pssw){

        out:
        for(UsuarioEntity u: usuarioRepo.findAll()){
            if(u.getNombre().equals(inicio) || u.getEmail().equals(inicio)){
                if(u.getPassw().equals(pssw)){
                    return true;
                }
                else{
                    break out;
                }
            }
        }

        return false;
    }

    public void guardarUsuario(UsuarioEntity user) {
        usuarioRepo.save(user);
    }

}
