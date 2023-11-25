package com.moviles.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name ="usuario")
@Entity
public class Usuario {
	@Column(name = "idusuario")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario ;
	private String nombres;
	private String apellidos;
	private String dni ;
	private String login ;
	private String password ;
	private String correo ;
	private String rol ;
	@Column(name = "fecharegistro")
	private Date fechaRegistro;
}
