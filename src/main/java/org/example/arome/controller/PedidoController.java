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

    @Operation(summary = "Gera a nota fiscal de um pedido")
    @GetMapping(value = "/nota-fiscal/gerar/{idPedido}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> gerarNotaFiscal(@PathVariable Long idPedido) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PdfWriter writer = new PdfWriter(outputStream);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            String imageUrl = "https://github.com/isabelaneu/Arome/blob/main/imagens/image-removebg-preview%20(2).png?raw=true";
            ImageData imageData = ImageDataFactory.create(new URL(imageUrl));
            Image logo = new Image(imageData);
            document.add(logo);

            document.add(new Paragraph("Arome").setBold());
            document.add(new Paragraph("Cliente:")); //pegar info do cliente q fez o pedido
            document.add(new Paragraph("Forma de Pagamento:")); //pegar info do pagto do pedido
            document.add(new Paragraph("Cartão Utilizado:")); //pegar info do cartao utilizado
            document.add(new Paragraph("Itens do Pedido:"));

            List<String> itens = List.of("Exemplo de item 1", "Exemplo de item 2"); //pegar os itens do pedido
            for (String item : itens) {
                document.add(new Paragraph(item));
            }

            document.add(new Paragraph(""));
            document.close();

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=nota_fiscal.pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(outputStream.toByteArray());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}