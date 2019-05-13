package lab5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorControllerTest {

    FornecedorController f = new FornecedorController();

    @Test
    void cadastraFornecedorTest() {
        assertEquals (f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678"),"lucas");
        assertThrows(IllegalArgumentException.class, () -> f.cadastraFornecedor("lucas", "lucas@ccc.ufcg.edu.br", "83 91234-5678"));
        assertThrows(IllegalArgumentException.class, () -> f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 94444-1111"));

        assertThrows(IllegalArgumentException.class, () -> f.cadastraFornecedor(null, "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678"));
        assertThrows(IllegalArgumentException.class, () -> f.cadastraFornecedor("", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678"));


        assertThrows(IllegalArgumentException.class, () -> f.cadastraFornecedor("Lucas", null, "83 91234-5678"));
        assertThrows(IllegalArgumentException.class, () -> f.cadastraFornecedor("Lucas", "", "83 94444-1111"));


        assertThrows(IllegalArgumentException.class, () -> f.cadastraFornecedor("Lucas", "lucas.lucena@ccc.ufcg.edu.br", null));
        assertThrows(IllegalArgumentException.class, () -> f.cadastraFornecedor("Lucas", "lucas.lucena@ccc.ufcg.edu.br", ""));
    }

    @Test
    void exibeFornecedorTest() {
        assertThrows(IllegalArgumentException.class, () -> this.f.exibeFornecedor("lucas"));
        f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678");
        assertEquals(f.exibeFornecedor("lucas"), "lucas - lucas.lucena@ccc.ufcg.edu.br - 83 91234-5678");

        assertThrows(IllegalArgumentException.class, () -> this.f.exibeFornecedor(""));
        assertThrows(IllegalArgumentException.class, () -> this.f.exibeFornecedor(null));
        assertThrows(IllegalArgumentException.class, () -> this.f.exibeFornecedor("Lucas"));
    }

    @Test
    void exibeTodosOsFornecedoresTest() {
        assertThrows(IllegalArgumentException.class, () -> this.f.exibeTodosOsFornecedores());

        f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678");
        assertEquals(f.exibeTodosOsFornecedores(), "lucas - lucas.lucena@ccc.ufcg.edu.br - 83 91234-5678");
        f.cadastraFornecedor("mateus", "mateus@ccc.ufcg.edu.br", "83 91234-1234");
        assertEquals(f.exibeTodosOsFornecedores(), "lucas - lucas.lucena@ccc.ufcg.edu.br - 83 91234-5678 | mateus - mateus@ccc.ufcg.edu.br - 83 91234-1234");
    }

    @Test
    void editaFornecedorTest() {
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor(null, "email", "lucas@ccc.ufcg.edu.br"));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("", "email", "lucas@ccc.ufcg.edu.br"));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", null, "lucas@ccc.ufcg.edu.br"));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "", "lucas@ccc.ufcg.edu.br"));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "email", null));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "email", ""));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "email", "lucas@ccc.ufcg.edu.br"));

        f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678");
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor(null, "email", "Lucas"));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("", "email", "Lucas"));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", null, "Lucas"));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "", "Lucas"));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "nome", "Lucas"));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "localizacao", "Lucas"));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "email", null));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "email", ""));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "telefone", null));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "telefone", ""));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "email", null));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("lucas", "email", ""));
        assertThrows(IllegalArgumentException.class, () -> this.f.editaFornecedor("Lucas", "email", "Lucas"));

        assertEquals(f.exibeFornecedor("lucas"), "lucas - lucas.lucena@ccc.ufcg.edu.br - 83 91234-5678");
        f.editaFornecedor("lucas", "email", "lucas@ccc.ufcg.edu.br");
        assertNotEquals(f.exibeFornecedor("lucas"), "lucas - lucas.lucena@ccc.ufcg.edu.br - 83 91234-5678");
        assertEquals(f.exibeFornecedor("lucas"), "lucas - lucas@ccc.ufcg.edu.br - 83 91234-5678");

        f.editaFornecedor("lucas", "telefone", "83 91234-4567");
        assertNotEquals(f.exibeFornecedor("lucas"), "lucas - lucas@ccc.ufcg.edu.br - 83 91234-5678");
        assertEquals(f.exibeFornecedor("lucas"), "lucas - lucas@ccc.ufcg.edu.br - 83 91234-4567");
    }

    @Test
    void removerFornecedorTest() {
        assertThrows(IllegalArgumentException.class, () -> this.f.removerFornecedor("lucas"));

        f.cadastraFornecedor("lucas", "lucas.lucena@ccc.ufcg.edu.br", "83 91234-5678");

        assertEquals(f.exibeFornecedor("lucas"), "lucas - lucas.lucena@ccc.ufcg.edu.br - 83 91234-5678");
        assertThrows(IllegalArgumentException.class, () -> this.f.removerFornecedor(null));
        assertThrows(IllegalArgumentException.class, () -> this.f.removerFornecedor(""));
        assertThrows(IllegalArgumentException.class, () -> this.f.removerFornecedor("Lucas"));

        f.removerFornecedor("lucas");
        assertThrows(IllegalArgumentException.class, () -> this.f.exibeFornecedor("lucas"));
        assertThrows(IllegalArgumentException.class, () -> this.f.removerFornecedor("lucas"));
    }

    @Test
    void cadastraProdutoTest() {
    }

    @Test
    void exibeProdutoTest() {
    }

    @Test
    void exibeProdutosDoFornecedorTest() {
    }

    @Test
    void exibeTodosOsProdutosTest() {
    }

    @Test
    void editaProdutoTest() {
    }

    @Test
    void removeProdutoTest() {
    }
}