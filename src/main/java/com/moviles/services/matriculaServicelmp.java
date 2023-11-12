package com.moviles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviles.interfaces.matriculaRepository;
import com.moviles.entity.Matricula;

@Service
public class matriculaServicelmp implements matriculaService {

	@Autowired
	private matriculaRepository rpy;
	
	@Override
	public Matricula agregarMatricula(Matricula matricula) {
		return rpy.save(matricula);
	}

	@Override
	public Matricula actualizarMatricula(Matricula matricula) {
		return rpy.save(matricula);
	}

	@Override
	public void eliminarMatricula(int idMatricula) {
		rpy.deleteById(idMatricula);
	}

	@Override
	public List<Matricula> listarTodo() {
		return rpy.findAll();
	}

}
