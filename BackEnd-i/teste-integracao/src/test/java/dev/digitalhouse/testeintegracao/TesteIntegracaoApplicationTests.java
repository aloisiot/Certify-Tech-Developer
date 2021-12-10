package dev.digitalhouse.testeintegracao;

import dev.digitalhouse.testeintegracao.model.Jogador;
import dev.digitalhouse.testeintegracao.model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TesteIntegracaoApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	 void testUsuarioService() {
		List<Usuario> usuarioList = testRestTemplate.getForObject("http://localhost:" + port + "/usuario", List.class);
		Assertions.assertNotNull(usuarioList);
		Assertions.assertEquals(2, usuarioList.size());
	}

	@Test
	void testJogadorService(){
		Jogador jogador = testRestTemplate.getForObject("http://localhost:" + port + "/jogador/Alan", Jogador.class);
		Assertions.assertNotNull(jogador);
		Assertions.assertEquals(jogador.getNome(), "Alan");
	}

}
