package br.com.fiapfood.producao.infra.controller;

import br.com.fiapfood.producao.application.interfaces.ProducaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MockFilaController {

    private final ProducaoService producaoService;

    public MockFilaController(ProducaoService producaoService) {
        this.producaoService = producaoService;
    }

    @GetMapping("/producao")
    @Operation(summary = "Simula um recebimento de um pedido na fila de producao")
    public ResponseEntity<String> simularConsumoPedidoFilaProducao() {
        return ResponseEntity.ok(producaoService.consomePedidoFilaProducao());
    }
}
