package com.moviles.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moviles.entity.Alumno;

public interface alumnoRepository extends JpaRepository<Alumno, Integer> {

	@Query("select x from Alumno x where x.nombre like ?1")
	public List<Alumno> listaPorNombre(String nombre);
	
}
