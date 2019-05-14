package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClienteControllerTest {

	ClienteController c = new ClienteController();

	@Test
	public void cadastraClienteTest() {
		assertEquals(c.cadastraClientes("12345678901", "lucas", "lucas.lucena@ccc.ufcg.edu.br", "lcc3"), "12345678901");
		assertThrows(IllegalArgumentException.class,
				() -> this.c.cadastraClientes("12345678901", "Lucas", "lucas.lucena@ccc.ufcg.edu.br", "lcc3"));
		assertThrows(IllegalArgumentException.class,
				() -> this.c.cadastraClientes("12345678901", "lucas", "lucas@ccc.ufcg.edu.br", "lcc3"));
		assertThrows(IllegalArgumentException.class,
				() -> this.c.cadastraClientes("12345678901", "lucas", "lucas.lucena@ccc.ufcg.edu.br", "lcc2"));

		assertThrows(IllegalArgumentException.class,
				() -> this.c.cadastraClientes(null, "lucas", "lucas.lucena@ccc.ufcg.edu.br", "lcc3"));
		assertThrows(IllegalArgumentException.class,
				() -> this.c.cadastraClientes("", "lucas", "lucas.lucena@ccc.ufcg.edu.br", "lcc3"));
		assertThrows(IllegalArgumentException.class,
				() -> this.c.cadastraClientes("1234567890", "lucas", "lucas.lucena@ccc.ufcg.edu.br", "lcc3"));
		assertThrows(IllegalArgumentException.class,
				() -> this.c.cadastraClientes("123456789012", "lucas", "lucas.lucena@ccc.ufcg.edu.br", "lcc3"));

		assertThrows(IllegalArgumentException.class,
				() -> this.c.cadastraClientes("11111111111", null, "lucas.lucena@ccc.ufcg.edu.br", "lcc3"));
		assertThrows(IllegalArgumentException.class,
				() -> this.c.cadastraClientes("11111111111", "", "lucas.lucena@ccc.ufcg.edu.br", "lcc3"));

		assertThrows(IllegalArgumentException.class,
				() -> this.c.cadastraClientes("11111111111", "lucas", null, "lcc3"));
		assertThrows(IllegalArgumentException.class, () -> this.c.cadastraClientes("11111111111", "lucas", "", "lcc3"));

		assertThrows(IllegalArgumentException.class,
				() -> this.c.cadastraClientes("11111111111", "lucas", "lucas.lucena@ccc.ufcg.edu.br", null));
		assertThrows(IllegalArgumentException.class,
				() -> this.c.cadastraClientes("11111111111", "lucas", "lucas.lucena@ccc.ufcg.edu.br", ""));
	}

	@Test
	public void exibeClienteTest() {
		c.cadastraClientes("12345678901", "lucas", "lucas.lucena@ccc.ufcg.edu.br", "lcc3");
		assertEquals(c.exibeCliente("12345678901"), "lucas - lcc3 - lucas.lucena@ccc.ufcg.edu.br");

		assertThrows(IllegalArgumentException.class, () -> this.c.exibeCliente(""));
		assertThrows(IllegalArgumentException.class, () -> this.c.exibeCliente(null));
		assertThrows(IllegalArgumentException.class, () -> this.c.exibeCliente("1234567890"));
		assertThrows(IllegalArgumentException.class, () -> this.c.exibeCliente("12345678909"));
		assertThrows(IllegalArgumentException.class, () -> this.c.exibeCliente("1234567890"));
		assertThrows(IllegalArgumentException.class, () -> this.c.exibeCliente("123456789012"));
	}

	@Test
	public void exibeTodoOsClientesTest() {
		assertThrows(IllegalArgumentException.class, () -> this.c.exibeTodosOsClientes());

		c.cadastraClientes("12345678901", "lucas", "lucas.lucena@ccc.ufcg.edu.br", "lcc3");
		c.cadastraClientes("10987654321", "mateus", "mateus@ccc.ufcg.edu.br", "lcc2");

		assertEquals(c.exibeTodosOsClientes(),
				"lucas - lcc3 - lucas.lucena@ccc.ufcg.edu.br | mateus - lcc2 - mateus@ccc.ufcg.edu.br");
	}

	@Test
	public void editaCliente() {
		c.cadastraClientes("12345678901", "lucas", "lucas.lucena@ccc.ufcg.edu.br", "lcc3");
		assertEquals(c.exibeCliente("12345678901"), "lucas - lcc3 - lucas.lucena@ccc.ufcg.edu.br");

		assertThrows(IllegalArgumentException.class, () -> this.c.editaCliente(null, "nome", "Lucas"));
		assertThrows(IllegalArgumentException.class, () -> this.c.editaCliente("", "nome", "Lucas"));
		assertThrows(IllegalArgumentException.class, () -> this.c.editaCliente("1234567890", "nome", "Lucas"));
		assertThrows(IllegalArgumentException.class, () -> this.c.editaCliente("123456789012", "nome", "Lucas"));

		assertThrows(IllegalArgumentException.class, () -> this.c.editaCliente("12345678901", null, "Lucas"));
		assertThrows(IllegalArgumentException.class, () -> this.c.editaCliente("12345678901", "", "Lucas"));
		assertThrows(IllegalArgumentException.class, () -> this.c.editaCliente("12345678901", "telefone", "Lucas"));
		assertThrows(IllegalArgumentException.class, () -> this.c.editaCliente("12345678901", "nome", null));
		assertThrows(IllegalArgumentException.class, () -> this.c.editaCliente("12345678901", "nome", ""));
		assertThrows(IllegalArgumentException.class, () -> this.c.editaCliente("12345678901", "localizacao", null));
		assertThrows(IllegalArgumentException.class, () -> this.c.editaCliente("12345678901", "localizacao", ""));
		assertThrows(IllegalArgumentException.class, () -> this.c.editaCliente("12345678901", "email", null));
		assertThrows(IllegalArgumentException.class, () -> this.c.editaCliente("12345678901", "email", ""));
		assertThrows(IllegalArgumentException.class, () -> this.c.editaCliente("12345678911", "email", "Lucas"));

		c.editaCliente("12345678901", "nome", "Lucas");
		assertNotEquals(c.exibeCliente("12345678901"), "lucas - lcc3 - lucas.lucena@ccc.ufcg.edu.br");
		assertEquals(c.exibeCliente("12345678901"), "Lucas - lcc3 - lucas.lucena@ccc.ufcg.edu.br");

		c.editaCliente("12345678901", "localizacao", "lcc2");
		assertNotEquals(c.exibeCliente("12345678901"), "Lucas - lcc3 - lucas.lucena@ccc.ufcg.edu.br");
		assertEquals(c.exibeCliente("12345678901"), "Lucas - lcc2 - lucas.lucena@ccc.ufcg.edu.br");

		c.editaCliente("12345678901", "email", "lucas@ccc.ufcg.edu.br");
		assertNotEquals(c.exibeCliente("12345678901"), "Lucas - lcc2 - lucas.lucena@ccc.ufcg.edu.br");
		assertEquals(c.exibeCliente("12345678901"), "Lucas - lcc2 - lucas@ccc.ufcg.edu.br");
	}

	@Test
	public void removerClienteTest() {
		c.cadastraClientes("12345678901", "lucas", "lucas.lucena@ccc.ufcg.edu.br", "lcc3");
		assertEquals(c.exibeCliente("12345678901"), "lucas - lcc3 - lucas.lucena@ccc.ufcg.edu.br");
		assertThrows(IllegalArgumentException.class, () -> this.c.removerCliente(null));
		assertThrows(IllegalArgumentException.class, () -> this.c.removerCliente(""));
		assertThrows(IllegalArgumentException.class, () -> this.c.removerCliente("1234567890"));
		assertThrows(IllegalArgumentException.class, () -> this.c.removerCliente("123456789012"));

		c.removerCliente("12345678901");
		assertThrows(IllegalArgumentException.class, () -> this.c.exibeCliente("12345678901"));
		assertThrows(IllegalArgumentException.class, () -> this.c.removerCliente("12345678901"));
	}
}