package br.com.fiapfood.producao.infra.mensageria;

import br.com.fiapfood.producao.domain.interfaces.MensagemConsumerService;
import br.com.fiapfood.producao.domain.interfaces.ProducaoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MensagemConsumerServiceImpl implements MensagemConsumerService {

    private static final String  PRODUCAO_PENDENTE = "PRODUCAO_PENDENTE";
    private static final Logger logger = LoggerFactory.getLogger(MensagemConsumerServiceImpl.class);

    private final ProducaoService producaoService;

    public MensagemConsumerServiceImpl(ProducaoService producaoService) {
        this.producaoService = producaoService;
    }

    @Override
    @KafkaListener(topics = PRODUCAO_PENDENTE, groupId = "producao_group_id")
    public void recebeMensagemProducaoPendente(String mensagem) {
        logger.info("Consumindo mensagem de producão pendente: {}", mensagem);
        producaoService.recebePedidoFilaProducao(mensagem);
    }
}
