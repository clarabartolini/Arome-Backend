package org.example.arome.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.arome.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.arome.services.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Cliente Controller", description = "Endpoints para gerenciar clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Adiciona um novo cliente
    @Operation(summary = "Adicionar cliente", description = "Endpoint para cadastrar um novo cliente.")
    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarCliente(@RequestBody Cliente cliente) {
        String resposta = clienteService.registerCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta); // Retorna 201 Created
    }

    // Lista todos os clientes
    @Operation(summary = "Listar todos os clientes", description = "Endpoint para listar todos os clientes cadastrados.")
    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content se a lista estiver vazia
        }
        return ResponseEntity.ok(clientes); // 200 OK
    }

    // Atualiza um cliente pelo ID
    @Operation(summary = "Atualizar cliente", description = "Endpoint para atualizar um cliente pelo ID.")
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Cliente atualizado = clienteService.updateCliente(id, cliente);
        if (atualizado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found se o cliente não existir
        }
        return ResponseEntity.ok(atualizado); // 200 OK
    }

    // Busca um cliente pelo ID
    @Operation(summary = "Buscar cliente por ID", description = "Endpoint para buscar um cliente pelo ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> ClienteById(@PathVariable Integer id) {
        Cliente cliente = clienteService.getClienteById(id);
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }
        return ResponseEntity.ok(cliente); // 200 OK
    }
}
