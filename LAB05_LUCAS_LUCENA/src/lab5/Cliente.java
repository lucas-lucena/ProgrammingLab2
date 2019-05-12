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

		this.cpf = cpf;
		this.nome = nome;
		this.local = local;
		this.email = email;
	}

	/**
	 * Retorna a representação em String de um Cliente seguindo o modelo: 
	 * "NOME - LOCAL - EMAIL"
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
}