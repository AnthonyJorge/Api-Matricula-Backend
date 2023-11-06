package com.moviles.services;

import java.util.List;

import com.moviles.entity.Alumno;

public interface alumnoService {
	
	public abstract Alumno agregarAlumno(Alumno alumno);
	
	public abstract Alumno actualizarAlumno(Alumno alumno);
	
	public abstract List<Alumno> listarAlumnoPorNombre(String nombre);
	
	public abstract void eliminarAlumno(int idAlumno);
	
	public abstract List<Alumno> listarTodos();

}
