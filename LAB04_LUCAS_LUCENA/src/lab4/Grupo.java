package lab4;

import java.util.HashSet;

/**
 * A representação de um Grupo. Todo grupo conta com um nome,
 * e um conjunto de alunos. Os grupos podem alocar objetos 
 * Aluno em seu conjunto de alunos.
 * 
 * @author lucas-lucena
 *
 */

public class Grupo {

	/**
	 * Nome do aluno.
	 */
	private String nome;
	
	/**
	 * Conjunto de alunos.
	 */
	private HashSet<Aluno> alunosSet;

	/**
	 * Constroi o grupo com um nome um conjunto de alunos vazio.
	 * 
	 * @param nome
	 */
	public Grupo(String nome) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME DO GRUPO NULO OU VAZIO!S");
		}
		
		this.nome = nome;
		this.alunosSet = new HashSet<>();
	}

	/**
	 * Aloca um aluno ao conjunto de alunos no grupo.
	 * 
	 * @param aluno
	 * @return String situação do alocamento do aluno.
	 */
	public String alocaAluno(Aluno aluno) {
		alunosSet.add(aluno);
		return "ALUNO ALOCADO!"; 
	}
	
	/**
	 * Recupera a informação do conjunto de alunos.
	 * 
	 * @return 
	 */
	public HashSet<Aluno> getAlunosSet() {
		return alunosSet;
	}
	
	/**
	 * A representação em String de um Grupo seguindo o modelo:
	 * "Alunos do grupo NOME DO GRUPO:\n" +
	 * "* Aluno: REPRESENTAÇÃO DE UM ALUNO"
	 */
	public String toString() {
		String alunos = "Alunos do grupo "+	nome +":\n";
		if (!alunosSet.isEmpty()) {
			for (Aluno a: alunosSet) {
				alunos += "* Aluno: " + a.toString() + "\n"; 
			}
		} else {
			alunos += "NENHUM ALUNO CADASTRADO AINDA!\n";
		}
		return alunos.trim();
	}

	/**
	 * Cria um código hash para a Grupo.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alunosSet == null) ? 0 : alunosSet.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Verifica se dois objetos Grupo são iguais, com base no nome
	 * e do conjunto de alunos.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (!alunosSet.isEmpty()) {
			if (!this.getAlunosSet().equals(other.getAlunosSet())) {
				return false;
			}
		} else return false;
		if (!nome.equals(other.nome))
			return false;
		return true;
	}	
}