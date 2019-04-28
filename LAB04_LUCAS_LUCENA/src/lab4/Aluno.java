package lab4;

public class Aluno {

	private String matricula;
	private String nome;
	private String curso;

	public Aluno(String matricula, String nome, String curso) {
		if (matricula == null || matricula.equals("")) {
			throw new IllegalArgumentException("MATRICULA NULA OU VAZIA");
		}
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME DO ALUNO NULO OU VAZIO");
		}
		if (curso == null || curso.equals("")) {
			throw new IllegalArgumentException("NOME DO CUROSO NULO OU VAZIO");
		}

		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;	
	}
	
	public String toString() {
		return this.matricula +
				" - " + this.nome +
				" - " + this.curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (!curso.equals(other.curso))
			return false;
		if (!matricula.equals(other.matricula))
			return false;
		if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}