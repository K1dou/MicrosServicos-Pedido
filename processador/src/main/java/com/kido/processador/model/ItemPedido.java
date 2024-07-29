package com.kido.processador.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    private UUID id =UUID.randomUUID();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id",foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "produto_fk"))
    private Produto produto;
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "pedido_id",foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "pedido_fk"))
    private Pedido pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public ItemPedido() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
