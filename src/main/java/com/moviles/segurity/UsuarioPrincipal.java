package com.moviles.segurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.moviles.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.apachecommons.CommonsLog;

@Getter
@Setter
@AllArgsConstructor
@CommonsLog
@ToString
public class UsuarioPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	private int idUsuario;
	private String login;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public static UsuarioPrincipal build(Usuario usuario) {
		log.info(">>>UsuarioPrincipal >> " + usuario );
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		return new UsuarioPrincipal(usuario.getIdUsuario(),usuario.getLogin(), usuario.getPassword(), authorities);	}
		

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	public int getIdUsuario() {
		return idUsuario;
	}



}