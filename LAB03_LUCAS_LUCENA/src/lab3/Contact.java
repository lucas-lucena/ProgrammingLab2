package lab3;

/**
 * A representação de um contato. Todo contato conta com um nome,
 * sobrenome e um número telefônico.
 * 
 * @author Lucas Leal de Lucena.
 *
 */
public class Contact {

	/**
	 * Nome do contato.
	 */
	private String firstName;

	/**
	 * Sobrenome do contato.
	 */
	private String lastName;

	/**
	 * Número telefônico do contato.
	 */
	private String phoneNumber;

	/**
	 * Constroi o contato com o nome, sobrenome e número do telefone.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 */
	public Contact(String firstName, String lastName, String phoneNumber) {
		if (firstName == null) {
			throw new NullPointerException("NOME NULO!");
		}
		if (lastName == null) {
			throw new NullPointerException("SOBRENOME NULO!");
		} 
		if (phoneNumber == null) {
			throw new NullPointerException("TELEFONE NULO!");
		}
		
		if (firstName.trim().equals("")) {
			throw new IllegalArgumentException("NOME INVALIDO!");
		}
		else if (lastName.trim().equals("")) {
			throw new IllegalArgumentException("SOBRENOME INVALIDO!");
		}
		else if (phoneNumber.trim().equals("")) {
			throw new IllegalArgumentException("TELEFONE INVALIDO!");
		} 
		else {
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
		}
	}

	/**
	 * Retorna a representação em String do nome completo seguindo
	 * o modelo: "NOME SOBRENOME".
	 * 
	 * @return Representação do nome completo.
	 */
	public String getFullName() {
		return firstName +  " " + lastName;
	}

	/**
	 * Retorna a representação em String do Contato seguindo o modelo:
	 * "NOME SOBRENOME - NÚMERO TELEFÔNICO".
	 */
	@Override
	public String toString() {
		return firstName + " " + lastName + " - " + phoneNumber;
	}

	/**
	 * Verifica se dois objetos Contatos são iguais, com base no nome
	 * e do sobrenome de ambos.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Contact other = (Contact) obj;
		if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (!lastName.equals(other.lastName)) {
			return false;
		}
		return true;
	}
}