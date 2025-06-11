package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Entity.Student;
import com.Service.StudentService;

@RestController
@RequestMapping("/Student")
@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins="*")
public class StudentController {

	@Autowired
	StudentService ser;

	@PostMapping("/savebook")
	public String savebook(@RequestBody List<Student> book) {
		return ser.savebook(book);
	}

	@GetMapping("/findall")
	public List<Student> findall() {
		return ser.findall();
	}

	@DeleteMapping("/deletebyid")
	public String deletebyid(Long id) {
		return ser.deletebyid(id);
	}

	@GetMapping("/findbyid")
	public Student findbyid(Long id) {
		return ser.findbyid(id);
	}

	@PostMapping("/login")
	public Student login(@RequestBody Student student) {
		return ser.loginStudent(student.getStudentusername(), student.getStudentpassword());

	}

//	  @GetMapping("/login")
//	    public Student login(Student loginRequest) {
//	        Student student = ser.loginStudent(loginRequest.getStudentusername(), loginRequest.getStudentpassword());
//	        return ser.loginStudent("Login successful for: " + student.getStudentusername(),student.getStudentpassword());
//	    }

}
