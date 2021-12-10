package com.digitalhouse.jwt.controller;

import com.digitalhouse.jwt.request.LoginForm;
import com.digitalhouse.jwt.response.TokenResponse;
import com.digitalhouse.jwt.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenResponse> autenticar(@RequestBody LoginForm form){
        UsernamePasswordAuthenticationToken dadosLogin = form.convert();

        try{
            Authentication authenticate = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.generateToken(authenticate);
            return ResponseEntity.ok(new TokenResponse(token, "Bearer"));
        }catch (AuthenticationException exception){
            return ResponseEntity.badRequest().build();
        }

    }
}
