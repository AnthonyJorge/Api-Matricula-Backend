package com.moviles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviles.entity.Usuario;
import com.moviles.interfaces.usuarioRepository;

@Service
public class UsuarioServicelmp implements UsuarioService{

	@Autowired
	private usuarioRepository rpy;
	
	@Override
	public Usuario agregarUsuario(Usuario usu) {
		return rpy.save(usu); 
	}

	@Override
	public Usuario actualizarUsuario(Usuario usu) {
		return rpy.save(usu); 
	}

	@Override
	public void eliminarUsuario(int idUsuario) {
		rpy.deleteById(idUsuario);
	}

	@Override
	public List<Usuario> listarTodos() {
		return rpy.findAll();
	}

}
