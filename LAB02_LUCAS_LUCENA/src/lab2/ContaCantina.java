package lab2;

/**
 * A representação da conta de uma cantina. Toda conta de cantina tem um nome,
 * uma divida com o cliente, a quantidade de itens consumidos e todo o preço
 * gasto com a cantina.
 * 
 * @author Lucas Leal de Lucena
 */
public class ContaCantina {

	/**
	 * Nome da cantina.
	 */
	private String nome;

	/**
	 * Divida do aluno com a cantina.
	 */
	private int dividaAtual;

	/**
	 * Itens que o aluno consumiu na cantina.
	 */
	private int itens;

	/**
	 * Soma do valor de todos os itens comprados na cantina até então.	
	 */
	private int dividaTotal;

	/**
	 * Constrói a conta na cantina com o nome, a quantidade de itens, a divida atual
	 * e a divida total igual a 0.
	 * 
	 * @param Nome da cantina.
	 */
	public ContaCantina(String nomeDaCantina) {
		this.nome = nomeDaCantina;
		this.itens = 0;
		this.dividaAtual = 0;
		this.dividaTotal = 0;
	}

	/**
	 * Cadastra a compra de um ou mais lanches com o valor em centavos na divida
	 * atual e total, e o numero de itens em itens.
	 * 
	 * @param Numero de itens comprados.
	 * @param Valor  em centavos da compra.
	 */
	public void cadastraLanche(int numeroDeItens, int valorCentavos) {
		this.itens += numeroDeItens;
		this.dividaAtual += valorCentavos;
		this.dividaTotal += valorCentavos;
	}

	/**
	 * Recebe uma parte do pagamento com o valor em centavos para reduzir a divida
	 * atual.
	 * 
	 * @param Valor em centavos do pagamento.
	 */
	public void pagaConta(int valorCentavos) {
		this.dividaAtual -= valorCentavos;
		if (dividaAtual < 0) {
			this.dividaAtual = 0;
		}
	}

	/**
	 * Retorna um inteiro da divida atual com a cantina, ou seja quanto o dono da
	 * conta deve pagar ainda.
	 * 
	 * @return A divida atual.
	 */
	public int getFaltaPagar() {
		return (dividaAtual);
	}

	/**
	 * Retorn A String que representa a conta da cantina. A representação segue o
	 * formato "Nome Itens Divida Total".
	 * 
	 * @return A representação de um string Conta da cantina.
	 */
	public String toString() {
		return (nome + " " + itens + " " + dividaTotal);
	}
}