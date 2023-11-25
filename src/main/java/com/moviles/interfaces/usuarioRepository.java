package com.moviles.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviles.entity.Usuario;

public interface usuarioRepository extends JpaRepository<Usuario, Integer> {

}
