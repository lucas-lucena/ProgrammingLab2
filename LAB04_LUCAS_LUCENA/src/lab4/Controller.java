package lab4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Um objeto para o controle dos alunos e gruopos.
 * 
 * @author lucas-lucena.
 * 
 */

public class Controller {

	/**
	 * Mapa contendo todos os alunos cadastrados, sendo uma matricula
	 * o seu identificador.
	 */
	
	private HashMap<String, Aluno> mapaAlunos;
	
	/**
	 * Mapa contendo todos os grupos cadastrados, sendo o nome do grupo
	 * o seu identificador.
	 */
	private HashMap<String, Grupo> mapaGrupos;
	
	/**
	 * String que guarda a representação dos alunos que respondem as 
	 * questões no quadro na ordem em que responderam.
	 */
	private String respondemQuestoes;
	
	/**
	 * Inteiro contador da quantidade de respostas dadas pelos alunos.
	 */
	private int contaRespostas;
	
	/**
	 * Constroi o controlador dos objetos alunos e grupos sem parâmetros.
	 */
	public Controller() {
		this.mapaGrupos = new HashMap<>();
		this.mapaAlunos = new HashMap<>();
		this.respondemQuestoes = "";
		this.contaRespostas = 0;
	}
	
	/**
	 * Cadastra um aluno dentro do mapa de alunos passando uma String matricula
	 * como identificador, este objeto vai possuir uma matricula, um nome e um
	 * curso. Também retorna uma String informando a situação da
	 * matrícula, se for validado, retornará um texto informando que a matrícula
	 * foi realizada com sucesso, caso o contrário, vai informar se algum dos 
	 * atributos do aluno são invalidos, serão, se forem nulos ou espaços em branco,
	 * dessa forma, lançando exceção de argumento inválido.
	 * 
	 * @param matricula
	 * @param nome
	 * @param curso
	 * @return Situação do cadastro.
	 */
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
	
	/**
	 * Consulta sobre a existencia de um aluno específico no mapa de alunos,
	 * buscando por sua matrícula que será o unico parâmetro necessário. Caso
	 * o aluno esteja cadastrado, será retornada uma String informando o aluno
	 * e sua representação em String, se o aluno não for econtrado informará
	 * que a matrícula buscada não foi cadastrada ainda, caso a matrícula passada
	 * seja inválida (nula ou com String vazia) será lançada uma exceção de
	 * argumento ilegal. 
	 * 
	 * @param matricula
	 * @return Resultado da consulta por um aluno.
	 */
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
	
	/**
	 * Cadastra um grupo dentro do mapa de grupos passando seu String nome
	 * como identificador, este objeto vai possuir um nome e um conjunto de
	 * alunos. Também retorna uma String informando a situação da
	 * matrícula, se for validado, retornará um texto informando que a matrícula
	 * foi realizada com sucesso, caso o contrário, vai informar se algum dos 
	 * atributos do aluno são invalidos, serão, se forem nulos ou espaços em branco,
	 * lançando exceção de argumento ilegal.
	 * 
	 * @param nomeGrupo
	 * @return
	 */
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
	
	/**
	 * Aloca um aluno em um grupo, serão passados a matrícula do aluno e o
	 * nome do grupo como parâmetro para realização do alocamento. Há a 
	 * verificação de parâmetros inválidos, eles sendo nulos ou String's
	 * vazias, lançando exceções de argumento ilegal. Também será retornado
	 * uma String informando a situação do cadastro, obtendo os possíveis casos:
	 * 
	 * *Sucesso, então o aluno seria alocado em um grupo e dessa forma
	 * 	retornando uma String informando o sucesso da operação.
	 * 
	 * *O aluno não ter sido matriculado ainda para realizar o alocamento
	 * 	dessa forma retornando que a matrícula do aluno não tinha sido
	 * 	registrada.
	 * 
	 * *O grupo não ter sido criado ainda para poder alocar um aluno e 
	 * 	dessa forma retornando que a nome do grupo não tinha sido
	 * 	registrado.
	 * 
	 * @param matricula
	 * @param nomeGrupo
	 * @return Situação do alocamento.
	 */
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
	
	/**
	 * Imprime a representação em String de um grupo, tendo como parâmetro
	 * apenas o nome do grupo. Faz a verificação se o nome do grupo for
	 * inválido, nullo ou String vazia, e caso seja, lançará uma exceção de 
	 * argumento ilegal. Também retornará String dependendo da existência do
	 * grupo, caso: 
	 * 
	 * O grupo esteja dentro do mapa, será retornado a String representando o
	 * grupo.
	 * 
	 * Não seja encontrado dentro do mapa de grupos, será retornado uma String
	 * informando que o grupo ainda não foi cadastrado.
	 * 
	 * @param nomeGrupo
	 * @return Resultado da representação de um grupo.
	 */
	public String imprimirGrupo (String nomeGrupo) {
		if (nomeGrupo == null || nomeGrupo.equals("")) {
			throw new IllegalArgumentException("NOME DO GRUPO NULA OU VAZIA!");
		}
		
		if (mapaGrupos.containsKey(nomeGrupo)) {
			return "\n" + mapaGrupos.get(nomeGrupo).toString() + "\n";
		} else {
			return "\nGRUPO NÃO CADASTRADO!\n";
		}
	
	}
	
	/**
	 * Cadastra a representação em String de um aluno na String 
	 * respondem questoes, seu unico parâmetro é a matrícula do aluno
	 * será representado. Faz a verificação se a matrícula for um atributo
	 * inválido, (nullo ou String vazia, e caso seja, lançará uma exceção de 
	 * argumento ilegal. Também retornará uma String representando a situação
	 * do cadastro de quem respondeu a questão. Caso a matrícula represente
	 * um aluno que não foi cadastrado, será informado que o aluno não está
	 * cadastrado, caso o contrario, o retorno será da confirmação do cadastro.
	 * 
	 * @param matricula
	 * @return Situação do cadastro de um aluno que respondeu a questão.
	 */
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
	
	/**
	 * Imprime uma String respondemQuestoes que representa todos os alunos que
	 * responderam questões no quadro em ordem do primeiro ao ultimo aluno a
	 * responder. A representação se da no seguinte modelo:
	 * "Alunos:
	 * 	1. ALUNO1
	 *  2. ALUNO2
	 *  3. ALUNO3"
	 *  
	 *  Também caso nenhuma aluno tenha respondido questões ainda, será retornado uma
	 *  String informando isso.
	 * 
	 * @return
	 */
	public String imprimeRespondemQuestoes ( ) {
		if (respondemQuestoes.equals("")) {
			return "\nNENHUM ALUNO RESPONDEU QUESTÕES NO QUADRO\n";
		}
		else {
			return "\nAlunos:\n" + respondemQuestoes;
		}
	}
}