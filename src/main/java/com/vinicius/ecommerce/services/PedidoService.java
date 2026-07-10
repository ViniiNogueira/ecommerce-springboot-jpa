package com.vinicius.ecommerce.services;

import com.vinicius.ecommerce.entities.Pedido;
import com.vinicius.ecommerce.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

//      findAll
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    //    findById
    public Pedido findById(Long id) {
        Optional<Pedido> obj = pedidoRepository.findById(id);
        return obj.get();
    }
}
