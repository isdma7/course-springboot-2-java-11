package com.enterprise.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.course.entities.Order;
import com.enterprise.course.services.OrderService;

//Rescurso Web implementado por Controlador Rest
@RestController  
@RequestMapping(value = "/orders")
public class OrderResources {
	
	//para o spring gerar as dependencias de Orderservice para mim
	@Autowired
	private OrderService service;
	
	//Metodo end point para aceder a utilizadores e assim verificarmos que o mapping esta a funcionar
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
			//Order u = new Order(1L, "Maria", "maria@gmail.com", "92313323", "12345");	
		
		List<Order> list = service.findAll();
		
		//criar resposta http e no corpo da resposta colocar lista
		return ResponseEntity.ok().body(list);	
		
	}
	
	
	//requisição do tipo Get passada pelo url e como queremos passar parametro colocamos assim 
	@GetMapping(value = "/{id}")
	//Colocamos a onotation PathVariable para conseguir com que o spring perceba o id
	public ResponseEntity<Order> findById(@PathVariable Long id){
		
		Order obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	
}
