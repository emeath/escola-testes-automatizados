package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aluno {

	private String nome;
	private String serie;
	private Date nascimento;
	private List<Nota> notas = new ArrayList<>();
	private Nota notaDeRecuperacao;

	public Aluno(String nome, String serie) {
		this.nome = nome;
		this.serie = serie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public Aluno adicionarNota(Nota nota) {
		validarNotaParaAtribuirParaAluno(nota);
		notas.add(nota);
		return this;
	}

	public void removerNota(Nota nota) {
		notas.remove(nota);
	}

	public Nota getNotaDeRecuperacao() {
		return notaDeRecuperacao;
	}

	public void setNotaDeRecuperacao(Nota notaDeRecuperacao) {
		validarNotaParaAtribuirParaAluno(notaDeRecuperacao);
		this.notaDeRecuperacao = notaDeRecuperacao;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", serie=" + serie + ", nascimento=" + nascimento + ", notas=" + notas + "]";
	}
	
	private void validarNotaParaAtribuirParaAluno(Nota nota) {
		if(nota.getValor() > 10.0) {
			throw new IllegalArgumentException("Nota deve ser menor igual a 10.0");
		} else if (nota.getValor() < 0) {
			throw new IllegalArgumentException("Nota deve ser maior igual a 0.0");
		}
		
		if(this.getNotas().size() >= 3) {
			throw new IllegalArgumentException("Quantidade de nota por aluno não pode ser maior que três");
		}
	}

}
