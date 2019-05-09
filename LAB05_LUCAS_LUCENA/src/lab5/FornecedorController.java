package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

public class FornecedorController {

	private HashMap<String, Fornecedor> mapaFornecedores;

	/**
	 * Constroi um Controller de fornecedores com um HashMap vazio.
	 */
	public FornecedorController() {
		mapaFornecedores = new HashMap<>();
	}

	/**
	 * Cadastra um Fornecedor no mapa de fornecedores passando uma String nome como
	 * identificador, e recebe Strings representando, respetivamente, nome, email e
	 * telefone de um Fornecedor. Também irá verificar o uso de entradas inválidas
	 * como Strings vazias ou entradas nulas, caso isto aconteça, serão lançadas
	 * exceções de argumento ilegal e informando o primeiro argumento ilegal passado
	 * como parâmetro. Além disso, este método também verifica se o Fornecedor que
	 * está sendo criado já existe, por meio de seu nome (identificador único),
	 * tendo os possíveis casos de retorno:
	 * 
	 * Caso o Fornecedor não tenha sido cadastrado (não exista um identificador em
	 * mapa de Fornecedores igual ao nome passado como parâmetro), retornará uma
	 * String informando que o cadastro foi bem sucedido.
	 * 
	 * Caso o Fornecedor já tenha sido cadastrado (já exista um identificador em
	 * mapa de Fornecedores igual ao nome passado como parâmetro), retornará uma
	 * String informando que o Fornecedor já tinha sido cadastrado anteriormente.
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 * @return String representando a situação do cadastro do Fornecedor.
	 */
	public String cadastraFornecedor(String nome, String email, String telefone) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if (email == null || email.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		if (telefone == null || telefone.equals("")) {
			throw new IllegalArgumentException("TELEFONE NULO OU STRING VAZIA!");
		}

		if (!mapaFornecedores.containsKey(nome)) {
			Fornecedor f = new Fornecedor(nome, email, telefone);
			mapaFornecedores.put(nome, f);
			return "CADASTRO BEM SUCEDIDO!";
		}
		return "FORNECEDOR JÁ CADASTRADO!";
	}

