package br.com.fiapfood.pagamento.infra.controller;

import br.com.fiapfood.producao.application.interfaces.ProducaoService;
import br.com.fiapfood.producao.infra.controller.MockFilaController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class MockFilaControllerTest {

    private MockFilaController controller;
    private ProducaoService service;

    @BeforeEach
    public void setup() {
        service = Mockito.mock(ProducaoService.class);
        controller = new MockFilaController(service);
    }

    @Test
     void testSimularConsumoPedidoFilaProducao() {
        String expected = "Test";
        when(service.consomePedidoFilaProducao()).thenReturn(expected);

        ResponseEntity<String> response = controller.simularConsumoPedidoFilaProducao();

        assertEquals(ResponseEntity.ok(expected), response);
    }
}