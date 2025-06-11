package com.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Entity.Student;
import com.Repository.StudentRepository;

@Service
public class StudentService {

//	private static final String UPLOAD_DIR = "uploads/";
	@Autowired
	StudentRepository srep;

	public String savebook(List<Student> stu) {
		srep.saveAll(stu);
		return "Student book added sucessfull";

	}

	public List<Student> findall() {
		return srep.findAll();
	}

	public String deletebyid(Long id) {
		srep.deleteById(id);
		return "Record deleted sucessfully";
	}

	public Student findbyid(Long id) {
		return srep.findById(id).orElse(null);
	}

	public Student loginStudent(String Username, String Password) {
		return srep.findByStudentusernameAndStudentpassword(Username, Password)
				.orElseThrow(() -> new RuntimeException("Invalid credentials"));
	}
}
