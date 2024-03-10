package br.com.fiapfood.producao.domain.interfaces;

public interface ProducaoService {


    public String recebePedidoFilaProducao(String mensagem);
    public String enviaMensagemProducaoFinalizada(Long idPedido);
}
