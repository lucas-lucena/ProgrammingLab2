package lab2;

/**
 * A representação de uma disciplina. Toda disciplina tem um nome, uma
 * quantidade de horas de estudos da disciplina, 4 notas e a media dessas notas.
 *
 * @author Lucas Leal de Lucena
 */
public class Disciplina {

	/**
	 * Nome da da disciplina.
	 */
	private String nome;

	/**
	 * Quantidade de horas que serão cadastradas.
	 */
	private int horas;

	/**
	 * As 4 notas da disciplina.
	 */
	private double[] notas;

	/**
	 * Constrói a Disciplina com o nome fornecido, e predefine 0 horas de estudo,
	 * uma lista para atribuir as 4 notas e a media igual a 0,0.
	 * 
	 * @param Nome da disciplina.
	 */
	public Disciplina(String nomeDaDisciplina) {
		this.nome = nomeDaDisciplina;
		this.horas = 0;
		this.notas = new double[4];
	}

	/**
	 * Adiciona uma quantidade de horas a variavel local horas.
	 * 
	 * @param Quantidade de horas.
	 */
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}

	/**
	 * Adiciona o valor de uma nota dentro da array notas na posição da nota.
	 * 
	 * @param Valor da posição da nota.
	 * @param Valor da nota na disciplina.
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}

	/**
	 * Faz a media das notas na array de notas.
	 * 
	 * @return A media das notas.
	 */
	private double fazMedia() {
		double media = 0.0;
		for (int i = 0; i < 4; i++) {
			media += this.notas[i];
		}
		media = media / 4.0;
		return (media);
	}

	/**
	 * Retorna o booleano.
	 * 
	 * @return A representação booleana se a média está maior ou igual a 7.
	 */
	public boolean aprovado() {
		return (this.fazMedia() >= 7.0);
	}

	/**
	 * Retorna a String que representa a Disciplina. A representação segue o formato
	 * "nome horas media [nota[0], nota[1], nota[2], nota[3]]".
	 * 
	 * @return A representação em String da Disciplina.
	 */
	public String toString() {
		return 	nome + " " + horas + " " + this.fazMedia() + " [" + notas[0] + ", " +
				notas[1] + ", " + notas[2] + ", " + notas[3] + "]";
	}
}