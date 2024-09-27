package com.kidou.notificacao_service.listener;

import com.kidou.notificacao_service.model.Pedido;
import com.kidou.notificacao_service.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    @Autowired
    private EmailService emailService;

    private final Logger logger = LoggerFactory.getLogger(PedidoListener.class);

    @RabbitListener(queues = "pedidos.v1.pedodo-criado-gerar-notificacao")
    public void enviarNotificacao(Pedido pedido){

        emailService.enviarEmail(pedido);

        logger.info("Notificacao gerada:{}",pedido.toString());
    }

}
