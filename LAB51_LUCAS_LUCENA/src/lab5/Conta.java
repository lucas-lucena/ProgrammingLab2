package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Conta {
	
	private String fornecedor; 

	private double debito;
	
	private List<Compra> compras;
	
	public Conta(String fornecedor) {
		if (fornecedor == null || fornecedor.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		}
		
		this.fornecedor = fornecedor;
		compras = new ArrayList<Compra>();
	}

	public void adicionaCompra(String data, String nome, String descricao, double preco) {
		if (data == null || data.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		}
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		}
		
		Compra compra = new Compra(data, nome, descricao, preco);
		this.compras.add(compra);
	}
	
	public String exibeCompras() {
		if (!compras.isEmpty()) {
			
//			Collections.sort(this.compras, new ComparaCompra());
			
			return this.fornecedor + " | " + compras.stream().map(p -> p.toString()).collect(Collectors.joining(" | "));
		}
		else {
			return this.fornecedor + " | ";
		}

	}

	public String getDebito() {
		double debito = 0;
		for (Compra compra: compras) {
			debito += compra.getPreco();
		}

		String r = String.format("%.2f", debito);
		String[] e = r.split(",");
		String x = e[0] + "." + e[1];
		return x;
	}

	public String getFornecedor() {
		return fornecedor;
	}
	
	
	
}
