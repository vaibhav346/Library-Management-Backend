package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Admin;
import com.Entity.Book;
import com.Entity.Student;
import com.Repository.AdminRepository;
import com.Repository.BookRepository;
import com.Repository.StudentRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository admin;

	@Autowired
	StudentRepository srepo;

	@Autowired
	BookRepository brepo;

	// 1.add admin and student but admin id is go to student table
	public String save(Admin ad) {
		for (Student s : ad.getStudent()) {
			s.setStud(ad);
		}
		for (Book b : ad.getBlist()) {
			b.setAdmin(ad);
		}
		Admin existingadmin = admin.findByAdminusername(ad.getAdminusername()).orElse(null);
		if (existingadmin != null) {
			return "Please enter another username. This is one is already exists";
		} else {
			admin.save(ad);
			return "Admin save sucessfully";
		}
	}

	// 2. findby id admin
	public Admin findbyid(Long id) {
		return admin.findById(id).orElse(null);
	}

	// 3. login admin
	public Admin login(String username, String password) {
		return admin.findByAdminusernameAndAdminpassword(username, password)
				.orElseThrow(() -> new RuntimeException("Invalid Credentials"));
	}

	// 4. update and add student
	public String updatebyid(Long aid, Admin newdata) {
		Admin existingadmin = admin.findById(aid).orElse(null);
		if (existingadmin == null) {
			return "Admin is not found";
		}

		if (newdata.getAdminId() == 0 && newdata.getAdminusername() == null && newdata.getAdminpassword() == null
				&& newdata.getAdminimgurl() == null && newdata.getAdmincontactno() == 0
				&& newdata.getAdminemail() == null && newdata.getAdminname() == null && newdata.getBlist() == null
				&& newdata.getStudent() == null) {
			return "No New Data provided for updatation";
		}

		if (newdata.getAdminusername() != null) {
			existingadmin.setAdminusername(newdata.getAdminusername());
		}

		if (newdata.getAdminpassword() != null) {
			existingadmin.setAdminpassword(newdata.getAdminpassword());
		}

		if (newdata.getAdminimgurl() != null) {
			existingadmin.setAdminimgurl(newdata.getAdminimgurl());
		}
		if (newdata.getAdmincontactno() != null) {
			existingadmin.setAdmincontactno(newdata.getAdmincontactno());
		}
		if (newdata.getAdminemail() != null) {
			existingadmin.setAdminemail(newdata.getAdminemail());
		}
		if (newdata.getAdminname() != null) {
			existingadmin.setAdminname(newdata.getAdminname());
		}

		List<Student> student = newdata.getStudent();
		for (Student s : student) {
			if (s.getSid() != null && s.getSid() != 0) // old record of student for updatation.
			{
				Student existingstudent = srepo.findById(s.getSid()).orElse(null);
				if (s.getStudentusername() != null) {
					existingstudent.setStudentusername(s.getStudentusername());
				}
				if (s.getStudentpassword() != null) {
					existingstudent.setStudentpassword(s.getStudentpassword());
				}
				if (s.getScontactno() != null) {
					existingstudent.setScontactno(s.getScontactno());
				}
				if (s.getSemail() != null) {
					existingstudent.setSemail(s.getSemail());
				}
				if (s.getStudentname() != null) {
					existingstudent.setStudentname(s.getStudentname());
				}
				if (s.getClassname() != null) {
					existingstudent.setClassname(s.getClassname());
				}
				if (s.getImgurl() != null) {
					existingstudent.setImgurl(s.getImgurl());
				} else {
					// if pid is not given then it is new Student Record
					s.setStud(existingadmin);
					existingadmin.getStudent().add(s);
				}
			}
		}

		List<Book> book = newdata.getBlist();
		for (Book b : book) {
			if (b.getBookId() != null && b.getBookId() != 0) //
			{
				Book existingbook = brepo.findById(b.getBookId()).orElse(null);
				if (b.getTitle() != null) {
					existingbook.setTitle(b.getTitle());
				}
				if (b.getAuthor() != null) {
					existingbook.setAuthor(b.getAuthor());
				}
				if (b.getGenre() != null) {
					existingbook.setGenre(b.getGenre());
				}

				if (b.getAvailability() != null) {
					existingbook.setAvailability(b.getAvailability());
				}
				if (b.getBorrowDate() != null) {
					existingbook.setBorrowDate(b.getBorrowDate());
				}
				if (b.getReturnDate() != null) {
					existingbook.setReturnDate(b.getReturnDate());
				}
				if (b.getImageUrl() != null) {
					existingbook.setImageUrl(b.getImageUrl());
				} else {
					b.setAdmin(existingadmin);
					existingadmin.getBlist().add(b);
				}
			}
		}
		admin.save(existingadmin);
		return "Record update sucessfully adn add record";
	}

}
