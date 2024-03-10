package br.com.fiapfood.pagamento.infra.controller;

import br.com.fiapfood.producao.domain.interfaces.ProducaoService;
import br.com.fiapfood.producao.infra.controller.ProducaoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class ProducaoControllerTest {

    private ProducaoController controller;
    private ProducaoService service;

    @BeforeEach
    public void setup() {
        service = Mockito.mock(ProducaoService.class);
        controller = new ProducaoController(service);
    }

    @Test
     void testSimularConsumoPedidoFilaProducao() {
        String expected = "OK";
        when(service.enviaMensagemProducaoFinalizada(anyLong())).thenReturn(expected);

        ResponseEntity<String> response = controller.enviarMensagemProducaoFinalizada(1L);

        assertEquals(expected, response.getBody());
    }
}