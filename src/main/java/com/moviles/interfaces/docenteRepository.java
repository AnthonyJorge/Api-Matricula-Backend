package com.moviles.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moviles.entity.Docente;

public interface docenteRepository extends JpaRepository<Docente, Integer> {
	
}
