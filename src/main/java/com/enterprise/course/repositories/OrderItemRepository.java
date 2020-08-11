package com.enterprise.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.course.entities.OrderItem;
import com.enterprise.course.entities.User;

//os nossos repositories vao ser interfaces isto porque os JPA repository tambem o é
//neste caso especifico o String JPA ja tem implementação padrao para a interface
//nao temos de a fazer, podemos de imediato usar

//Neste caso Repository é opcional porque ja esta a ir buscar a dependencias ao JPA pelo extendOrder, Instant, ISO 8601
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>  {

}
