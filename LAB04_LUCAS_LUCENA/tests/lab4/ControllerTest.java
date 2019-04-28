package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControllerTest {

	private Controller c = new Controller();
	
	@Test
	void cadastraAlunoTest () {
		assertEquals(c.cadastraAluno("123", "lucas", "computação"), "\nCADASTRO REALIZADO!\n");
		assertEquals(c.cadastraAluno("123", "lucas", "medicina"), "\nMATRÍCULA JÁ CADASTRADA!\n");
		assertEquals(c.cadastraAluno("123", "raphael", "medicina"), "\nMATRÍCULA JÁ CADASTRADA!\n");
		
		assertThrows(IllegalArgumentException.class, ()-> this.c.cadastraAluno("", "lucas", "computação"));
		assertThrows(IllegalArgumentException.class, ()-> this.c.cadastraAluno(null, "lucas", "computação"));
		assertThrows(IllegalArgumentException.class, ()-> this.c.cadastraAluno("123", "", "computação"));
		assertThrows(IllegalArgumentException.class, ()-> this.c.cadastraAluno("123", null, "computação"));
		assertThrows(IllegalArgumentException.class, ()-> this.c.cadastraAluno("123", "lucas", ""));
		assertThrows(IllegalArgumentException.class, ()-> this.c.cadastraAluno("123", "lucas", null));
	}
	
	@Test
	void consultaAlunoTest() {
		c.cadastraAluno("123", "lucas", "computação");
		
		assertEquals(c.consultaAluno("123"), "\nAluno: 123 - lucas - computação\n");
		assertEquals(c.consultaAluno("321"), "\nAluno não cadastrado.\n");
	
		assertThrows(IllegalArgumentException.class, ()-> this.c.consultaAluno(""));
		assertThrows(IllegalArgumentException.class, ()-> this.c.consultaAluno(null));
	}
	
	@Test
	void cadastraGrupoTest() {
		assertEquals(c.cadastraGrupo("projeto"), "\nCADASTRO REALIZADO!\n");
		assertEquals(c.cadastraGrupo("projeto"), "\nGRUPO JÁ CADASTRADO!\n");
		assertEquals(c.cadastraGrupo("PROJETO"), "\nGRUPO JÁ CADASTRADO!\n");
		assertEquals(c.cadastraGrupo("estudos"), "\nCADASTRO REALIZADO!\n");
		
		assertThrows(IllegalArgumentException.class, ()-> this.c.cadastraGrupo(""));
		assertThrows(IllegalArgumentException.class, ()-> this.c.cadastraGrupo(null));
	}
	
	@Test
	void alocarAlunoTest() {
		c.cadastraGrupo("projeto");
		c.cadastraAluno("123", "lucas", "computação");
		
		assertEquals(c.alocarAluno("999", "projeto"), "\nAluno não cadastrado.\n");
		assertEquals(c.alocarAluno("123", "estudo"), "\nGrupo não cadastrado.\n");
		assertEquals(c.alocarAluno("123", "projeto"), "\nALUNO ALOCADO!\n");
		
		assertThrows(IllegalArgumentException.class, ()-> this.c.alocarAluno("", "projeto"));
		assertThrows(IllegalArgumentException.class, ()-> this.c.alocarAluno(null, "projeto"));
		assertThrows(IllegalArgumentException.class, ()-> this.c.alocarAluno("123", ""));
		assertThrows(IllegalArgumentException.class, ()-> this.c.alocarAluno("123", null));
	}
	
	@Test
	void imprimirGrupoTest() {
		c.cadastraGrupo("projeto");
		assertEquals(c.imprimirGrupo("projeto"), "\nAlunos do grupo projeto:\nNENHUM ALUNO CADASTRADO AINDA!\n");
		
		c.cadastraAluno("123", "lucas", "computação");
		c.alocarAluno("123", "projeto");
		assertEquals(c.imprimirGrupo("projeto"), "\nAlunos do grupo projeto:\n* Aluno: 123 - lucas - computação\n");
		
		assertEquals(c.imprimirGrupo("estudos"), "GRUPO NÃO CADASTRADO!\n");
		
		assertThrows(IllegalArgumentException.class, ()-> c.imprimirGrupo(""));
		assertThrows(IllegalArgumentException.class, ()-> c.imprimirGrupo(null));
	}
	
	@Test
	void cadastraRespondemQuestoes() {
		assertEquals(c.cadastraRespondemQuestoes("123"), "\nAluno não cadastrado.\n");
		
		c.cadastraAluno("123", "lucas", "computação");
		
		assertEquals(c.cadastraRespondemQuestoes("123"), "\nALUNO REGISTRADO!\n");
		
		assertThrows(IllegalArgumentException.class, ()-> c.cadastraRespondemQuestoes(""));
		assertThrows(IllegalArgumentException.class, ()-> c.cadastraRespondemQuestoes(null));
	}
	
	@Test
	void imprimeRespondemQuestoesTest() {
		assertEquals(c.imprimeRespondemQuestoes(), "\nNENHUM ALUNO RESPONDEU QUESTÕES NO QUADRO\n");
		
		c.cadastraAluno("123", "lucas", "computação");
		c.cadastraRespondemQuestoes("123");
		
		assertEquals(c.imprimeRespondemQuestoes(), "\nAlunos:\n1. 123 - lucas - computação\n");
	}
}































