package lab5;

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
	 * Constroi um objeto cliente, com cpf, nome, um local e um email.
	 * 
	 * @param cpf
	 * @param nome
	 * @param local
	 * @param email
	 */
	public Cliente(String cpf, String nome, String local, String email) {
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
		
		this.cpf = cpf;
		this.nome = nome;
		this.local = local;
		this.email = email;
	}
	
	/**
	 * Retorna a representação em String de um cliente seguindo o modelo:
	 * "NOME - LOCAL - EMAIL"
	 */
	public String toString() {
		return this.nome + " - " + this.local + " - " + this.email;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
