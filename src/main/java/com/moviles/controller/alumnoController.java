package com.moviles.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviles.entity.Alumno;
import com.moviles.services.alumnoService;
import com.moviles.utils.Mensajes;


@RestController
@RequestMapping("/crudAlumno")
public class alumnoController {
	

	@Autowired
	private alumnoService alService;


	@GetMapping("/listarAlumno")
	@ResponseBody
	public ResponseEntity<List<Alumno>> listarAlumno(){
		List<Alumno> listado = alService.listarTodos();
		return ResponseEntity.ok(listado);
	}

	@PostMapping("/agregarAlumno")
	@ResponseBody
	public ResponseEntity<?> insertarAlumno(@RequestBody Alumno obj) {
		HashMap<String, Object> salida = new HashMap<>();

		
		obj.setFechaRegistro(new Date());
		
			Alumno objSalida = alService.agregarAlumno(obj);
			if (objSalida == null) {
				salida.put("mensaje", Mensajes.MENSAJE_REG_ERROR);

			} else {
				salida.put("mensaje", Mensajes.MENSAJE_REG_EXITOSO);
			
		}

		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizarAlumno")
	@ResponseBody
	public ResponseEntity<?> actualizarAlumno(@RequestBody Alumno obj) {
		HashMap<String, Object> salida = new HashMap<>();

		obj.setFechaRegistro(new Date());
		
			Alumno objSlida = alService.actualizarAlumno(obj);
			if (objSlida == null) {
				salida.put("mensaje", Mensajes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Mensajes.MENSAJE_ACT_EXITOSO);
			
		}
		return ResponseEntity.ok(salida);

	}

	@DeleteMapping("/eliminarAlumno/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminarAlumno(@PathVariable("id") int idAlumno) {
		Map<String, Object> salida = new HashMap<>();

		try {
			alService.eliminarAlumno(idAlumno);
			salida.put("mensaje", Mensajes.MENSAJE_ELI_EXITOSO);

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Mensajes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
