package com.enterprise.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.course.entities.User;

//os nossos repositories vao ser interfaces isto porque os JPA repository tambem o é
//neste caso especifico o String JPA ja tem implementação padrao para a interface
//nao temos de a fazer, podemos de imediato usar
public interface UserRepository extends JpaRepository<User, Long>  {

}
