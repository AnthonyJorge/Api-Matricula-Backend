package com.moviles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviles.interfaces.alumnoRepository;
import com.moviles.entity.Alumno;

@Service
public class alumnoServicelmp implements alumnoService{

	@Autowired
	private alumnoRepository rpy;
	@Override
	public Alumno agregarAlumno(Alumno alumno) {
		return rpy.save(alumno);
	}

	@Override
	public Alumno actualizarAlumno(Alumno alumno) {
		return rpy.save(alumno);
	}


	@Override
	public void eliminarAlumno(int idAlumno) {
		rpy.deleteById(idAlumno);
	}

	@Override
	public List<Alumno> listarTodos() {
		return rpy.findAll();
	}
	

}
