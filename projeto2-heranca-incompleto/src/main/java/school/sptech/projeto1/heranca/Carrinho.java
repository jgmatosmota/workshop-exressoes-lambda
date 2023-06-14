package school.sptech.projeto1.heranca;

import java.util.*;
import java.util.stream.Stream;

public class Carrinho {
    
    List<Produto> produtos;

    public Carrinho() {
        this.produtos = new ArrayList<>();
    }
    
    /**
     * Adiciona um Produto novo no carrinho.
     * Caso o valor seja null o Produto não deve ser adicionado
     * 
     * Parâmetro produto: Novo Produto a ser adicionado
     */
    public void adicionarProduto(Produto produto) {
        if(produto != null){
            produtos.add(produto);
        }else{
            System.out.println("nao pode null");
        }
    }

    /**
     * Remove um Produto do carrinho pelo índice.
     * Caso o índice do produto for inválido o método não deve lançar
     * um erro de execução
     *
     * Parâmetro indice: Índice do Produto que será removido
     */
    public void removerProduto(int indice) {
        if (indice >= 0 && indice < produtos.size()) {
        produtos.remove(indice);
    } else {
        System.out.println("Índice inválido");
    }
    }
    
    /**
     * Calcula o valor total de todos os itens do carrinho.
     * 
     * Retorna valor total do carrinho
     */
    public Double calcularTotal() {
        return produtos.stream().mapToDouble(p -> p.getPreco()).sum();
    }
    
    /**
     * Calcula o valor das parcelas de acordo com o número de vezes que
     * o usuário deseja parcelar.
     * 
     * Parâmetro vezes: Número de vezes que o usuário deseja parcelar
     * Retorna total do carrinho parcelado
     */
    public Double parcelarCompra(Integer vezes) {
        return calcularTotal() / vezes;
    }
    
    /**
     * Encontra um Produto com o índice desejado.
     * Caso o índice não seja encontrado retorne null
     * 
     * Parâmetro index: Índice do Produto
     * Retorna Produto encontrado
     */
    public Produto findProdutoPeloIndice(Integer index) {
        return Stream.ofNullable(produtos).filter(p -> index >= 0 && index <= p.size()).map(p -> p.get(index)).findFirst().orElse(null);
    }
    
    /**
     * Encontra um Produto com o nome desejado ignorando letras 
     * maiúsculas e minúsculas.
     * 
     * Caso um Produto não seja encontrado retorne null
     * 
     * Parâmetro nome: Nome do Produto
     * Retorna Produto encontrado
     */
    public Produto findProdutoPeloNome(String nome) {
        return produtos.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
    }
    
    /**
     * Encontra todos os Produto de uma determinada categoria
     * ignorando letras maiúsculas e minúsculas.
     * 
     * Caso não encontre nenhum Produto devolva uma lista vazia
     * 
     * Parâmetro categoria: Categoria desejada
     * Return Produtos encontrados
     */
    public List<Produto> findProdutoPorCategoria(String categoria) {
        return produtos.stream().filter(p -> p.getCategoria().equalsIgnoreCase(categoria)).toList();
    }
    
    /**
     * Encontra todos os ProdutoInternacional presentes no Carrinho.
     * Caso não encontre nenhum ProdutoInternacional devolva uma lista vazia
     * 
     * Retorna Produtos internacionais encontrados
     */
    public Integer countProdutosInternacionais() {
        return produtos.stream().filter(p -> p instanceof ProdutoInternacional).toList().size();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
