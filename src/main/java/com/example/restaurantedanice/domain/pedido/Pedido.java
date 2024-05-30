package com.example.restaurantedanice.domain.pedido;

import com.example.restaurantedanice.domain.cliente.Cliente;
import com.example.restaurantedanice.domain.comida.Comida;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity(name = "pedido")
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Cliente cliente;
    @ManyToMany
    private List<Comida> comidas;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataHora;
    @Enumerated(EnumType.STRING)
    private Status status;
    private boolean ativo;
    private Double precoTotal;

    public Pedido(Cliente cliente, List<Comida> comidasList) {

        this.cliente = cliente;
        this.comidas = comidasList;
        this.dataHora = LocalDateTime.now();
        this.status = Status.PREPARANDO;
        this.ativo = true;
        this.precoTotal = comidasList.stream().mapToDouble(Comida::getPreco).sum();

    }

    public Pedido(Cliente cliente, List<Comida> comidas, LocalDateTime dataHora, Status status, boolean ativo, Double precoTotal) {
        this.cliente = cliente;
        this.comidas = comidas;
        this.dataHora = dataHora;
        this.status = status;
        this.ativo = ativo;
        this.precoTotal = precoTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
    }

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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
