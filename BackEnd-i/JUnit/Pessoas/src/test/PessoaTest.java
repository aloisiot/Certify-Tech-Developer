package test;

import model.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaTest {
    Pessoa p;
    Pessoa p1;

    @BeforeEach
    void antesDeCada(){
        p = new Pessoa(19, "Marcia", "Soares");
        p1 = new Pessoa(15, "Clara", "Soares");
    }

    @Test
    public void testeNomeCompleto(){
        assertEquals("Marcia Soares", p.getNomeCOmpleto());
        assertEquals("Clara Soares", p1.getNomeCOmpleto());
    }

    @Test
    public void testeEAdulto(){
        assertTrue(p.eAdulto());
        assertFalse(p1.eAdulto());
    }
}
