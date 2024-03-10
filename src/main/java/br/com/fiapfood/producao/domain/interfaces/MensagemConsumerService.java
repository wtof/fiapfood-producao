package br.com.fiapfood.producao.domain.interfaces;

public interface MensagemConsumerService {
    void recebeMensagemProducaoPendente(String mensagem);
}
