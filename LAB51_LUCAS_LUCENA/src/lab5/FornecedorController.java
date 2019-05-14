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
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}

		if (!mapaFornecedores.containsKey(nome)) {
			Fornecedor f = new Fornecedor(nome, email, telefone);
			mapaFornecedores.put(nome, f);
			return nome;
		} else {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
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
			throw new IllegalArgumentException("Erro no exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
		}

		if (mapaFornecedores.containsKey(nome)) {
			return mapaFornecedores.get(nome).toString();
		} else {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
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
		} else {
			throw new IllegalArgumentException(
					"Erro na exibicao de todos os fornecedores: nao existe nenhum fornecedor cadastrado");
		}
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
	 * @param atributo
	 * @param novoValor
	 * @return Situação da edição de um Fornecedor.
	 */
	public String editaFornecedor(String nome, String atributo, String novoValor) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if (atributo == null || atributo.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}
		if (novoValor == null || novoValor.equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}

		if (mapaFornecedores.containsKey(nome)) {
			if (atributo.equals("email")) {
				this.mapaFornecedores.get(nome).setEmail(novoValor);
				return novoValor;
			} else if (atributo.equals("telefone")) {
				this.mapaFornecedores.get(nome).setTelefone(novoValor);
				return novoValor;
			} else if (atributo.equals("nome")) {
				throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
			} else {
				throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
			}
		} else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
		}
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
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}
		if (mapaFornecedores.containsKey(nome)) {
			mapaFornecedores.remove(nome);
			return "REMOÇÃO BEM SUCEDIDA!";
		} else {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
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
	public String cadastraProduto(String nomeFornecedor, String nomeProduto, String descricao, float preco) {
		if (nomeFornecedor == null || nomeFornecedor.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if (nomeProduto == null || nomeProduto.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
		if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}

		if (mapaFornecedores.containsKey(nomeFornecedor)) {
			return mapaFornecedores.get(nomeFornecedor).cadastraProduto(nomeProduto, descricao, preco);
		} else {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
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
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if (nomeProduto == null || nomeProduto.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}

		if (mapaFornecedores.containsKey(nomeFornecedor)) {
			return mapaFornecedores.get(nomeFornecedor).exibeProduto(nomeProduto, descricao);
		} else {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}

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
			throw new IllegalArgumentException(
					"Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		if (mapaFornecedores.containsKey(nomeFornecedor)) {
			return mapaFornecedores.get(nomeFornecedor).exibeProdutosDoFornecedor();
		} else {
			throw new IllegalArgumentException(
					"Erro na exibicao de produto: fornecedor nao existe.");
		}
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
		if (!mapaFornecedores.isEmpty()) {
			ArrayList<String> Fornecedores = new ArrayList<>();
			for (Fornecedor Fornecedor : this.mapaFornecedores.values()) {
				Fornecedores.add(Fornecedor.exibeProdutosDoFornecedor());
			}			
			if (!Fornecedores.isEmpty()) {
				Collections.sort(Fornecedores);
			}
			return Fornecedores.stream().map(Fornecedor -> Fornecedor.toString()).collect(Collectors.joining(" | "));
		} 
		else {
			throw new IllegalArgumentException("Erro na exibicao de todos os produtos: nenhum fornecedor cadastrado");
		}
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
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if (nomeProduto == null || nomeProduto.equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}
		if (preco < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}

		if (mapaFornecedores.containsKey(nomeFornecedor)) {
			return mapaFornecedores.get(nomeFornecedor).editaProduto(nomeProduto, descricao, preco);
		} else {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
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
		if (nomeProduto == null || nomeProduto.equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
		if (nomeFornecedor == null || nomeFornecedor.equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		if (mapaFornecedores.containsKey(nomeFornecedor)) {
			return mapaFornecedores.get(nomeFornecedor).removeProduto(nomeProduto, descricao);
		} else {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}

	}
}