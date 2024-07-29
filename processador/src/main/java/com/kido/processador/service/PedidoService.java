package com.kido.processador.service;

import com.kido.processador.model.Pedido;
import com.kido.processador.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ItemPedidoService itemPedidoService;

    private final Logger logger = LoggerFactory.getLogger(PedidoService.class);


    public void  save (Pedido pedido){

        pedidoRepository.save(pedido);
        logger.info("Pedido Salvo: {}",pedido);
    }
}
