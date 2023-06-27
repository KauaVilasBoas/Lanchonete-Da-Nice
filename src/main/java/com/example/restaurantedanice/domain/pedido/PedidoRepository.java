package com.example.restaurantedanice.domain.pedido;

import com.example.restaurantedanice.domain.comida.Comida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

//    Page<Pedido> findAllByStatusEquals(String string);
    @Query("SELECT p.comidas FROM pedido p WHERE p.id = :pedidoId")
    List<Comida> findComidasByPedidoId(Long pedidoId);

}
