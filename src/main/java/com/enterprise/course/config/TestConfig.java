package com.enterprise.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.enterprise.course.entities.User;
import com.enterprise.course.repositories.UserRepository;

//Usamos esta class unicamente para testes e confs, por isso mesmo usamos tambem uma 
//interface de testes em application-test.properties
@Configuration
//test no profile, nome igualzinho ao colocado no application propreties
// assim identifica que so roda configuração apenas quando esta no perfil de test
@Profile("test")
public class TestConfig implements CommandLineRunner{
	//para ja usamos esta class para popular a nossa BD
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {//fizemos um implements da interface CommandLineRunner e temos assim obrigaçao de implementar este metodo que irá ser executado sempre que executarmos a aplicação e é isso que nos queremos
		// TODO Auto-generated method stub
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		// Para salvar chamo o objeto userrepository que acessa dados
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		
		
		
	}

}
