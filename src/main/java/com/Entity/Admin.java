package com.Entity;

import java.util.List;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin_login")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long AdminId;
	@Column(unique = true)
	String adminusername;
	String adminpassword;
	String adminrole;
	String adminimgurl;

	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	List<Book> blist;

	@OneToMany(mappedBy = "stud", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	List<Student> student;

	public Admin() {
		super();
	}

	public Admin(Long adminId, String adminusername, String adminpassword, String adminrole, String adminimgurl,
			List<Book> blist, List<Student> student) {
		super();
		AdminId = adminId;
		this.adminusername = adminusername;
		this.adminpassword = adminpassword;
		this.adminrole = adminrole;
		this.adminimgurl = adminimgurl;
		this.blist = blist;
		this.student = student;
	}

	public Long getAdminId() {
		return AdminId;
	}

	public void setAdminId(Long adminId) {
		AdminId = adminId;
	}

	public String getAdminusername() {
		return adminusername;
	}

	public void setAdminusername(String adminusername) {
		this.adminusername = adminusername;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

	public String getAdminrole() {
		return adminrole;
	}

	public void setAdminrole(String adminrole) {
		this.adminrole = adminrole;
	}

	public String getAdminimgurl() {
		return adminimgurl;
	}

	public void setAdminimgurl(String adminimgurl) {
		this.adminimgurl = adminimgurl;
	}

	public List<Book> getBlist() {
		return blist;
	}

	public void setBlist(List<Book> blist) {
		this.blist = blist;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

//	public Admin() {
//		super();
//	}
//
//	public Admin(Long adminId, String adminusername, String adminpassword, String adminrole, String adminimgurl) {
//		super();
//		AdminId = adminId;
//		this.adminusername = adminusername;
//		this.adminpassword = adminpassword;
//		this.adminrole = adminrole;
//		this.adminimgurl = adminimgurl;
//	}
//
//	public Long getAdminId() {
//		return AdminId;
//	}
//
//	public void setAdminId(Long adminId) {
//		AdminId = adminId;
//	}
//
//	public String getAdminusername() {
//		return adminusername;
//	}
//
//	public void setAdminusername(String adminusername) {
//		this.adminusername = adminusername;
//	}
//
//	public String getAdminpassword() {
//		return adminpassword;
//	}
//
//	public void setAdminpassword(String adminpassword) {
//		this.adminpassword = adminpassword;
//	}
//
//	public String getAdminrole() {
//		return adminrole;
//	}
//
//	public void setAdminrole(String adminrole) {
//		this.adminrole = adminrole;
//	}
//
//	public String getAdminimgurl() {
//		return adminimgurl;
//	}
//
//	public void setAdminimgurl(String adminimgurl) {
//		this.adminimgurl = adminimgurl;
//	}

}
