package com.example.datajpa;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.datajpa.model.User;
import com.example.datajpa.repo.UserRepo;
/**
 * 
 * @author Ravishankar.kumar
 *
 */
@SpringBootApplication
public class DatajpaApplication{

	public static void main(String[] args) {
		SpringApplication.run(DatajpaApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(UserRepo userRepo) {
        return args -> {

            // create Users
            List<User> userList = Arrays.asList(
                    new User(1,"Deottam", "Jha", 55,true),
                    new User(2,"Silpa", "Shetty", 29,true),
                    new User(3,"deepa", "Mahto", 35,false),
                    new User(4,"Muthu", "Sarbanan", 30,true),
                    new User(4,"Sibhar", "Mahto", 30,true),
                    new User(6,"Shilpa","Shetti",34,false)
            );
            
            userRepo.saveAll(userList);

        };
    }
}
