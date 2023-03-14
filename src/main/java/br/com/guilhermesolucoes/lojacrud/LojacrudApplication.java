package br.com.guilhermesolucoes.lojacrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Guilherme Pacheco De Medeiros
 * @version 1.0
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class LojacrudApplication {

	//Método main
	public static void main(String[] args) {
		SpringApplication.run(LojacrudApplication.class, args);
	}

}
