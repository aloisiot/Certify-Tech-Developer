import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    void testarMetodoSomar(){
        Calculadora calculadora = new Calculadora();
        int result = calculadora.somar(2,6);

        Assertions.assertEquals(8, result);
    }
}
