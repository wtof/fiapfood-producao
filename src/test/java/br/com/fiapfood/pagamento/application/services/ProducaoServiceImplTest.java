package br.com.fiapfood.pagamento.application.services;

import br.com.fiapfood.producao.application.services.ProducaoServiceImpl;
import br.com.fiapfood.producao.domain.interfaces.MensagemProducerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProducaoServiceImplTest {

    @Mock
    private MensagemProducerService producer;

    @Test
    void testConsomePedidoFilaProducao() {
        ProducaoServiceImpl producaoService = new ProducaoServiceImpl(producer);
        String result = producaoService.recebePedidoFilaProducao("mensagem");
        assertEquals("Simula Consumo de  pedido da fila de producao", result);
    }
}