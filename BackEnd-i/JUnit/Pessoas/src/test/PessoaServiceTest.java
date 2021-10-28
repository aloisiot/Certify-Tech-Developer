package test;

import model.Pessoa;
import org.junit.jupiter.api.Test;
import service.PessoaService;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaServiceTest {

    Pessoa p = new Pessoa(19, "Marcia", "Soares");
    Pessoa p1 = new Pessoa(15, "Clara", "Soares");
    Pessoa p2 = new Pessoa(35, "Marcia", "Lagos");
    Pessoa p3 = new Pessoa(12, "Mario", "Melgaço");

    @Test
    public void testAddPessoa(){
        PessoaService pessoaService = new PessoaService();
        pessoaService.addPessoa(p);
        pessoaService.addPessoa(p1);
        pessoaService.addPessoa(p2);
        pessoaService.addPessoa(p3);

        assertEquals(2, pessoaService.numPessoas());
    }
}
