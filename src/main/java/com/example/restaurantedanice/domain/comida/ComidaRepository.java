package com.example.restaurantedanice.domain.comida;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComidaRepository extends JpaRepository<Comida, Long> {

    @Query("""
        SELECT c.comida
                FROM pedido p
                JOIN pedidos_comidas t ON p.id = t.pedido_id
                JOIN comidas c ON t.comida_id = c.id
                WHERE p.id = :id
""")
    List<Long> pegarTodasAsComidasPeloIdDoPedido(Long id);

}
