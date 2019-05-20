package lab5;

import easyaccept.EasyAccept;

public class Facade {

	// Operações com Clientes.

	private ClienteController cc = new ClienteController();
	private FornecedorController fc = new FornecedorController();

	// EasyAccept
	public static void main(String[] args) {
		args = new String[] { "lab5.Facade", "acceptance_test/use_case_1.txt", "acceptance_test/use_case_2.txt",
				"acceptance_test/use_case_3.txt", "acceptance_test/use_case_4.txt", "acceptance_test/use_case_5.txt",
				"acceptance_test/use_case_6.txt" };
		EasyAccept.main(args);
	}

	/**
	 * Cadastra um Cliente no sistema, este método vai receber Strings representando
	 * respectivamente, o cpf, nome, local associado e email do cliente.
	 * 
	 * @param cpf
	 * @param nome
	 * @param email
	 * @param local
	 * @return String representando a situação do cadastro do Cliente.
	 */
	public String adicionaCliente(String cpf, String nome, String email, String local) {
		return cc.cadastraClientes(cpf, nome, email, local);
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
	public String exibeClientes() {
		return cc.exibeTodosOsClientes();
	}

	/**
	 * Edita as informações do cadastro de um Cliente associado ao cpf (única
	 * informação que não pode ser alterada) passado como parâmetro.
	 * 
	 * @param cpf
	 * @param atributo
	 * @param novoValor
	 * @return Situação da edição do Cliente.
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		cc.editaCliente(cpf, atributo, novoValor);
	}

	/**
	 * Remove, do sistema, um Cliente associado ao cpf passado como parâmetro.
	 * 
	 * @param cpf
	 * @return Situação da remoção do Cliente.
	 */
	public void removeCliente(String cpf) {
		cc.removerCliente(cpf);
	}

	// Operações com Forencedores.

	/**
	 * Cadastra um Fornecedor no sistema, este método vai receber Strings
	 * representando respectivamente, o nome, email e telefone do Fornecedor.
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 * @return String representando a situação do cadastro do Fornecedor.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
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
	public String exibeFornecedores() {
		return fc.exibeTodosOsFornecedores();
	}

	/**
	 * Edita as informações do cadastro de um Fornecedor associado ao nome (única
	 * informação que não pode ser alterada) passado como parâmetro.
	 * 
	 * @param nome
	 * @param atributo
	 * @param novoValor
	 * @return Situação da edição do Fornecedor.
	 */
	public String editaFornecedor(String nome, String atributo, String novoValor) {
		return fc.editaFornecedor(nome, atributo, novoValor);
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
	public String adicionaProduto(String nomeFornecedor, String nomeProduto, String descricao, float preco) {
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
	public String exibeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
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
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		return fc.exibeProdutosDoFornecedor(nomeFornecedor);
	}

	/**
	 * Retorna a representação em String de todos os Produtos cadastrados no
	 * sistema.
	 * 
	 * @return Representação em String de todos os Produtos cadastrados no sistema.
	 */
	public String exibeProdutos() {
		return fc.exibeTodosOsProdutos();
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
	public String editaProduto(String nomeProduto, String descricao, String nomeFornecedor, double preco) {
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
	public String removeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		return fc.removeProduto(nomeFornecedor, nomeProduto, descricao);
	}

	/**
	 * TODO
	 * 
	 * @param fornecedor
	 * @param nome
	 * @param descricao
	 * @param fator
	 * @param produtos
	 * @return
	 */
	public String adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		return fc.cadastraCombo(fornecedor, nome, descricao, fator, produtos);
	}

	/**
	 * TODO
	 * 
	 * @param nome
	 * @param descricao
	 * @param fornecedor
	 * @param novoFator
	 * @return
	 */
	public String editaCombo(String nome, String descricao, String fornecedor, double novoFator) {
		return fc.editaCombo(fornecedor, nome, descricao, novoFator);
	}
	
	public String adicionaCompra (String cpf, String fornecedor, String data, String nomeDoProduto, String descricaoDoProduto) {
		fc.verificaFornecedor(fornecedor);
		double preco = fc.verificaProduto(fornecedor, nomeDoProduto, descricaoDoProduto);
		
		return cc.adicionaCompra(cpf, fornecedor, data, nomeDoProduto, descricaoDoProduto, preco);
	}
	
	public String getDebito(String cpf, String fornecedor) {
		fc.verificaFornecedor(fornecedor);
		return cc.getDebito(cpf, fornecedor);
	}
	
	
}