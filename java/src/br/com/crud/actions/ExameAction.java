package br.com.crud.actions;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.crud.factory.ExameRepositoryFactory;
import br.com.crud.factory.RepositoryFactory;
import br.com.crud.model.Exame;
import br.com.crud.model.Finalidade;
import br.com.crud.model.Medico;
import br.com.crud.model.Repository;
import br.com.crud.model.TipoExame;

@SuppressWarnings("serial")
public class ExameAction extends ActionSupport {
	private Exame exame = new Exame();
	private RepositoryFactory factory = new ExameRepositoryFactory();

	private List<Exame> exames;
	private List<TipoExame> tiposExame;
	private List<Medico> medicos;
	private Integer medicoSelecionado;
	private Integer tipoExameSelecionado;
	private String finalidadeSelecionada;
	private String dataExame;
	private String dataVencimento;
	private List<Finalidade> finalidades = Arrays.asList(Finalidade.values());

	public List<Finalidade> getFinalidades() {
		return finalidades;
	}

	public void setFinalidades(List<Finalidade> finalidades) {
		this.finalidades = finalidades;
	}

	public String getDataExame() {
		return dataExame;
	}

	public void setDataExame(String dataExame) {
		this.dataExame = dataExame;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Exame getExame() {
		return exame;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public int getMedicoSelect() {
		return medicoSelecionado;
	}

	public void setMedicoSelect(int medicoSelect) {
		this.medicoSelecionado = medicoSelect;
	}

	public int getTipoExameSelecionado() {
		return tipoExameSelecionado;
	}

	public void setTipoExameSelecionado(int tipoExameSelecionado) {
		this.tipoExameSelecionado = tipoExameSelecionado;
	}

	public String getFinalidadeSelecionada() {
		return finalidadeSelecionada;
	}

	public void setFinalidadeSelecionada(String finalidadeSelecionada) {
		this.finalidadeSelecionada = finalidadeSelecionada;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<TipoExame> getTiposExame() {
		return tiposExame;
	}

	public void setTiposExame(List<TipoExame> tiposExame) {
		this.tiposExame = tiposExame;
	}

	public String adicionaOuAltera() {
		Repository repository;
		try {
			repository = this.factory.criarRepository();

			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.sql.Date dataEx = new java.sql.Date(format.parse(dataExame).getTime());
			java.sql.Date dataV = new java.sql.Date(format.parse(dataVencimento).getTime());

			if (this.exame.getId() == null) {
				repository.adicionaExame(this.exame);
			} else {
				Medico medico = new Medico();
				medico.setId(medicoSelecionado);
				exame.setMedico(medico);
				TipoExame tipoExame = new TipoExame();
				tipoExame.setId(tipoExameSelecionado);
				exame.setFinalidade(Enum.valueOf(Finalidade.class, finalidadeSelecionada));
				exame.setTipoExame(tipoExame);
				exame.setDataExame(dataEx);
				exame.setDataVencimento(dataV);
				repository.alteraExame(this.exame);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.exame = new Exame();
		listaMedicos();

		return ExameAction.SUCCESS;
	}

	public String remove() {
		try {
			Repository repository;

			repository = this.factory.criarRepository();
			repository.removeExame(this.exame.getId());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// repository = new ExameRepository();
		this.exame = new Exame();
		return ExameAction.SUCCESS;
	}

	public String preparaAlteracao() {
		try {
			Repository repository;
			repository = this.factory.criarRepository();
			this.exame = repository.buscaExame(this.exame.getId());
			medicoSelecionado = exame.getMedico().getId();
			tipoExameSelecionado = exame.getTipoExame().getId();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			dataExame = sdf.format(exame.getDataExame());
			dataVencimento = sdf.format(exame.getDataVencimento());
			listaMedicos();
			listaTiposExame();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ExameAction.SUCCESS;
	}

	public String preparaCadastro() {
		try {

			listaMedicos();
			listaTiposExame();
			tipoExameSelecionado = null;
			medicoSelecionado = null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ExameAction.SUCCESS;
	}
	
	public String lista() {
		try {
			Repository repository;
			repository = this.factory.criarRepository();
			this.exames = repository.listaExames();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ExameAction.SUCCESS;
	}

	public String listaMedicos() {
		try {
			Repository repository;
			repository = this.factory.criarRepository();
			this.medicos = repository.medicos();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ExameAction.SUCCESS;
	}

	public String listaTiposExame() {
		try {
			Repository repository;
			repository = this.factory.criarRepository();
			this.tiposExame = repository.tiposExame();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ExameAction.SUCCESS;
	}

}
