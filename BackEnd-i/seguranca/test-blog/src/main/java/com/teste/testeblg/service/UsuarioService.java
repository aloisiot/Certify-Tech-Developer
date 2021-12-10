package com.teste.testeblg.service;

import com.teste.testeblg.model.Usuario;
import com.teste.testeblg.model.UsuarioLogin;
import com.teste.testeblg.repository.UsuarioRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaEncoted = encoder.encode(usuario.getSenha());
        usuario.setSenha(senhaEncoted);
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioLogin> logar(Optional<UsuarioLogin> user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<Usuario> usuario = usuarioRepository.findByUsuario(user.get().getUsuario());

        if(usuario.isPresent()){
            if(encoder.matches(usuario.get().getUsuario(), usuario.get().getUsuario())){
                String auth = user.get().getUsuario() + ":" + user.get().getSenha();
                byte[] authEncoded = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic" + new String(authEncoded);
                user.get().setToken(authHeader);
                user.get().setNome(usuario.get().getNome());
                return user;
            }
        }
        return null;
    }
}
