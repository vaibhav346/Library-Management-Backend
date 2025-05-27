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

	public String updatebyid(Long id, Book newdata) {
		Book existing = new Book();
		existing = bookrep.findById(id).orElse(null);

		if (existing == null) {
			return "Record not match for this database";
		}

		if (newdata.getBookId() != 0 && newdata.getTitle() != null && newdata.getAuthor() != null
				&& newdata.getGenre() != null && newdata.getAvailability() != false && newdata.getImageUrl() != null) {
			return "Record is not provided for the old data updataion";
		}

		if (newdata.getTitle() != null) {
			existing.setTitle(newdata.getTitle());
		}

		if (newdata.getAuthor() != null) {
			existing.setAuthor(newdata.getAuthor());
		}
		if (newdata.getGenre() != null) {
			existing.setGenre(newdata.getGenre());
		}

		if (newdata.getAvailability() != false) {
			existing.setAvailability(newdata.getAvailability());
		}
		if (newdata.getImageUrl() != null) {
			existing.setImageUrl(newdata.getImageUrl());
		}
		bookrep.save(existing);
		return "Record updated sucessfully";
	}

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AdminRepository adminRepository;

	// Add a book under a specific Admin
	public String addBook(Long adminId, Book book) {
		Optional<Admin> adminOpt = adminRepository.findById(adminId);
		if (adminOpt.isPresent()) {
			Admin admin = adminOpt.get();
//				book.setAdmin(admin);
			book.setAdmin(admin);
			bookRepository.save(book);
			return "Book added successfully under admin.";
		} else {
			throw new RuntimeException("Admin not found with ID: " + adminId);
		}
	}

	// Get all books added by an Admin
	public List<Book> getBooksByAdmin(Long adminId) {
		Optional<Admin> adminOpt = adminRepository.findById(adminId);
		if (adminOpt.isPresent()) {
			return adminOpt.get().getBlist();
		} else {
			throw new RuntimeException("Admin not found.");
		}
	}
}
