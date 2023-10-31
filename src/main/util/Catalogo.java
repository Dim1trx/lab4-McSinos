package main.util;

import main.model.Produto;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Produto> produtos = new ArrayList<>();

    public Catalogo() {
        produtos.add(new Produto(1L, "Hamburguer", 4.99, 0));
        produtos.add(new Produto(2L, "Batata Frita", 2.99, 0));
        produtos.add(new Produto(3L, "Refrigerante", 1.99, 0));
        produtos.add(new Produto(4L, "Chicken McNuggets", 3.49, 0));
        produtos.add(new Produto(5L, "Hot Dog", 2.49, 0));
        produtos.add(new Produto(6L, "Pizza Slice", 2.99, 0));
        produtos.add(new Produto(7L, "Taco", 1.99, 0));
        produtos.add(new Produto(8L, "Sundae", 1.49, 0));
        produtos.add(new Produto(9L, "Milkshake", 3.99, 0));
        produtos.add(new Produto(10L, "Onion Rings", 2.99, 0));
    }

    public List<Produto> getCatalogo() {
        return produtos;
    }

    public void imprimeCatalago() {
        for (Produto produto : produtos) {
            System.out.printf("Id: %d, %s, R$%.2f %n",
                    produto.getId(), produto.getNome(), produto.getPreco());
        }
        System.out.println();
    }

    public Produto getProduto(Long id, int num) {
        Produto produto = findById(id);
        if (produto != null) {
            produto.setQuantidade(num);
            return produto;
        }else throw new InvalidParameterException("Produto não encontrado");
    }

    private Produto findById(Long id) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                return produto;
            }
        }
        return null;
    }

}
