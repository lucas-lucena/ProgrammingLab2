package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {

	Cliente c1;
	Cliente c2;

	@BeforeEach
	void criarCliente() {
		c1 = new Cliente("12345678901", "lucas", "lucas.lucena@ccc.ufcg.edu.br", "lcc3");
		c2 = new Cliente("10987654321", "matheus", "matheus@ccc.ufcg.edu.br", "lcc2");
	}

	@Test
	void construtorTest() {
		assertThrows(IllegalArgumentException.class,
				() -> new Cliente(null, "lucas", "lucas.lucena@ccc.ufcg.edu.br", "lcc3"));
		assertThrows(IllegalArgumentException.class,
				() -> new Cliente("", "lucas", "lucas.lucena@ccc.ufcg.edu.br", "lcc3"));
		assertThrows(IllegalArgumentException.class,
				() -> new Cliente("123456789012", "lucas", "lucas.lucena@ccc.ufcg.edu.br", "lcc3"));
		assertThrows(IllegalArgumentException.class,
				() -> new Cliente("1234567890", "lucas", "lucas.lucena@ccc.ufcg.edu.br", "lcc3"));

		assertThrows(IllegalArgumentException.class,
				() -> new Cliente("12345678901", null, "lucas.lucena@ccc.ufcg.edu.br", "lcc3"));
		assertThrows(IllegalArgumentException.class,
				() -> new Cliente("12345678901", "", "lucas.lucena@ccc.ufcg.edu.br", "lcc3"));

		assertThrows(IllegalArgumentException.class, () -> new Cliente("12345678901", "lucas", null, "lcc3"));
		assertThrows(IllegalArgumentException.class, () -> new Cliente("12345678901", "lucas", "", "lcc3"));

		assertThrows(IllegalArgumentException.class,
				() -> new Cliente("12345678901", "lucas", "lucas.lucena@ccc.ufcg.edu.br", null));
		assertThrows(IllegalArgumentException.class,
				() -> new Cliente("12345678901", "lucas", "lucas.lucena@ccc.ufcg.edu.br", ""));
	}

	@Test
	void toStringTest() {
		Cliente cTest = new Cliente("10987654321", "matheus", "matheus@ccc.ufcg.edu.br", "lcc2");
		assertEquals(cTest.toString(), "matheus - lcc2 - matheus@ccc.ufcg.edu.br");
		assertEquals(c1.toString(), "lucas - lcc3 - lucas.lucena@ccc.ufcg.edu.br");

		assertNotEquals(c1.toString(), cTest.toString());
		assertNotEquals(c1.toString(), "matheus - lcc2 - matheus@ccc.ufcg.edu.br");
		assertNotEquals(cTest.toString(), "lucas - lcc3 - lucas.lucena@ccc.ufcg.edu.br");
	}

	@Test
	void setAndGetTest() {

		assertNotEquals(c1.getNome(), "Lucas");
		assertEquals(c1.getNome(), "lucas");
		c1.setNome("Lucas");
		assertNotEquals(c1.getNome(), "lucas");
		assertEquals(c1.getNome(), "Lucas");

		assertNotEquals(c1.getEmail(), "lucas.lucena@gmail.com");
		assertEquals(c1.getEmail(), "lucas.lucena@ccc.ufcg.edu.br");
		c1.setEmail("lucas.lucena@gmail.com");
		assertNotEquals(c1.getEmail(), "lucas.lucena@ccc.ufcg.edu.br");
		assertEquals(c1.getEmail(), "lucas.lucena@gmail.com");

		assertNotEquals(c1.getLocal(), "lcc2");
		assertEquals(c1.getLocal(), "lcc3");
		c1.setLocal("lcc2");
		assertNotEquals(c1.getLocal(), "lcc3");
		assertEquals(c1.getLocal(), "lcc2");
	}

	@Test
	void hashCodeTest() {
		assertNotEquals(c1.hashCode(), c2.hashCode());
		assertNotEquals(c2.hashCode(), c1.hashCode());

		assertEquals(c1.hashCode(), c1.hashCode());
		assertEquals(c2.hashCode(), c2.hashCode());
	}

	@Test
	void equalsTest() {
		Cliente c3 = new Cliente("12345678901", "lucas", "lucas.lucena@ccc.ufcg.edu.br", "lcc3");
		Cliente c4 = new Cliente("10987654321", "matheus", "matheus@ccc.ufcg.edu.br", "lcc2");

		assertTrue(c1.equals(c1));
		assertFalse(c1.equals(""));
		assertFalse(c1.equals("aaaaaaa"));
		assertFalse(c1.equals(null));

		assertTrue(c1.equals(c3));
		assertTrue(c2.equals(c4));

		assertFalse(c1.equals(c2));
		assertFalse(c1.equals(c4));
		assertFalse(c2.equals(c3));
		assertFalse(c3.equals(c4));
	}

}