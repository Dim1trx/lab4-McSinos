package service;

import main.model.Pedido;
import main.model.Produto;
import main.service.McSinos;
import main.util.Catalogo;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class McSinosTest {

    private McSinos mcSinos;
    private ByteArrayOutputStream outContent;

    @Before
    public void setUp() {
        mcSinos = new McSinos();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testNovoPedido() {

        mcSinos.novoPedido(new Scanner("1\n2\n"), 1);
        assertFalse(mcSinos.getPedidos().isEmpty());
        Pedido pedido = mcSinos.getPedidos().peek();
        assertNotNull(pedido);
        assertEquals(1, pedido.getProdutos().size());
    }
    @Test
    public void testImprimePedidos() {
        mcSinos.imprimePedidos();
        assertEquals("Não há pedidos"+ System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testGetPedido() {
        // Testa se não há pedidos
        mcSinos.getPedido();
        assertEquals("Não há pedidos."+ System.lineSeparator(), outContent.toString());

        // Testa se produto foi adicionado ao pedido
        mcSinos.novoPedido(new Scanner("1\n2\n"), 1);
        assertEquals("Não há pedidos.\nInforme o ID do produto numero 1: Qual será a quantidade desse produto? Produtos adicionados ao pedido." + System.lineSeparator(), outContent.toString());
        mcSinos.getPedido();

        // Testa se o pedido foi removido da fila
        assertTrue(mcSinos.getPedidos().isEmpty());
    }

    @Test
    public void testImprimePedido() {
        Pedido pedido = new Pedido(1L);
        Produto produto = new Produto(1L, "Hamburguer", 4.99, 2);
        pedido.getProdutos().add(produto);

        mcSinos.imprimePedido(pedido);
        assertTrue(outContent.toString().startsWith("Pedido #1 - 1 produtos"));
    }
}