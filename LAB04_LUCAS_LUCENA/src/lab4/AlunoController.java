package lab4;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;

public class AlunoController {

	private HashMap<String, Aluno> MapaAlunos;
	private HashMap<String, HashSet> MapaGrupos;
	
	public AlunoController() {
		this.MapaAlunos = new HashMap<>();
	}
	
	public String CadastraAluno(String matricula, String nome, String curso) {
		
		if  (MapaAlunos.containsKey(matricula)) {
			return "MATRÍCULA JÁ CADASTRADA!";
		}
		else {
			Aluno aluno = new Aluno(matricula, nome, curso);
			MapaAlunos.put(matricula, aluno);
			return "CADASTRO REALIZADO!";
		}
	}
	
	public String ConsultaAluno(String matricula) {
		
		if (MapaAlunos.containsKey(matricula)) {
			return MapaAlunos.get(matricula).toString();
		}
		else {
			return "Aluno não cadastrado.";
		}
	}
	
	public String CadastraGrupo(String nomeGrupo) {
		nomeGrupo = nomeGrupo.toLowerCase();
		
		if (MapaGrupos.containsKey(nomeGrupo)) {
			return "GRUPO JÁ CADASTRADO!";
		}
		else {
			HashSet<Aluno> grupoSet = new HashSet<>();
			MapaGrupos.put(nomeGrupo, grupoSet);
			return "CADASTRO REALIZADO!";
		}
	}
}
