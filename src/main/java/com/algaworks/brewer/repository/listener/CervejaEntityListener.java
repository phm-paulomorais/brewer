package com.algaworks.brewer.repository.listener;

import javax.persistence.PostLoad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.storage.FotoStorage;

public class CervejaEntityListener {
	
	@Autowired
	private FotoStorage fotoStorage;
	
	@PostLoad
	public void postLoad(final Cerveja cerveja) {
		// próxima instrução: o Spring vai pegar o objeto CervejaEntityListener e resolver
		// a injeção de dependência baseado no contexto corrente
		// se não tivesse essa instrução, não daria certo para instaciar o fotoStorage
		// devido que a gerência desse objeto está sendo feita no contexto do JPA/Hibernate 
		// (Ver anotação na entidade cerveja: @EntityListeners(CervejaEntityListener.class))
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		cerveja.setUrlFoto(fotoStorage.getUrl(cerveja.getFotoOrMock()));
		cerveja.setUrlThumbnailFoto(fotoStorage.getUrl(FotoStorage.THUMBNAIL_PREFIX + cerveja.getFotoOrMock()));
	}

}
