package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GrupoTest {

	private Grupo g1;
	private Grupo g2;
	private Grupo g3;
	
	@BeforeEach
	void criaGrupos() {
		g1 = new Grupo("p2");
		g2 = new Grupo("fmcc2");
		g3 = new Grupo("p2");
	}
	
	@Test
	void construtorTest() {
		assertThrows(IllegalArgumentException.class, () -> new Grupo(""));
		assertThrows(IllegalArgumentException.class, () -> new Grupo(null));
	}
	
	@Test
	void alocaAlunoTest() {
		
	}
}
