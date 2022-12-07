package com.example.hitogrupalserver.repositoryMusica;

import com.example.hitogrupalserver.model.MusicaEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.List;

@Service
@ApplicationScope
public class MusicaService {

    private IMusicaRepository musicaRepo;
    private List<MusicaEntity> listaMusica;

    public MusicaService(IMusicaRepository musicaRepo) {
        this.musicaRepo = musicaRepo;
        this.listaMusica = new ArrayList<>();
    }

    public List<MusicaEntity> mostrarMusica(){
        listaMusica.clear();
        for (MusicaEntity m: musicaRepo.findAll()) {
            this.listaMusica.add(m);
        }
        return this.listaMusica;
    }


    //Guarda el usuario en la base de datos
    public void guardarMusica(MusicaEntity musica) {
        musicaRepo.save(musica);
    }

}
