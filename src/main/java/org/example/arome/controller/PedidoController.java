package org.example.arome.controller;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.arome.models.Pedido;
import org.example.arome.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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

    @Operation(summary = "Retorna o último pedido")
    @GetMapping("/ultimoPedido")
    public ResponseEntity<Pedido> ultimoPedido() {
        Pedido pedido = pedidoRepository.findLastOrder();
        return ResponseEntity.ok(pedido);
    }

    @Operation(summary = "Adiciona um pedido")
    @PostMapping("/adicionar")
    public ResponseEntity<Pedido> adicionar(@Valid @RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoRepository.save(pedido);
        return ResponseEntity.ok(novoPedido);
    }
    @Operation(summary = "Busca um pedido por ID")
    @GetMapping("/buscar/{idPedido}")
    public ResponseEntity<Pedido> buscar(@PathVariable int idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
        return ResponseEntity.ok(pedido);
    }

        }
