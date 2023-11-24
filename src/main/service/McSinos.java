package main.service;

import main.model.Pedido;
import main.model.Produto;
import main.util.Catalogo;

import java.security.InvalidParameterException;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class McSinos {
    private AtomicLong counter = new AtomicLong(0);
    private Catalogo catalogo = new Catalogo();
    private Queue<Pedido> pedidos = new LinkedList<>();

    public McSinos() {
    }

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
            try {
                System.out.print("Informe o ID do produto numero " + (i + 1) + ": ");
                Long id = sc.nextLong();

                System.out.print("Qual será a quantidade desse produto? ");
                int quantidade = sc.nextInt();

                Produto produto = catalogo.getProduto(id, quantidade);

                produtos.add(produto);

                System.out.println("Produtos adicionados ao pedido.\n");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Certifique-se de inserir um ID válido e uma quantidade válida.");
                sc.nextLine();
                i--;
            } catch (NoSuchElementException e) {
                System.out.println("Entrada insuficiente. Certifique-se de fornecer todas as informações necessárias.");
                sc.nextLine();
                i--;
            } catch (InvalidParameterException e) {
                System.out.println("Produto não encontrado. Certifique-se de inserir um ID válido.");
                sc.nextLine();
                i--;
            }

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

    public Pedido getPedido() {
        if (!pedidos.isEmpty()) {
            Pedido retirado = pedidos.poll();
            System.out.print("Pedido retirado com sucesso:");
            imprimePedido(retirado);
            return retirado;
        }

        else {
            System.out.println("Não há pedidos.");
            return null;
        }
    }

    public void imprimePedido(Pedido pedido) {
        System.out.println("Pedido #" + pedido.getId() + " - " + pedido.getProdutos().size() + " produtos");
        for (Produto produto : pedido.getProdutos()) {
            pedido.imprimeProduto(produto);
        }
        System.out.printf("Total: R$%.2f %n", pedido.getTotal());
    }
}


