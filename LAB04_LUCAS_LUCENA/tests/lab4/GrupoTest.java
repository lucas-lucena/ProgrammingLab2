package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GrupoTest {

	private Grupo g1;
	private Grupo g2;
	private Grupo g3;
	private Aluno a;
	
	@BeforeEach
	void criaGrupos() {
		g1 = new Grupo("p2");
		g2 = new Grupo("fmcc2");
		g3 = new Grupo("p2");
		Aluno a = new Aluno("123", "lucas", "computacao");
	}
	
	@Test
	void construtorTest() {
		assertThrows(IllegalArgumentException.class, () -> new Grupo(""));
		assertThrows(IllegalArgumentException.class, () -> new Grupo(null));
	}
	
	@Test
	void alocaAlunoTest() {
		g1.alocaAluno(a);
		g2.alocaAluno(a);
		g3.alocaAluno(a);
	}
	
	@Test
	void toStringTest() {
		assertEquals(g1.toString(), "Alunos do grupo p2:\nNENHUM ALUNO CADASTRADO AINDA!");
		
		Aluno a = new Aluno("123", "lucas", "computacao");
		g1.alocaAluno(a);
		assertEquals(g1.toString(), "Alunos do grupo p2:\n* Aluno: 123 - lucas - computacao");
	}
	
	@Test
	void hashCodeTest() {
		Grupo gTest = new Grupo("p2");
		assertNotSame(gTest.hashCode(), g1.hashCode());
		assertNotSame(g1.hashCode(), g2.hashCode());
		assertNotSame(g3.hashCode(), g2.hashCode());
		assertEquals(g1.hashCode(), g3.hashCode());
		assertEquals(g1.hashCode(), g1.hashCode());
	}
	
	@Test 
	void equalsTest() {
		Grupo g4 = new Grupo("p2");
		Grupo g5 = new Grupo("fmcc2");
		Grupo g6 = new Grupo("fmcc2");
		Aluno aTest = new Aluno("123", "lucas", "medicina");
		
		g1.alocaAluno(a);
		g2.alocaAluno(a);
		g3.alocaAluno(a);
		g5.alocaAluno(a);
		g6.alocaAluno(aTest);
		
		assertTrue(g1.equals(g1));
		assertFalse(g1.equals(""));
		assertFalse(g1.equals("Teste"));
		assertFalse(g1.equals(null));
		
		assertTrue(g1.equals(g3));
		assertFalse(g1.equals(g4));
		assertFalse(g1.equals(g2));
		assertFalse(g1.equals(g5));
		assertFalse(g1.equals(g6));
		
		assertTrue(g2.equals(g5));
		assertFalse(g2.equals(g1));
		assertFalse(g2.equals(g3));
		assertFalse(g2.equals(g4));
		assertFalse(g2.equals(g6));
		
		assertTrue(g3.equals(g1));
		assertFalse(g3.equals(g4));
		assertFalse(g3.equals(g2));
		assertFalse(g3.equals(g5));
		assertFalse(g3.equals(g6));
		
		assertFalse(g4.equals(g1));
		assertFalse(g4.equals(g3));
		assertFalse(g4.equals(g2));
		assertFalse(g4.equals(g5));
		assertFalse(g4.equals(g6));
		
		assertTrue(g5.equals(g2));
		assertFalse(g5.equals(g1));
		assertFalse(g5.equals(g3));
		assertFalse(g5.equals(g4));
		assertFalse(g5.equals(g6));
		
		assertFalse(g6.equals(g1));
		assertFalse(g6.equals(g2));
		assertFalse(g6.equals(g3));
		assertFalse(g6.equals(g4));
		assertFalse(g6.equals(g5));
	
	}
}
