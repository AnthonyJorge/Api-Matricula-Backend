package com.moviles.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moviles.entity.Docente;

public interface docenteRepository extends JpaRepository<Docente, Integer> {

	@Query("select x from Docente x where x.nombre like ?1")
	public List<Docente> listaPorNombre(String nombre);
	
}
