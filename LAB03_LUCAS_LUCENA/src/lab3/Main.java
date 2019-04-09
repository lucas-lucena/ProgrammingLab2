package lab3;

import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
	
		/** Posição em que um contato será cadastrádo. */
		int position;

		/** Nome atribuido a um contato. */
		String firstName;
		
		/** Sobrenome atribuido a um contato. */
		String lastName;
		
		/** Número telefônico atribuido a um contato. */
		String phoneNumber;

		/** Uma agenda para armazenar os contatos */
		PhoneBook agenda = new PhoneBook();		
		
		/** Menu com as opções de operações do programa. */
		String menu =	"(C)adastrar Contato\n" +
				"(L)istar Contatos\n" +
				"(E)xibir Contato\n" +
				"(S)air\n" +
				"\nOpção> ";

		/** Representa qual operação será realizada. */
		String operation = "";
		
		do {
			System.out.print(menu);
			operation = sc.nextLine().toUpperCase();
			
			/** Verifica qual operação o usuário quer utilizar. */
			switch (operation) {	
				case "C":
					System.out.print("Posição: ");
					position = sc.nextInt();
					sc.nextLine();
					
					System.out.print("Nome: ");
					firstName = sc.nextLine();
					
					System.out.print("Sobrenome: ");
					lastName = sc.nextLine();
					
					System.out.print("Telefone: ");
					phoneNumber = sc.nextLine();
					
					/** Cadastra o usuário e informa se a operação ocorreu corretamente. */
					System.out.println("\n" + agenda.registerContact(position, firstName, lastName, phoneNumber));
					break;

				case "L":
					System.out.println("\n" + agenda.listContacts());
					break;

				case "E":
					System.out.print("Contato> ");
					position = sc.nextInt();
					sc.nextLine();

					/** Verifica se existe um contato cadastrado na posição informada e
					 *  exibe o contato presente nesta posição. */
					System.out.println("\n" + agenda.showContact(position) + "\n");
					break;

				default:
					if (operation.equals("S")) {
						System.out.print("PROGRAMA ENCERRADO!");
					} else {
						System.out.println("\nOPÇÃO INVÁLIDA!\n");
					}
			}
		} while (!operation.equals("S"));
		sc.close();
	}
}