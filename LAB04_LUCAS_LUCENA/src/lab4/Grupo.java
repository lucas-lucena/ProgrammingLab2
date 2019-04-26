package lab4;

import java.util.HashSet;

public class Grupo {

	private String nome;
	private HashSet<Aluno> alunosSet;

	public Grupo(String nome) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME DO GRUPO NULO OU VAZIO!S");
		}
		
		this.nome = nome;
		this.alunosSet = new HashSet<>();
	}
	
	public String AlocaAluno(Aluno aluno) {
		alunosSet.add(aluno);
		return "ALUNO ALOCADO!"; 
	}
	
	public String toString() {
		String alunos = "Alunos do grupo "+	nome +":\n";
		for (Aluno a: alunosSet) {
			alunos += "* " + a.toString() + "\n"; 
		}
		return alunos.trim();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alunosSet == null) ? 0 : alunosSet.hashCode());
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
		Grupo other = (Grupo) obj;
		if (alunosSet == null) {
			if (other.alunosSet != null)
				return false;
		} else if (!alunosSet.equals(other.alunosSet))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
