package com.kido.processador.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kido.processador.model.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name ="pedido")
public class Pedido {

    @Id
    private UUID id = UUID.randomUUID();
    private String cliente;

    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL)
    private List<ItemPedido> itemPedidos = new ArrayList<>();


    private Double valorTotal;
    private String emailNotificacao;
    @Enumerated(EnumType.STRING)
    private Status status = Status.EM_PROCESSAMENTO;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHora = LocalDateTime.now();

    public LocalDateTime getDataHora() {
        return dataHora;
    }


    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Pedido() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItemPedidos() {
        return itemPedidos;
    }

    public void setItemPedidos(List<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getEmailNotificacao() {
        return emailNotificacao;
    }

    public void setEmailNotificacao(String emailNotificacao) {
        this.emailNotificacao = emailNotificacao;
    }
}
