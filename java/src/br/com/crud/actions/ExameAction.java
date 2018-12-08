package br.com.crud.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.crud.factory.ExameRepositoryFactory;
import br.com.crud.factory.RepositoryFactory;
import br.com.crud.model.Exame;
import br.com.crud.model.ExameRepository;
import br.com.crud.model.Repository;

@SuppressWarnings("serial")
public class ExameAction extends ActionSupport
{
	private Exame exame = new Exame();
	private RepositoryFactory factory = new ExameRepositoryFactory();
	
	private List<Exame> exames;
	
	public Exame getExame() 
	{
		return exame;
	}

	public List<Exame> getExames() 
	{
		return exames;
	}

	public String adicionaOuAltera()
	{
		Repository repository = this.factory.criarRepository();
		
		if(this.exame.getId() == null)
		{
			repository.adicionaExame(this.exame);
		}
		else
		{
			repository.alteraExame(this.exame);
		}
		
		this.exame = new Exame();
		
		return ExameAction.SUCCESS;
	}
	
	public String remove()
	{
		Repository repository = this.factory.criarRepository();
		repository = new ExameRepository();
		repository.removeExame(this.exame.getId());
		this.exame = new Exame();
		return ExameAction.SUCCESS;
	}
	
	public String preparaAlteracao()
	{
		Repository repository = this.factory.criarRepository();
		this.exame = repository.buscaExame(this.exame.getId());
		return ExameAction.SUCCESS;
	}
	
	public String lista()
	{
		Repository repository = this.factory.criarRepository();
		this.exames = repository.listaExames();
		return ExameAction.SUCCESS;
	}
	
}
