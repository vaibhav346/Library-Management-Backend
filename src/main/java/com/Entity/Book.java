package com.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book_Details")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	Long bookId;
	String title;
	String author;
	String genre;
	boolean availability;
	String imageUrl;

	@ManyToOne
	@JoinColumn(name = "Student_id")
	@JsonBackReference(value = "student-books")
	Student student;

	@ManyToOne
	@JoinColumn(name = "Admin_id")
	@JsonBackReference
	Admin admin;

	public Book() {
		super();
	}

	public Book(Long bookId, String title, String author, String genre, boolean availability, String imageUrl,
			Student student, Admin admin) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.availability = availability;
		this.imageUrl = imageUrl;
		this.student = student;
		this.admin = admin;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean getAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

//	
//	public Book() {
//		super();
//	}
//
//	public Book(Long bookId, String title, String author, String genre, boolean availability, String imageUrl) {
//		super();
//		this.bookId = bookId;
//		this.title = title;
//		this.author = author;
//		this.genre = genre;
//		this.availability = availability;
//		this.imageUrl = imageUrl;
//	}
//	
//	
//
//	public Long getBookId() {
//		return bookId;
//	}
//
//	public void setBookId(Long bookId) {
//		this.bookId = bookId;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//
//	public String getGenre() {
//		return genre;
//	}
//
//	public void setGenre(String genre) {
//		this.genre = genre;
//	}
//
//	public boolean getAvailability() {
//		return availability;
//	}
//
//	public void setAvailability(boolean availability) {
//		this.availability = availability;
//	}
//
//	public String getImageUrl() {
//		return imageUrl;
//	}
//
//	public void setImageUrl(String imageUrl) {
//		this.imageUrl = imageUrl;
//	}

}
