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

	Long sid;
	@Column(unique = true, name = "Username")
	String studentusername;
	@Column(name = "Password")
	String studentpassword;
	Long scontactno;
	String semail;
	String studentname;
	String classname;
	String address;
	String imgurl;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference(value = "student-books")
	List<Book> blist;

	@ManyToOne
	@JoinColumn(name = "aid")
	@JsonBackReference
	Admin stud;

	public Student() {
		super();
	}

	public Student(Long sid, String studentusername, String studentpassword, Long scontactno, String semail,
			String studentname, String classname, String address, String imgurl, List<Book> blist, Admin stud) {
		super();
		this.sid = sid;
		this.studentusername = studentusername;
		this.studentpassword = studentpassword;
		this.scontactno = scontactno;
		this.semail = semail;
		this.studentname = studentname;
		this.classname = classname;
		this.address = address;
		this.imgurl = imgurl;
		this.blist = blist;
		this.stud = stud;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
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

	public Long getScontactno() {
		return scontactno;
	}

	public void setScontactno(Long scontactno) {
		this.scontactno = scontactno;
	}

	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public List<Book> getBlist() {
		return blist;
	}

	public void setBlist(List<Book> blist) {
		this.blist = blist;
	}

	public Admin getStud() {
		return stud;
	}

	public void setStud(Admin stud) {
		this.stud = stud;
	}

}
