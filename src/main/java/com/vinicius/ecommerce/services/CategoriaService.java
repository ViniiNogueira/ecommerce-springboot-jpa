package com.vinicius.ecommerce.services;

import com.vinicius.ecommerce.entities.Categoria;
import com.vinicius.ecommerce.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

//    findAll
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

//    findById
    public Categoria findById(Long id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.get();
    }
}
