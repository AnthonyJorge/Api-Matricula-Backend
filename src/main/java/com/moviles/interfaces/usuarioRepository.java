package com.moviles.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.moviles.entity.Usuario;

public interface usuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query("Select x from Usuario x where x.login = :#{#usu.login} and x.password = :#{#usu.password}")
	public abstract Usuario login(@Param(value = "usu") Usuario bean);
	
	public abstract Usuario findByLogin(String login);

}
