package com.moviles.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.moviles.entity.Alumno;
import com.moviles.entity.Curso;
import com.moviles.entity.Docente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name ="matricula")
@Entity
public class Matricula {
	@Column(name = "idmatricula")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMatricula;
	private double precio;
	@Column(name = "preciototal")
	private double precioTotal;
	@Column(name = "tipoPago")
	private String tipoPago;
	
	@Column(name="fecharegistro")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "America/Lima")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaRegistro;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name ="idCurso")
	private Curso curso;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name ="idDocente")
	private Docente docente;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name ="idAlumno")
	private Alumno alumno;
	
}
