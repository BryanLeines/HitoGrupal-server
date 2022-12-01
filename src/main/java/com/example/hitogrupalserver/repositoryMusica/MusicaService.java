package com.example.hitogrupalserver.repositoryMusica;

import com.example.hitogrupalserver.model.MusicaEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class MusicaService {

    private IMusicaRepository musicaRepo;

    public MusicaService(IMusicaRepository musicaRepo) {
        this.musicaRepo = musicaRepo;
    }


    //Guarda el usuario en la base de datos
    public void guardarMusica(MusicaEntity musica) {
        musicaRepo.save(musica);
    }

}
