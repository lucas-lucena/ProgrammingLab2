    package lab5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    Produto p1;
    Produto p2;

    @BeforeEach
    void criarProdutos() {
        p1 = new Produto("misto", "pão, queijo e presunto", 2);
        p2 = new Produto("americano", "pão, queijo e salada", 3);
    }

    @Test
    void construtorTest() {
        assertThrows(IllegalArgumentException.class, () -> new Produto(null, "tapioca com queijo", 1));
        assertThrows(IllegalArgumentException.class, () -> new Produto("", "tapioca com queijo", 1));

        assertThrows(IllegalArgumentException.class, () -> new Produto("tapioca", null, 1));
        assertThrows(IllegalArgumentException.class, () -> new Produto("tapioca", "", 1));

        assertThrows(IllegalArgumentException.class, () -> new Produto("tapioca", "tapioca com queijo", -1));
    }


    @Test
    void toStringTest() {
        Produto pTest = new Produto("tapioca", "tapioca com queijo", 1);
        assertEquals(pTest.toString(), "tapioca - tapioca com queijo - R$1,00");
        assertEquals(p1.toString(), "misto - pão, queijo e presunto - R$2,00");

        assertNotEquals(p1.toString(), pTest.toString());
        assertNotEquals(p1.toString(), "tapioca - tapioca com queijo - R$1,00");
        assertNotEquals(pTest.toString(), "misto - pão, queijo e presunto - R$2,00");
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
        Produto p3 = new Produto("misto", "pão, queijo e presunto", 2);
        Produto p4 = new Produto("americano", "pão, queijo e salada", 3);

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