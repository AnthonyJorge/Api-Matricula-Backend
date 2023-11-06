package com.moviles.services;

import java.util.List;

import com.moviles.entity.Curso;

public interface cursoService {
	
	public abstract Curso agregarCurso(Curso curso);

	public abstract Curso actualizarCurso(Curso curso);
		
	public abstract List<Curso> listaCursoPorNombre(String nombre);
	
	public abstract void eliminarDocente(int idCurso);

	public abstract List<Curso> listarTodos();

}
