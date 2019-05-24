package lab5;

public class Compra {

	private String cliente;

	private String fornecedor;

	private String data;

	private String year;

	private String month;

	private String day;

	private String nome;

	private String descricao;

	private double preco;

	public Compra(String data, String nome, String descricao, double preco, String fornecedor, String cliente) {
		if (data == null || data.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		}
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException(
					"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		}

		String[] dataElements = data.split("/");
		this.year = dataElements[2];
		this.month = dataElements[1];
		this.day = dataElements[0];

		this.data = data;
		this.fornecedor = fornecedor;
		this.cliente = cliente;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	@Override
	public String toString() {
		String newData = this.day + "-" + this.month + "-" + this.year;
		return nome + " - " + newData;
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

	public String getCliente() {
		return cliente;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public String getYear() {
		return year;
	}

	public String getMonth() {
		return month;
	}

	public String getDay() {
		return day;
	}

	public String porCliente() {
		return this.cliente + ", " + this.fornecedor + ", " + this.descricao + ", " + this.data;
	}

	public String porFornecedor() {
		return this.fornecedor + ", " + this.cliente + ", " + this.descricao + ", " + this.data;
	}

	public String porData() {
		return this.data + ", " + this.cliente + ", " + this.fornecedor + ", " + this.descricao;
	}

}
