package lab5;

import java.lang.reflect.Array;
import java.util.HashMap;

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
	 * Retorna a representação em String de um Fornecedor seguindo o modelo: 
	 * "NOME - EMAIL - TELEFONE"
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		return nome + ", - " + email + " - " + telefone;
	}
	
	// Operações referentes a produto. // apagar nota verde assim que refatorar
	
	/**
	 * 
	 * @param nome
	 * @param descricao
	 * @param preco
	 * @return
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
	
	// Outros métodos de Fornecedor // apagar nota verde assim que refatorar
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
