package com.example.restaurantedanice.domain.pedido;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

//    Page<Pedido> findAllByStatusEquals(String string);

}
