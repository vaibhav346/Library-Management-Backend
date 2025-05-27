package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.BorrowedBook;
import com.Service.BorrowedBookService;

@RestController
@RequestMapping("/BorrowedBook")
public class BorrowedBookController {

	@Autowired
	BorrowedBookService borser;

	@PostMapping("/save")
	public String save(@RequestBody BorrowedBook borrowedbook) {
		borser.save(borrowedbook);
		return "Recored Added sucessfully";
	}

	@GetMapping("/findall")
	public List<BorrowedBook> findall() {
		return borser.findall();
	}

	@PutMapping("/updatebyid")
	public String updatebyid(Long id, BorrowedBook newdata) {
		return borser.updatebyid(id, newdata);
	}

	@DeleteMapping("/deletebyid")
	public String deletebyid(Long id) {
		return borser.deletebyid(id);

	}

	@PostMapping("/insertdata")
	public String insertdata(@RequestBody BorrowedBook date) {
		return borser.insertdata(date);
	}
}
