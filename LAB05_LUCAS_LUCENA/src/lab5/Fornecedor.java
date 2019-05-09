package lab5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Fornecedor {
	/**
	 * Nome do Fornecedor.
	 */
	private String nome;

	/**
	 * Email do Fornecedor.
	 */
	private String email;

	/**
	 * Telefone do Fornecedor.
	 */
	private String telefone;

	private HashMap<String, Produto> mapaProdutos;

	/**
	 * Constroi um objeto Fornecedor que tem como atributos as Strings nome, email e
	 * telefone que estão associados ao Fornecedor.
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 */
	public Fornecedor(String nome, String email, String telefone) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME NULO OU STRING VAZIA!");
		}
		if (email == null || email.equals("")) {
			throw new IllegalArgumentException("EMAIL NULO OU STRING VAZIA!");
		}
		if (telefone == null || telefone.equals("")) {
			throw new IllegalArgumentException("TELEFONE NULO OU STRING VAZIA!");
		}

		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.mapaProdutos = new HashMap<>();
	}

	/**
	 * Retorna a representação em String de um Fornecedor seguindo o modelo: "NOME -
	 * EMAIL - TELEFONE"
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		return nome + ", - " + email + " - " + telefone;
	}

	// Operações referentes a produto.

	/**
	 * Cadastra um Produto no mapa de Produtos passando uma String nome + descrição
	 * como identificador, e recebe Strings representando, respetivamente, nome,
	 * descrição e preço de um Produto. Também irá verificar o uso de entradas
	 * inválidas como Strings vazias ou entradas nulas, caso isto aconteça, serão
	 * lançadas exceções de argumento ilegal e informando o primeiro argumento
	 * ilegal passado como parâmetro. Além disso, este método também verifica se o
	 * Produto que está sendo criado já existe, por meio de seu nome (identificador
	 * único), tendo os possíveis casos de retorno:
	 * 
	 * Caso o Produto não tenha sido cadastrado (não exista um identificador em mapa
	 * de Produtos igual ao nome passado como parâmetro), retornará uma String
	 * informando que o cadastro foi bem sucedido.
	 * 
	 * Caso o Produto já tenha sido cadastrado (já exista um identificador em mapa
	 * de Produtos igual ao nome passado como parâmetro), retornará uma String
	 * informando que o Produto já tinha sido cadastrado anteriormente.
	 * 
	 * @param nome
	 * @param descricao
	 * @param preco
	 * @return Situação do cadastro de um Produto.
	 */ // apagar nota verde assim que refatorar
	public String CadastraProduto(String nome, String descricao, double preco) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME NULO OU STRING VAZIA!");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("DESCRIÇÃO NULO OU STRING VAZIA!");
		}

		String idProduto = nome + descricao;
		if (!mapaProdutos.containsKey(idProduto)) {
			Produto p = new Produto(nome, descricao, preco);
			mapaProdutos.put(idProduto, p);
			return "CADASTRO BEM SUCEDIDO!";
		}
		return "PRODUTO JÁ CADASTRADO!";

	}

	/**
	 * Retornar a representação em String de um Produto que está associado a String
	 * nome + descrição passada como parâmetro está presente no mapa de Produtos.
	 * Também irá verificar o uso de entradas inválidas como String vazia ou entrada
	 * nula, caso isto aconteça, será lançada uma exceçõe de argumento ilegal e
	 * informando que o nome passado como parâmetro é um argumento ilegal. Além
	 * disso, este método também verifica se o Produto que está sendo exibido
	 * existe, por meio de seu nome + descrição (identificador único), tendo os
	 * possíveis casos de retorno:
	 * 
	 * 
	 * Caso o Produto não tenha sido cadastrado (não exista um identificador em mapa
	 * de Produtos igual ao nome + descrição passado como parâmetro), retornará uma
	 * String informando que o Produto não pode ser exibido, por não ter sido
	 * cadastrado.
	 * 
	 * Caso o Produto tenha sido cadastrado (já exista um identificador em mapa de
	 * Produtos igual ao nome + descrição passado como parâmetro), retornará a
	 * representação em String do Produto associado ao nome + descrição.
	 * 
	 * @param nome
	 * @param descricao
	 * @return Representação em String de um Produto.
	 */
	public String ExibeProduto(String nome, String descricao) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME NULO OU STRING VAZIA!");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("DESCRIÇÃO NULO OU STRING VAZIA!");
		}

		String idProduto = nome + descricao;
		if (mapaProdutos.containsKey(idProduto)) {
			return mapaProdutos.get(idProduto).toString();
		}
		return "PRODUTO NÃO CADASTRADO!";
	}

	/**
	 * Retornar a representação em String de todos os Produtos associados a um
	 * Fornecedor em ordem alfabetica e separando-os com "|". Além disso, este
	 * método também verifica se no sistema não existe nenhum Produrp cadastrado,
	 * tendo os possíveis casos de retorno.
	 * 
	 * Caso não tenha nenhum Produto cadastrado no sistema, retornará uma String
	 * informando ao usuário que não existe nenhum Produto cadastrado no momento.
	 * 
	 * Caso tenha pelo menos 1 Produto cadastrado, retornará em ordem alfabética
	 * todos os Produtos que no momento estão associados a um determinado
	 * Fornecedor, e separando-os pelo caractere "|".
	 * 
	 * @return Representa todos os Produtos de um Fornecedor.
	 */
	public String ExibeProdutosDoFornecedor() {
		ArrayList<String> Produtos = new ArrayList<>();
		for (Produto Produto : this.mapaProdutos.values()) {
			Produtos.add(this.nome + " - " + Produto.toString());
		}
		if (!Produtos.isEmpty()) {
			Collections.sort(Produtos);
			return Produtos.stream().map(Fornecedor -> Fornecedor.toString()).collect(Collectors.joining(" | "));
		}
		return "NENHUM PRODUTO CADASTRADO!";
	}

	/**
	 * Edita as informações de um Produto que tenha o identificador no mapa de
	 * Produtos igual ao nome + descrição passados como parâmetros (estás sendo as
	 * unicas informações que não podem ser alteradas, por serem os identificadores
	 * de um Produto no mapa de Produtos). Também irá verificar o uso de entradas
	 * inválidas como Strings vazias ou entradas nulas, caso isto aconteça, serão
	 * lançadas exceções de argumento ilegal e informando o primeiro argumento
	 * ilegal passado como parâmetro. Além disso, este método também verifica se o
	 * Produto que está sendo editado existe, por meio de seu nome + descrição
	 * (identificador único), tendo os possíveis casos de retorno:
	 *
	 * Caso o Produto não esteja cadastrado (não exista um identificador em mapa de
	 * Produtos igual ao nome + descrição passado como parâmetro), retornará uma
	 * String informando que não existe o Produto desejado para a edição.
	 * 
	 * Caso o Produto esteja cadastrado (exista um identificador em mapa de Produtos
	 * igual ao nome + descrição passado como parâmetro), retornará uma String
	 * informando que a edição foi bem sucedida.
	 * 
	 * @param nome
	 * @param descricao
	 * @param preco
	 * @return Situação da edição de um Produto.
	 */
	public String EditaProduto(String nome, String descricao, double preco) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME NULO OU STRING VAZIA!");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("DESCRIÇÃO NULO OU STRING VAZIA!");
		}

		String idProduto = nome + descricao;
		if (mapaProdutos.containsKey(idProduto)) {
			this.mapaProdutos.get(idProduto).setPreco(preco);
			return "EDIÇÃO BEM SUCEDIDA!";
		}
		return "PRODUTO NÃO CADASTRADO!";
	}

	/**
	 * Remove um Produto que tenha o identificador no mapa de Produtos igual ao nome
	 * + descrição passado como parâmetro. Também irá verificar o uso de uma entrada
	 * inválida como String vazia ou entrada nula, caso isto aconteça, será lançada
	 * uma exceção de argumento ilegal e informando que o nome passado como
	 * parâmetro é um argumento ilegal. Além disso, este método também verifica se o
	 * Produto que está sendo removido existe, por meio de seu nome + descrição
	 * (identificador único), tendo os possíveis casos de retorno:
	 * 
	 * Caso o Produto não esteja cadastrado (não exista um identificador em mapa de
	 * Produtos igual ao nome + descrição passados como parâmetros), retornará uma
	 * String informando que não existe o Produto desejado para a remoção.
	 * 
	 * Caso o Produto esteja cadastrado (exista um identificador em mapa de Produtos
	 * igual ao nome + descrição passados como parâmetros), retornará uma String
	 * informando que a remoção foi bem sucedida.
	 * 
	 * @param nome
	 * @param descricao
	 * @return Situação da remoção de um Produto.
	 */
	public String RemoveProduto(String nome, String descricao) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME NULO OU STRING VAZIA!");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("DESCRIÇÃO NULO OU STRING VAZIA!");
		}

		String idProduto = nome + descricao;
		if (mapaProdutos.containsKey(idProduto)) {
			this.mapaProdutos.remove(idProduto);
			return "REMOÇÃO BEM SUCEDIDA!";
		}
		return "PRODUTO NÃO CADASTRADO!";

	}

	// Outros métodos de Fornecedor (getters, setters, hashcode e equals).

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}