package com.moviles.services;



import java.util.List;

import com.moviles.entity.Usuario;



public interface UsuarioService {
	public abstract Usuario agregarUsario(Usuario usuario);

	
	public abstract void eliminarUsuario(int idUsuario);

	
	public abstract Usuario actualizarUsuario(Usuario usuario);
	
	
	public abstract List<Usuario> listarTodos();
}
