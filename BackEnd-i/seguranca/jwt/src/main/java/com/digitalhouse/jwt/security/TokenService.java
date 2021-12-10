package com.digitalhouse.jwt.security;

import com.digitalhouse.jwt.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${api.jwt.secret}")
    private String expiration;

    @Value("${api.jwt.expiration}")
    private String secret;


    public String generateToken(Authentication authenticate) {

        Usuario usuario = (Usuario) authenticate.getPrincipal();
        Date date = new Date();
        Date expirationDate = new Date( date.getTime());

        return Jwts.builder()
                .setIssuer("Api teste JWT")
                .setSubject(usuario.getId().toString())
                .setIssuedAt(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try{
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
            return true;
        } catch (Exception exception){
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
return Long.parseLong(claims.getSubject());
    }
}
