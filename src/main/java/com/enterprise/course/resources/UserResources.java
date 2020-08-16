package com.enterprise.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	//Endpoint para inserir
	//Esta classe é um controlador Rest que tem o caminho especificado acima /users
	//para ir buscar usamos o get, que podemos fazer no postman, que faz o get de todos se nao inserirmos nada tal como definido acima ou pelo id se especificado ta l como dizemos tmabem acima
	//os 2 endopoints acima eram para buscar dados no bd com o metodo get do hhtp
	//para inserir usamos o post
	//Esta anotation do spring vai fazer uma pre processamento na compiliçao definindo que este metodo vai receber o metodo post do http 
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){ // tenho de colocar uma anotion para poder converter para jason na altura da inserção  e quando chegar ser deserializar para objeto java user neste caso
		
		obj = service.insert(obj);
		
		// Assim ja dava mas queremos que o http retorne o codigo 201 que é o correto para inserções return ResponseEntity.ok().body(obj);
		
		//FOrma de gerar um endereºo necessario para poder receber no metodo created do responseentity
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();		
		return ResponseEntity.created(uri).body(obj); // assim eu passo o user e recebo a uri tal como feito acima com o caminho /id e depois com o onj.getid obtenho o id gerado na criação do mesmo
	
	}
	
	
	
}
