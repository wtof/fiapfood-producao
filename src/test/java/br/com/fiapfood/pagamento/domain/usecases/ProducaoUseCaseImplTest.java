package br.com.fiapfood.pagamento.domain.usecases;

import br.com.fiapfood.producao.application.interfaces.ProducaoService;
import br.com.fiapfood.producao.domain.usecases.ProducaoUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ProducaoUseCaseImplTest {

    @Test
    void testConsomePedidoFilaProducao() {

        ProducaoService producaoService = Mockito.mock(ProducaoService.class);
        when(producaoService.consomePedidoFilaProducao()).thenReturn("Simula Consumo de  pedido da fila de producao");
        ProducaoUseCaseImpl producaoUseCase = new ProducaoUseCaseImpl(producaoService);

        String result = producaoUseCase.consomePedidoFilaProducao();

        assertEquals("Simula Consumo de  pedido da fila de producao", result);
    }
}