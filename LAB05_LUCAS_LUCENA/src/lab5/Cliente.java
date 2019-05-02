package lab5;

public class Cliente {
	
	private String cpf;
	
	private String nome;
	
	private String local;
	
	private String email;
	
	
	public Cliente(String cpf, String nome, String local, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.local = local;
		this.email = email;
	}
	
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
