package lab5;

public class Compra {

	
	private String data; 
	
	private String nome; 
	
	private String descricao;
	
	private double preco;
	
	public Compra(String data, String nome, String descricao, double preco) {
		if (data == null || data.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		}
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		}
		
		this.data = data;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	@Override
	public String toString() {
		return nome + " - " + data;
	}

	public String getData() {
		return data;
	}

	public String getNome() {
		return nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
}
