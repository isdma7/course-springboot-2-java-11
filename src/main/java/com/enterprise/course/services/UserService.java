package com.enterprise.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.enterprise.course.entities.User;
import com.enterprise.course.repositories.UserRepository;


//registrar como componente do spring e assim depois ja podemos no Userresources criar a dependencia spring para o services
//ou seja assim vai poder ser injetado automaticamente com o autowired
//@Component, podia ser @Repository, neste caso como é serviço colocamos service para ficar semanticamente melhor
@Service
public class UserService {

	//Para criar a dependencia de forma transparente para o programador para a camanda repository
	//Para o Spring fazer a injeção de dependencia de forma transparente ao programador
	@Autowired 
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id){
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		
		return repository.save(obj); //metodo que tenho no repository para salvar e que por defeito ja retorna o objeto salvo
	}
	
	public void delete(Long id) {
		repository.deleteById(id);

	}
	
	public User update(Long id, User obj) {
		User entity = repository.getOne(id); // em vez de fazermos o get acima que vai ao bd, preparamos um objeto monitorado pelo JPA para mechermos e depois sim efetuamos uma operação com o bd
		updateData(entity, obj); //criamos uma função para atualizar dados do meu entity com base no que chega do obj
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());	
	}
	
}
