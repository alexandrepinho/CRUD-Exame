package br.com.crud.factory;

import br.com.crud.model.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.crud.model.ExameRepository;

public class ExameRepositoryFactory implements RepositoryFactory {


	@Override
	public Repository criarRepository() throws ClassNotFoundException, SQLException, Exception {
		return new ExameRepository(getConnection());
	}

	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/exame_ocupacional", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
