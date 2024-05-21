package com.example.restaurantedanice.infra.order;

import com.example.restaurantedanice.infra.food.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

     Page<Order> findAllByAtivoTrue(Pageable pageable);

     List<Order> findAllByStatusEquals(Status status);

     @Query("SELECT p.comidas FROM pedido p WHERE p.id = :pedidoId")
     List<Food> findComidasByPedidoId(Long pedidoId);

}
