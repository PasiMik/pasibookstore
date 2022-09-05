package com.example.pasibookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.pasibookstore.domain.Book;

@Controller
public class BookController {
	
	@GetMapping("/index")
	public String getRequests(Model model) {
		model.addAttribute("book", new Book());
		return "index";
	}
	


}
