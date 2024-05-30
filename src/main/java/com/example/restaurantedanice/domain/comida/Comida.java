package com.example.restaurantedanice.domain.comida;

import com.example.restaurantedanice.domain.comida.dtos.AtualizacaoComidaDTO;
import com.example.restaurantedanice.domain.comida.dtos.CadastroComidaDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Table(name = "comidas")
@Entity(name = "Comida")
public class Comida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String imagem;
    private Double preco;
    private boolean ativo;

    public Comida(CadastroComidaDTO dados) {
        this.titulo = dados.titulo();
        this.imagem = dados.imagem();
        this.preco = dados.preco();
        this.ativo = true;
    }

    public void atualizarDados(AtualizacaoComidaDTO dados) {

        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.imagem() != null) {
            this.imagem = dados.imagem();
        }
        if (dados.preco() != null) {
            this.preco = dados.preco();
        }


    }

    public Comida(String titulo, String imagem, Double preco, boolean ativo) {
        this.titulo = titulo;
        this.imagem = imagem;
        this.preco = preco;
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comida comida = (Comida) o;
        return Objects.equals(id, comida.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Comida() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
