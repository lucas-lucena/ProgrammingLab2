package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ClienteController {

	private HashMap<String, Cliente> mapaClientes;
	
	public ClienteController() {
		mapaClientes = new HashMap<>();
	}
	
	/**
	 * Cadastra um Cliente no mapa de clientes passando uma String cpf 
	 * como identificador, e vai receber Strings representando
	 * um cpf, nome, local associado e email do respectivo cliente.
	 * 
	 * @param cpf
	 * @param nome
	 * @param local
	 * @param email
	 * @return
	 */
	public String CadastraClientes(String cpf, String nome, String local, String email) {
		if (cpf == null || cpf.equals("")) {
			throw new IllegalArgumentException("CPF NULO OU STRING VAZIA!");
		}
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME NULO OU STRING VAZIA!");
		}
		if (local == null || local.equals("")) {
			throw new IllegalArgumentException("LOCAL NULO OU STRING VAZIA!");
		}
		if (email == null || email.equals("")) {
			throw new IllegalArgumentException("EMAIL NULO OU STRING VAZIA!");
		}
		
		Cliente c = new Cliente(cpf, nome, local, email);
		if (!mapaClientes.containsKey(cpf)) {
			mapaClientes.put(cpf, c);
			return "CADASTRO BEM SUCEDIDO!";
		}
		return "CLIENTE JÁ CADASTRADO!";
	}
	
	/**
	 * Retornar a representação textual de um Cliente no seguinte modelo:
	 * "NOME - LOCAL - EMAIL"
	 */
	public String ExibeCliente(String cpf) {
		if (cpf == null || cpf.equals("")) {
			throw new IllegalArgumentException("CPF NULO OU STRING VAZIA!");
		}
		
		if (mapaClientes.containsKey(cpf)) {
			return mapaClientes.get(cpf).toString();
		}
		return "CLIENE NÃO CADASTRADO!";
	}
	
	/**
	 * Retornar a representação textual de todos os clientes
	 * cadastrados no sistema em ordem alfabetica separando-os
	 * usando o separador "|" 
	 */
	public String ExibeTodosOsClientes() {
		
		ArrayList<String> clientes = new ArrayList<>();
		for (Cliente cliente: this.mapaClientes.values()) {
			clientes.add(cliente.toString());
		}
		Collections.sort(clientes);
		return clientes.stream().map(cliente -> cliente.toString()).collect(Collectors.joining(" | "));	
	}
	
	/**
	 * Editar o cadastro de um cliente (Exceto o CPF).
	 */
	public String EditaCliente(String cpf, String nome, String local, String email) {
		if (cpf == null || cpf.equals("")) {
			throw new IllegalArgumentException("CPF NULO OU STRING VAZIA!");
		}
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("NOME NULO OU STRING VAZIA!");
		}
		if (local == null || local.equals("")) {
			throw new IllegalArgumentException("LOCAL NULO OU STRING VAZIA!");
		}
		if (email == null || email.equals("")) {
			throw new IllegalArgumentException("EMAIL NULO OU STRING VAZIA!");
		}
		
		if (mapaClientes.containsKey(cpf)) {
			this.mapaClientes.get(cpf).setNome(nome);
			this.mapaClientes.get(cpf).setLocal(local);
			this.mapaClientes.get(cpf).setEmail(email);
			return "EDIÇÃO BEM SUCESSIDA";
		}
		 
		return "EDIÇÃO MAL SUCESSIDA";
	}
	
	/**
	 * Remove um cliente do sistema.
	 */
	public String RemoverCliente(String cpf) {
		if (cpf == null || cpf.equals("")) {
			throw new IllegalArgumentException("CPF NULO OU STRING VAZIA!");
		}
		
		if (mapaClientes.containsKey(cpf)) {
			mapaClientes.remove(cpf);
			return "REMOÇÃO BEM SUCEDIDA!";
		}
		
		return "CLIENTE NÃO CADASTRADO!";
	}
	
}
