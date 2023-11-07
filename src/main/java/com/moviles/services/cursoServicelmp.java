package com.moviles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviles.interfaces.cursoRepository;
import com.moviles.entity.Curso;

@Service
public class cursoServicelmp implements cursoService{
	@Autowired
	private  cursoRepository rpy;
	
	@Override
	public Curso agregarCurso(Curso curso) {
		return rpy.save(curso);
	}


	@Override
	public void eliminarDocente(int idCurso) {
		rpy.deleteById(idCurso);
	}

	@Override
	public Curso actualizarCurso(Curso curso) {
		return rpy.save(curso);
	}

	@Override
	public List<Curso> listarTodos() {
		return rpy.findAll();
	}
}
