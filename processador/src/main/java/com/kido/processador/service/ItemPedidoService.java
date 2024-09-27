package com.kido.processador.service;

import com.kido.processador.repository.ItemPedidoRepository;
import com.kido.processador.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itempedidoRepository;
}
