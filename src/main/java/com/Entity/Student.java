package com.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Student_Login")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	Long UserId;
	@Column(unique = true, name = "Username")
	String studentusername;
	@Column(name = "Password")
	String studentpassword;
	String Role;
	String imgurl;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference(value = "student-books")
	List<Book> blist;

	@OneToMany(mappedBy = "borrowedbook", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	List<BorrowedBook> borrowedbooklist;

	@ManyToOne
	@JoinColumn(name = "Admin_id")
	@JsonBackReference
	Admin stud;

	public Student() {
		super();
	}

	public Student(Long userId, String studentusername, String studentpassword, String role, String imgurl) {
		super();
		this.UserId = userId;
		this.studentusername = studentusername;
		this.studentpassword = studentpassword;
		this.Role = role;
		this.imgurl = imgurl;
	}

	public Long getUserId() {
		return UserId;
	}

	public void setUserId(Long userId) {
		this.UserId = userId;
	}

	public String getStudentusername() {
		return studentusername;
	}

	public void setStudentusername(String studentusername) {
		this.studentusername = studentusername;
	}

	public String getStudentpassword() {
		return studentpassword;
	}

	public void setStudentpassword(String studentpassword) {
		this.studentpassword = studentpassword;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		this.Role = role;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

}
