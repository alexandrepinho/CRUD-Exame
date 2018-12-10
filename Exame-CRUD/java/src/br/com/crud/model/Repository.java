package br.com.crud.model;

import java.util.List;

public interface Repository 
{
	public void adicionaExame(Exame exame);
	
	public void alteraExame(Exame exame);

	public void removeExame(int id);
	
	public Exame buscaExame(int id);
		
	public List<Exame> listaExames();
	
	public List<TipoExame> tiposExame();
		
	public List<Medico> medicos();
	
}
