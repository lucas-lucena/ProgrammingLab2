package lab5;

public class Facade {

	
	// Operações com Clientes
	ClienteController cc = new ClienteController();
	
	/**
	 * Cadastra um Cliente no sistema, e vai receber Strings representando
	 * um cpf, nome, local associado e email do respectivo cliente 
	 * 
	 * @param cpf
	 * @param nome
	 * @param local
	 * @param email
	 * @return Situação do cadastro do Cliente
	 */
	public String CadastraCLiente(String cpf, String nome, String local, String email) {
		return cc.CadastraClientes(cpf, nome, local, email);
	}
	
	/**
	 * Retornar a representação textual de um Cliente no seguinte modelo:
	 * "NOME - LOCAL - EMAIL"
	 */
	public String ExibeCliente(String cpf) {
		return cc.ExibeCliente(cpf);
	}
	
	/**
	 * Retornar a representação textual de todos os clientes
	 * cadastrados no sistema em ordem alfabetica separando-os
	 * com o caractere "|"
	 */
	public String ExibeTodosOsClientes( ) {
		return cc.ExibeTodosOsClientes();
	}
	
	/**
	 * Editar o cadastro de um cliente (Exceto o CPF
	 */
	public String EditaCliente(String cpf, String nome, String local, String email) {
		return cc.EditaCliente(cpf, nome, local, email);
	}
	
	/**
	 * Remover cliente
	 */
	public String RemoveCliente(String cpf) {
		return cc.RemoverCliente(cpf);
	}
	
	// Operações com Forencedores.
	
	/**
	 *  Cadastra Fornecedores.
	 */
	
	/**
	 * Retrona representação textual de um Fornecedor.
	 * NOME - EMAIL - TELEFONE
	 */
	
	/**
	 * Retrona a representação textual de todos os fornecedores 
	 * cadastrados no sistema em ordem alfabetica separando-os
	 * com o caractere "|"
	 * NOME1 - EMAIL1 - TELEFONE | NOME2 - EMAIL2 - TELEFONE2
	 */
	
	/**
	 * Editar cadastro do fornecedor (Exceto o nome)
	 */
	
	/**
	 * Remover um Fornecedor do cadastro.
	 */
	
	// Operações com Produtos dos Fornecedores
	
	/**
	 * Cadastra um produto para um Fornecedor. 
	 */
	
	/**
	 * Retorna a representação textual de um produto de um Fornecedor
	 * NOME - DESCRIÇÃO - PREÇO
	 */
	
	/**
	 * Retorna a representação textual de todos os produtos de um certo
	 * Fornecedor cadastrado no sistema, em ordem alfabetica separando-os
	 * com o caractere "|"
	 * NOME1 - DESCRIÇÃO1 - PREÇO1 | NOME2 - DESCRIÇÃO2 - PREÇO2
	 */
	
	/**
	 * Retorna a representação textual de todos os produtos de todos os
	 * Fornecedorer cadastrados no sistema, em ordem de Fornecedor e
	 * separando-os com o caractere "|"
	 * FORNECEDOR 1 - NOME1 - DESCRIÇÃO1 - PREÇO1 | FORNECEDOR1 NOME2 - 
	 * DESCRIÇÃO2 - PREÇO2 | FORNECEDOR2 - NOME3 - DESCRIÇÃO3	 - PREÇO3 
	 */
	
	/**
	 * Edita o preço do produto (para outras operações sugere-se deletar
	 * o produto original e adicionar um alterado)
	 */
	
	/**
	 * Remove um produto de um fornecedor
	 */
	
}