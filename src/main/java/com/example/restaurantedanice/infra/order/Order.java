package com.example.restaurantedanice.infra.order;

import com.example.restaurantedanice.infra.client.Client;
import com.example.restaurantedanice.infra.food.Food;
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
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Client client;
    @ManyToMany
    private List<Food> foods;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataHora;
    @Enumerated(EnumType.STRING)
    private Status status;
    private boolean ativo;
    private Double precoTotal;

    public Order(Client client, List<Food> comidasList) {

        this.client = client;
        this.foods = comidasList;
        this.dataHora = LocalDateTime.now();
        this.status = Status.PREPARANDO;
        this.ativo = true;
        this.precoTotal = comidasList.stream().mapToDouble(Food::getPreco).sum();

    }

}
