package lab5;



public class Combo extends Produto {

	Produto produto1;
	
	double preco1;
	
	Produto produto2;
	
	double preco2;
	
	double fator;
	
	public Combo(String nome, String descricao, double fator, Produto produto1, Produto produto2) {
		super(nome, descricao, (produto1.getPreco()+produto2.getPreco()), fator);
		
		this.fator = fator;
		this.produto1 = produto1;
		this.produto2 = produto2;
		this.preco1 = produto1.getPreco();
		this.preco2 = produto2.getPreco();
		
	}
	
	public String toString() {
		String resultado = String.format("%.2f", this.getPreco());
		return this.getNome() + " - " + this.getDescricao() + " - R$" + resultado;
	}
	
	public double getPreco() {
		double soma = preco1 + preco2;
		return soma - (soma*this.fator);
	}

	public Produto getProduto1() {
		return produto1;
	}

	public Produto getProduto2() {
		return produto2;
	}
	
	public void setFator(double fator) {
		this.fator = fator;
	}
	
}
