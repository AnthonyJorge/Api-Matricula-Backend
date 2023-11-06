package com.moviles.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviles.entity.Curso;
import com.moviles.services.cursoService;
import com.moviles.utils.Mensajes;

@RestController
@RequestMapping("/crudCurso")
@CrossOrigin(origins = "http://localhost:4200")
public class cursoController {

	@Autowired
	private cursoService cuService;

	@GetMapping("/listarCursoPorNombre/{nom}")
	@ResponseBody
	public ResponseEntity<List<Curso>> listaCursoPorNombre(@PathVariable("nom") String nom) {
		List<Curso> lista = null;
		try {
			if (nom.equals("todos")) {
				lista = cuService.listaCursoPorNombre("%");
			} else {
				lista = cuService.listaCursoPorNombre("%" + nom + "%");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	

	@GetMapping("/listarCursos")
	@ResponseBody
	public ResponseEntity<List<Curso>> listarCursos(){
		List<Curso> listado = cuService.listarTodos();
		return ResponseEntity.ok(listado);
	}

	@PostMapping("/agregarCurso")
	@ResponseBody
	public ResponseEntity<?> insertarCurso(@RequestBody Curso obj) {
		HashMap<String, Object> salida = new HashMap<>();
		List<Curso> validarCurso = cuService.listarTodos();

		
		obj.setFechaRegistro(new Date());

		if (validarCurso.stream()
				.anyMatch(c -> c.getNombre().equals(obj.getNombre()) && c.getIdCurso() != obj.getIdCurso())) {
			salida.put("mensaje", Mensajes.MENSAJE_CURSONOMBRE_EXISTE);
		} else {
			Curso objSalida = cuService.agregarCurso(obj);
			if (objSalida == null) {
				salida.put("mensaje", Mensajes.MENSAJE_REG_ERROR);

			} else {
				salida.put("mensaje", Mensajes.MENSAJE_REG_EXITOSO);
			}
		}

		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizarCurso")
	@ResponseBody
	public ResponseEntity<?> actualizarCurso(@RequestBody Curso obj) {
		HashMap<String, Object> salida = new HashMap<>();
		List<Curso> validarCurso = cuService.listarTodos();

		obj.setFechaRegistro(new Date());
		if (validarCurso.stream()
				.anyMatch(c -> c.getNombre().equals(obj.getNombre()) && c.getIdCurso() != obj.getIdCurso())) {
			salida.put("mensaje", Mensajes.MENSAJE_CURSONOMBRE_EXISTE);
		} else {

			Curso objSlida = cuService.actualizarCurso(obj);
			if (objSlida == null) {
				salida.put("mensaje", Mensajes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Mensajes.MENSAJE_ACT_EXITOSO);
			}
		}
		return ResponseEntity.ok(salida);

	}

	@DeleteMapping("/eliminarCurso/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminarCurso(@PathVariable("id") int idCuros) {
		Map<String, Object> salida = new HashMap<>();

		try {
			cuService.eliminarDocente(idCuros);
			salida.put("mensaje", Mensajes.MENSAJE_ELI_EXITOSO);

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Mensajes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
