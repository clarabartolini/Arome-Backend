package org.example.arome.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.arome.models.Pedido;
import org.example.arome.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@Tag(name = "Pedidos", description = "Endpoints para gerenciar pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Operation(summary = "Retorna todos os pedidos")
    @GetMapping("/listar")
    public ResponseEntity<List<Pedido>> listar() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return ResponseEntity.ok(pedidos);

    }

    @Operation(summary = "Retorna o último pedido ")
    @GetMapping("/ultimoPedido")
    public ResponseEntity<Pedido> ultimoPedido() {
        Pedido pedido = pedidoRepository.findLastOrder();
        return ResponseEntity.ok(pedido);
    }

}
