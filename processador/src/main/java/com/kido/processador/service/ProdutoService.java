package com.kido.processador.service;

import com.kido.processador.model.ItemPedido;
import com.kido.processador.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public void save(List<ItemPedido> itemPedidos) {
        itemPedidos.forEach(item->{
            produtoRepository.save(item.getProduto());
        });
    }
}
