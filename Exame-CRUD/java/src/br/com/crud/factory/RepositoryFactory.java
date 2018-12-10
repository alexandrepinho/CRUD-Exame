package br.com.crud.factory;

import java.sql.SQLException;

import br.com.crud.model.Repository;

public interface RepositoryFactory {
	Repository criarRepository() throws ClassNotFoundException, SQLException, Exception;
}
