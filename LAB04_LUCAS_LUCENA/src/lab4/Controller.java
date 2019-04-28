package lab4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Controller {

	// 	ATRIBUTOS
	private HashMap<String, Aluno> mapaAlunos;
	private HashMap<String, Grupo> mapaGrupos;
	private String respondemQuestoes;
	private int contaRespostas;
	
	public Controller() {
		this.mapaGrupos = new HashMap<>();
		this.mapaAlunos = new HashMap<>();
		this.respondemQuestoes = "";
		this.contaRespostas = 0;
	}
	
	// 	METODOS ALUNO
	public String cadastraAluno(String matricula, String nome, String curso) {
		if (matricula == null || matricula.equals("")) {
			throw new IllegalArgumentException("MATRICULA NULA OU VAZIA");
		}
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME DO ALUNO NULO OU VAZIO");
		}
		if (curso == null || curso.equals("")) {
			throw new IllegalArgumentException("NOME DO CUROSO NULO OU VAZIO");
		}
		
		if  (mapaAlunos.containsKey(matricula)) {
			return "\nMATRÍCULA JÁ CADASTRADA!\n";
		}
		else {
			Aluno aluno = new Aluno(matricula, nome, curso);
			mapaAlunos.put(matricula, aluno);
			return "\nCADASTRO REALIZADO!\n";
		}
	}
	
	public String consultaAluno(String matricula) {
		if (matricula == null || matricula.equals("")) {
			throw new IllegalArgumentException("MATRICULA NULA OU VAZIA!");
		}
		
		if (mapaAlunos.containsKey(matricula)) {
			return "\nAluno: " + mapaAlunos.get(matricula).toString() + "\n";
		}
		else {
			return "\nAluno não cadastrado.\n";
		}
	}
	
	// 	METODOS GRUPOS
	public String cadastraGrupo(String nomeGrupo) {
		if (nomeGrupo == null || nomeGrupo.equals("")) {
			throw new IllegalArgumentException("NOME DO GRUPO NULO OU VAZIO!");
		}
		
		nomeGrupo = nomeGrupo.toLowerCase();
		
		if (mapaGrupos.containsKey(nomeGrupo)) {
			return "\nGRUPO JÁ CADASTRADO!\n";
		}
		else {
			Grupo grupo = new Grupo(nomeGrupo);
			mapaGrupos.put(nomeGrupo, grupo);
			return "\nCADASTRO REALIZADO!\n";
		}
	}
	
	public String alocarAluno (String matricula, String nomeGrupo) {
		if (nomeGrupo == null || nomeGrupo.equals("")) {
			throw new IllegalArgumentException("NOME DO GRUPO NULA OU VAZIA!");
		}
		if (matricula == null || matricula.equals("")) {
			throw new IllegalArgumentException("MATRICULA NULA OU VAZIA!");
		}
		
		nomeGrupo = nomeGrupo.toLowerCase();
		
		if (!mapaAlunos.containsKey(matricula)) {
			return "\nAluno não cadastrado.\n";
		}
		else if (!mapaGrupos.containsKey(nomeGrupo)) {
			return "\nGrupo não cadastrado.\n";
		}
		else {
			mapaGrupos.get(nomeGrupo).alocaAluno(mapaAlunos.get(matricula));
			return "\nALUNO ALOCADO!\n";
		}
	} 
	
	public String imprimirGrupo (String nomeGrupo) {
		if (nomeGrupo == null || nomeGrupo.equals("")) {
			throw new IllegalArgumentException("NOME DO GRUPO NULA OU VAZIA!");
		}
		
		if (mapaGrupos.containsKey(nomeGrupo)) {
			return "\n" + mapaGrupos.get(nomeGrupo).toString() + "\n";
		} else {
			return "GRUPO NÃO CADASTRADO!\n";
		}
	
	}
	
	// QUADRO
	public String cadastraRespondemQuestoes(String matricula) {
		if (matricula == null || matricula.equals("")) {
			throw new IllegalArgumentException("MATRICULA NULA OU VAZIA!");
		}
		
		if (!mapaAlunos.containsKey(matricula)) {
			return "\nAluno não cadastrado.\n";
		}
		this.contaRespostas++;
		this.respondemQuestoes += contaRespostas + ". " + mapaAlunos.get(matricula).toString() + "\n"; 
		return "\nALUNO REGISTRADO!\n";
	}
	
	public String imprimeRespondemQuestoes ( ) {
		if (respondemQuestoes.equals("")) {
			return "\nNENHUM ALUNO RESPONDEU QUESTÕES NO QUADRO\n";
		}
		else {
			return "\nAlunos:\n" + respondemQuestoes;
		}
	}
}




























