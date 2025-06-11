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
	String adminimgurl;
	Long admincontactno;
	String adminemail;
	String adminname;

	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	List<Book> blist;

	@OneToMany(mappedBy = "stud", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	List<Student> student;

	public Admin() {
		super();
	}

	public Admin(Long adminId, String adminusername, String adminpassword, String adminimgurl, Long admincontactno,
			String adminemail, String adminname, List<Book> blist, List<Student> student) {
		super();
		AdminId = adminId;
		this.adminusername = adminusername;
		this.adminpassword = adminpassword;
		this.adminimgurl = adminimgurl;
		this.admincontactno = admincontactno;
		this.adminemail = adminemail;
		this.adminname = adminname;
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

	public String getAdminimgurl() {
		return adminimgurl;
	}

	public void setAdminimgurl(String adminimgurl) {
		this.adminimgurl = adminimgurl;
	}

	public Long getAdmincontactno() {
		return admincontactno;
	}

	public void setAdmincontactno(Long admincontactno) {
		this.admincontactno = admincontactno;
	}

	public String getAdminemail() {
		return adminemail;
	}

	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
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

}
