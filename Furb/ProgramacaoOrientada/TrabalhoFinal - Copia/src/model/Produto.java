package model;

import java.util.Objects;

/**
 * Representa um item do estoque.
 */
public class Produto {

    private String codigo;
    private String nome;
    private double precoUnitario;
    private int quantidadeEstoque;
    private CategoriaProduto categoria;

    public Produto(String codigo, String nome, double precoUnitario, int quantidadeEstoque, CategoriaProduto categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
    }

    /**
     * Adiciona ou remove uma quantidade do estoque do produto.
     *
     * @param qtd A quantidade a ser adicionada (pode ser negativa para remoção).
     */
    public void adicionarEstoque(int qtd) {
        this.quantidadeEstoque += qtd;
    }

    /**
     * Remove uma quantidade do estoque do produto.
     *
     * @param qtd A quantidade a ser removida.
     */
    public void removerEstoque(int qtd) {
        if (qtd > 0 && this.quantidadeEstoque >= qtd) {
            this.quantidadeEstoque -= qtd;
        }
    }

    /**
     * Calcula o valor total do produto em estoque.
     *
     * @return O valor total (preço unitário * quantidade em estoque).
     */
    public double getValorTotal() {
        return this.precoUnitario * this.quantidadeEstoque;
    }

    // Getters and Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return nome + " (" + codigo + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(codigo, produto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
