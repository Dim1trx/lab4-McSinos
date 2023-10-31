package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Pedido {
    private Long id;
    private List<Produto> produtos = new ArrayList<>();

    public Pedido(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pedido.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("produtos=" + produtos)
                .toString();
    }

    public double getTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getTotal();
        }
        return total;
    }

    public void imprimeProduto(Produto produto) {
        System.out.printf("%d - %s - quant.: %d - R$%.2f\n",
                produto.getId(), produto.getNome(), produto.getQuantidade(), produto.getTotal());
    }
}
