package com.vinicius.ecommerce.services;

import com.vinicius.ecommerce.entities.Produto;
import com.vinicius.ecommerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    //    findAll
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

//    findById
    public Produto findById(Long id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.get();
    }
}
