package lab3;

import java.util.Arrays;

/**
 * A representação de uma Agenda Telefônica. Toda Agenda contem uma lista de
 * contatos e pode registrar um contato, exibir um contato específico apartir
 * de sua posição e listar todos os contatos registrados.
 * 
 * @author Lucas Leal de Lucena
 * 
 */

public class PhoneBook {

	/**
	 * Lista com todos os contatos da agenda.
	 */
	Contact[] contacts = new Contact[100];

	/**
	 * Registra um contato na agenda em uma posição específica(desde que esteja
	 * no intervalo de 1 a 100), que vai possuir nome, sobrenome e o seu respectivo
	 * número telefônico. Também retorna uma String informando a situação do
	 * registro, se for validado, retornará que o cadastro foi realizado, caso
	 * não seja válido, vai retornar que a posição foi inválida se estiver fora do
	 * intervalo pré-definido, ou vai informar se algum dos atributos do contato
	 * sõ invalidos se forem nulos ou espaços em branco. 
	 * 
	 * @param position
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @return String situação do registro do contato.
	 */
	public String registerContact(int position, String firstName, String lastName, String phoneNumber) {
		try {
			this.contacts[position-1] = new Contact(firstName, lastName, phoneNumber);;
			return "CADASTRO REALIZADO!\n";
		} catch (IndexOutOfBoundsException ioobe) {
			return "POSIÇÃO INVÁLIDA!\n";
		}
	}

	/**
	 * Retorna a representação em String de uma lista de todos os contatos já
	 * registrados na agenda e suas respectívas posições, caso nada tenha sido
	 * cadastrado ainda, simplismente retornará uma String informando que 
	 * nenhum contato foi registrado.
	 * 
	 * @return Lista de contatos.
	 */
	public String listContacts() {
		String list = ""; 
		int count = 0;
		for (int i = 0; i < 100; i++) {
			if (contacts[i] != null) {
				list = list + (i+1) + " - " + contacts[i].getFullName() + "\n";
				count += 1;
			}
		}
		if (count != 0) {
			return list;
		}
		else {
			return "NENHUM CONTATO FOI REGISTRADO\n";
		}
	}
 
	/**
	 * Retorna a representação em String de um contato contido em uma
	 * determinada posição da agenda. Também retorna uma String que
	 * informa quando a posição verificada é inválida ou retorna outra
	 * String contactando que a posição verificada está sem contato
	 * cadastrado.
	 * 
	 * @param position
	 * @return String informando o Contato em determinada posição.
	 */
	public String showContact(int position) {
		try {
			return contacts[position-1].toString();
		} catch (NullPointerException npe) {
			return "SEM CONTATO CADASTRADO!";
		} catch (IndexOutOfBoundsException ioobe){
			return "POSIÇÃO INVÁLIDA!";
		}
	}
	/**
	 * Retorna uma String informando se os nomes de dois contatos, em
	 * posições distintas da lista, são da mesma pessoa.
	 * 
	 * @param position1
	 * @param position2
	 * @return String comparação dos contatos
	 */
	public String compareContacts(int position1, int position2) {
		if (contacts[position1-1].equals(contacts[position2-1])) {
			return "SIM SOU EU!\n";
		}
		else {
			return "NÃO SOU EU!\n";
		}
	}
	
	/**
	 * Cria um código hash para a Agenda.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contacts);
		return result;
	}

	/**
	 * Verifica se dois objetos Agendas são iguais com base na lista
	 * de Contatos.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneBook other = (PhoneBook) obj;
		if (!Arrays.equals(contacts, other.contacts))
			return false;
		return true;
	}
}