package school.sptech.projeto1.heranca;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class CarrinhoTest {

    private Carrinho carrinho;
    
    private final List<Produto> produtos = List.of(
        new Produto(1, "Pão Françês 1kg", "Padaria", 5.00),
        new Produto(2, "Queijo Mussarela 1kg", "Frios", 10.90),
        new Produto(3, "Requeijão Cremoso", "Frios", 8.90),
        new Produto(4, "Caneca", "Cozinha", 35.50),
        new Produto(5, "Faca Tramontina", "Cozinha", 98.90),
        new Produto(6, "O Poder do Hábito", "Livraria", 30.00),
        new Produto(7, "Cronicas de Gelo e Fogo", "Livraria", 90.00),
        new ProdutoInternacional(8, "Cartão de Memória", "Eletronicos", 50.00),
        new ProdutoInternacional(9, "Pendrive", "Eletronicos", 30.90),
        new ProdutoInternacional(10, "Controle Dualshock", "Videogame", 359.00),
        new ProdutoInternacional(11, "Playstation 5", "Videogame", 4_999.00)
    );
    
    @BeforeEach
    void iniciar() {
        this.carrinho = new Carrinho();
        for (Produto produto : produtos) {
            carrinho.adicionarProduto(produto);
        }
    }
    
    @Test
    @DisplayName("adicionarProduto(): dado um valor válido deve adicionar o produto no carrinho")
    void dadoUmValorValidoMetodoAdicionarProdutoDeveAdicionarOProdutoNoCarrinho() {
        Produto novo = new Produto(100, "Lápis", "Papelaria", 1_000.00);
        
        carrinho.adicionarProduto(novo);
        
        assertEquals(produtos.size() + 1, carrinho.getProdutos().size());
        assertTrue(carrinho.getProdutos().contains(novo));
    }
    
    @Test
    @DisplayName("adicionarProduto(): dado um valor inválido não deve adicionar o produto no carrinho")
    void dadoUmValorInvalidoMetodoAdicionarProdutoNaoDeveAdicionarOProdutoNoCarrinho() {
        Produto novo = null;
        
        carrinho.adicionarProduto(novo);
        
        assertEquals(produtos.size(), carrinho.getProdutos().size());
    }
    
    @Test
    @DisplayName("removerProduto(): dado um valor válido deve remover o produto da lista")
    void aoPassarUmValorValidoMetodoRemoverProdutoDeveRemoverOProdutoDaLista() {
        Produto produto = produtos.get(2);
        
        carrinho.removerProduto(2);
        
        assertEquals(produtos.size() - 1, carrinho.getProdutos().size());
        assertFalse(carrinho.getProdutos().contains(produto));
    }
    
    @Test
    @DisplayName("removerProduto(): dado um valor inválido não deve lançar um erro")
    void aoPassarUmValorInvalidoMetodoRemoverProdutoNaoDeveLancarUmErro() {
        assertDoesNotThrow(() -> carrinho.removerProduto(8282));
        assertDoesNotThrow(() -> carrinho.removerProduto(-2));
    }

    @Test
    @DisplayName("calcularTotal(): deve calcular o valor de todos os itens do carrinho")
    void aoAdicionarProdutosMetodoCalcularTotalDeveCalcularOValorDosItensDoCarrinho() {
        Carrinho carrinhoSoma = new Carrinho();
        carrinhoSoma.adicionarProduto(new Produto(1, "Pão Françês 1kg", "Padaria", 5.00));
        carrinhoSoma.adicionarProduto(new Produto(2, "Caneca", "Cozinha", 35.50));
        carrinhoSoma.adicionarProduto(new ProdutoInternacional(3, "Playstation 2", "videogame", 1000.00));
        carrinhoSoma.adicionarProduto(new ProdutoInternacional(4, "Cartão de Memória", "Eletronicos", 50.00));

        assertEquals(1720.5, carrinhoSoma.calcularTotal(), 1);
    }

    @Test
    @DisplayName("parcelarCompra(): deve calcular o valor de cada parcela dependendo da quantidade selecionada")
    void aoAdicionarProdutosMetodoParcelarProdutoDeveCalcularOValorDosItensParceladoEmTresVezes() {
        Carrinho carrinhoSoma = new Carrinho();
        carrinhoSoma.adicionarProduto(new Produto(1, "Pão Françês 1kg", "Padaria", 5.00));
        carrinhoSoma.adicionarProduto(new Produto(2, "Caneca", "Cozinha", 35.50));
        carrinhoSoma.adicionarProduto(new ProdutoInternacional(3, "Playstation 2", "videogame", 1000.00));
        carrinhoSoma.adicionarProduto(new ProdutoInternacional(4, "Cartão de Memória", "Eletronicos", 50.00));

        assertEquals(573.5, carrinhoSoma.parcelarCompra(3), 1);
    }
    
    @Test
    @DisplayName("findProdutoPeloIndice(): quando índice válido deve retornar o produto encontrado")
    void quandoIndiceValidoMetodoFindProdutoPeloIndiceDeveRetornarOProdutoEncontrado() {
        Produto procurado = produtos.get(1);
        Produto encontrado = carrinho.findProdutoPeloIndice(1);
        
        assertEquals(procurado, encontrado);
    }
    
    @Test
    @DisplayName("findProdutoPeloIndice(): quando índice inválido deve retornar null")
    void quandoIndiceInvalidoMetodoFindProdutoPeloIndiceDeveRetornarNull() {
        Produto encontrado = carrinho.findProdutoPeloIndice(90);
        
        assertNull(encontrado);
    }
    
    @Test
    @DisplayName("findProdutoPeloNome(): quando nome válido deve retornar o produto encontrado")
    void quandoNomeValidoMetodoFindProdutoPeloNomeDeveRetornarOProdutoEncontrado() {
        Produto procurado = produtos.get(3);
        Produto encontrado = carrinho.findProdutoPeloNome("Caneca");
        
        assertEquals(procurado, encontrado);
    }
    
    @Test
    @DisplayName("findProdutoPeloNome(): quando nome válido caixa baixa deve retornar o produto encontrado")
    void quandoNomeValidoCaixaBaixaMetodoFindProdutoPeloNomeDeveRetornarOProdutoEncontrado() {
        Produto procurado = produtos.get(3);
        Produto encontrado = carrinho.findProdutoPeloNome("caneca");
        
        assertEquals(procurado, encontrado);
    }
    
    @Test
    @DisplayName("findProdutoPeloNome(): quando nome inválido deve retornar null")
    void quandoNomeInvalidoMetodoFindProdutoPeloNomeDeveRetornarNull() {
        Produto encontrado = carrinho.findProdutoPeloNome("Computador");
        
        assertNull(encontrado);
    }
    
    @Test
    @DisplayName("findProdutoPorCategoria(): quando categoria válida deve retornar todos os produtos encontrados")
    void quandoCategoriaValidaMetodoFindProdutoPorCategoriaDeveRetornarOsProdutosEncontrados() {
        List<Produto> procurados = List.of(produtos.get(9), produtos.get(10));
        List<Produto> encontrados = carrinho.findProdutoPorCategoria("Videogame");
        
        assertEquals(procurados, encontrados);
    }
    
    @Test
    @DisplayName("findProdutoPorCategoria(): quando categoria válida e em caixa alta deve retornar todos os produtos encontrados")
    void quandoCategoriaValidaECaixaAltaMetodoFindProdutoPorCategoriaDeveRetornarOsProdutosEncontrados() {
        List<Produto> procurados = List.of(produtos.get(9), produtos.get(10));
        List<Produto> encontrados = carrinho.findProdutoPorCategoria("VIDEOGAME");
        
        assertEquals(procurados, encontrados);
    }
    
    @Test
    @DisplayName("findProdutoPorCategoria(): quando categoria inválida deve retornar uma lista vazia")
    void quandoCategoriaInvalidaMetodoFindProdutoPorCategoriaDeveRetornarUmaListaVazia() {
        List<Produto> encontrados = carrinho.findProdutoPorCategoria("Limpeza");
        
        assertTrue(encontrados.isEmpty());
    }
    
    @Test
    @DisplayName("countProdutosInternacionais(): deve retornar a quantidade de produtos internacionais no carrinho - Cenário 1")
    void quando4ProdutosInternacionaisAdicionadosMetodoCountProdutosInternacionaisDeveRetornar4() {
        Integer quantidade = carrinho.countProdutosInternacionais();
        
        assertEquals(4, quantidade);
    }
    
    @Test
    @DisplayName("countProdutosInternacionais(): deve retornar a quantidade de produtos internacionais no carrinho - Cenário 2")
    void quandoProdutosInternacionaisNaoAdicionadosMetodoCountProdutosInternacionaisDeveRetornar0() {
        Carrinho carrinhoSemInternacional = new Carrinho();
        carrinhoSemInternacional.adicionarProduto(new Produto(1, "Pão Françês 1kg", "Padaria", 5.00));
        carrinhoSemInternacional.adicionarProduto(new Produto(2, "Caneca", "Cozinha", 35.50));
        carrinhoSemInternacional.adicionarProduto(new Produto(3, "Playstation 2", "videogame", 1000.00));
        carrinhoSemInternacional.adicionarProduto(new Produto(4, "Cartão de Memória", "Eletronicos", 50.00));
        
        Integer quantidade = carrinhoSemInternacional.countProdutosInternacionais();
        
        assertEquals(0, quantidade);
    }
}
