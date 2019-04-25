package lab4;

import java.util.HashSet;

public class Grupo {

	private String nome;
	private HashSet<Aluno> alunosSet;

	public Grupo(String nome) {
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
}
