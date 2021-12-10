package br.com.alura.testjwt.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.alura.testjwt.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${api.jwt.expiration}")
	private String expiration;
	
	@Value("${api.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authentication) {
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder() //metodo para podermos setar as informações para criar o token
				.setIssuer("API de teste JWT")//setar a aplicação que fez a geração do token
				.setSubject(logado.getId().toString()) //quem é o usuario atenticado a quem pertence esse token
				.setIssuedAt(dataExpiracao)//data de validade/expiração
				.signWith(SignatureAlgorithm.HS256, secret)//pra selecionar o algoritmo de criptografia e a senha da nossa aplicação,
				//q é usada para fazer a assinatura. gerar o hash da criptografia do token
				.compact();//para compactar e transformar tudo isso em uma string
	}

	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}

}
