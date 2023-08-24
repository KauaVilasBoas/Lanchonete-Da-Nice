package com.example.restaurantedanice.domain.pedido;

import com.example.restaurantedanice.domain.cliente.Cliente;
import com.example.restaurantedanice.domain.comida.Comida;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "pedido")
@Table(name = "pedidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Cliente cliente;
    @ManyToMany
    private List<Comida> comidas;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime data_hora;
    @Enumerated(EnumType.STRING)
    private Status status;
    private boolean ativo;
    private Double precoTotal;

    public Pedido(Cliente cliente, List<Comida> comidasList) {

        this.cliente = cliente;
        this.comidas = comidasList;
        this.data_hora = LocalDateTime.now();
        this.status = Status.PREPARANDO;
        this.ativo = true;
        this.precoTotal = comidasList.stream().mapToDouble(Comida::getPreco).sum();

    }

}
