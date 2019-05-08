package lab5;

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

	/**
	 * Constroi um objeto Fornecedor que tem como atributos as Strings nome, email e
	 * telefone que estão associados ao Fornecedor.
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 */
	public Fornecedor(String nome, String email, String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	/**
	 * Retorna a representação em String de um Fornecedor seguindo o modelo: "NOME -
	 * EMAIL - TELEFONE"
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		return "Fornecedor [nome=" + nome + ", email=" + email + ", telefone=" + telefone + "]";
	}

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
