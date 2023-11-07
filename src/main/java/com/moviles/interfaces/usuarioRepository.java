package com.moviles.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.moviles.entity.Usuario;

public interface usuarioRepository extends JpaRepository<Usuario, Integer> {

}
