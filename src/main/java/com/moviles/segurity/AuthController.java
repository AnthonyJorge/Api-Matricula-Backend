package com.moviles.segurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins ="http://localhost:4200")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    
    
    @PostMapping("/login")
    public ResponseEntity<UsuarioPrincipal> login(@RequestBody LoginUsuario loginUsuario){
    	log.info(">>> login >>> " + loginUsuario.getLogin());
    	log.info(">>> login >>> " + loginUsuario.getPassword());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getLogin(), loginUsuario.getPassword()));
        
        log.info(">>> authentication >>> " + authentication);
        
        //Validaciones en la base de datos
        UsuarioPrincipal usuario = (UsuarioPrincipal)authentication.getPrincipal();
        log.info(">>> usuario >>> " + usuario.toString());
        
        return new  ResponseEntity<UsuarioPrincipal>( HttpStatus.OK);
    }
}
