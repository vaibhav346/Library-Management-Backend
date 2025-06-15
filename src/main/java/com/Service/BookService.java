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
		book.setStatus("PENDING");
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

	public List<Book> findbytitle(String title) {
		return bookrep.findByTitle(title);
	}

	public Book updateBook(Long bookId, Book updatedBook) {
		Optional<Book> optionalBook = bookrep.findById(bookId);

		if (optionalBook.isPresent()) {
			Book existingBook = optionalBook.get();

			// Update fields
			existingBook.setTitle(updatedBook.getTitle());
			existingBook.setAuthor(updatedBook.getAuthor());
			existingBook.setGenre(updatedBook.getGenre());
			existingBook.setAvailability(updatedBook.getAvailability());
			existingBook.setBorrowDate(updatedBook.getBorrowDate());
			existingBook.setReturnDate(updatedBook.getReturnDate());
			existingBook.setStatus(updatedBook.getStatus());
			existingBook.setImageUrl(updatedBook.getImageUrl());

			return bookrep.save(existingBook);
		} else {
			throw new RuntimeException("Book not found with id: " + bookId);
		}
	}

	// borrow book
	public Book borrowbook(Long bookid) {
		Book book = bookrep.findById(bookid).orElse(null);
		book.setStatus("BORROW");

		return bookrep.save(book);
	}

	// return book
	public Book returnbook(Long bookid) {
		Book book = bookrep.findById(bookid).orElse(null);
		book.setStatus("RETURN");
		return bookrep.save(book);
	}

}
