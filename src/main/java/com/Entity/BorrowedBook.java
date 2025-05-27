package com.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BorrowedBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	Long borrowId;
	LocalDate borrowDate;
	LocalDate returnDate;

	@ManyToOne
	@JoinColumn(name = "Student_id")
	@JsonBackReference
	Student borrowedbook;

	public BorrowedBook() {
		super();
	}

	public BorrowedBook(Long borrowId, LocalDate borrowDate, LocalDate returnDate) {
		super();
		this.borrowId = borrowId;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}

	public Long getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(Long borrowId) {
		this.borrowId = borrowId;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

}
