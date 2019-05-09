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

	// Operações com Produtos dos Fornecedores //

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
	public String CadastraProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		return fc.CadastraProduto(nomeFornecedor, nomeProduto, descricao, preco);
	}

	/**
	 * Retornar a representação em String de um Produto.
	 *
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @return Representação em String de um Produto.
	 */
	public String ExibeProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		return fc.ExibeProduto(nomeFornecedor, nomeProduto, descricao);
	}

	/**
	 * Retorna a representação em String de todos os Produtos associados a um
	 * Fornecedor
	 * 
	 * @param nomeFornecedor
	 * @return Representação em String de todos os Produtos associados a um
	 *         Fornecedor
	 */
	public String ExibeProdutosDoFornecedor(String nomeFornecedor) {
		return fc.ExibeProdutosDoFornecedor(nomeFornecedor);
	}

	/**
	 * Retorna a representação em String de todos os Produtos cadastrados no
	 * sistema.
	 * 
	 * @return Representação em String de todos os Produtos cadastrados no sistema.
	 */
	public String ExibeTodosOsProdutos() {
		return fc.ExibeTodosOsFornecedores();
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
	public String EditaProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		return fc.EditaProduto(nomeFornecedor, nomeProduto, descricao, preco);
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
	public String RemoveProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		return fc.RemoveProduto(nomeFornecedor, nomeProduto, descricao);
	}
}