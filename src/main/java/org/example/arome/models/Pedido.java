package org.example.arome.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "ID do pedido", example = "1")
    private int id;
    @Schema(description = "ID do cliente", example = "1")
    private int id_cliente;
    @Schema(description = "ID do produto", example = "1")
    private int id_produto;
    @Schema(description = "Valor total do pedido", example = "100.00")
    private double valor_total;
    @Schema(description = "ID do pagamento", example = "1")
    private int id_pagto;
    @Schema(description = "ID do cartão de crédito", example = "1")
    private int id_cartao;
    @Schema(description = "ID do endereço de entrega", example = "1")
    private int id_endereco;
    @Schema(description = "Status do pedido", example = "false")
    private boolean pedido_feito;

    public Pedido() {
    }

    public int getId() {
        return  id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public int getId_pagto() {
        return id_pagto;
    }

    public void setId_pagto(int id_pagto) {
        this.id_pagto = id_pagto;
    }

    public int getId_cartao() {
        return id_cartao;
    }

    public void setId_cartao(int id_cartao) {
        this.id_cartao = id_cartao;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public boolean isPedido_feito() {
        return pedido_feito;
    }

    public void setPedido_feito(boolean pedido_feito) {
        this.pedido_feito = pedido_feito;
    }


}
