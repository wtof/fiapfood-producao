package br.com.fiapfood.producao.infra.mensageria;

import br.com.fiapfood.producao.domain.interfaces.MensagemProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class MensagemProducerServiceImpl implements MensagemProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final Logger logger = LoggerFactory.getLogger(MensagemProducerServiceImpl.class);
    private static final String  PRODUCAO_FINALIZADA = "PRODUCAO_FINALIZADA";


    public MensagemProducerServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void enviaMensagemProducaoFinalizada(String mensagem) {
        logger.info("Enviando mensagem de producão finalizada: {}", mensagem);
        kafkaTemplate.send(PRODUCAO_FINALIZADA, mensagem);
    }
}
