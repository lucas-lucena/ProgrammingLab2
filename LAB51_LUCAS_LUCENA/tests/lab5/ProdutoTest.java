package lab5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoSimplesTest {

	ProdutoSimples p1;
	ProdutoSimples p2;

	@BeforeEach
	void criarProdutoSimpless() {
		p1 = new ProdutoSimples("misto", "pão, queijo e presunto", 2);
		p2 = new ProdutoSimples("americano", "pão, queijo e salada", 3);
	}

	@Test
	void construtorTest() {
		assertThrows(IllegalArgumentException.class, () -> new ProdutoSimples(null, "tapioca com queijo", 1));
		assertThrows(IllegalArgumentException.class, () -> new ProdutoSimples("", "tapioca com queijo", 1));

		assertThrows(IllegalArgumentException.class, () -> new ProdutoSimples("tapioca", null, 1));
		assertThrows(IllegalArgumentException.class, () -> new ProdutoSimples("tapioca", "", 1));

		assertThrows(IllegalArgumentException.class, () -> new ProdutoSimples("tapioca", "tapioca com queijo", -1));
	}

	@Test
	void toStringTest() {
		ProdutoSimples pTest = new ProdutoSimples("tapioca", "tapioca com queijo", 1);
		assertEquals(pTest.toString(), "tapioca - tapioca com queijo - R$1,00");
		assertEquals(p1.toString(), "misto - pão, queijo e presunto - R$2,00");

		assertNotEquals(p1.toString(), pTest.toString());
		assertNotEquals(p1.toString(), "tapioca - tapioca com queijo - R$1,00");
		assertNotEquals(pTest.toString(), "misto - pão, queijo e presunto - R$2,00");
	}

	@Test
	void setAndGetTest() {
		assertNotEquals(p1.getNome(), "Misto");
		assertEquals(p1.getNome(), "misto");

		assertNotEquals(p1.getDescricao(), "pão, queijo e salada");
		assertEquals(p1.getDescricao(), "pão, queijo e presunto");

		assertNotEquals(p1.getPreco(), "5,50");
		assertEquals(p1.getPreco(), "2,00");
		p1.setPreco(5.50);
		assertEquals(p1.getPreco(), "5,50");
		assertNotEquals(p1.getPreco(), "2,00");
	}

	@Test
	void hashCodeTest() {
		assertNotEquals(p1.hashCode(), p2.hashCode());
		assertNotEquals(p2.hashCode(), p1.hashCode());

		assertEquals(p2.hashCode(), p2.hashCode());
		assertEquals(p1.hashCode(), p1.hashCode());
	}

	@Test
	void equalsTest() {
		ProdutoSimples p3 = new ProdutoSimples("misto", "pão, queijo e presunto", 2);
		ProdutoSimples p4 = new ProdutoSimples("americano", "pão, queijo e salada", 3);

		assertTrue(p1.equals(p1));
		assertFalse(p1.equals(""));
		assertFalse(p1.equals("aaaaaaa"));
		assertFalse(p1.equals(null));

		assertTrue(p1.equals(p3));
		assertTrue(p2.equals(p4));

		assertFalse(p1.equals(p2));
		assertFalse(p1.equals(p4));
		assertFalse(p2.equals(p3));
		assertFalse(p3.equals(p4));
	}

}