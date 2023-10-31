package main.service;

import main.model.Pedido;
import main.model.Produto;
import main.util.Catalogo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
public class McSinos {
    private AtomicLong counter = new AtomicLong(0);
    private Catalogo catalogo = new Catalogo();
    private Queue<Pedido> pedidos = new LinkedList<>();

    public McSinos() {}

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public Queue<Pedido> getPedidos() {
        return pedidos;
    }
    public void novoPedido(Scanner sc, int n) {
        Pedido pedido = new Pedido(counter.incrementAndGet());
        List<Produto> produtos = pedido.getProdutos();

        for (int i = 0; i < n; i++) {
            System.out.print("Informe o ID do produto numero " + (i + 1) + ": ");
            Long id = sc.nextLong();

            System.out.print("Qual será a quantidade desse produto? ");
            int quantidade = sc.nextInt();

            Produto produto = catalogo.getProduto(id, quantidade);

            produtos.add(produto);

            System.out.println("Produtos adicionado ao pedido.\n");
        }
        pedidos.add(pedido);
        sc.nextLine();
    }


    public void imprimePedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos");
        } else {
            for (Pedido pedido : pedidos) {
                imprimePedido(pedido);
            }
        }
    }

    public void getPedido() {
        if (!pedidos.isEmpty()) {
            Pedido retirado =  pedidos.poll();

            System.out.print("Pedido retirado com sucesso: ");
            imprimePedido(retirado);
        }
        else throw new NullPointerException("Não há pedidos");
    }

    public void imprimePedido(Pedido pedido) {
        System.out.println("Pedido #" + pedido.getId() + " - " + pedido.getProdutos().size() + " produtos");
        for (Produto produto : pedido.getProdutos()) {
            pedido.imprimeProduto(produto);
        }
        System.out.printf("Total: R$%.2f %n", pedido.getTotal());
    }
}


