package model;

import main.model.Produto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProdutoTest {

    @Test
    public void testValorTotal() {
        Produto produto = new Produto(1L, "Teste", 10.0, 3);
        assertEquals(30.0, produto.valorTotal(), 0.001);
    }

    @Test
    public void testGetTotal() {
        Produto produto = new Produto(1L, "Teste", 10.0, 3);
        assertEquals(30.0, produto.getTotal(), 0.001);
    }
}