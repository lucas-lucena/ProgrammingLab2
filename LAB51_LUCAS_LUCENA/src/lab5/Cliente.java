package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import comparators.ComparaConta;

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
	
	public HashMap getMapa() {
		return this.mapaContas;
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

	public String adicionaCompra(String fornecedor, String data, String nomeDoProduto, String descricaoDoProduto, double preco) {
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
			mapaContas.get(fornecedor).adicionaCompra(data, nomeDoProduto, descricaoDoProduto, preco);
		}
		else {
			Conta conta = new Conta(fornecedor);
			conta.adicionaCompra(data, nomeDoProduto, descricaoDoProduto, preco);
			mapaContas.put(fornecedor, conta);
		}
		
		return null;
	}

	public String getDebito(String fornecedor) {
		if (fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		}
		
		if (mapaContas.containsKey(fornecedor)) {
			return mapaContas.get(fornecedor).getDebito();
		}
		else {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		}
		
	}

	public String exibeContas(String fornecedor) {
		if (fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		}
		
		if (mapaContas.containsKey(fornecedor)) {
			return "Cliente: " + this.nome  + " | " +  mapaContas.get(fornecedor).exibeCompras();
		}
		else {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}
	}
	
	public String exibeContasClientes() {
		if (!mapaContas.isEmpty()) {
			List<Conta> Contas = new ArrayList<>();
			Contas.addAll(this.mapaContas.values());
			
			Collections.sort(Contas, new ComparaConta());

			return this.nome + " | " + Contas.stream().map(c -> c.exibeCompras()).collect(Collectors.joining(" | "));
			

		//	return this.nome + " | " + Contas.stream().map(Conta -> Conta.toString()).collect(Collectors.joining(" | "));
		} 
		else {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		}
	}

	public String realizaPagamento(String fornecedor) {
		if (fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro no pagamento da conta: fornecedor nao pode ser vazio ou nulo.");
		}
		
		if (mapaContas.containsKey(fornecedor)) {
			mapaContas.remove(fornecedor);
			return "PAGAMENTO BEM SUCEDIDO!";
		}
		else {
			throw new IllegalArgumentException("Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");
		}
	}
	
	public String listar
	
	
}