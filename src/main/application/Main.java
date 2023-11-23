package main.application;

import main.util.Menu;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            Menu.imprimeOpcoes();


            try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                opcao = 0;
            }
            sc.nextLine();

            Menu.selecionaOpcao(opcao, sc);
            System.out.println("--------");
            System.out.print("Pressione enter para continuar...");
            sc.nextLine();

        }
    }
}
