package br.com.crud.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExameRepository implements Repository {
	private static List<Exame> exames = new ArrayList<Exame>();
	private Connection connection;

	public ExameRepository(Connection connection) {

		this.connection = connection;
	}

	@Override
	public void adicionaExame(Exame exame) {
		PreparedStatement preparedStatement;

		String sql = "INSERT INTO exame "
				+ "(tipo_exame, medico,dt_exame,dt_vencimento,resultado,finalidade,nome_paciente,documento_paciente`) "
				+ "VALUES (?,?,?,?,?,?,?,?);";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, exame.getTipoExame().getId());
			preparedStatement.setInt(2, exame.getMedico().getId());
			preparedStatement.setDate(3, (Date) exame.getDataExame());
			preparedStatement.setDate(4, (Date) exame.getDataVencimento());
			preparedStatement.setBoolean(5, exame.isResultado());
			preparedStatement.setString(6, exame.getFinalidade().toString());
			preparedStatement.setString(7, exame.getNomePaciente());
			preparedStatement.setString(8, exame.getDocumentoPaciente());

			preparedStatement.executeUpdate();
			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		exame.setId(ExameRepository.exames.size() + 1);
		ExameRepository.exames.add(exame);

	}

	@Override
	public void alteraExame(Exame exame) {
		PreparedStatement preparedStatement;

		String sql = "UPDATE exame SET tipo_exame=?,medico=?,dt_exame=?,dt_vencimento=?,resultado=?,"
				+ "finalidade=?, nome_paciente=?, documento_paciente=? WHERE id=?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, exame.getTipoExame().getId());
			preparedStatement.setInt(2, exame.getMedico().getId());
			preparedStatement.setDate(3, new Date (exame.getDataExame().getTime()));
			preparedStatement.setDate(4, new Date (exame.getDataVencimento().getTime()));
			preparedStatement.setBoolean(5, exame.isResultado());
			preparedStatement.setString(6, exame.getFinalidade().toString());
			preparedStatement.setString(7, exame.getNomePaciente());
			preparedStatement.setString(8, exame.getDocumentoPaciente());
			preparedStatement.setInt(9, exame.getId());

			preparedStatement.executeUpdate();
			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeExame(int id) {
		PreparedStatement preparedStatement;

		String sql = "DELETE FROM exame where id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Exame buscaExame(int id) {

		PreparedStatement preparedStatement;
		Exame exame = new Exame();

		try {
			String sql = "SELECT e.id,e.tipo_exame, t.nome, e.medico, m.nome, m.crm , e.dt_exame,\n "
					+ " e.dt_vencimento, e.resultado,\n" + " e.finalidade, e.nome_paciente,e.documento_paciente\n"
					+ "FROM exame as e \n" + "INNER JOIN tipo_exame as t ON t.id = e.tipo_exame\n"
					+ "INNER JOIN medico as m ON m.id = e.medico where e.id=?;\n";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				exame.setId(rs.getInt(1));
				TipoExame tipoExame = new TipoExame();
				tipoExame.setId(rs.getInt(2));
				tipoExame.setNome(rs.getString(3));
				exame.setTipoExame(tipoExame);
				Medico medico = new Medico();
				medico.setId(rs.getInt(4));
				medico.setNome(rs.getString(5));
				medico.setCrm(rs.getString(6));
				exame.setMedico(medico);
				exame.setDataExame(rs.getDate(7));
				exame.setDataVencimento(rs.getDate(8));
				exame.setResultado(rs.getBoolean(9));
				exame.setFinalidade(Finalidade.valueOf(rs.getString(10)));
				exame.setNomePaciente(rs.getString(11));
				exame.setDocumentoPaciente(rs.getString(12));
				rs.close();
				preparedStatement.close();
				connection.close();

				return exame;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return exame;

//		return ExameRepository.exames.get(id - 1);

	}

	@Override
	public List<Exame> listaExames() {
		try {
			String sql = "SELECT e.id,e.tipo_exame, t.nome, e.medico, m.nome, m.crm , e.dt_exame,\n "
					+ " e.dt_vencimento, e.resultado,\n" + " e.finalidade, e.nome_paciente,e.documento_paciente\n"
					+ "FROM exame as e \n" + "INNER JOIN tipo_exame as t ON t.id = e.tipo_exame\n"
					+ "INNER JOIN medico as m ON m.id = e.medico;\n";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();

			exames.clear();

			while (rs.next()) {
				Exame exame = new Exame();
				exame.setId(rs.getInt(1));
				TipoExame tipoExame = new TipoExame();
				tipoExame.setId(rs.getInt(2));
				tipoExame.setNome(rs.getString(3));
				exame.setTipoExame(tipoExame);
				Medico medico = new Medico();
				medico.setId(rs.getInt(4));
				medico.setNome(rs.getString(5));
				medico.setCrm(rs.getString(6));
				exame.setMedico(medico);
				exame.setDataExame(rs.getDate(7));
				exame.setDataVencimento(rs.getDate(8));
				exame.setResultado(rs.getBoolean(9));
				exame.setFinalidade(Finalidade.valueOf(rs.getString(10)));
				exame.setNomePaciente(rs.getString(11));
				exame.setDocumentoPaciente(rs.getString(12));
				exames.add(exame);

			}

			rs.close();
			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return exames;

	}

	@Override
	public List<TipoExame> tiposExame() {

		String sql = "SELECT id,nome FROM tipo_exame";
		PreparedStatement preparedStatement;
		List<TipoExame> tiposExame = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				TipoExame tipoExame = new TipoExame();
				tipoExame.setId(rs.getInt(1));
				tipoExame.setNome(rs.getString(2));
				tiposExame.add(tipoExame);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tiposExame;
	}



	@Override
	public List<Medico> medicos() {

		String sql = "SELECT id,nome,crm FROM medico";
		PreparedStatement preparedStatement;
		List<Medico> medicos = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Medico medico = new Medico();
				medico.setId(rs.getInt(1));
				medico.setNome(rs.getString(2));
				medico.setCrm(rs.getString(3));
				medicos.add(medico);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medicos;
	}

}
