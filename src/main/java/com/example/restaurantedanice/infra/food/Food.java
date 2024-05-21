package com.example.restaurantedanice.infra.food;

import com.example.restaurantedanice.application.food.FoodUpdateDTO;
import com.example.restaurantedanice.application.food.FoodCreateDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "comidas")
@Entity(name = "Comida")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String imagem;
    private Double preco;
    private boolean ativo;

    public Food(FoodCreateDTO dados) {
        this.titulo = dados.titulo();
        this.imagem = dados.imagem();
        this.preco = dados.preco();
        this.ativo = true;
    }

    public void atualizarDados(FoodUpdateDTO dados) {

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
}
