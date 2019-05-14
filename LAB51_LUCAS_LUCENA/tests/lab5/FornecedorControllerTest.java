package lab5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorControllerTest {

	FornecedorController f = new FornecedorController();

	@Test
	void cadastraFornecedorTest() {
		assertEquals(f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678"), "lucas");
		assertThrows(IllegalArgumentException.class,
				() -> f.cadastraFornecedor("lucas", "lucas@ccc.ufcg.edu.br", "83 91234-5678"));
		assertThrows(IllegalArgumentException.class,
				() -> f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 94444-1111"));

		assertThrows(IllegalArgumentException.class,
				() -> f.cadastraFornecedor(null, "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678"));
		assertThrows(IllegalArgumentException.class,
				() -> f.cadastraFornecedor("", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678"));

		assertThrows(IllegalArgumentException.class, () -> f.cadastraFornecedor("Lucas", null, "83 91234-5678"));
		assertThrows(IllegalArgumentException.class, () -> f.cadastraFornecedor("Lucas", "", "83 94444-1111"));

		assertThrows(IllegalArgumentException.class,
				() -> f.cadastraFornecedor("Lucas", "lucas.lucena@ccc.ufcg.edu.br", null));
		assertThrows(IllegalArgumentException.class,
				() -> f.cadastraFornecedor("Lucas", "lucas.lucena@ccc.ufcg.edu.br", ""));
	}

	@Test
	void exibeFornecedorTest() {
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeFornecedor("lucas"));
		f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678");
		assertEquals(f.exibeFornecedor("lucas"), "lucas - lucas.lucena@ccc.ufcg.edu.br - 83 91234-5678");

		assertThrows(IllegalArgumentException.class, () -> this.f.exibeFornecedor(""));
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeFornecedor(null));
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeFornecedor("Lucas"));
	}

	@Test
	void exibeTodosOsFornecedoresTest() {
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeTodosOsFornecedores());

		f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678");
		assertEquals(f.exibeTodosOsFornecedores(), "lucas - lucas.lucena@ccc.ufcg.edu.br - 83 91234-5678");
		f.cadastraFornecedor("mateus", "mateus@ccc.ufcg.edu.br", "83 91234-1234");
		assertEquals(f.exibeTodosOsFornecedores(),
				"lucas - lucas.lucena@ccc.ufcg.edu.br - 83 91234-5678 | mateus - mateus@ccc.ufcg.edu.br - 83 91234-1234");
	}

	@Test
	void editaFornecedorTest() {
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaFornecedor(null, "email", "lucas@ccc.ufcg.edu.br"));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaFornecedor("", "email", "lucas@ccc.ufcg.edu.br"));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaFornecedor("lucas", null, "lucas@ccc.ufcg.edu.br"));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaFornecedor("lucas", "", "lucas@ccc.ufcg.edu.br"));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "email", null));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "email", ""));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaFornecedor("lucas", "email", "lucas@ccc.ufcg.edu.br"));

		f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678");
		assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor(null, "email", "Lucas"));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("", "email", "Lucas"));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", null, "Lucas"));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "", "Lucas"));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "nome", "Lucas"));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "localizacao", "Lucas"));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "email", null));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "email", ""));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "telefone", null));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "telefone", ""));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "email", null));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "email", ""));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("Lucas", "email", "Lucas"));

		assertEquals(f.exibeFornecedor("lucas"), "lucas - lucas.lucena@ccc.ufcg.edu.br - 83 91234-5678");
		f.editaFornecedor("lucas", "email", "lucas@ccc.ufcg.edu.br");
		assertNotEquals(f.exibeFornecedor("lucas"), "lucas - lucas.lucena@ccc.ufcg.edu.br - 83 91234-5678");
		assertEquals(f.exibeFornecedor("lucas"), "lucas - lucas@ccc.ufcg.edu.br - 83 91234-5678");

		f.editaFornecedor("lucas", "telefone", "83 91234-4567");
		assertNotEquals(f.exibeFornecedor("lucas"), "lucas - lucas@ccc.ufcg.edu.br - 83 91234-5678");
		assertEquals(f.exibeFornecedor("lucas"), "lucas - lucas@ccc.ufcg.edu.br - 83 91234-4567");
	}

	@Test
	void removerFornecedorTest() {
		assertThrows(IllegalArgumentException.class, () -> this.f.removerFornecedor("lucas"));

		f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678");

		assertEquals(f.exibeFornecedor("lucas"), "lucas - lucas.lucena@ccc.ufcg.edu.br - 83 91234-5678");
		assertThrows(IllegalArgumentException.class, () -> this.f.removerFornecedor(null));
		assertThrows(IllegalArgumentException.class, () -> this.f.removerFornecedor(""));
		assertThrows(IllegalArgumentException.class, () -> this.f.removerFornecedor("Lucas"));

		f.removerFornecedor("lucas");
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeFornecedor("lucas"));
		assertThrows(IllegalArgumentException.class, () -> this.f.removerFornecedor("lucas"));
	}

	@Test
	void cadastraProdutoTest() {
		assertThrows(IllegalArgumentException.class,
				() -> f.cadastraProduto(null, "misto", "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class, () -> f.cadastraProduto("", "misto", "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class,
				() -> f.cadastraProduto("lucas", null, "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class, () -> f.cadastraProduto("lucas", "", "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class, () -> f.cadastraProduto("lucas", "misto", null, 2));
		assertThrows(IllegalArgumentException.class, () -> f.cadastraProduto("lucas", "misto", "", 2));
		assertThrows(IllegalArgumentException.class,
				() -> f.cadastraProduto("lucas", "misto", "pão, queijo e presunto", -1));
		assertThrows(IllegalArgumentException.class,
				() -> f.cadastraProduto("lucas", "misto", "pão, queijo e presunto", 2));

		assertEquals(f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678"), "lucas");
		assertThrows(IllegalArgumentException.class,
				() -> f.cadastraProduto(null, "misto", "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class, () -> f.cadastraProduto("", "misto", "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class,
				() -> f.cadastraProduto("lucas", null, "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class, () -> f.cadastraProduto("lucas", "", "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class, () -> f.cadastraProduto("lucas", "misto", null, 2));
		assertThrows(IllegalArgumentException.class, () -> f.cadastraProduto("lucas", "misto", "", 2));

		assertThrows(IllegalArgumentException.class,
				() -> f.cadastraProduto("lucas", "misto", "pão, queijo e presunto", -1));
		assertEquals(f.cadastraProduto("lucas", "misto", "pão, queijo e presunto", 2), "CADASTRO BEM SUCEDIDO!");
		assertThrows(IllegalArgumentException.class,
				() -> f.cadastraProduto("lucas", "misto", "pão, queijo e presunto", 2));
	}

	@Test
	void exibeProdutoTest() {
		assertThrows(IllegalArgumentException.class,
				() -> this.f.exibeProduto("lucas", "misto", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.exibeProduto(null, "misto", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeProduto("", "misto", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.exibeProduto("lucas", null, "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeProduto("lucas", "", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeProduto("lucas", "misto", null));
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeProduto("lucas", "misto", ""));

		f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678");

		assertThrows(IllegalArgumentException.class,
				() -> this.f.exibeProduto("lucas", null, "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeProduto("lucas", "", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeProduto("lucas", "misto", null));
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeProduto("lucas", "misto", ""));

		f.cadastraProduto("lucas", "misto", "pão, queijo e presunto", 2);
		assertEquals(f.exibeProduto("lucas", "misto", "pão, queijo e presunto"),
				"misto - pão, queijo e presunto - R$2,00");
	}

	@Test
	void exibeProdutosDoFornecedorTest() {
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeProdutosDoFornecedor(null));
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeProdutosDoFornecedor(""));
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeProdutosDoFornecedor("lucas"));

		f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678");

		assertThrows(IllegalArgumentException.class, () -> this.f.exibeProdutosDoFornecedor("lucas"));

		f.cadastraProduto("lucas", "misto", "pão, queijo e presunto", 2);
		assertEquals(f.exibeProdutosDoFornecedor("lucas"), "lucas - misto - pão, queijo e presunto - R$2,00");

		f.cadastraProduto("lucas", "americano", "pão, queijo e salada", 3);
		assertEquals(f.exibeProdutosDoFornecedor("lucas"),
				"lucas - americano - pão, queijo e salada - R$3,00 | lucas - misto - pão, queijo e presunto - R$2,00");
	}

	@Test
	void exibeTodosOsProdutosTest() {
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeTodosOsProdutos());

		f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678");
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeTodosOsProdutos());

		f.cadastraProduto("lucas", "misto", "pão, queijo e presunto", 2);
		assertEquals(f.exibeTodosOsProdutos(), "lucas - misto - pão, queijo e presunto - R$2,00");
		f.cadastraProduto("lucas", "americano", "pão, queijo e salada", 3);
		assertEquals(f.exibeTodosOsProdutos(),
				"lucas - americano - pão, queijo e salada - R$3,00 | lucas - misto - pão, queijo e presunto - R$2,00");

		f.cadastraFornecedor("mateus", "mateus@ccc.ufcg.edu.br", "83 91234-1234");
		assertThrows(IllegalArgumentException.class, () -> this.f.exibeTodosOsProdutos());

		f.cadastraProduto("mateus", "salada", "alface, tomate e cebola", 2);
		assertEquals(f.exibeTodosOsProdutos(),
				"lucas - americano - pão, queijo e salada - R$3,00 | lucas - misto - pão, queijo e presunto - R$2,00 | mateus - salada - alface, tomate e cebola - R$2,00");
	}

	@Test
	void editaProdutoTest() {
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaProduto("lucas", "misto", "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaProduto(null, "misto", "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaProduto("", "misto", "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaProduto("lucas", null, "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaProduto("lucas", "", "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaProduto("lucas", "misto", null, 2));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaProduto("lucas", "misto", "", 2));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaProduto("lucas", "misto", "pão, queijo e presunto", -1));

		f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678");

		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaProduto("lucas", "misto", "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaProduto(null, "misto", "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaProduto("", "misto", "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaProduto("lucas", null, "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaProduto("lucas", "", "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaProduto("lucas", "misto", null, 2));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaProduto("lucas", "misto", "", 2));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaProduto("lucas", "misto", "pão, queijo e presunto", -1));

		f.cadastraProduto("lucas", "misto", "pão, queijo e presunto", 3);

		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaProduto(null, "misto", "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaProduto("", "misto", "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaProduto("lucas", null, "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaProduto("lucas", "", "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaProduto("lucas", "misto", null, 2));
		assertThrows(IllegalArgumentException.class, () -> this.f.editaProduto("lucas", "misto", "", 2));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.editaProduto("lucas", "misto", "pão, queijo e presunto", -1));

		assertEquals(f.editaProduto("lucas", "misto", "pão, queijo e presunto", 2), "PRODUTO EDITADO COM SUCESSO!");
		assertEquals(f.exibeProduto("lucas", "misto", "pão, queijo e presunto"),
				"misto - pão, queijo e presunto - R$2,00");
	}

	@Test
	void removeProdutoTest() {
		assertThrows(IllegalArgumentException.class,
				() -> this.f.removeProduto("lucas", "misto", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.exibeProduto("lucas", "misto", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.removeProduto(null, "misto", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> this.f.removeProduto("", "misto", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.removeProduto("lucas", null, "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> this.f.removeProduto("lucas", "", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> this.f.removeProduto("lucas", "misto", null));
		assertThrows(IllegalArgumentException.class, () -> this.f.removeProduto("lucas", "misto", ""));

		f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678");
		assertThrows(IllegalArgumentException.class,
				() -> this.f.exibeProduto("lucas", "misto", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.removeProduto("lucas", "misto", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.removeProduto(null, "misto", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> this.f.removeProduto("", "misto", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.removeProduto("lucas", null, "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> this.f.removeProduto("lucas", "", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> this.f.removeProduto("lucas", "misto", null));
		assertThrows(IllegalArgumentException.class, () -> this.f.removeProduto("lucas", "misto", ""));

		f.cadastraProduto("lucas", "misto", "pão, queijo e presunto", 2);
		assertEquals(f.exibeProduto("lucas", "misto", "pão, queijo e presunto"),
				"misto - pão, queijo e presunto - R$2,00");

		assertThrows(IllegalArgumentException.class,
				() -> this.f.removeProduto(null, "misto", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> this.f.removeProduto("", "misto", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.removeProduto("lucas", null, "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> this.f.removeProduto("lucas", "", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> this.f.removeProduto("lucas", "misto", null));
		assertThrows(IllegalArgumentException.class, () -> this.f.removeProduto("lucas", "misto", ""));

		assertEquals(f.removeProduto("lucas", "misto", "pão, queijo e presunto"), "REMOÇÃO BEM SUCEDIDA!");

		assertThrows(IllegalArgumentException.class,
				() -> this.f.removeProduto("lucas", "misto", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.removeProduto(null, "misto", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> this.f.removeProduto("", "misto", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class,
				() -> this.f.removeProduto("lucas", null, "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> this.f.removeProduto("lucas", "", "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> this.f.removeProduto("lucas", "misto", null));
		assertThrows(IllegalArgumentException.class, () -> this.f.removeProduto("lucas", "misto", ""));
	}
}