package com.example.book.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.model.Book;
import com.example.book.service.BookService;

@RestController
@RequestMapping("app/v1/")
public class BookRestController {

	@Autowired
	BookService bookService;

	@GetMapping("books")
	public ResponseEntity<List<Book>> get() {
		return ResponseEntity.ok(bookService.getAll());
	}
	
	@PostMapping("books")
	public ResponseEntity<Book> save(@RequestBody(required=true) Book book) {
		bookService.save(book);
		return new ResponseEntity<Book>(book, HttpStatus.CREATED);
	}
	
	@DeleteMapping("books/{id}")
	public ResponseEntity<String> delete(@PathVariable(required=true) long id) {
		bookService.delete(id);
		return ResponseEntity.ok("Deleted");
	}
	
	@PutMapping("books")
	public ResponseEntity<Book> put(@RequestBody(required=true) Book book) {
		bookService.edit(book);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
}
