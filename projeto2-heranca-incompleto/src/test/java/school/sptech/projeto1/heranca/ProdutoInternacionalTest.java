package school.sptech.projeto1.heranca;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

class ProdutoInternacionalTest {

    @Test
    @DisplayName("getPreco(): quando acionado deve retornar o valor do preço com imposto - Cenário 1")
    public void getPrecoQuandoAcionadoDeveRetornarOValorDoPreco() {
        ProdutoInternacional prdInternacional = new ProdutoInternacional(
                1, "Playstation 5", "videogame", 4_500.99
        );

        assertEquals(7_201.584, prdInternacional.getPreco(), 1.0);
    }

    @Test
    @DisplayName("getPreco(): quando acionado deve retornar o valor do preço com imposto - Cenário 2")
    void getPrecoQuandoAcionadoEProdutoPossuiValor0DeveRetornar0() {
        ProdutoInternacional prdInternacional = new ProdutoInternacional(
                1, "Playstation 5", "videogame", 0.0);
        Double precoCorretoComTaxa = 0.0;
        assertEquals(precoCorretoComTaxa, prdInternacional.getPreco());
    }

    @Test
    @DisplayName("getId(): quando acionado deve retornar o valor do id")
    public void getIdQuandoAcionadoDeveRetornarOValorDoId() {
        ProdutoInternacional prdInternacional = new ProdutoInternacional(
                1, "Playstation 5", "videogame", 4_999.99
        );

        assertEquals(1, prdInternacional.getId());
    }

    @Test
    @DisplayName("getNome(): quando acionado deve retornar o valor do nome")
    public void getNomeQuandoAcionadoDeveRetornarOValorDoNome() {
        ProdutoInternacional prdInternacional = new ProdutoInternacional(
                1, "Playstation 5", "videogame", 4_999.99
        );

        assertEquals("Playstation 5", prdInternacional.getNome());
    }

    @Test
    @DisplayName("getCategoria(): quando acionado o valor da categoria")
    public void getCategoriaQuandoAcionadoDeveRetornarOValorDaCategoria() {
        ProdutoInternacional prdInternacional = new ProdutoInternacional(
                1, "Playstation 5", "videogame", 4_999.99
        );

        assertEquals("videogame", prdInternacional.getCategoria());
    }
    
    @Test
    @DisplayName("clasee ProdutoInternacional deve ser herdeira da classe Produto")
    public void objetoProdutoInternacionalDeveSerHerdeiraDeProduto() {
        ProdutoInternacional prdInternacional = new ProdutoInternacional(
                1, "Playstation 5", "videogame", 4_500.99
        );

        assertInstanceOf(Produto.class, prdInternacional);
    }

    @Test
    @DisplayName("classe ProdutoInternacional deve conter apenas o getter sobrescrito")
    void produtoInternacionalDeveApenasConterGetterSobreescrito(){
        List<Method> methods = Arrays.asList(ProdutoInternacional.class.getDeclaredMethods());

        assertEquals(1, methods.size());
    }

    @Test
    @DisplayName("classe ProdutoInternacional deve conter apenas getters")
    void produtoInternacionalDeveConterApenasGetter(){
        List<Field> fields = Arrays.asList(ProdutoInternacional.class.getDeclaredFields());

        for (Field field : fields) {
            String getter = "get" + StringUtils.capitalize(field.getName());
            String setter = "set" + StringUtils.capitalize(field.getName());

            assertDoesNotThrow(() -> Produto.class.getDeclaredMethod(getter));
            assertThrows(NoSuchMethodException.class, () -> ProdutoInternacional.class.getDeclaredMethod(setter, field.getType()));
        }
    }
}
