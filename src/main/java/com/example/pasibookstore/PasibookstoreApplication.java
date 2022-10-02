package com.example.pasibookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.pasibookstore.domain.Book;
import com.example.pasibookstore.domain.BookRepository;
import com.example.pasibookstore.domain.Category;
import com.example.pasibookstore.domain.CategoryRepository;
import com.example.pasibookstore.domain.UserRepository;
import com.example.pasibookstore.domain.Userlog;

@SpringBootApplication
public class PasibookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasibookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner book(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Science Fiction"));			
			 
			repository.save( new Book(" East of Eden", "John Steinbeck", 1952, "12323232-11", 25.90, crepository.findByName("Fantasy").get(0)));
			repository.save(new Book("Number the Stars", "Lois Lowry", 1989, "236598-26", 32.90, crepository.findByName("Horror").get(0)));
			
			Userlog user1 = new Userlog("user", "$2a$10$aeYF.z4171UTtrGFvh/9aOOkk0VPj8Sq0CFRYzMSpuMTyBX8SfRnm","user@pasila.com", "USER");
			Userlog  user2 = new Userlog ("admin", "$2a$10$GQOA2HC5rJ0HjARfGcqZUufFdluGJ4sSOR6Z6eC2swOlN47I74nGW","admin@pasila.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
	}
}
