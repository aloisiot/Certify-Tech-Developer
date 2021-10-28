package test;

import model.Circulo;
import model.Quadrado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FormasTest {

    Circulo c = new Circulo(56);
    Quadrado q = new Quadrado(32);

    @Test
    public void perimetroDoCirculo(){
        assertEquals(351, c.calcPerimetro());
    }

    @Test
    public void perimetroDoQuadrado(){
        assertEquals(128, q.calcPerimetro());
    }
}
