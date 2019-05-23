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
	 * informando que o Cliente já tinha sido cadastrado anteriormente.
	 * 
	 * @param cpf
	 * @param nome
	 * @param local
	 * @param email
	 * @return String representando a situação do cadastro do Cliente.
	 */
	public String cadastraClientes(String cpf, String nome, String email, String local) {
		if (cpf == null || cpf.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		if (local == null || local.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
		if (email == null || email.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}

		if (!mapaClientes.containsKey(cpf)) {
			Cliente c = new Cliente(cpf, nome, email, local);
			mapaClientes.put(cpf, c);
			return cpf;
		} else {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}

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
	public String exibeCliente(String cpf) {
		if (cpf == null || cpf.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		}
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cpf invalido.");
		}

		if (mapaClientes.containsKey(cpf)) {
			return mapaClientes.get(cpf).toString();
		} else {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
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
	public String exibeTodosOsClientes() {
		ArrayList<String> Clientes = new ArrayList<>();
		for (Cliente Cliente : this.mapaClientes.values()) {
			Clientes.add(Cliente.toString());
		}
		if (!Clientes.isEmpty()) {
			Collections.sort(Clientes);
			return Clientes.stream().map(Cliente -> Cliente.toString()).collect(Collectors.joining(" | "));
		} else {
			throw new IllegalArgumentException("Erro na exibicao dos clientes: nao existem clientes cadastrados.");
		}
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
	public void editaCliente(String cpf, String atributo, String novoValor) {
		if (cpf == null || cpf.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		}
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf invalido.");
		}
		if (atributo == null || atributo.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
		if (atributo.equals("cpf")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
		}
		if (!atributo.equals("nome") && !atributo.equals("email") && !atributo.equals("localizacao")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
		if (novoValor == null || novoValor.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}

		if (mapaClientes.containsKey(cpf)) {
			if (atributo.equals("nome")) {
				this.mapaClientes.get(cpf).setNome(novoValor);
			}
			if (atributo.equals("localizacao")) {
				this.mapaClientes.get(cpf).setLocal(novoValor);
			}
			if (atributo.equals("email")) {
				this.mapaClientes.get(cpf).setEmail(novoValor);
			}
		} else {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
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
	public void removerCliente(String cpf) {
		if (cpf == null || cpf.equals("")) {
			throw new IllegalArgumentException("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		}
//		if (cpf.length() != 11) {
//			throw new IllegalArgumentException("Erro na remocao do cliente: cpf invalido.");
//		}
		
		if (mapaClientes.containsKey(cpf)) {
			mapaClientes.remove(cpf);
		} else {
			throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		}
	}
	
	public String adicionaCompra(String cpf, String fornecedor, String data, String nomeDoProduto, String descricaoDoProduto, double preco) {
		if (cpf == null || cpf.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		}
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		}
		if (fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		}
		if (data == null || data.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		}
		
		String[] datas = data.split("/");
		
		if (Integer.parseInt(datas[1]) > 12 || Integer.parseInt(datas[1]) < 1) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}
		if (nomeDoProduto == null || nomeDoProduto.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		}
		if (descricaoDoProduto == null || descricaoDoProduto.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		}
		
		if (mapaClientes.containsKey(cpf)) {
			return mapaClientes.get(cpf).adicionaCompra(fornecedor, data, nomeDoProduto, descricaoDoProduto, preco);
		}
		else {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}
		
	}

	public String getDebito(String cpf, String fornecedor, boolean fornecedorStatus) {
		if (cpf == null || cpf.equals("")) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		}
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");
		}
		if (fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		}
		if (!fornecedorStatus) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		}
		
		if (mapaClientes.containsKey(cpf)) {
			return mapaClientes.get(cpf).getDebito(fornecedor);
		}
		else {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		}
		
	}

	public String exibeContas(String cpf, String fornecedor, boolean fornecedorStatus) {
		if (cpf == null || cpf.equals("")) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		}
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf invalido.");
		}
		if (fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		}
		if (!fornecedorStatus) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		}
		
		if (mapaClientes.containsKey(cpf)) {
			return mapaClientes.get(cpf).exibeContas( fornecedor);
		}
		else {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		}
	}

	public String exibeContasClientes(String cpf) {
		if (cpf == null || cpf.equals("")) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		}
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf invalido.");
		}
		
		
		if (mapaClientes.containsKey(cpf)) {
			return "Cliente: " + mapaClientes.get(cpf).exibeContasClientes(); 
		} 
		else {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
		}
		
	}
	
	
}