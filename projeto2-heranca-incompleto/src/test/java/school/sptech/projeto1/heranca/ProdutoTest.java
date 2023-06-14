package school.sptech.projeto1.heranca;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

class ProdutoTest {

  @Test
  @DisplayName("getPreco(): quando acionado deve retornar o valor do preço do produto - Cenário 1")
  void getPrecoQuandoAcionadoEProdutoPossuiValor499999DeveRetornar499999() {
    Produto produto = new Produto(
        1, "Playstation 5", "videogame", 4_999.99);
    Double precoCorretoComTaxa = 4_999.99;
    assertEquals(precoCorretoComTaxa, produto.getPreco());
  }

  @Test
  @DisplayName("getPreco(): quando acionado deve retornar o valor do preço do produto - Cenário 2")
  void getPrecoQuandoAcionadoEProdutoPossuiValor0DeveRetornar0() {
    Produto produto = new Produto(
        1, "Playstation 5", "videogame", 4_999.99);
    Double precoCorretoComTaxa = 4_999.99;
    assertEquals(precoCorretoComTaxa, produto.getPreco());
  }

  @Test
  @DisplayName("classe Produto deve conter getters e setters para todos os atributos")
  void produtoGetterTest(){
    List<Field> fields = Arrays.asList(Produto.class.getDeclaredFields());

    for (Field field : fields) {
      String getter = "get" + StringUtils.capitalize(field.getName());
      String setter = "set" + StringUtils.capitalize(field.getName());

      assertDoesNotThrow(() -> Produto.class.getDeclaredMethod(getter));
      assertDoesNotThrow(() -> Produto.class.getDeclaredMethod(setter, field.getType()));
    }
  }
}