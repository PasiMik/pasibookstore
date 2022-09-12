package com.example.pasibookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.pasibookstore.domain.Book;
import com.example.pasibookstore.domain.BookRepository;
import com.example.pasibookstore.domain.Category;
import com.example.pasibookstore.domain.CategoryRepository;

@SpringBootApplication
public class PasibookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasibookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner book(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Science Fiction"));			
			 
			repository.save( new Book(" East of Eden", "john Steinbeck", 1952, "12323232-11", 25.90, crepository.findByName("Fantasy").get(0)));
			repository.save(new Book("Number the Stars", "Lois Lowry", 1989, "236598-26", 32.90, crepository.findByName("Horror").get(0)));
		};
	}
}
