package com.enterprise.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.course.entities.User;

@RestController  // Rescurso Web implementado por Controlador Rest
@RequestMapping(value = "/users")
public class UserResources {
	
	//Metodo end point para aceder a utilizadores e assim verificarmos que o mapping esta a funcionar
	@GetMapping
	public ResponseEntity<User> findAll(){
			User u = new User(1L, "Maria", "maria@gmail.com", "92313323", "12345");
					
			return ResponseEntity.ok().body(u);	
	}
}
