package lab3; 

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhoneBookTest { 
	
	private PhoneBook p = new PhoneBook();
	
	@BeforeEach
	void registerContact() {
		p.registerContact(1, "Lucas", "Lucena", "1220");
		p.registerContact(2, "Matheus", "Henrique", "1717");
		p.registerContact(3, "Daniel", "DeMatos", "9876");
		p.registerContact(99, "Lucas", "Lucena", "1220");
	}
	
	@Test
	void testRegisterContact() { 
		PhoneBook ptest = new PhoneBook();
		assertEquals(ptest.registerContact(1, "Lucas", "Leal", "1234"), "CADASTRO REALIZADO!\n");
		assertEquals(ptest.registerContact(100, "Brener", "Quevedo", "4444"), "CADASTRO REALIZADO!\n");
		assertEquals(p.registerContact(0, "Rodrigo", "Estrela", "5678"),  "POSIÇÃO INVÁLIDA!\n");
		assertEquals(p.registerContact(101, "Gabriel", "Felipe", "1010"),  "POSIÇÃO INVÁLIDA!\n");
		assertEquals(p.registerContact(1, null, "Jordao", "2345"), "NOME INVALIDO!\n");
		assertEquals(p.registerContact(1, "  ", "Jordao", "2345"), "NOME INVALIDO!\n");	
		assertEquals(p.registerContact(1, "Andre", null, "2345"), "SOBRENOME INVALIDO!\n");
		assertEquals(p.registerContact(1, "Andre", "  ", "2345"), "SOBRENOME INVALIDO!\n");
		assertEquals(p.registerContact(1, "Andre", "Jordao", null), "TELEFONE INVALIDO!\n");
		assertEquals(p.registerContact(1, "Andre", "Jordao", "  "), "TELEFONE INVALIDO!\n");
	}
	
	@Test
	void testShowContact() {
		assertEquals(p.showContact(0), "POSIÇÃO INVÁLIDA!");
		assertEquals(p.showContact(101), "POSIÇÃO INVÁLIDA!");
		assertEquals(p.showContact(78), "SEM CONTATO CADASTRADO!");
		assertEquals(p.showContact(1), "Lucas Lucena - 1220");
		assertEquals(p.showContact(2), "Matheus Henrique - 1717");
		assertEquals(p.showContact(3), "Daniel DeMatos - 9876");
	}
	
	@Test
	void testCompareContacts() {
		assertEquals(p.compareContacts(1, 99), "SIM SOU EU!\n");
		assertEquals(p.compareContacts(1, 2), "NÃO SOU EU!\n");
	}
	
	@Test
	void testListContacts() {
		PhoneBook pvoid = new PhoneBook();
		assertEquals(p.listContacts(), "1 - Lucas Lucena\n" + "2 - Matheus Henrique\n" + "3 - Daniel DeMatos\n" + "99 - Lucas Lucena\n");
		assertEquals(pvoid.listContacts(), "NENHUM CONTATO FOI REGISTRADO\n");
	}
	 
	@Test
	void testEquals() {
		assertTrue (p.equals(p));
		assertFalse (p.equals(null));
		assertFalse (p.equals("java"));

		PhoneBook p1 = new PhoneBook();
		PhoneBook p2 = new PhoneBook();
		
		p1.registerContact(1, "Lucas", "Lucena", "1220");
		p1.registerContact(2, "Matheus", "Henrique", "1717");
		p1.registerContact(3, "Daniel", "DeMatos", "9876");
		p1.registerContact(99, "Lucas", "Lucena", "1220");

		assertTrue (p1.equals(p));
		assertFalse (p1.equals(p2));

	}
	
	@Test
	public void testHashCode() {
		assertEquals(130783620, p.hashCode());
	}
}
