package br.com.fiapfood.producao.infra.controller;

import br.com.fiapfood.producao.domain.interfaces.ProducaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProducaoController {

    private final ProducaoService producaoService;

    public ProducaoController(ProducaoService producaoService) {
        this.producaoService = producaoService;
    }

    @PostMapping("/producao/pedido/{idPedido}/finalizado")
    @Operation(summary = "Envia mensagem de produção finalizada")
    public ResponseEntity<String> enviarMensagemProducaoFinalizada(@PathVariable("idPedido") Long idPedido) {
        return ResponseEntity.ok(producaoService.enviaMensagemProducaoFinalizada(idPedido));
    }
}
