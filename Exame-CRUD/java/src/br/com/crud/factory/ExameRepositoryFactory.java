package br.com.crud.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import br.com.crud.model.ExameRepository;
import br.com.crud.model.Repository;

public class ExameRepositoryFactory implements RepositoryFactory {

	@Override
	public Repository criarRepository() throws ClassNotFoundException, SQLException, Exception {
		return new ExameRepository(getConnection());
	}

	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties props = new Properties();
			props.setProperty("user", "root");
			props.setProperty("password", "root");
			props.setProperty("encoding", "utf_8");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/exame_ocupacional", props);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
