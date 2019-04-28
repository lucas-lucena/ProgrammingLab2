package lab4;

import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/** Controlador dos alunos e grupos */ 
		Controller controller = new Controller();
		
		/** Matricula atribuida a um aluno. */
		String matricula;
		
		/** Nome atribuido a um aluno. */
		String aluno;
		
		/** Curso atribuido a um aluno. */
		String curso;
		
		/** Nome atribuido a um grupo*/
		String grupo;
		
		/** Menu com as opções de operações do programa. */
		String menu = "(C)adastrar Aluno\n" + 
				"(E)xibir Aluno\n" + 
				"(N)ovo Grupo\n" + 
				"(A)locar Aluno no Grupo e Imprimir Grupos\n" + 
				"(R)egistrar Aluno que Respondeu\n" + 
				"(I)mprimir Alunos que Responderam\n" + 
				"(O)ra, vamos fechar o programa!\n"+
				"\n" +
				"Opção>";
		
		/** Representa qual operação será realizada. */
		String operation = "";
		
		do {
			System.out.print(menu);
			operation = scanner.nextLine().toUpperCase();
			
			/** Verifica qual operação o usuário quer utilizar. */
			switch (operation) {
				case "C":
					System.out.print("Matrícula: ");
					matricula = scanner.nextLine();
					
					System.out.print("Nome: ");
					aluno = scanner.nextLine();
					
					System.out.print("Curso: ");
					curso = scanner.nextLine();
					
					/** Cadastra um aluno e informa se aquela matricula já foi cadastrada
					 * ou se e invalida. 
					 */
					System.out.println(controller.cadastraAluno(matricula, aluno, curso));

					break;
				
				case "E":
					System.out.print("Matrícula: ");
					matricula = scanner.nextLine();
					
					System.out.println(controller.consultaAluno(matricula));
					break;
					
				case "N":
					System.out.print("Grupo: ");
					grupo = scanner.nextLine();
					
					System.out.println(controller.cadastraGrupo(grupo));
					break;
				
				case "A":
					System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
					String checador = scanner.nextLine();
					if (checador.toUpperCase().equals("A")) {
						System.out.print("Matrícula: ");
						matricula = scanner.nextLine();
						
						System.out.print("Grupo: ");
						grupo = scanner.nextLine();
						
						System.out.println(controller.alocarAluno(matricula, grupo));
					}
					if (checador.toUpperCase().equals("I")) {
						System.out.print("Grupo: ");
						grupo = scanner.nextLine();
						
						System.out.println(controller.imprimirGrupo(grupo));
					}
					break;
					
				case "R":
					System.out.print("Matrícula: ");
					matricula = scanner.nextLine();
					
					System.out.println(controller.cadastraRespondemQuestoes(matricula));
					break;
					
				case "I":
					System.out.println(controller.imprimeRespondemQuestoes());
					break;
					
				default:
					if (operation.equals("O")) {
						System.out.print("Programa encerrado!");
					} else {
						System.out.println("\nOpção inválida!\n");
					}
			}
		}
			while(!operation.equals("O"));
		scanner.close();
	}
}