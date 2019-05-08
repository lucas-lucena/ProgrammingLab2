package lab5;

public class Facade {

	// Operações com Clientes
	private ClienteController cc = new ClienteController();

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
	 * Retornar a representação em String de todos os Clientes cadastrados no
	 * sistema.
	 * 
	 * @return String representando todos os Clientes cadastrados.
	 */
	public String ExibeTodosOsClientes() {
		return cc.ExibeTodosOsClientes();
	}

	/**
	 * Edita as informações do cadastro de um Cliente associado ao cpf (única
	 * informação que não pode ser alterada) passado como parâmetro.
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
	private FornecedorController fc = new FornecedorController();

	/**
	 * Cadastra um Fornecedor no sistema, este método vai receber Strings
	 * representando respectivamente, o nome, email e telefone do Fornecedor.
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 * @return String representando a situação do cadastro do Fornecedor.
	 */
	public String CadastraFornecedor(String nome, String email, String telefone) {
		return fc.CadastraFornecedor(nome, email, telefone);
	}

	/**
	 * Retornar a representação em String de um Fornecedor que corresponda a String
	 * nome passada como parâmetro.
	 * 
	 * @param nome
	 * @return String representando um Fornecedor.
	 */
	public String ExibeFornecedor(String nome) {
		return fc.ExibeFornecedor(nome);
	}

	/**
	 * Retornar a representação em String de todos os Fornecedores cadastrados no
	 * sistema.
	 * 
	 * @return String representando todos os Fornecedores cadastrados.
	 */
	public String ExibeTodosOsFornecedores() {
		return fc.ExibeTodosOsFornecedores();
	}

	/**
	 * Edita as informações do cadastro de um Fornecedor associado ao nome (única
	 * informação que não pode ser alterada) passado como parâmetro.
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 * @return Situação da edição do Fornecedor.
	 */
	public String EditaFornecedor(String nome, String email, String telefone) {
		return fc.EditaFornecedor(nome, email, telefone);
	}

	/**
	 * Remove, do sistema, um Fornecedor associado ao nome passado como parâmetro.
	 * 
	 * @param nome
	 * @return Situação da remoção do Fornecedor.
	 */
	public String RemoveFornecedor(String nome) {
		return fc.RemoverFornecedor(nome);
	}

	// Operações com Produtos dos Fornecedores

	/**
	 * Cadastra um produto para um Fornecedor.
	 */ // apagar nota verde assim que refatorar
	public String CadastraProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		return fc.CadastraProduto(nomeFornecedor, nomeProduto, descricao, preco);
	}
	

	/**
	 * Retorna a representação textual de um produto de um Fornecedor NOME -
	 * DESCRIÇÃO - PREÇO
	 */ // apagar nota verde assim que refatorar

	/**
	 * Retorna a representação textual de todos os produtos de um certo Fornecedor
	 * cadastrado no sistema, em ordem alfabetica separando-os com o caractere "|"
	 * NOME1 - DESCRIÇÃO1 - PREÇO1 | NOME2 - DESCRIÇÃO2 - PREÇO2
	 */ // apagar nota verde assim que refatorar

	/**
	 * Retorna a representação textual de todos os produtos de todos os Fornecedorer
	 * cadastrados no sistema, em ordem de Fornecedor e separando-os com o caractere
	 * "|" FORNECEDOR 1 - NOME1 - DESCRIÇÃO1 - PREÇO1 | FORNECEDOR1 NOME2 -
	 * DESCRIÇÃO2 - PREÇO2 | FORNECEDOR2 - NOME3 - DESCRIÇÃO3 - PREÇO3
	 */ // apagar nota verde assim que refatorar

	/**
	 * Edita o preço do produto (para outras operações sugere-se deletar o produto
	 * original e adicionar um alterado)
	 */ // apagar nota verde assim que refatorar

	/**
	 * Remove um produto de um fornecedor
	 */ // apagar nota verde assim que refatorar

}