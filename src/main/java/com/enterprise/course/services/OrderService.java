package com.enterprise.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.course.entities.Order;
import com.enterprise.course.repositories.OrderRepository;


//registrar como componente do spring e assim depois ja podemos no Orderresources criar a dependencia spring para o services
//ou seja assim vai poder ser injetado automaticamente com o autowired
//@Component, podia ser @Repository, neste caso como é serviço colocamos service para ficar semanticamente melhor
@Service
public class OrderService {

	//Para criar a dependencia de forma transparente para o programador para a camanda repository
	//Para o Spring fazer a injeção de dependencia de forma transparente ao programador
	@Autowired 
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id){
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}
