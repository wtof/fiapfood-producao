package br.com.fiapfood.producao.domain.usecases;

import br.com.fiapfood.producao.domain.interfaces.ProducaoService;
import br.com.fiapfood.producao.domain.interfaces.ProducaoUseCase;
import org.springframework.stereotype.Component;

@Component
public class ProducaoUseCaseImpl implements ProducaoUseCase {

    private final ProducaoService producaoService;

    public ProducaoUseCaseImpl(ProducaoService producaoService) {
        this.producaoService = producaoService;
    }

    @Override
    public String consomePedidoFilaProducao() {
        return this.producaoService.recebePedidoFilaProducao("mensagem");
    }
}
