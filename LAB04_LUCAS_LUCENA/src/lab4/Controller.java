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
	public String CadastraAluno(String matricula, String nome, String curso) {
		
		if  (mapaAlunos.containsKey(matricula)) {
			return "\nMATRÍCULA JÁ CADASTRADA!\n";
		}
		else {
			Aluno aluno = new Aluno(matricula, nome, curso);
			mapaAlunos.put(matricula, aluno);
			return "\nCADASTRO REALIZADO!\n";
		}
	}
	
	public String ConsultaAluno(String matricula) {
		
		if (mapaAlunos.containsKey(matricula)) {
			return "\n" + mapaAlunos.get(matricula).toString() + "\n";
		}
		else {
			return "\nAluno não cadastrado.\n";
		}
	}
	
	// 	METODOS GRUPOS
	public String CadastraGrupo(String nomeGrupo) {
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
	
	public String AlocarAluno (String matricula, String nomeGrupo) {
		nomeGrupo = nomeGrupo.toLowerCase();
		
		if (!mapaAlunos.containsKey(matricula)) {
			return "\nAluno não cadastrado.\n";
		}
		else if (!mapaGrupos.containsKey(nomeGrupo)) {
			return "\nGrupo não cadastrado.\n";
		}
		else {
			mapaGrupos.get(nomeGrupo).AlocaAluno(mapaAlunos.get(matricula));
			return "\nALUNO ALOCADO!\n";
		}
	}
	
	public String ImprimirGrupo (String nomeGrupo) {
		return "\n" + mapaGrupos.get(nomeGrupo).toString() + "\n";
	}
	
	// QUADRO
	public String CadastraRespondemQuestoes(String matricula) {
		if (!mapaAlunos.containsKey(matricula)) {
			return "\nAluno não cadastrado.\n";
		}
		this.contaRespostas++;
		this.respondemQuestoes += contaRespostas + ". " + mapaAlunos.get(matricula).toString() + "\n"; 
		return "\nALUNO REGISTRADO!\n";
	}
	
	public String ImprimeRespondemQuestoes ( ) {
		if (respondemQuestoes.equals("")) {
			return "\nNENHUM ALUNO RESPONDEU QUESTÕES NO QUADRO\n";
		}
		else {
			return "\nAlunos:\n" + respondemQuestoes;
		}
	}
}
