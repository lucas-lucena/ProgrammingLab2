package lab5;

public class Produto {

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
	private String preco;

	/**
	 * Constroi um objeto Produto, que tenha como atributos as Strings que
	 * representam os nome, descrição e preço que estão associados ao Produto.
	 * 
	 * @param nome
	 * @param descricao
	 * @param preco
	 */
	public Produto(String nome, String descricao, String preco) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME NULO OU STRING VAZIA!");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("DESCRIÇÃO NULO OU STRING VAZIA!");
		}

		String resultado = String.format("%.2f", this.preco);
		this.nome = nome;
		this.descricao = descricao;
		this.preco = resultado;
	}
	
	/**
	 * Retorna a representação em String de um Produto seguindo o modelo: 
	 * "NOME - DESCRIÇÃO - PREÇO"
	 * 
	 * @return Representação em String do Produto.
	 */
	@Override
	public String toString() {
		String resultado = String.format("%.2f", this.preco);
		return nome + " - " + descricao + " - R$" + resultado;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco (String preco) {
		String resultado = String.format("%.2f", preco);
		this.preco = resultado;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
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
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}