package lab2;

/**
 * A representação da conta de um laboratório. Toda conta tem um nome pelo qual
 * será identificado, uma cota de quantos MB poderão ser consumidos e uma
 * representação do consumo atual.
 *
 * @author Lucas Leal de Lucena
 */
public class ContaLaboratorio {

	/**
	 * Nome da conta do laboratório.
	 */
	private String nome;

	/**
	 * Cota de MB que a conta permite.
	 */
	private int cota;

	/**
	 * A quantidade de MB consumidos na conta.
	 */
	private int consumo;

	/**
	 * Constrói a conta do laboratório com o nome e a cota predefinida de 2000 MB.
	 * 
	 * @param Nome do laboratorio.
	 */
	public ContaLaboratorio(String nomeDoLaboratorio) {
		this.nome = nomeDoLaboratorio;
		this.consumo = 0;
		this.cota = 2000;
	}

	/**
	 * Constrói a conta do laboratório com o nome e definindo a cota de MB.
	 * 
	 * @param Nome do laboratório.
	 * @param Cota de MB que o laboratório suporta.
	 */
	public ContaLaboratorio(String nomeDoLaboratorio, int cota) {
		this.nome = nomeDoLaboratorio;
		this.cota = cota;
		this.consumo = 0;
	}

	/**
	 * Adiciona o valor de mbytes a variavel consumo, não retorna nada.
	 * 
	 * @param Quantidade de MB.
	 */
	public void consomeEspaco(int mbytes) {
		this.consumo += mbytes;
	}

	/**
	 * Reduz o valor de mbytes a variavel consumo, não retorna nada.
	 * 
	 * @param Quantidade de MB.
	 */
	public void liberaEspaco(int mbytes) {
		this.consumo -= mbytes;
	}

	/**
	 * Retorna o booleano.
	 * 
	 * @return A representação booleana se o consumo ultrapassou a cota ou não.
	 */
	public boolean atingiuCota() {
		return ((consumo - cota) >= 0);
	}

	/**
	 * Retorna a String que representa a conta do laboratório. A representação segue
	 * o formato "NomeDoLab 1999/2000".
	 *
	 * @return A representação em String da conta do laboratório.
	 */
	public String toString() {
		return this.nome + " " + this.consumo + "/" + this.cota;
	}
}