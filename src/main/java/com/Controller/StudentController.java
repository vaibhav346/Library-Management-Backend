package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@PostMapping("/savedtud")
	public String savebook(@RequestBody Student stud) {
		return ser.savestud(stud);
	}

	@GetMapping("/findall")
	public List<Student> findall() {
		return ser.findall();
	}

	@DeleteMapping("/deletebyid")
	public String deletebyid(Long id) {
		return ser.deletebyid(id);
	}

	@GetMapping("/findbyid/{id}")
	public Student findbyid(@PathVariable Long id) {
		return ser.findbyid(id);
	}

	@PostMapping("/login")
	public Student login(@RequestBody Student student) {
		return ser.loginStudent(student.getStudentusername(), student.getStudentpassword());

	}

	  @PutMapping("/update/{sid}")
	    public ResponseEntity<Student> updateStudentById(
	            @PathVariable Long sid,
	            @RequestBody Student updatedStudent) {
	        Student updated = ser.updateStudentById(sid, updatedStudent);
	        return ResponseEntity.ok(updated);
	    }
	  
	  @GetMapping("/findbyname/{name}")
	  public List<Student> findbyname (@PathVariable String name){
		  return ser.findbyname(name);
	  }

}
