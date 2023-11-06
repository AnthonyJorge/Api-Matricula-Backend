package com.moviles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviles.interfaces.docenteRepository;
import com.moviles.entity.Docente;

@Service
public class docenteServicelmp implements docenteService{

	@Autowired
	private docenteRepository rpy;
	
	@Override
	public Docente agregarDocente(Docente docente) {
		return rpy.save(docente);
	}

	@Override
	public Docente actualizarDocentes(Docente docente) {
		return rpy.save(docente);
	}

	@Override
	public List<Docente> listarDocentePorNombre(String nombre) {
		return rpy.listaPorNombre(nombre);
	}

	@Override
	public void eliminarDocente(int idDocente) {
		rpy.deleteById(idDocente);
	}

	@Override
	public List<Docente> listarTodos() {
		return rpy.findAll();
	}
	
	
	

}
