package com.enterprise.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.course.entities.Product;
import com.enterprise.course.repositories.ProductRepository;


//registrar como componente do spring e assim depois ja podemos no Productresources criar a dependencia spring para o services
//ou seja assim vai poder ser injetado automaticamente com o autowired
//@Component, podia ser @Repository, neste caso como é serviço colocamos service para ficar semanticamente melhor
@Service
public class ProductService {

	//Para criar a dependencia de forma transparente para o programador para a camanda repository
	//Para o Spring fazer a injeção de dependencia de forma transparente ao programador
	@Autowired 
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id){
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
}
