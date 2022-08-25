package services.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entidades.Aluno;
import entidades.Nota;
import services.SistemaAprovacao;

class SistemaAprovacaoTest {

	@Test
	void alunoAprovadoDeveriaRetornarVerdadeiroQuandoNotasForem678() {
		Aluno aluno = new Aluno("aluno", "8a serie");
		aluno.adicionarNota(new Nota(6.0)).adicionarNota(new Nota(7.0)).adicionarNota(new Nota(8.0));
		Assertions.assertTrue(SistemaAprovacao.alunoAprovado(aluno) == true);
	}

	@Test
	void alunoAprovadoDeveriaRetornarFalsoQuandoNotasForem642() {
		Aluno aluno = new Aluno("aluno", "7a serie");
		aluno.adicionarNota(new Nota(6.0)).adicionarNota(new Nota(4.0)).adicionarNota(new Nota(2.0));
		Assertions.assertFalse(SistemaAprovacao.alunoAprovado(aluno) == true);
	}

}
