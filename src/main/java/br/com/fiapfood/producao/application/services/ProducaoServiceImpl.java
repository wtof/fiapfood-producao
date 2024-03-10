package br.com.fiapfood.producao.application.services;

import br.com.fiapfood.producao.application.exceptions.ApplicationException;
import br.com.fiapfood.producao.domain.interfaces.MensagemProducerService;
import br.com.fiapfood.producao.domain.interfaces.ProducaoService;
import br.com.fiapfood.producao.domain.interfaces.ProducaoUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProducaoServiceImpl implements ProducaoService {

    ProducaoUseCase producaoUseCase;

    private final MensagemProducerService producer;

    public ProducaoServiceImpl(MensagemProducerService mensagemProducerService) {
        this.producer = mensagemProducerService;
    }

    @Override
    public String recebePedidoFilaProducao(String mensagem) {
        return "Simula Consumo de  pedido da fila de producao";
    }

    @Override
    public String enviaMensagemProducaoFinalizada(Long idPedido) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Long> payload = new HashMap<>();
        payload.put("idPedido", idPedido);
        String json = null;
        try {
            json = objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            throw new ApplicationException("Erro ao tentar converter id do pedido para Json", e);
        }
        producer.enviaMensagemProducaoFinalizada(json);
        return "PEDIDO ENVIADO PARA FILA DE PRODUCAO FINALIZADA COM SUCESSO";
    }
}
