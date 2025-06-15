package com.Controller;

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

import com.Entity.Book;
import com.Service.BookService;

@RestController
@RequestMapping("/Book")
public class BookController {

	@Autowired
	BookService bookser;

	@PostMapping("/save")
	public String save(@RequestBody Book book) {
		return bookser.save(book);
	}

	@GetMapping("/findall")
	public List<Book> findall() {
		return bookser.finall();
	}

	@DeleteMapping("/detebyid/{bookId}")
	public String deletebyid(@PathVariable Long bookId) {
		return bookser.deletebyid(bookId);
	}

	@GetMapping("/findbyid/{id}")
	public Book findbyid(@PathVariable Long id) {
		return bookser.findbyid(id);
	}

	@GetMapping("/findbytitle/{title}")
	public List<Book> findbytitle(@PathVariable String title) {
		return bookser.findbytitle(title);
	}

	@PutMapping("/update/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
		return bookser.updateBook(id, updatedBook);
	}

	@PutMapping("/borrow/{id}")
	public Book borrow(@PathVariable Long id) {
		return bookser.borrowbook(id);
	}

	@PutMapping("/return/{id}")
	public Book returnbook(@PathVariable Long id) {
		return bookser.returnbook(id);
	}
}
