package com.example.restaurantedanice.infra.food;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

    // List<Comida> findAllByPedido(Pedido pedido);

    Page<Food> findAllByAtivoTrue(Pageable pageable);
}
