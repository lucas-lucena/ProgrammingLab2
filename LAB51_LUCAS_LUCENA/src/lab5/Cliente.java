package lab5;

import java.util.HashMap;

public class Cliente {
	/**
	 * Cpf do Cliente.
	 */
	private String cpf;

	/**
	 * Nome do Cliente.
	 */
	private String nome;

	/**
	 * Local em que o Cliente é associado.
	 */
	private String local;

	/**
	 * Email do Cliente.
	 */
	private String email;
	
	/**
	 * Mapa de compras.
	 */
	private HashMap<String, Conta> mapaContas;

	/**
	 * Constroi um objeto Cliente, que tenha como atributos as Strings que
	 * representam o cpf, nome, um local e um email que estão associados ao Cliente.
	 * 
	 * @param cpf
	 * @param nome
	 * @param local
	 * @param email
	 */
	public Cliente(String cpf, String nome, String email, String local) {
		if (cpf == null || cpf.equals("") || cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME NULO OU STRING VAZIA!");
		}
		if (email == null || email.equals("")) {
			throw new IllegalArgumentException("EMAIL NULO OU STRING VAZIA!");
		}
		if (local == null || local.equals("")) {
			throw new IllegalArgumentException("LOCAL NULO OU STRING VAZIA!");
		}

		mapaContas = new HashMap<>();
		this.cpf = cpf;
		this.nome = nome;
		this.local = local;
		this.email = email;
	}

	/**
	 * Retorna a representação em String de um Cliente seguindo o modelo: "NOME -
	 * LOCAL - EMAIL"
	 * 
	 * @return Representação em string do Cliente.
	 */
	public String toString() {
		return nome + " - " + local + " - " + email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return this.local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	public String adicionaCompra(String fornecedor, String data, String nomeDoProduto, String descricaoDoProduto) {
		if (fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		}
		if (data == null || data.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		}
		if (nomeDoProduto == null || nomeDoProduto.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		}
		if (descricaoDoProduto == null || descricaoDoProduto.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		}
		
		if (mapaContas.containsKey(fornecedor)) {
			mapaContas.get(fornecedor).adicionaCompra(data, nomeDoProduto, descricaoDoProduto);
		}
		else {
			Conta conta = new Conta(fornecedor);
			conta.adicionaCompra(data, nomeDoProduto, descricaoDoProduto);
			mapaContas.put(fornecedor, conta);
		}
		
		return null;
	}
}