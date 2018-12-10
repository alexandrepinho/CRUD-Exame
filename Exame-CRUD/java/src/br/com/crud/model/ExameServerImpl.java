package br.com.crud.model;

import java.sql.SQLException;

import javax.jws.WebService;

import br.com.crud.factory.ExameRepositoryFactory;
import br.com.crud.factory.RepositoryFactory;

@WebService(endpointInterface = "br.com.crud.model.ExameServer")
public class ExameServerImpl implements ExameServer {
	private RepositoryFactory factory = new ExameRepositoryFactory();

	@Override
	public Exame busca(int codigo) {
		try {
			Repository repository = this.factory.criarRepository();
			return repository.buscaExame(codigo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
