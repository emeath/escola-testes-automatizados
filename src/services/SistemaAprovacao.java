package services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import entidades.Aluno;
import entidades.Nota;

public class SistemaAprovacao {

	public static Double calculaMediaDoAluno(Aluno aluno) {

		if(aluno.getNotas().size() != 3) {
			throw new IllegalArgumentException("A media é calculada apenas quando aluno possui tres notas.");
		}
		
		Double somatorioNotas = 0.0;
		for (Nota nota : aluno.getNotas()) {
			somatorioNotas += nota.getValor();
		}

		Double media = somatorioNotas / (aluno.getNotas().size());

		BigDecimal bd = BigDecimal.valueOf(media);
		bd = bd.setScale(1, RoundingMode.HALF_UP);
		return bd.doubleValue();

	}

	public static boolean alunoAprovado(Aluno aluno) {

		if (aluno.getNotas().size() != 3) {
			throw new IllegalArgumentException("Aluno deve ter três notas.");
		}

		Double media = calculaMediaDoAluno(aluno);

		if (media >= 6.0) {
			return true;
		}

		return false;
	}

	public static SituacaoRecuperacao alunoAprovadoRecuperacao(Aluno alunoTeste) {

		Double nota = alunoTeste.getNotaDeRecuperacao().getValor();

		if (nota >= 8.0) {
			return SituacaoRecuperacao.APROVADO;
		} else if (nota >= 6.0) {
			return SituacaoRecuperacao.REGIME_ESPECIAL;
		} else {
			return SituacaoRecuperacao.REPROVADO;
		}

	}

}
