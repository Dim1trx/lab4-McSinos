package main.model;

public class Produto {
    private Long id;
    private String nome;
    private Double preco;
    private Integer quantidade;

    public Produto(Long id, String nome, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double valorTotal() {
        return this.preco * this.quantidade;
    }

    @Override
    public String toString() {
        return String.format("Produto { id: %d, nome: %s, preco: %.2f, quantidade: %d }",
                this.id, this.nome, this.preco, this.quantidade);
    }

    public double getTotal() {
        return this.preco * this.quantidade;
    }
}
