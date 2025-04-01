package org.example.arome.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do produto", example = "1")
    private int id;
    @Schema(description = "Nome do produto", example = "Mouse Gamer")
    private String nome;
    @Schema(description = "Tipo do produto", example = "Laranja")
    private String tipo;
    @Schema(description = "Preço do produto", example = "120.99")
    private double preco;
    @Schema(description = "Quantidade em estoque", example = "100")
    private int qt_estoque;
    @Schema(description = "Descrição do produto", example = "Mouse gamer leve e de alta qualidade, ideal para jogos de computador.")
    private String descricao;
    @Schema(description = "URL da imagem do produto", example = "https://www.example.com/imagem.jpg")
    private String url_imagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQt_estoque() {
        return qt_estoque;
    }

    public void setQt_estoque(int qt_estoque) {
        this.qt_estoque = qt_estoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl_imagem() {
        return url_imagem;
    }

    public void setUrl_imagem(String url_imagem) {
        this.url_imagem = url_imagem;
    }
}
