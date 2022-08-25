package services;

import entidades.Aluno;
import entidades.Nota;

public class SistemaAprovacao {

	public static boolean alunoAprovado(Aluno aluno) {
		Double somatorioNotas = 0.0;
		for (Nota nota : aluno.getNotas()) {
			somatorioNotas += nota.getValor();
		}
		
		somatorioNotas /= aluno.getNotas().size();

		if (somatorioNotas >= 6.0) {
			return true;
		}

		return false;
	}

}
