package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {
	
	@Autowired
	BookRepository repo;
	
	@PostMapping("/addBook")
	public String addBook(Book book) {
		repo.save(book);
		return book.getId() +":"+book.getName()+":"+book.getAuthor();
	}
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return repo.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(int id) {
		repo.deleteById(id);
		return "deleted";
	}
	

}
