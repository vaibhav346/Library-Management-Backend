package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Admin;
import com.Entity.Book;
import com.Repository.AdminRepository;
import com.Repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookrep;

	public String save(Book book) {
		bookrep.save(book);
		return "Book added sucessfully";
	}

	public List<Book> finall() {
		return bookrep.findAll();
	}

	public String deletebyid(Long id) {
		bookrep.deleteById(id);
		return "Book delete sucessfully";
	}

	public Book findbyid(Long id) {
		return bookrep.findById(id).orElse(null);
	}

	public List<Book> findbytitle(String name) {
		return bookrep.findByTitle(name);
	}

}
