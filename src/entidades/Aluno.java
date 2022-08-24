package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aluno {

	private String nome;
	private String serie;
	private Date nascimento;
	private List<Nota> notas = new ArrayList<>();

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
		notas.add(nota);
		return this;
	}

	public void removerNota(Nota nota) {
		notas.remove(nota);
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", serie=" + serie + ", nascimento=" + nascimento + ", notas=" + notas + "]";
	}

}
