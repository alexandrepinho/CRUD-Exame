package br.com.crud.factory;

import br.com.crud.model.Repository;
import br.com.crud.model.ExameRepository;

public class ExameRepositoryFactory implements RepositoryFactory {

	@Override
	public Repository criarRepository() {
		return new ExameRepository();
	}

}
