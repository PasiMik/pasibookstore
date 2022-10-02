package com.example.pasibookstore.domain;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<Userlog, Long> {
	Userlog findByUsername(String username);
}
