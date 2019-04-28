package lab4;

/**
 * A representação de um aluno. Todo aluno conta com um nome,
 * matrícula e um curso.
 * 
 * @author lucas-lucena
 *
 */

public class Aluno {

	/** 
	 * Matrícula do aluno.
	 */
	private String matricula;
	
	/** 
	 * Nome do aluno.
	 */
	private String nome;
	
	/** 
	 * Curso do aluno.
	 */
	private String curso;

	/**
	 * Constroi o aluno com matrícula, nome e curso.
	 * 
	 * @param matricula
	 * @param nome
	 * @param curso
	 */
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

	/**
	 * Restorna representação em String do Aluno seguindo o modelo:
	 * "MATRICULA - NOME- CURSO".
	 */
	public String toString() {
		return this.matricula +
				" - " + this.nome +
				" - " + this.curso;
	}

	/**
	 * Cria um código hash para a Agenda.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Verifica se dois objetos Aluno são iguais, com base na matrícula,
	 * do nome e do curso.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (!matricula.equals(other.matricula))
			return false;
		if (!nome.equals(other.nome))
			return false;
		if (!curso.equals(other.curso))
			return false;
		return true;
	}
}