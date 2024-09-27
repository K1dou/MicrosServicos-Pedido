package com.kidou.notificacao_service.service;

import com.kidou.notificacao_service.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;


    public void enviarEmail(Pedido pedido) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("hique1276@gmail.com");
        simpleMailMessage.setTo(pedido.getEmailNotificacao());
        simpleMailMessage.setSubject("Pedido de compra");
        simpleMailMessage.setText(this.gerarMensagem(pedido));
        mailSender.send(simpleMailMessage);
    }

    private String gerarMensagem(Pedido pedido) {
        String pedidoId = pedido.getId().toString();
        String cliente = pedido.getCliente();
        String valor = pedido.getValorTotal().toString();
        String status = pedido.getStatus().name();
        return String.format("Ola %s seu pedido de numero %s no valor de %s, foi realizado com sucesso. \n Status: %s",cliente,pedidoId,valor,status);
    }

}