	/**
	 * Retornar a representação em String de um Fornecedor que está associado a
	 * String nome passada como parâmetro e presente no mapa de Fornecedores. Também
	 * irá verificar o uso de entradas inválidas como String vazia ou entrada nula,
	 * caso isto aconteça, será lançada uma exceçõe de argumento ilegal e informando
	 * que o nome passado como parâmetro é um argumento ilegal. Além disso, este
	 * método também verifica se o Fornecedor que está sendo exibido existe, por
	 * meio de seu nome (identificador único), tendo os possíveis casos de retorno:
	 * 
	 * 
	 * Caso o Fornecedor não tenha sido cadastrado (não exista um identificador em
	 * mapa de Fornecedores igual ao nome passado como parâmetro), retornará uma
	 * String informando que o Fornecedor não pode ser exibido, por não ter sido
	 * cadastrado.
	 * 
	 * Caso o Fornecedor tenha sido cadastrado (já exista um identificador em mapa
	 * de Fornecedores igual ao nome passado como parâmetro), retornará a
	 * representação em String do Fornecedor associado ao nome.
	 * 
	 * @param nome
	 * @return Representação em string do Fornecedor.
	 */
	public String exibeFornecedor(String nome) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME NULO OU STRING VAZIA!");
		}

		if (mapaFornecedores.containsKey(nome)) {
			return mapaFornecedores.get(nome).toString();
		}
		return "FORNECEDOR NÃO CADASTRADO!";
	}

	/**
	 * Retornar a representação em String de todos os Fornecedores cadastrados no
	 * sistema em ordem alfabetica e separando-os com "|". Além disso, este método
	 * também verifica se no sistema não existe nenhum Fornecedor cadastrado, tendo
	 * os possíveis casos de retorno.
	 * 
	 * Caso não tenha nenhum Fornecedor cadastrado no sistema, retornará uma String
	 * informando ao usuário que não existe nenhum Fornecedor cadastrado no momento.
	 * 
	 * Caso tenha pelo menos 1 Fornecedor cadastrado, retornará em ordem alfabética
	 * todos os Fornecedores que estão cadastrados no momento e separando-os pelo
	 * caractere "|".
	 * 
	 * @return String representando todos os Fornecedores cadastrados.
	 */
	public String exibeTodosOsFornecedores() {

		ArrayList<String> Fornecedores = new ArrayList<>();
		for (Fornecedor Fornecedor : this.mapaFornecedores.values()) {
			Fornecedores.add(Fornecedor.toString());
		}
		if (!Fornecedores.isEmpty()) {
			Collections.sort(Fornecedores);
			return Fornecedores.stream().map(Fornecedor -> Fornecedor.toString()).collect(Collectors.joining(" | "));
		}
		return "NENHUM FORNECEDOR CADASTRADO!";
	}

	/**
	 * Edita as informações de um Fornecedor que tenha o identificador no mapa de
	 * Fornecedores igual ao nome passado como parâmetro (esta sendo a unica
	 * informação que não pode ser alterada, por ser o identificador de um
	 * Fornecedor no mapa de Fornecedores). Também irá verificar o uso de entradas
	 * inválidas como Strings vazias ou entradas nulas, caso isto aconteça, serão
	 * lançadas exceções de argumento ilegal e informando o primeiro argumento
	 * ilegal passado como parâmetro. Além disso, este método também verifica se o
	 * Fornecedor que está sendo editado existe, por meio de seu nome (identificador
	 * único), tendo os possíveis casos de retorno:
	 *
	 * Caso o Fornecedor não esteja cadastrado (não exista um identificador em mapa
	 * de Fornecedores igual ao nome passado como parâmetro), retornará uma String
	 * informando que não existe o Fornecedor desejado para a edição.
	 * 
	 * Caso o Fornecedor esteja cadastrado (exista um identificador em mapa de
	 * Fornecedores igual ao nome passado como parâmetro), retornará uma String
	 * informando que a edição foi bem sucedida.
	 *
	 * @param nome
	 * @param email
	 * @param telefone
	 * @return Situação da edição de um Fornecedor.
	 */
	public String editaFornecedor(String nome, String email, String telefone) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME NULO OU STRING VAZIA!");
		}
		if (email == null || email.equals("")) {
			throw new IllegalArgumentException("EMAIL NULO OU STRING VAZIA!");
		}
		if (telefone == null || telefone.equals("")) {
			throw new IllegalArgumentException("TELEFONE NULO OU STRING VAZIA!");
		}

		if (mapaFornecedores.containsKey(nome)) {
			this.mapaFornecedores.get(nome).setEmail(email);
			this.mapaFornecedores.get(nome).setTelefone(telefone);
			return "EDIÇÃO BEM SUCESSIDA";
		}
		return "EDIÇÃO MAL SUCESSIDA";
	}

	/**
	 * Remove um Fornecedor que tenha o identificador no mapa de Fornecedores igual
	 * ao nome passado como parâmetro. Também irá verificar o uso de uma entrada
	 * inválida como String vazia ou entrada nula, caso isto aconteça, será lançada
	 * uma exceção de argumento ilegal e informando que o nome passado como
	 * parâmetro é um argumento ilegal. Além disso, este método também verifica se o
	 * Fornecedor que está sendo removido existe, por meio de seu nome
	 * (identificador único), tendo os possíveis casos de retorno:
	 * 
	 * Caso o Fornecedor não esteja cadastrado (não exista um identificador em mapa
	 * de Fornecedores igual ao nome passado como parâmetro), retornará uma String
	 * informando que não existe o Fornecedor desejado para a remoção.
	 * 
	 * Caso o Fornecedor esteja cadastrado (exista um identificador em mapa de
	 * Fornecedores igual ao nome passado como parâmetro), retornará uma String
	 * informando que a remoção foi bem sucedida.
	 * 
	 * @param nome
	 * @return Situação da remoção de um Fornecedor.
	 */
	public String removerFornecedor(String nome) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("nome NULO OU STRING VAZIA!");
		}
		if (mapaFornecedores.containsKey(nome)) {
			mapaFornecedores.remove(nome);
			return "REMOÇÃO BEM SUCEDIDA!";
		}
		return "FORNECEDOR NÃO CADASTRADO!";
	}

	/**
	 * Cadastra um Produto em um Fornecedor passando as seguintes Strings
	 * representando, respetivamente, o nome do Fornecedor, e o nome, descrição e
	 * preço do Produto. Também irá verificar o uso de entradas inválidas como
	 * Strings vazias ou entradas nulas, caso isto aconteça, serão lançadas exceções
	 * de argumento ilegal e informando o primeiro argumento ilegal passado como
	 * parâmetro. Além disso, este método também verifica se o Fornecedor em que o
	 * Produto está sendo associado existe, por meio de seu nome (identificador
	 * único), tendo os possíveis casos de retorno:
	 * 
	 * Caso o Fornecedor tenha sido cadastrado (se existe um identificador em mapa
	 * de Fornecedores igual ao nome de Fornecedor passado como parâmetro),
	 * retornará uma String informando a situação do cadastro do Produto.
	 * 
	 * Caso o Fornecedor não tenha sido cadastrado (não exista um identificador em
	 * mapa de Fornecedores igual ao nome de Fornecedor passado como parâmetro),
	 * retornará uma String informando que o Fornecedor não foi cadastrado.
	 * 
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 * @return Situação do Cadastro de um Produto.
	 */
	public String cadastraProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		if (nomeFornecedor == null || nomeFornecedor.equals("")) {
			throw new IllegalArgumentException("NOME DO FORNECEDOR NULO OU STRING VAZIA!");
		}
		if (nomeProduto == null || nomeProduto.equals("")) {
			throw new IllegalArgumentException("NOME DO PRODUTO NULO OU STRING VAZIA!");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("DESCRIÇÃO NULO OU STRING VAZIA!");
		}

		if (mapaFornecedores.containsKey(nomeFornecedor)) {
			return mapaFornecedores.get(nomeFornecedor).cadastraProduto(nomeProduto, descricao, preco);
		}
		return "FORNECEDOR NÃO CADASTRADO!";
	}

	/**
	 * Retorna um Produto de um Fornecedor passando as seguintes Strings
	 * representando, respetivamente, o nome do Fornecedor, e o nome e descrição do
	 * Produto. Também irá verificar o uso de entradas inválidas como Strings vazias
	 * ou entradas nulas, caso isto aconteça, serão lançadas exceções de argumento
	 * ilegal e informando o primeiro argumento ilegal passado como parâmetro. Além
	 * disso, este método também verifica se o Fornecedor em que o Produto está
	 * sendo associado existe, por meio de seu nome (identificador único), tendo os
	 * possíveis casos de retorno:
	 * 
	 * Caso o Fornecedor tenha sido cadastrado (se existe um identificador em mapa
	 * de Fornecedores igual ao nome de Fornecedor passado como parâmetro),
	 * retornará uma String representando um Produto.
	 * 
	 * Caso o Fornecedor não tenha sido cadastrado (não exista um identificador em
	 * mapa de Fornecedores igual ao nome de Fornecedor passado como parâmetro),
	 * retornará uma String informando que o Fornecedor não foi cadastrado.
	 * 
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @return Representação em String de um Produto.
	 */
	public String exibeProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		if (nomeFornecedor == null || nomeFornecedor.equals("")) {
			throw new IllegalArgumentException("NOME DO FORNECEDOR NULO OU STRING VAZIA!");
		}
		if (nomeProduto == null || nomeProduto.equals("")) {
			throw new IllegalArgumentException("NOME DO PRODUTO NULO OU STRING VAZIA!");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("DESCRIÇÃO NULO OU STRING VAZIA!");
		}

		if (mapaFornecedores.containsKey(nomeFornecedor)) {
			return mapaFornecedores.get(nomeFornecedor).exibeProduto(nomeProduto, descricao);
		}
		return "FORNECEDOR NÃO CADASTRADO!";
	}

	/**
	 * Retorna todos os Produtos de um Fornecedor passando uma String representando
	 * o nome do Fornecedor. Também irá verificar o uso de entrada inválida como
	 * String vazia ou entrada nula, caso isto aconteça, será lançada uma exceção de
	 * argumento ilegal informando que o nome do Fornecedor passado como parâmetro é
	 * um argumento ilegal. Além disso, este método também verifica se existe o
	 * Fornecedor do qual o Produto é associado, por meio de seu nome (identificador
	 * único), tendo os possíveis casos de retorno:
	 * 
	 * Caso o Fornecedor tenha sido cadastrado (se existe um identificador em mapa
	 * de Fornecedores igual ao nome de Fornecedor passado como parâmetro),
	 * retornará uma String representando todos os Produtos.
	 * 
	 * Caso o Fornecedor não tenha sido cadastrado (não exista um identificador em
	 * mapa de Fornecedores igual ao nome de Fornecedor passado como parâmetro),
	 * retornará uma String informando que o Fornecedor não foi cadastrado.
	 * 
	 * @param nomeFornecedor
	 * @return Representação em String de todos os Produtos associados a um
	 *         Fornecedor
	 */
	public String exibeProdutosDoFornecedor(String nomeFornecedor) {
		if (nomeFornecedor == null || nomeFornecedor.equals("")) {
			throw new IllegalArgumentException("NOME DO FORNECEDOR NULO OU STRING VAZIA!");
		}

		if (mapaFornecedores.containsKey(nomeFornecedor)) {
			return mapaFornecedores.get(nomeFornecedor).toString();
		}
		return "FORNECEDOR NÃO CADASTRADO!";
	}

	/**
	 * Retorna uma String representando todos os Produtos cadastrados no sistema em
	 * ordem alfabética e separando-os com o caractere "|". Além disso, este método
	 * também verifica se existe algum Fornecedor cadastrado no sistema, tendo os
	 * possíveis casos de retorno:
	 * 
	 * Caso algum Fornecedor tenha sido cadastrado, retornará uma String
	 * representando todos os Produtos.
	 * 
	 * Caso nenhum Fornecedor tenha sido cadastrado, retornará uma String informando
	 * que não há Fornecedor cadastrado.
	 * 
	 * @return Representação em String de todos os Produtos cadastrados no sistema.
	 */
	public String exibeTodosOsProdutos() {
		ArrayList<String> Fornecedores = new ArrayList<>();
		for (Fornecedor Fornecedor : this.mapaFornecedores.values()) {
			Fornecedores.add(Fornecedor.exibeProdutosDoFornecedor());
		}
		if (!Fornecedores.isEmpty()) {
			Collections.sort(Fornecedores);
			return Fornecedores.stream().map(Fornecedor -> Fornecedor.toString()).collect(Collectors.joining(" | "));
		}

		return "NENHUM FORNECEDOR CADASTRADO!";
	}

	/**
	 * Edita as informações de um Produto que esteja acossiado a um Fornecedor
	 * identificado pelo nome de Fornecedor passado como parâmetro (está sendo a
	 * unica informação que não pode ser alterada, por ser o identificador de um
	 * Fornecedor no mapa de Fornecedores) além dos parâmetros referentes a nome,
	 * descrição e preço do Produto. Também irá verificar o uso de entradas
	 * inválidas como Strings vazias ou entradas nulas, caso isto aconteça, serão
	 * lançadas exceções de argumento ilegal e informando o primeiro argumento
	 * ilegal passado como parâmetro. Além disso, este método também verifica se o
	 * Fornecedor associado ao Produto que está sendo editado existe, por meio de
	 * seu nome (identificador único), tendo os possíveis casos de retorno:
	 *
	 * Caso o Fornecedor tenha sido cadastrado (se existe um identificador em mapa
	 * de Fornecedores igual ao nome de Fornecedor passado como parâmetro),
	 * retornará uma String representando todos os Produtos.
	 * 
	 * Caso o Fornecedor não tenha sido cadastrado (não exista um identificador em
	 * mapa de Fornecedores igual ao nome de Fornecedor passado como parâmetro),
	 * retornará uma String informando que o Fornecedor não foi cadastrado.
	 * 
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 * @return Situação da edição de um Produto.
	 */
	public String editaProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		if (nomeFornecedor == null || nomeFornecedor.equals("")) {
			throw new IllegalArgumentException("NOME DO FORNECEDOR NULO OU STRING VAZIA!");
		}
		if (nomeProduto == null || nomeProduto.equals("")) {
			throw new IllegalArgumentException("NOME DO PRODUTO NULO OU STRING VAZIA!");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("DESCRIÇÃO NULO OU STRING VAZIA!");
		}

		if (mapaFornecedores.containsKey(nomeFornecedor)) {
			return mapaFornecedores.get(nomeFornecedor).editaProduto(nomeProduto, descricao, preco);
		}
		return "FORNECEDOR NÃO ESTÁ CADASTRADO!";
	}

	/**
	 * Remove um Produto que esteja acossiado a um Fornecedor identificado pelo nome
	 * de Fornecedor passado como parâmetro (está sendo a unica informação que não
	 * pode ser alterada, por ser o identificador de um Fornecedor no mapa de
	 * Fornecedores) além dos parâmetros referentes a nome e descrição do Produto.
	 * Também irá verificar o uso de entradas inválidas como Strings vazias ou
	 * entradas nulas, caso isto aconteça, serão lançadas exceções de argumento
	 * ilegal e informando o primeiro argumento ilegal passado como parâmetro. Além
	 * disso, este método também verifica se o Fornecedor associado ao Produto que
	 * está sendo editado existe, por meio de seu nome (identificador único), tendo
	 * os possíveis casos de retorno:
	 *
	 * Caso o Fornecedor tenha sido cadastrado (se existe um identificador em mapa
	 * de Fornecedores igual ao nome de Fornecedor passado como parâmetro),
	 * retornará uma String representando todos os Produtos.
	 * 
	 * Caso o Fornecedor não tenha sido cadastrado (não exista um identificador em
	 * mapa de Fornecedores igual ao nome de Fornecedor passado como parâmetro),
	 * retornará uma String informando que o Fornecedor não foi cadastrado.
	 * 
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @return Situação da remoção de um Produto
	 */
	public String removeProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		if (nomeFornecedor == null || nomeFornecedor.equals("")) {
			throw new IllegalArgumentException("NOME DO FORNECEDOR NULO OU STRING VAZIA!");
		}
		if (nomeProduto == null || nomeProduto.equals("")) {
			throw new IllegalArgumentException("NOME DO PRODUTO NULO OU STRING VAZIA!");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("DESCRIÇÃO NULO OU STRING VAZIA!");
		}

		if (mapaFornecedores.containsKey(nomeFornecedor)) {
			return mapaFornecedores.get(nomeFornecedor).removeProduto(nomeProduto, descricao);
		}
		return "FORNECEDOR NÃO ESTÁ CADASTRADO!";
	}
}