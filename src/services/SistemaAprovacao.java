package services;

import entidades.Aluno;
import entidades.Nota;

public class SistemaAprovacao {

	public static boolean alunoAprovado(Aluno aluno) {

		if (aluno.getNotas().size() != 3) {
			throw new IllegalArgumentException("Aluno deve ter três notas.");
		}

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

	public static SituacaoRecuperacao alunoAprovadoRecuperacao(Aluno alunoTeste) {

		Double nota = alunoTeste.getNotaDeRecuperacao().getValor();
		
		if ( nota >= 8.0) {
			return SituacaoRecuperacao.APROVADO;
		} else if(nota >= 6.0) {
			return SituacaoRecuperacao.REGIME_ESPECIAL;
		} else {
			return SituacaoRecuperacao.REPROVADO;
		}

	}

}
