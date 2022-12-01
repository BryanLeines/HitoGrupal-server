package com.example.hitogrupalserver.repositoryCategoria;

import com.example.hitogrupalserver.model.CategoriaEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class CategoriaService {

    private ICategoriaRespository categoriaRepo;

    public CategoriaService(ICategoriaRespository categoriaRepo) {
        this.categoriaRepo = categoriaRepo;
    }

    //recoge las categorias de la base de datos
    public Iterable<CategoriaEntity> listaCategorias() {
        return categoriaRepo.findAll();
    }

}
