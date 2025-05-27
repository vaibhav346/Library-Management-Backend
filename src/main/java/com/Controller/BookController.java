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

	@GetMapping("/findbyid")
	public Book findbyid(Long id) {
		return bookser.findbyid(id);
	}

	@GetMapping("/findbytitle")
	public List<Book> findbytitle(String title) {
		return bookser.findbytitle(title);
	}

	@PutMapping("/updatebyid/{id}")
	public String updatebyid(@PathVariable Long id, @RequestBody Book newdata) {
		return bookser.updatebyid(id, newdata);
	}

	@Autowired
	private BookService bookService;

	@PostMapping("/add/{adminId}")
	public ResponseEntity<String> addBook(@PathVariable Long adminId, @RequestBody Book book) {
		try {
			String result = bookService.addBook(adminId, book);
			return ResponseEntity.ok(result);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@GetMapping("/admin/{adminId}")
	public ResponseEntity<List<Book>> getBooksByAdmin(@PathVariable Long adminId) {
		try {
			List<Book> books = bookService.getBooksByAdmin(adminId);
			return ResponseEntity.ok(books);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
