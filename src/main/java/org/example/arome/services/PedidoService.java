package org.example.arome.services;

import org.example.arome.models.Pedido;
import org.example.arome.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscarUltimoPedido() {
        return pedidoRepository.findLastOrder();
    }
    public List<Pedido> getAllPedidos()  {
        return pedidoRepository.findAll();
    }
    public void savePedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }
}