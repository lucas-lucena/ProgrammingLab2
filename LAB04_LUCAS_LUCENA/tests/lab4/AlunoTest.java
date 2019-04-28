package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlunoTest {
	
	private Aluno a1;
	private Aluno a2;
	private Aluno a3;
	
	@BeforeEach
	void criaAlunos() {
		a1 = new Aluno("123", "lucas", "computacao");
		a2 = new Aluno("321", "marcos", "computacao");
		a3 = new Aluno("123", "lucas", "computacao");
	}

	@Test
	void construtorTest() {
		assertThrows(IllegalArgumentException.class, () -> new Aluno(null, "lucas", "computacao"));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("", "lucas", "computacao"));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("123", null, "computacao"));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("123", "", "computacao"));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("123", "lucas", null));
		assertThrows(IllegalArgumentException.class, () -> new Aluno("123", "lucas", ""));
	}
	
	@Test
	void toStringTest() {
		assertEquals(a1.toString(), "123 - lucas - computacao");
		assertEquals(a2.toString(), "321 - marcos - computacao");
		assertEquals(a3.toString(), "123 - lucas - computacao");
		
	}
	
	@Test
	void hashCodeTest() {
		Aluno aTest = new Aluno("123", "lucas", "computacao");
		assertNotSame(aTest.hashCode(), a1.hashCode());
		assertNotSame(a1.hashCode(), a2.hashCode());
		assertEquals(a1.hashCode(), a1.hashCode());
	}
	
	@Test
	void equalsTest() {
		Aluno a4 = new Aluno("321", "lucas", "computacao");
		Aluno a5 = new Aluno("123", "marcos", "computacao");
		Aluno a6 = new Aluno("123", "lucas", "civil");
		
		assertTrue(a1.equals(a1));
		assertFalse(a1.equals(""));
		assertFalse(a1.equals("Teste"));
		assertFalse(a1.equals(null));
		
		assertTrue(a1.equals(a3));
		assertTrue(a3.equals(a1));
		assertFalse(a1.equals(a2));
		assertFalse(a2.equals(a1));
		
		assertFalse(a1.equals(a4));
		assertFalse(a4.equals(a1));
		assertFalse(a1.equals(a5));
		assertFalse(a5.equals(a1));
		assertFalse(a1.equals(a6));
		assertFalse(a6.equals(a1));
	}
}