package test.util;

import main.model.Produto;
import main.util.Catalogo;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CatalogoTest {

    private Catalogo catalogo;

    @Before
    public void setUp() {
        catalogo = new Catalogo();
    }

    @Test
    public void testGetCatalogo() {
        assertNotNull(catalogo.getCatalogo());
        assertEquals(10, catalogo.getCatalogo().size());
    }

    @Test
    public void testGetProduto() {
        Produto produto = catalogo.getProduto(1L, 2);
        assertNotNull(produto);
        assertEquals(2, produto.getQuantidade().intValue());

        try {
            catalogo.getProduto(100L, 1);
        } catch (Exception e) {
            assertEquals(InvalidParameterException.class, e.getClass());
        }
    }


}
