package com.moviles.services;

import java.util.List;

import com.moviles.entity.Matricula;

public interface matriculaService {
	
	public abstract Matricula agregarMatricula(Matricula matricula);
	
	public abstract Matricula actualizarMatricula(Matricula matricula);
	
	public abstract void eliminarMatricula(int idMatricula);
	
	public abstract List<Matricula> listarTodo();
	


}
