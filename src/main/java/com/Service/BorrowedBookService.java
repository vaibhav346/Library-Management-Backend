package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.BorrowedBook;
import com.Repository.BorrowedBookRepository;

@Service
public class BorrowedBookService {

	@Autowired
	BorrowedBookRepository borrowed;

	public String save(BorrowedBook borr) {
		borrowed.save(borr);
		return "book record added sucessfully";
	}

	public List<BorrowedBook> findall() {
		return borrowed.findAll();
	}
	
	public String deletebyid(Long id) {
	 borrowed.deleteById(id);
	 return "Record deleted sucessfully";
	}

	public String updatebyid(Long id, BorrowedBook newdata) {
		BorrowedBook existing = new BorrowedBook();
		existing = borrowed.findById(id).orElse(null);

		if (existing == null) {
			return "Record not match for the database";
		}

		if (newdata.getBorrowId() != 0 && newdata.getBorrowDate() != null && newdata.getReturnDate() != null) {
			return "New record not provided for old data updatioin";
		}

		if (newdata.getBorrowDate() != null) {
			existing.setBorrowDate(newdata.getBorrowDate());
		}

		if (newdata.getReturnDate() != null) {
			existing.setReturnDate(newdata.getReturnDate());
		}
		borrowed.save(existing);
		return "Record updated sucessfully";
	}
	
	
	
	
	public String insertdata(BorrowedBook date) {
		borrowed.save(date);
		return "Record Added sucessfully";
	}
}
