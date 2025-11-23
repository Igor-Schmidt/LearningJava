package service;

import model.Movimento;
import model.Produto;
import persistence.Persistencia;
import persistence.ProdutoPersistenciaCSV;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio relacionada ao estoque de produtos.
 */
public class ServicoEstoque {

    private List<Produto> produtos;
    private final Persistencia<Produto> persistencia;

    public ServicoEstoque() {
        this.persistencia = new ProdutoPersistenciaCSV();
        this.produtos = new ArrayList<>(persistencia.carregar());
    }

    /**
     * Cadastra um novo produto ou atualiza um existente.
     *
     * @param p O produto a ser cadastrado/atualizado.
     */
    public void cadastrarProduto(Produto p) {
        Optional<Produto> produtoExistente = produtos.stream()
                .filter(produto -> produto.getCodigo().equals(p.getCodigo()))
                .findFirst();

        if (produtoExistente.isPresent()) {
            Produto prod = produtoExistente.get();
            
            prod.setNome(p.getNome());
            prod.setPrecoUnitario(p.getPrecoUnitario());
            prod.setCategoria(p.getCategoria());
            
        } else {
            // Adiciona novo produto
            this.produtos.add(p);
        }
        this.persistencia.salvar(this.produtos);
    }

    /**
     * Busca um produto pelo seu código.
     *
     * @param codigo O código do produto.
     * @return Um {@link Optional} contendo o produto se encontrado, ou vazio caso contrário.
     */
    public Optional<Produto> buscarProduto(String codigo) {
        return this.produtos.stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst();
    }

    /**
     * Atualiza o estoque de um produto com base em um movimento.
     *
     * @param movimento O movimento que afeta o estoque.
     */
    public void atualizarEstoque(Movimento movimento) {
        buscarProduto(movimento.getProduto().getCodigo()).ifPresent(produto -> {
            
            produto.adicionarEstoque(movimento.calcularImpacto());
            persistencia.salvar(produtos);
            
        });
    }

    /**
     * Retorna a lista de todos os produtos cadastrados.
     *
     * @return A lista de produtos.
     */
    public List<Produto> getSaldoAtual() {
        return new ArrayList<>(this.produtos);
    }

    /**
     * Calcula o valor total de todos os produtos em estoque.
     *
     * @return O valor total do estoque.
     */
    public double getValorTotalEstoque() {
        return this.produtos.stream()
                .mapToDouble(Produto::getValorTotal)
                .sum();
    }
    
    /**
     * Exclui um produto do cadastro.
     * @param produto O produto a ser excluído.
     */
    public void excluirProduto(Produto produto) {
        this.produtos.remove(produto);
        this.persistencia.salvar(this.produtos);
    }
}
