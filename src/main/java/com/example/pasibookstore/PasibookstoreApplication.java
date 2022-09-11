package com.example.pasibookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.pasibookstore.domain.Book;
import com.example.pasibookstore.domain.BookRepository;

@SpringBootApplication
public class PasibookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasibookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner book(BookRepository repository) {
		return (args) -> {
			Book book1 = new Book(" East of Eden", "john Steinbeck", 1952, "12323232-11", 25.90);
			Book book2 = new Book("Number the Stars", "Lois Lowry", 1989, "236598-26", 32.90);
			repository.save(book1);
			repository.save(book2);
		};
	}
}
