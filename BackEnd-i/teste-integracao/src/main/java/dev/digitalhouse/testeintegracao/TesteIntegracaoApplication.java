package dev.digitalhouse.testeintegracao;

import dev.digitalhouse.testeintegracao.model.Jogador;
import dev.digitalhouse.testeintegracao.model.Usuario;
import dev.digitalhouse.testeintegracao.repository.JogadorRepository;
import dev.digitalhouse.testeintegracao.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TesteIntegracaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteIntegracaoApplication.class, args);
	}

	@Bean
	public CommandLineRunner criaUsuario(UsuarioRepository usuarioRepository, JogadorRepository jogadorRepository){
		return (args -> {
			usuarioRepository.save(new Usuario("Adriano"));
			usuarioRepository.save(new Usuario("Marcos"));
			jogadorRepository.save(new Jogador("Alan", 18));
			jogadorRepository.save(new Jogador("Matheus", 19));
		});
	}
}
