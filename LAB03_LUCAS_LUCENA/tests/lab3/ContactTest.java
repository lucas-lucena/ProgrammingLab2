package lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {

	private Contact c1;
	private Contact c2;
	private Contact c3;
	private Contact c4;
	private Contact c5;
	private Contact c6;
	private Contact c7;
	
	@BeforeEach
	void creatContact() {
    	c1 = new Contact("Lucas", "Lucena", "1220");
    	c2 = new Contact("Mateus", "Henrique", "1717");
    	c3 = new Contact("Rodrigo", "Estrela", "8899");
    	c4 = new Contact("Rodrigo", "Estrela", "9988");
    	c5 = new Contact("Mateus", "Henrique", "1717");
    	c6 = new Contact("Lucas", "Lucena", "0221");
    	c7 = new Contact("Lucas", "Leal", "0221");
	}
	
	@Test
	void ConstructorTest() {
		assertThrows(NullPointerException.class, () -> new Contact(null,"Lucena", "1220"));
		assertThrows(NullPointerException.class, () -> new Contact("Lucas",null, "1220"));
		assertThrows(NullPointerException.class, () -> new Contact("Lucas","Lucena", null));
		assertThrows(IllegalArgumentException.class, () -> new Contact("","Lucena", "1220"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("Lucas","", "1220"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("Lucas","Lucena", ""));
	}
	
	@Test
	void toStringTest() {
		assertEquals(c1.toString(), "Lucas Lucena - 1220" );
		assertEquals(c2.toString(), "Mateus Henrique - 1717" );
		assertEquals(c3.toString(), "Rodrigo Estrela - 8899" );
		assertEquals(c4.toString(), "Rodrigo Estrela - 9988" );
		assertEquals(c5.toString(), "Mateus Henrique - 1717" );
		assertEquals(c6.toString(), "Lucas Lucena - 0221" );
	}
	
	@Test
	void getFullNameTest() {
		assertEquals("Lucas Lucena", c1.getFullName());
		assertEquals("Mateus Henrique", c2.getFullName());
		assertEquals("Rodrigo Estrela", c3.getFullName());
		assertEquals("Rodrigo Estrela", c4.getFullName());
		assertEquals("Mateus Henrique", c5.getFullName());
		assertEquals("Lucas Lucena", c6.getFullName());
	}
	
	@Test
	void equalsTest() {
		
		assertTrue(c1.equals(c1));
		assertFalse(c1.equals(null));
		assertFalse(c1.equals("Teste"));
		
		assertTrue(c1.equals(c6));
		assertTrue(c2.equals(c5));
		assertTrue(c3.equals(c4));
		assertTrue(c6.equals(c1));
		assertTrue(c5.equals(c2));
		assertTrue(c4.equals(c3));
		
		assertFalse(c1.equals(c2));
		assertFalse(c1.equals(c3));
		assertFalse(c1.equals(c4));
		assertFalse(c1.equals(c5));
		assertFalse(c1.equals(c7));
		
		assertFalse(c2.equals(c1));
		assertFalse(c2.equals(c3));
		assertFalse(c2.equals(c4));
		assertFalse(c2.equals(c6));
		
		assertFalse(c3.equals(c1));
		assertFalse(c3.equals(c2));
		assertFalse(c3.equals(c5));
		assertFalse(c3.equals(c6));
		
		assertFalse(c4.equals(c1));
		assertFalse(c4.equals(c2));
		assertFalse(c4.equals(c5));
		assertFalse(c4.equals(c6));
		
		assertFalse(c5.equals(c1));
		assertFalse(c5.equals(c3));
		assertFalse(c5.equals(c4));
		assertFalse(c5.equals(c6));
		
		assertFalse(c6.equals(c2));
		assertFalse(c6.equals(c3));
		assertFalse(c6.equals(c4));
		assertFalse(c6.equals(c5));
	}	
}
