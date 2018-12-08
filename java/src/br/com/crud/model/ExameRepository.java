package br.com.crud.model;

import java.util.ArrayList;
import java.util.List;

public class ExameRepository implements Repository {
	private static List<Exame> exames = new ArrayList<Exame>();

	@Override
	public void adicionaExame(Exame exame) {
		exame.setId(ExameRepository.exames.size() + 1);
		ExameRepository.exames.add(exame);

	}

	@Override
	public void alteraExame(Exame exame) {
		ExameRepository.exames.set(exame.getId() - 1, exame);

	}

	@Override
	public void removeExame(int id) {
		ExameRepository.exames.remove(id - 1);

	}

	@Override
	public Exame buscaExame(int id) {
		System.out.println("ID " + id);
		return ExameRepository.exames.get(id - 1);

	}

	@Override
	public List<Exame> listaExames() {
		return new ArrayList<Exame>(ExameRepository.exames);

	}

}
