package lab2;

/**
 * Representação da saúde de um estudante em que apresenta estados da saúde
 * mental, física e geral.
 * 
 * @author Lucas Leal de Lucena
 */
public class Saude {

	/**
	 * Sauúe geral do aluno, pode ser boa, ok ou fraca.
	 */
	private String saudeGeral;

	/**
	 * Saúde física do aluno, pode ser boa ou fraca.
	 */
	private String saudeFisica;

	/**
	 * Saúde mental do aluno, pode ser boa ou fraca.
	 */
	private String saudeMental;

	/**
	 * Constrói a representação da Saúde com todas as saúdes mental, física e geral
	 * boas.
	 * 
	 */
	public Saude() {
		saudeGeral = "boa";
		saudeFisica = "boa";
		saudeMental = "boa";

	}

	/**
	 * Define a saúde geral com base na saúde física e na mental. caso as duas forem
	 * "boa" a geral será boa, ou se as duas forem "fraca" a geral tembém será
	 * fraca, mas se a física e e a mental forem diferentes a geral será "ok". Não
	 * retorna nada.
	 * 
	 */
	private void defineSaudeGeral() {
		if (saudeFisica.equals("boa") && saudeMental.equals("boa")) {
			this.saudeGeral = "boa";
		} else if (!saudeFisica.equals(saudeMental)) {
			this.saudeGeral = "ok";
		} else {
			this.saudeGeral = "fraca";
		}
	}

	/**
	 * Define a saúde mental com o valor que receber como parametro e também define
	 * a saude geral chamando um metodo sem parametro.
	 * 
	 * @param Valor da saúde mental
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
		this.defineSaudeGeral();
	}

	/**
	 * Define a saúde física com o valor que receber como parametro e também define
	 * a saude geral chamando um metodo sem parametro.
	 * 
	 * @param Valor da saúde física.
	 */
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
		this.defineSaudeGeral();
	}

	/**
	 * Retorna a String que representa a saúde geral do aluno. O formato dela será
	 * só a saúde geral.
	 * 
	 * @return a representação em String da saúde geral de um aluno
	 */
	public String getStatusGeral() {
		return saudeGeral;
	}

}