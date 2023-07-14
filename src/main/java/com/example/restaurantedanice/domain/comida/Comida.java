package com.example.restaurantedanice.domain.comida;

import com.example.restaurantedanice.domain.comida.dtos.AtualizacaoComidaDTO;
import com.example.restaurantedanice.domain.comida.dtos.CadastroComidaDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "comidas")
@Entity(name = "Comida")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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
}
