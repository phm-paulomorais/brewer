package com.algaworks.brewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BrewerApplication {
	
	private static ApplicationContext APPLICATION_CONTEXT;
	
	public static void main(String[] args) {
		APPLICATION_CONTEXT = SpringApplication.run(BrewerApplication.class, args);
	}
	
	// próxima instrução: o Spring vai pegar o objeto (qualquer tipo de objeto) 
	// nesse exemplo estamos considerando o objeto CervejaEntityListener e resolver
	// a injeção de dependência baseado no contexto corrente
	// se não tivesse essa instrução, não daria certo para instaciar o fotoStorage
	// devido que a gerência desse objeto está sendo feita no contexto do JPA/Hibernate
	// e não no contexto do Spring
	// (Ver anotação na entidade cerveja: @EntityListeners(CervejaEntityListener.class))
	public static <T> T getBean(Class<T> requiredType) {
		return APPLICATION_CONTEXT.getBean(requiredType);
	}
}