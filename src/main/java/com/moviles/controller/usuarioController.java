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

import com.moviles.entity.Usuario;
import com.moviles.services.UsuarioService;
import com.moviles.utils.Mensajes;

@RestController
@RequestMapping("/crudUsuario")
public class usuarioController {
	
	@Autowired
	private UsuarioService usuService;
	
	
	@GetMapping("/listarUsuario")
	@ResponseBody
	public ResponseEntity<List<Usuario>> listarUsuario(){
		List<Usuario> listado = usuService.listarTodos();
		return ResponseEntity.ok(listado);
	}

	@PostMapping("/agregarUsuario")
	@ResponseBody
	public ResponseEntity<?> agregarUsuario(@RequestBody Usuario usu) {
		HashMap<String, Object> salida = new HashMap<>();

		
		usu.setFechaRegistro(new Date());
		
		Usuario objSalida = usuService.agregarUsuario(usu);
			if (objSalida == null) {
				salida.put("mensaje", Mensajes.MENSAJE_REG_ERROR);

			} else {
				salida.put("mensaje", Mensajes.MENSAJE_REG_EXITOSO);
			
		}

		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizarUsuario")
	@ResponseBody
	public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usu) {
		HashMap<String, Object> salida = new HashMap<>();

		usu.setFechaRegistro(new Date());
		
		Usuario objSlida = usuService.actualizarUsuario(usu);
			if (objSlida == null) {
				salida.put("mensaje", Mensajes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Mensajes.MENSAJE_ACT_EXITOSO);
			
		}
		return ResponseEntity.ok(salida);

	}

	@DeleteMapping("/eliminarUsuario/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminarUsuario(@PathVariable("id") int idUsuario) {
		Map<String, Object> salida = new HashMap<>();

		try {
			usuService.eliminarUsuario(idUsuario);
			salida.put("mensaje", Mensajes.MENSAJE_ELI_EXITOSO);

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Mensajes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
