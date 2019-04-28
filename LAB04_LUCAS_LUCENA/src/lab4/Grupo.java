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
	
	public String alocaAluno(Aluno aluno) {
		alunosSet.add(aluno);
		return "ALUNO ALOCADO!"; 
	}
	
	public HashSet<Aluno> getAlunosSet() {
		return alunosSet;
	}
	
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
