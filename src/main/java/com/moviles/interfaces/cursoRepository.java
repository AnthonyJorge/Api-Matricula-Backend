package com.moviles.interfaces;


import org.springframework.data.jpa.repository.JpaRepository;

import com.moviles.entity.Curso;

public interface cursoRepository extends JpaRepository<Curso, Integer>{

}
