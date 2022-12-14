package services.tests;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entidades.Aluno;
import entidades.Nota;
import services.SituacaoRecuperacao;
import services.SistemaAprovacao;

class SistemaAprovacaoTest {

	private Aluno alunoTeste;

	@BeforeEach
	public void inicializar() {
		alunoTeste = new Aluno("Nome aluno de Teste", "8a serie");
	}

	@Test
	public void atribuirNotaParaAlunoDeveriaLancarExcecaoQuandoNotaMaiorQue10() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			alunoTeste.adicionarNota(new Nota(10.1));
		});
	}

	@Test
	public void atribuirNotaParaAlunoDeveriaLancarExcecaoQuandoNotaMenorQue0() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			alunoTeste.adicionarNota(new Nota(-0.1));
		});
	}

	@Test
	public void atribuirNotaParaAlunoDeveriaLancarExcecaoQuandoQuantidadeDeNotasForMaiorQue3() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			alunoTeste
					.adicionarNota(new Nota(4.0))
					.adicionarNota(new Nota(4.0))
					.adicionarNota(new Nota(4.0))
					.adicionarNota(new Nota(4.0));
		});
	}

	@Test
	public void alunoAprovadoDeveriaRetornarVerdadeiroQuandoNotasForem678() {
		alunoTeste.adicionarNota(new Nota(6.0)).adicionarNota(new Nota(7.0)).adicionarNota(new Nota(8.0));
		Assertions.assertTrue(SistemaAprovacao.alunoAprovado(alunoTeste) == true);
	}

	@Test
	public void alunoAprovadoDeveriaRetornarFalsoQuandoNotasForem642() {
		alunoTeste.adicionarNota(new Nota(6.0)).adicionarNota(new Nota(4.0)).adicionarNota(new Nota(2.0));
		Assertions.assertFalse(SistemaAprovacao.alunoAprovado(alunoTeste) == true);
	}

	@Test
	public void alunoAprovadoDeveriaLancarExcecaoQuandoQuantidadeDeNotasNaoFor3() {
		alunoTeste.adicionarNota(new Nota(10.0));
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			SistemaAprovacao.alunoAprovado(alunoTeste);
		});
	}

	@Test
	public void alunoAprovadoDeveriaLancarExcecaoQuandoQuantidadeDeNotasNaoForIgualA3() {
		alunoTeste.adicionarNota(new Nota(10.0)).adicionarNota(new Nota(8.9));
		try {
			SistemaAprovacao.alunoAprovado(alunoTeste);
			fail("Esperado exce????o!");
		} catch (Exception e) {
			Assertions.assertEquals("Aluno deve ter tr??s notas.", e.getMessage());
		}

	}

	@Test
	public void alunoAprovadoRecuperacaoDeveriaRetornarAprovadoQuandoMediaMaiorIgualA8() {
		alunoTeste.setNotaDeRecuperacao(new Nota(8.0));
		Assertions.assertEquals(SituacaoRecuperacao.APROVADO, SistemaAprovacao.alunoAprovadoRecuperacao(alunoTeste));
	}

	@Test
	public void alunoAprovadoRecuperacaoDeveriaRetornarReprovadoQuandoMediaMenorQue6() {
		alunoTeste.setNotaDeRecuperacao(new Nota(5.9));
		Assertions.assertEquals(SituacaoRecuperacao.REPROVADO, SistemaAprovacao.alunoAprovadoRecuperacao(alunoTeste));
	}

	@Test
	public void alunoAprovadoRecuperacaoDeveriaRetornarRegimeEspecialQuandoMediaMenorQue6() {
		alunoTeste.setNotaDeRecuperacao(new Nota(7.0));
		Assertions.assertEquals(SituacaoRecuperacao.REGIME_ESPECIAL,
				SistemaAprovacao.alunoAprovadoRecuperacao(alunoTeste));
	}

	@Test
	public void calculaMediaDeAlunoDeveriaRetornarMediaQuandoQuantidadeDeNotasFor3() {
		alunoTeste.adicionarNota(new Nota(1.0)).adicionarNota(new Nota(2.0)).adicionarNota(new Nota(3.0));
		Assertions.assertTrue(SistemaAprovacao.calculaMediaDoAluno(alunoTeste) >= 0.0);
	}
	
	@Test
	public void calculaMediaDeAlunoDeveriaRetornarCincoPonto8QuandoNotas() {
		alunoTeste.adicionarNota(new Nota(3.5)).adicionarNota(new Nota(7.4)).adicionarNota(new Nota(6.4));
		Assertions.assertEquals(5.8, SistemaAprovacao.calculaMediaDoAluno(alunoTeste));
	}
	
	@Test
	public void calculaMediaDeAlunoDeveriaLancarExcecaoQuandoNotaForDiferenteDe3() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			alunoTeste.adicionarNota(new Nota(3.5)).adicionarNota(new Nota(7.4));
			SistemaAprovacao.calculaMediaDoAluno(alunoTeste);
		});
	}
	
}
