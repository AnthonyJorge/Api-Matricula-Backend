package com.moviles.services;

import java.util.List;

import com.moviles.entity.Docente;

public interface docenteService {
	
	public abstract Docente agregarDocente(Docente docente);

	public abstract Docente actualizarDocentes(Docente docente);
	
	
	public abstract void eliminarDocente(int idDocente);
	
	public abstract List<Docente> listarTodos();
}
