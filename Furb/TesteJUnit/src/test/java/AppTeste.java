import L04_ListaDuplamenteEncadeada.ListaDupla;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTeste {

    @Test
    void testarCaso01 () {
        ListaDupla<Integer> lista = new ListaDupla<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        Assertions.assertEquals(20, lista.buscar(5).getInfo(), "Era esperado 20!");
    }

//    System.out.println(lista.buscar(20).getInfo());

//    @Test
//    void testAddition() {
//        int expected = 5;
//        int actual = 2 + 3;
//        Assertions.assertEquals(expected, actual, "Addition of 2 and 3 should be 5");
//    }
//
//    @Test
//    void testStringConcatenation() {
//        String expected = "HelloWorld";
//        String actual = "Hello" + "World";
//        Assertions.assertEquals(expected, actual, "Strings should concatenate correctly");
//    }
}