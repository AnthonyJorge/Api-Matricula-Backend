package com.moviles.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviles.interfaces.usuarioRepository;
import com.moviles.entity.Usuario;



@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private usuarioRepository repository;
	

	@Override
	public Usuario buscaPorLogin(String login) {
		return repository.findByLogin(login);
	}


	@Override
	public Usuario agregarUsario(Usuario usuario) {
		return repository.save(usuario);
	}


	@Override
	public List<Usuario> listarTodos() {
		return repository.findAll();
	}
	
	@Override
	public Usuario actualizarUsuario(Usuario Usuario) {
		return repository.save(Usuario);
	}
	

	@Override
	public void eliminarUsuario(int idUsuario) {
		repository.deleteById(idUsuario);
	}

}
