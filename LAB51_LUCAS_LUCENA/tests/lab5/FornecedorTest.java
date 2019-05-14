package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FornecedorTest {

	Fornecedor f1;
	Fornecedor f2;

	@BeforeEach
	void criaFornecedores() {
		f1 = new Fornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678");
		f2 = new Fornecedor("mateus", "mateus@ccc.ufcg.edu.br", "11 98765-4321");
	}

	@Test
	void construtorTest() {
		assertThrows(IllegalArgumentException.class,
				() -> new Fornecedor(null, "joao@ccc.ufcg.edu.br", "82 1111-2222"));
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("", "joao@ccc.ufcg.edu.br", "82 1111-2222"));

		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("joao", null, "82 1111-2222"));
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("joao", "", "82 1111-2222"));

		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("joao", "joao@ccc.ufcg.edu.br", null));
		assertThrows(IllegalArgumentException.class, () -> new Fornecedor("joao", "joao@ccc.ufcg.edu.br", ""));
	}

	@Test
	void toStringTest() {
		Fornecedor fTest = new Fornecedor("joao", "joao@ccc.ufcg.edu.br", "92 1111-2222");
		assertEquals(fTest.toString(), "joao - joao@ccc.ufcg.edu.br - 92 1111-2222");
		assertEquals(f1.toString(), "lucas - lucas.lucena@ccc.ufcg.edu.br - 83 91234-5678");

		assertNotEquals(f1.toString(), fTest.toString());
		assertNotEquals(f1.toString(), "joao - joao@ccc.ufcg.edu.br - 92 1111-2222");
		assertNotEquals(fTest.toString(), "lucas - lucas.lucena@ccc.ufcg.edu.br - 83 91234-5678");
	}

	@Test
	void cadastraProdutoTest() {
		assertThrows(IllegalArgumentException.class, () -> f1.cadastraProduto(null, "pão, queijo e presunto", 2));
		assertThrows(IllegalArgumentException.class, () -> f1.cadastraProduto("", "pão, queijo e presunto", 2));

		assertThrows(IllegalArgumentException.class, () -> f1.cadastraProduto("misto", null, 2));
		assertThrows(IllegalArgumentException.class, () -> f1.cadastraProduto("misto", "", 2));

		assertThrows(IllegalArgumentException.class, () -> f1.cadastraProduto("misto", "pão, queijo e presunto", -1));

		assertEquals(f1.cadastraProduto("misto", "pão, queijo e presunto", 2), "CADASTRO BEM SUCEDIDO!");

		assertThrows(IllegalArgumentException.class, () -> f1.cadastraProduto("misto", "pão, queijo e presunto", 3));
	}

	@Test
	void exibeProdutosTest() {
		assertThrows(IllegalArgumentException.class, () -> f1.exibeProduto(null, "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> f1.exibeProduto("", "pão, queijo e presunto"));

		assertThrows(IllegalArgumentException.class, () -> f1.exibeProduto("misto", null));
		assertThrows(IllegalArgumentException.class, () -> f1.exibeProduto("misto", ""));

		assertThrows(IllegalArgumentException.class, () -> f1.exibeProduto("misto", "pão, queijo e presunto"));
		f1.cadastraProduto("misto", "pão, queijo e presunto", 2);

		assertEquals(f1.exibeProduto("misto", "pão, queijo e presunto"), "misto - pão, queijo e presunto - R$2,00");
	}

	@Test
	void exibeProdutosDoFornecedorTest() {
		assertEquals(f1.exibeProdutosDoFornecedor(), "lucas -");

		f1.cadastraProduto("misto", "pão, queijo e presunto", 2);
		assertEquals(f1.exibeProdutosDoFornecedor(), "lucas - misto - pão, queijo e presunto - R$2,00");

		f1.cadastraProduto("americano", "pão, salada e queijo", 3);
		assertEquals(f1.exibeProdutosDoFornecedor(),
				"lucas - americano - pão, salada e queijo - R$3,00 | lucas - misto - pão, queijo e presunto - R$2,00");
	}

	@Test
	void editaProdutoTest() {
		assertThrows(IllegalArgumentException.class, () -> f1.editaProduto(null, "pão, queijo e presunto", 3));
		assertThrows(IllegalArgumentException.class, () -> f1.editaProduto("", "pão, queijo e presunto", 3));

		assertThrows(IllegalArgumentException.class, () -> f1.editaProduto("misto", null, 3));
		assertThrows(IllegalArgumentException.class, () -> f1.editaProduto("misto", "", 3));

		assertThrows(IllegalArgumentException.class, () -> f1.editaProduto("misto", "pão, queijo e presunto", -1));

		assertThrows(IllegalArgumentException.class, () -> f1.editaProduto("misto", "pão, queijo e presunto", 2));

		f1.cadastraProduto("misto", "pão, queijo e presunto", 2);

		assertEquals(f1.editaProduto("misto", "pão, queijo e presunto", 1), "PRODUTO EDITADO COM SUCESSO!");
	}

	@Test
	void removeProdutoTest() {
		assertThrows(IllegalArgumentException.class, () -> f1.removeProduto(null, "pão, queijo e presunto"));
		assertThrows(IllegalArgumentException.class, () -> f1.removeProduto("", "pão, queijo e presunto"));

		assertThrows(IllegalArgumentException.class, () -> f1.removeProduto("misto", null));
		assertThrows(IllegalArgumentException.class, () -> f1.removeProduto("misto", ""));

		assertThrows(IllegalArgumentException.class, () -> f1.removeProduto("misto", "pão, queijo e presunto"));

		f1.cadastraProduto("misto", "pão, queijo e presunto", 2);
		assertEquals(f1.removeProduto("misto", "pão, queijo e presunto"), "REMOÇÃO BEM SUCEDIDA!");
	}

	@Test
	void setAndGetTest() {
		assertNotEquals(f1.getNome(), "Lucas");
		assertEquals(f1.getNome(), "lucas");

		assertNotEquals(f1.getEmail(), "lucas.lucena@gmail.com");
		assertEquals(f1.getEmail(), "lucas.lucena@ccc.ufcg.edu.br");
		f1.setEmail("lucas.lucena@gmail.com");
		assertNotEquals(f1.getEmail(), "lucas.lucena@ccc.ufcg.edu.br");
		assertEquals(f1.getEmail(), "lucas.lucena@gmail.com");

		assertNotEquals(f1.getTelefone(), "83 94444-3333");
		assertEquals(f1.getTelefone(), "83 91234-5678");
		f1.setTelefone("83 94444-3333");
		assertNotEquals(f1.getTelefone(), "83 91234-5678");
		assertEquals(f1.getTelefone(), "83 94444-3333");
	}

	@Test
	void hashCodeTest() {
		assertNotEquals(f1.hashCode(), f2.hashCode());
		assertNotEquals(f2.hashCode(), f1.hashCode());

		assertEquals(f1.hashCode(), f1.hashCode());
		assertEquals(f2.hashCode(), f2.hashCode());
	}

	@Test
	void equalsTest() {
		Fornecedor f3 = new Fornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678");
		Fornecedor f4 = new Fornecedor("mateus", "mateus@ccc.ufcg.edu.br", "11 98765-4321");

		assertTrue(f1.equals(f1));
		assertFalse(f1.equals(""));
		assertFalse(f1.equals("aaaaaaa"));
		assertFalse(f1.equals(null));

		assertTrue(f1.equals(f3));
		assertTrue(f2.equals(f4));

		assertFalse(f1.equals(f2));
		assertFalse(f1.equals(f4));
		assertFalse(f2.equals(f3));
		assertFalse(f3.equals(f4));
	}

}