package com.registro.usuarios.service.Impl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.registro.usuarios.entity.Rol;
import com.registro.usuarios.repository.UsuarioRepositorio;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
    UsuarioRepositorio repositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.registro.usuarios.entity.Usuario appUsuario = repositorio.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Login Usuario Invalido!"));
		
		Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();
		for (Rol roles: appUsuario.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roles.getDescripcion());
            grantList.add(grantedAuthority);
		}
		UserDetails usuario = (UserDetails)new User(username,appUsuario.getPassword(),grantList);
		
		return usuario;
	}

}
