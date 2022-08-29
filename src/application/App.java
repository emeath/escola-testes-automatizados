package application;

import entidades.Aluno;
import entidades.Nota;
import services.SistemaAprovacao;

public class App {
	
	public static void main(String[] args) {
		
		Aluno aluno = new Aluno("João", "7a serie");
		aluno.adicionarNota(new Nota(10.0)).adicionarNota(new Nota(6.0)).adicionarNota(new Nota(6.0));
		
		boolean alunoAprovado = SistemaAprovacao.alunoAprovado(aluno);
		
		System.out.println(aluno);
		System.out.println("Aluno aprovado? " + alunoAprovado);
		System.out.println("Media: " + SistemaAprovacao.calculaMediaDoAluno(aluno));
		
	}

}
