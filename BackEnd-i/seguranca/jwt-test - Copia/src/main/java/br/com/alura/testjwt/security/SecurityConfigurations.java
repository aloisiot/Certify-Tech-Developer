package br.com.alura.testjwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.alura.testjwt.repository.UsuarioRepository;

//aqui estarão todas as classes de segurança do nosso projeto

@EnableWebSecurity //para habilitar o modulo de segurança na nossa aplicação
@Configuration //quando iniciarmos o projeto o spring vai carregar e ler as configurações dessa classe

//precisamos herdar a classe WebSecurityConfigurerAdapter que tem alguns metodos de configuração
// que vamos sobreescrever para fazer nossas configuracoes
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Bean//porque aí o Spring sabe que esse método devolve o authenticationManager e conseguimos injetar no nosso controller
	@Override
	//a classe q extendemos tem o metodo que sabe criar o AuthenticationManager
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	//Configuracoes de autenticacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//userDetailsService para mostrar pro spring qual é a service que tem a logica de autenticacao
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	//Configuracoes de autorizacao
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/auth").permitAll()
		.anyRequest().authenticated()
				//csrf é uma abreviação para cross-site request forgery, que é um tipo de ataque hacker que acontece em aplicações web.
				//Como vamos fazer autenticação via token, nossa api estará livre desse tipo de ataque. Entao desabilitamos esse cara
				//pro Spring Security não fazer a validação do token do csrf
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//não é para criar session quando fizermos autenticacao
		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
	}

	
}
