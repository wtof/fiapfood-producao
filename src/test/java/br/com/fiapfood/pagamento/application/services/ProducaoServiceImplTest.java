package br.com.fiapfood.pagamento.application.services;

import br.com.fiapfood.producao.application.services.ProducaoServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProducaoServiceImplTest {

    @Test
    void testConsomePedidoFilaProducao() {
        ProducaoServiceImpl producaoService = new ProducaoServiceImpl();
        String result = producaoService.consomePedidoFilaProducao();
        assertEquals("Simula Consumo de  pedido da fila de producao", result);
    }
}