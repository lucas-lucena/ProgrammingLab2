package lab5;

public class Facade {

	
	// Operações com Clientes
	ClienteController cc = new ClienteController();
	
	/**
	 * Cadastra um Cliente no sistema, este método vai receber Strings representando
	 * respectivamente, o cpf, nome, local associado e email do cliente. 
	 * 
	 * @param cpf
	 * @param nome
	 * @param local
	 * @param email
	 * @return String representando a situação do cadastro do Cliente.
	 */
	public String CadastraCLiente(String cpf, String nome, String local, String email) {
		return cc.CadastraClientes(cpf, nome, local, email);
	}
	
	/**
	 * Retornar a representação em String de um Cliente que corresponda a String cpf 
	 * passada como parâmetro.
	 * 
	 * @param cpf
	 * @return String representando um Cliente.
	 */
	public String ExibeCliente(String cpf) {
		return cc.ExibeCliente(cpf);
	}
	
	/**
	 * Retornar a representação em String de todos os clientes cadastrados no sistema.
	 * 
	 * @return String representando todos os clientes cadastrados.
	 */
	public String ExibeTodosOsClientes( ) {
		return cc.ExibeTodosOsClientes();
	}
	
	/**
	 * Edita as informações do cadastro de um Cliente associado ao cpf (única informação
	 * que não pode ser alterada) passado como parâmetro.
	 * 
	 * @param cpf
	 * @param nome
	 * @param local
	 * @param email
	 * @return Situação da edição do Cliente.
	 */
	public String EditaCliente(String cpf, String nome, String local, String email) {
		return cc.EditaCliente(cpf, nome, local, email);
	}
	
	/**
	 * Remove, do sistema, um Cliente associado ao cpf passado como parâmetro.
	 * 
	 * @param cpf
	 * @return Situação da remoção do Cliente.
	 */
	public String RemoveCliente(String cpf) {
		return cc.RemoverCliente(cpf);
	}
	
	// Operações com Forencedores.
	
	/**
	 *  Cadastra Fornecedores.
	 */ //apagar nota verde assim que refatorar
	
	/**
	 * Retrona representação textual de um Fornecedor.
	 * NOME - EMAIL - TELEFONE
	 */ //apagar nota verde assim que refatorar
	
	/**
	 * Retrona a representação textual de todos os fornecedores 
	 * cadastrados no sistema em ordem alfabetica separando-os
	 * com o caractere "|"
	 * NOME1 - EMAIL1 - TELEFONE | NOME2 - EMAIL2 - TELEFONE2
	 */ //apagar nota verde assim que refatorar
	
	/**
	 * Editar cadastro do fornecedor (Exceto o nome)
	 */ //apagar nota verde assim que refatorar
	
	/**
	 * Remover um Fornecedor do cadastro.
	 */ //apagar nota verde assim que refatorar
	
	// Operações com Produtos dos Fornecedores
	
	/**
	 * Cadastra um produto para um Fornecedor. 
	 */ //apagar nota verde assim que refatorar
	
	/**
	 * Retorna a representação textual de um produto de um Fornecedor
	 * NOME - DESCRIÇÃO - PREÇO
	 */ //apagar nota verde assim que refatorar
	
	/**
	 * Retorna a representação textual de todos os produtos de um certo
	 * Fornecedor cadastrado no sistema, em ordem alfabetica separando-os
	 * com o caractere "|"
	 * NOME1 - DESCRIÇÃO1 - PREÇO1 | NOME2 - DESCRIÇÃO2 - PREÇO2
	 */ //apagar nota verde assim que refatorar
	
	/**
	 * Retorna a representação textual de todos os produtos de todos os
	 * Fornecedorer cadastrados no sistema, em ordem de Fornecedor e
	 * separando-os com o caractere "|"
	 * FORNECEDOR 1 - NOME1 - DESCRIÇÃO1 - PREÇO1 | FORNECEDOR1 NOME2 - 
	 * DESCRIÇÃO2 - PREÇO2 | FORNECEDOR2 - NOME3 - DESCRIÇÃO3	 - PREÇO3 
	 */ //apagar nota verde assim que refatorar
	
	/**
	 * Edita o preço do produto (para outras operações sugere-se deletar
	 * o produto original e adicionar um alterado)
	 */ //apagar nota verde assim que refatorar
	
	/**
	 * Remove um produto de um fornecedor
	 */ //apagar nota verde assim que refatorar
	
}