package br.com.fiapfood.producao.application.services;

import br.com.fiapfood.producao.application.interfaces.ProducaoService;
import br.com.fiapfood.producao.domain.interfaces.ProducaoUseCase;
import org.springframework.stereotype.Service;

@Service
public class ProducaoServiceImpl implements ProducaoService {

    ProducaoUseCase producaoUseCase;

    @Override
    public String consomePedidoFilaProducao() {
        return "Simula Consumo de  pedido da fila de producao";
    }
}
