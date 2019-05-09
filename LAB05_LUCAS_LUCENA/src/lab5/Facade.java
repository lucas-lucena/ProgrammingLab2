package lab5;

import easyaccept.EasyAccept;

public class Facade {

	// Operações com Clientes.

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
	public String adicionaCliente(String cpf, String nome, String local, String email) {
		return cc.cadastraClientes(cpf, nome, local, email);
	}

	/**
	 * Retornar a representação em String de um Cliente que corresponda a String cpf
	 * passada como parâmetro.
	 * 
	 * @param cpf
	 * @return String representando um Cliente.
	 */
	public String exibeCliente(String cpf) {
		return cc.exibeCliente(cpf);
	}

	/**
	 * Retornar a representação em String de todos os Clientes cadastrados no
	 * sistema.
	 * 
	 * @return String representando todos os Clientes cadastrados.
	 */
	public String exibeTodosOsClientes() {
		return cc.exibeTodosOsClientes();
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
	public String editaCliente(String cpf, String nome, String local, String email) {
		return cc.editaCliente(cpf, nome, local, email);
	}

	/**
	 * Remove, do sistema, um Cliente associado ao cpf passado como parâmetro.
	 * 
	 * @param cpf
	 * @return Situação da remoção do Cliente.
	 */
	public String removeCliente(String cpf) {
		return cc.removerCliente(cpf);
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
	public String cadastraFornecedor(String nome, String email, String telefone) {
		return fc.cadastraFornecedor(nome, email, telefone);
	}

	/**
	 * Retornar a representação em String de um Fornecedor que corresponda a String
	 * nome passada como parâmetro.
	 * 
	 * @param nome
	 * @return String representando um Fornecedor.
	 */
	public String exibeFornecedor(String nome) {
		return fc.exibeFornecedor(nome);
	}

	/**
	 * Retornar a representação em String de todos os Fornecedores cadastrados no
	 * sistema.
	 * 
	 * @return String representando todos os Fornecedores cadastrados.
	 */
	public String exibeTodosOsFornecedores() {
		return fc.exibeTodosOsFornecedores();
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
	public String editaFornecedor(String nome, String email, String telefone) {
		return fc.editaFornecedor(nome, email, telefone);
	}

	/**
	 * Remove, do sistema, um Fornecedor associado ao nome passado como parâmetro.
	 * 
	 * @param nome
	 * @return Situação da remoção do Fornecedor.
	 */
	public String removeFornecedor(String nome) {
		return fc.removerFornecedor(nome);
	}

	// Operações com Produtos dos Fornecedores.

	/**
	 * Cadastra um Produto no sistema e o relaciona com um Fornecedor. Este método
	 * vai receber Strings representando respectivamente, o nome do Fornecedor, e
	 * nome , descrição e preço do Produto.
	 * 
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 * @return String representando a situação do cadastro do Produto.
	 */
	public String cadastraProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		return fc.cadastraProduto(nomeFornecedor, nomeProduto, descricao, preco);
	}

	/**
	 * Retornar a representação em String de um Produto.
	 *
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @return Representação em String de um Produto.
	 */
	public String exibeProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		return fc.exibeProduto(nomeFornecedor, nomeProduto, descricao);
	}

	/**
	 * Retorna a representação em String de todos os Produtos associados a um
	 * Fornecedor
	 * 
	 * @param nomeFornecedor
	 * @return Representação em String de todos os Produtos associados a um
	 *         Fornecedor
	 */
	public String exibeProdutosDoFornecedor(String nomeFornecedor) {
		return fc.exibeProdutosDoFornecedor(nomeFornecedor);
	}

	/**
	 * Retorna a representação em String de todos os Produtos cadastrados no
	 * sistema.
	 * 
	 * @return Representação em String de todos os Produtos cadastrados no sistema.
	 */
	public String exibeTodosOsProdutos() {
		return fc.exibeTodosOsFornecedores();
	}

	/**
	 * Edita as informações de cadastro de um Produto associado ao nome e a
	 * descrição passada como parâmetro (sendo estas as únicas informações que não
	 * podem ser alteradas por serem identificadores do Produto).
	 * 
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @param preco
	 * @return Situação da edição de um Produto.
	 */
	public String editaProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		return fc.editaProduto(nomeFornecedor, nomeProduto, descricao, preco);
	}

	/**
	 * Remove um Produto associado ao nome e a descrição passada como parâmetro
	 * (sendo estas as únicas informações que não podem ser alteradas por serem
	 * identificadores do Produto).
	 * 
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @return Situação da remoção do Produto de um Fornecedor.
	 */
	public String removeProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		return fc.removeProduto(nomeFornecedor, nomeProduto, descricao);
	}
	
	// Easy Accept
	public static void main(String[] args) {
		args = new String[] {"lab5.Facade", "acceptance_test/use_case_1.txt"};
			EasyAccept.main(args);
	}
}