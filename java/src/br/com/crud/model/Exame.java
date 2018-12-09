package br.com.crud.model;

import java.util.Date;

public class Exame {

	private Integer id;
	private TipoExame tipoExame;
	private Medico medico;
	private Date dataExame;
	private Date dataVencimento;
	private boolean resultado;
	private Finalidade finalidade;
	private String nomePaciente;
	private String documentoPaciente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoExame getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(TipoExame tipoExame) {
		this.tipoExame = tipoExame;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Date getDataExame() {
		return dataExame;
	}

	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public boolean isResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}

	public Finalidade getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(Finalidade finalidade) {
		this.finalidade = finalidade;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getDocumentoPaciente() {
		return documentoPaciente;
	}

	public void setDocumentoPaciente(String documentoPaciente) {
		this.documentoPaciente = documentoPaciente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exame other = (Exame) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
