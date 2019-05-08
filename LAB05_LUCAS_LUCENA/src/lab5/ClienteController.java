package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ClienteController {

	private HashMap<String, Cliente> mapaClientes;

	/**
	 * Constroi um Controller de Clientes com um HashMap vazio.
	 */
	public ClienteController() {
		mapaClientes = new HashMap<>();
	}

	/**
	 * Cadastra um Cliente no mapa de Clientes passando uma String cpf como
	 * identificador, e recebe Strings representando, respetivamente, o cpf, nome,
	 * local associado e email de um Cliente. Também irá verificar o uso de entradas
	 * inválidas como Strings vazias ou entradas nulas, caso isto aconteça, serão
	 * lançadas exceções de argumento ilegal e informando o primeiro argumento
	 * ilegal passado como parâmetro. Além disso, este método também verifica se o
	 * Cliente que está sendo criado já existe, por meio de seu cpf (identificador
	 * único), tendo os possíveis casos de retorno:
	 * 
	 * Caso o Cliente não tenha sido cadastrado (não exista um identificador em mapa
	 * de Clientes igual ao cpf passado como parâmetro), retornará uma String
	 * informando que o cadastro foi bem sucedido.
	 * 
	 * Caso o Cliente já tenha sido cadastrado (já exista um identificador em mapa
	 * de Clientes igual ao cpf passado como parâmetro), retornará uma String
	 * informando que o Cliente já foi cadastrado.
	 * 
	 * @param cpf
	 * @param nome
	 * @param local
	 * @param email
	 * @return String representando a situação do cadastro do Cliente.
	 */
	public String CadastraClientes(String cpf, String nome, String local, String email) {
		if (cpf == null || cpf.equals("")) {
			throw new IllegalArgumentException("CPF NULO OU STRING VAZIA!");
		}
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME NULO OU STRING VAZIA!");
		}
		if (local == null || local.equals("")) {
			throw new IllegalArgumentException("LOCAL NULO OU STRING VAZIA!");
		}
		if (email == null || email.equals("")) {
			throw new IllegalArgumentException("EMAIL NULO OU STRING VAZIA!");
		}

		if (!mapaClientes.containsKey(cpf)) {
			Cliente c = new Cliente(cpf, nome, local, email);
			mapaClientes.put(cpf, c);
			return "CADASTRO BEM SUCEDIDO!";
		}
		return "CLIENTE JÁ CADASTRADO!";
	}

	/**
	 * Retornar a representação em String de um Cliente que está associado a String
	 * cpf passada como parâmetro e presente no mapa de Clientes. Também irá
	 * verificar o uso de entradas inválidas como String vazia ou entrada nula, caso
	 * isto aconteça, será lançada uma exceçõe de argumento ilegal e informando que
	 * o cpf passado como parâmetro é um argumento ilegal. Além disso, este método
	 * também verifica se o Cliente que está sendo exibido existe, por meio de seu
	 * cpf (identificador único), tendo os possíveis casos de retorno:
	 * 
	 * 
	 * Caso o Cliente não tenha sido cadastrado (não exista um identificador em mapa
	 * de Clientes igual ao cpf passado como parâmetro), retornará uma String
	 * informando que o Cliente não pode ser exibido, por não ter sido cadastrado.
	 * 
	 * Caso o Cliente tenha sido cadastrado (já exista um identificador em mapa de
	 * Clientes igual ao cpf passado como parâmetro), retornará a representação em
	 * String do Cliente associado ao cpf.
	 * 
	 * @param cpf
	 * @return Representação em string do Cliente.
	 */
	public String ExibeCliente(String cpf) {
		if (cpf == null || cpf.equals("")) {
			throw new IllegalArgumentException("CPF NULO OU STRING VAZIA!");
		}

		if (mapaClientes.containsKey(cpf)) {
			return mapaClientes.get(cpf).toString();
		}
		return "CLIENTE NÃO CADASTRADO!";
	}

	/**
	 * Retornar a representação em String de todos os Clientes cadastrados no
	 * sistema em ordem alfabetica e separando-os com "|". Além disso, esté método
	 * também verifica se no sistema não existe nenhum Cliente cadastrado, tendo os
	 * possíveis casos de retorno.
	 * 
	 * Caso não tenha nenhum Cliente cadastrado no sistema, retornará uma String
	 * informando ao usuário que não existe nenhum Cliente cadastrado no momento.
	 * 
	 * Caso tenha pelo menos 1 Cliente cadastrado, retornará em ordem alfabética
	 * todos os Clientes que estão cadastrados no momento e separando-os pelo
	 * caractere "|".
	 * 
	 * @return String representando todos os Clientes cadastrados.
	 */
	public String ExibeTodosOsClientes() {

		ArrayList<String> Clientes = new ArrayList<>();
		for (Cliente Cliente : this.mapaClientes.values()) {
			Clientes.add(Cliente.toString());
		}
		if (!Clientes.isEmpty()) {
			Collections.sort(Clientes);
			return Clientes.stream().map(Cliente -> Cliente.toString()).collect(Collectors.joining(" | "));
		}
		return "NENHUM CLIENTE CADASTRADO!";
	}

	/**
	 * Edita as informações de um Cliente que tenha o identificador no mapa de
	 * Clientes igual ao cpf passado como parâmetro (esta sendo a unica informação
	 * que não pode ser alterada, por ser o identificador de um Cliente no mapa de
	 * Clientes). Também irá verificar o uso de entradas inválidas como Strings
	 * vazias ou entradas nulas, caso isto aconteça, serão lançadas exceções de
	 * argumento ilegal e informando o primeiro argumento ilegal passado como
	 * parâmetro. Além disso, este método também verifica se o Cliente que está
	 * sendo editado existe, por meio de seu cpf (identificador único), tendo os
	 * possíveis casos de retorno:
	 *
	 * Caso o Cliente não esteja cadastrado (não exista um identificador em mapa de
	 * Clientes igual ao cpf passado como parâmetro), retornará uma String
	 * informando que não existe o Cleinte desejado para a edição.
	 * 
	 * Caso o Cliente esteja cadastrado (exista um identificador em mapa de Clientes
	 * igual ao cpf passado como parâmetro), retornará uma String informando que a
	 * edição foi bem sucedida.
	 * 
	 * @param cpf
	 * @param nome
	 * @param local
	 * @param email
	 * @return Situação da edição de um Cliente.
	 */
	public String EditaCliente(String cpf, String nome, String local, String email) {
		if (cpf == null || cpf.equals("")) {
			throw new IllegalArgumentException("CPF NULO OU STRING VAZIA!");
		}
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME NULO OU STRING VAZIA!");
		}
		if (local == null || local.equals("")) {
			throw new IllegalArgumentException("LOCAL NULO OU STRING VAZIA!");
		}
		if (email == null || email.equals("")) {
			throw new IllegalArgumentException("EMAIL NULO OU STRING VAZIA!");
		}

		if (mapaClientes.containsKey(cpf)) {
			this.mapaClientes.get(cpf).setNome(nome);
			this.mapaClientes.get(cpf).setLocal(local);
			this.mapaClientes.get(cpf).setEmail(email);
			return "EDIÇÃO BEM SUCESSIDA";
		}

		return "EDIÇÃO MAL SUCESSIDA";
	}

	/**
	 * Remove um Cliente que tenha o identificador no mapa de Clientes igual ao cpf
	 * passado como parâmetro. Também irá verificar o uso de uma entrada inválida
	 * como String vazia ou entrada nula, caso isto aconteça, será lançada uma
	 * exceção de argumento ilegal e informando que o cpf passado como parâmetro é
	 * um argumento ilegal. Além disso, este método também verifica se o Cliente que
	 * está sendo removido existe, por meio de seu cpf (identificador único), tendo
	 * os possíveis casos de retorno:
	 * 
	 * Caso o Cliente não esteja cadastrado (não exista um identificador em mapa de
	 * Clientes igual ao cpf passado como parâmetro), retornará uma String
	 * informando que não existe o Cleinte desejado para a remoção.
	 * 
	 * Caso o Cliente esteja cadastrado (exista um identificador em mapa de Clientes
	 * igual ao cpf passado como parâmetro), retornará uma String informando que a
	 * remoção foi bem sucedida.
	 * 
	 * @param cpf
	 * @return Situação da remoção de um Cliente.
	 */
	public String RemoverCliente(String cpf) {
		if (cpf == null || cpf.equals("")) {
			throw new IllegalArgumentException("CPF NULO OU STRING VAZIA!");
		}

		if (mapaClientes.containsKey(cpf)) {
			mapaClientes.remove(cpf);
			return "REMOÇÃO BEM SUCEDIDA!";
		}

		return "CLIENTE NÃO CADASTRADO!";
	}

}