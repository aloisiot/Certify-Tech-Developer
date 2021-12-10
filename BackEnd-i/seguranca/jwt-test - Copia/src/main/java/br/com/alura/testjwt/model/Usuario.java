package br.com.alura.testjwt.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
//implements UserDetails para falarmos para o Spring Security que essa é a classe que representa um usuario no sistema
//Assim, dizemos para o spring que essa é a classe que tem detalhes de um usuario
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String senha;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	//pro Spring Security, alem de ele ter que ter um cara que representa o usuario, ele tem que tem um
	//cara que representa o perfil, para ter o perfil que esta relacionado com as permissões de acesso dele
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}

	//para o spring saber a senha do usuario ele vai chamar esse metodo
	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	//esses metodos que nos devolvem boolean servem para caso vc faça controle da conta do usuario,
	//no nosso caso não teremos esse controle mais fino, mais detalhado

	//a conta não esta expirada? sim
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//a conta não esta bloqueada? sim
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//a conta credencial dele não esta expirada? sim
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//a conta esta habilitada? sim
	@Override
	public boolean isEnabled() {
		return true;
	}

}
