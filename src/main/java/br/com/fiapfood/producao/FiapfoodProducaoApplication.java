package br.com.fiapfood.producao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FiapfoodProducaoApplication {
	public static void main(String[] args) {
		SpringApplication.run(FiapfoodProducaoApplication.class, args);
	}

}
