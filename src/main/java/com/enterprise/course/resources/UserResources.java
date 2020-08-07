package com.enterprise.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.course.entities.User;
import com.enterprise.course.services.UserService;

//Rescurso Web implementado por Controlador Rest
@RestController  
@RequestMapping(value = "/users")
public class UserResources {
	
	//para o spring gerar as dependencias de Userservice para mim
	@Autowired
	private UserService service;
	
	//Metodo end point para aceder a utilizadores e assim verificarmos que o mapping esta a funcionar
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
			//User u = new User(1L, "Maria", "maria@gmail.com", "92313323", "12345");	
		
		List<User> list = service.findAll();
		
		//criar resposta http e no corpo da resposta colocar lista
		return ResponseEntity.ok().body(list);	
		
	}
	
	
	//requisição do tipo Get passada pelo url e como queremos passar parametro colocamos assim 
	@GetMapping(value = "/{id}")
	//Colocamos a onotation PathVariable para conseguir com que o spring perceba o id
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		User obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	
}
