package main.util;

import main.service.McSinos;

import java.util.Scanner;

public class Menu {
    private static McSinos mcSinos = new McSinos();
    public static void imprimeOpcoes() {

        System.out.println("1 - Mostrar a fila de pedidos");
        System.out.println("2 - Solicitar o pedido");
        System.out.println("3 - Entregar o pedido");
        System.out.println("4 - Sair do app");
        System.out.print("Digite uma opção: ");
    }

    public static void selecionaOpcao(int opcao, Scanner sc) {
        switch (opcao) {
            case 1:
                mcSinos.imprimePedidos();
                break;
            case 2:
                System.out.println("-----Catálogo de produtos-----");

                mcSinos.getCatalogo().imprimeCatalago();

                System.out.print("Quantos produtos deseja adicionar ao pedido? ");
                int n = sc.nextInt();

                mcSinos.novoPedido(sc, n);
                break;
            case 3:
                try {
                    mcSinos.getPedido();
                } catch (NullPointerException e) {
                    System.out.println("Não há pedidos.");
                }
                break;
            case 4:
                System.out.println("Saindo do app");
                break;
            default:
                System.out.println("Opção inválida");
        }
    }
}
