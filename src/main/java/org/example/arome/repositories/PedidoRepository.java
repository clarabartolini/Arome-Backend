package org.example.arome.repositories;

import org.example.arome.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query("SELECT p FROM Pedido p ORDER BY p.id DESC LIMIT 1")
    Pedido findLastOrder();
    List<Pedido> findAllByOrderByIdDesc();

}
