package com.moviles.services;

import java.util.List;

import com.moviles.entity.Usuario;

public interface UsuarioService {

public abstract Usuario agregarUsuario(Usuario usu);
	
	public abstract Usuario actualizarUsuario(Usuario usu );
	
	
	public abstract void eliminarUsuario(int idUsuario);
	
	public abstract List<Usuario> listarTodos();
}
