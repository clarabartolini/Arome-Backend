package org.example.arome.repositories;

import org.example.arome.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    @Query("SELECT p FROM Pedido p ORDER BY p.id DESC LIMIT 1")
    Pedido findLastOrder();
    Pedido findPedidoById(int idPedido);
}
