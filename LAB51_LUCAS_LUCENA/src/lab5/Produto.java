package lab5;

public abstract class Produto {

	/**
	 * Nome do Produto.
	 */
	private String nome;

	/**
	 * Descrição do Produto.
	 */
	private String descricao;

	/**
	 * Preço do Produto.
	 */
	private double preco;
	
	private double fator;

	/**
	 * Constroi um objeto Produto, que tenha como atributos as Strings que
	 * representam os nome, descrição e preço que estão associados ao Produto.
	 * 
	 * @param nome
	 * @param descricao
	 * @param preco
	 */
	public Produto(String nome, String descricao, double preco, double fator) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME NULO OU STRING VAZIA!");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("DESCRIÇÃO NULO OU STRING VAZIA!");
		}
		if (preco < 0) {
			throw new IllegalArgumentException("PRECO INVALIDO!");
		}

		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	/**
	 * Retorna a representação em String de um Produto seguindo o modelo: "NOME -
	 * DESCRIÇÃO - PREÇO"
	 * 
	 * @return Representação em String do Produto.
	 */
	@Override
	public String toString() {
		String resultado = String.format("%.2f", preco);
		return nome + " - " + descricao + " - R$" + resultado;
	}

	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public double getFator() {
		return this.fator;
	}
	
	public void setFator(double fator) {
		this.fator = fator;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		Produto other = (Produto) obj;
		if (!(nome + descricao).equals(other.nome + other.descricao))
			return false;
		return true;
	}

}