package com.example.restaurantedanice.domain.comida;

import com.example.restaurantedanice.domain.pedido.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComidaRepository extends JpaRepository<Comida, Long> {

    // List<Comida> findAllByPedido(Pedido pedido);

    Page<Comida> findAllByAtivoTrue(Pageable pageable);
}
