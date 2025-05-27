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

	private static final String UPLOAD_DIR = "student-images";

	public String registerStudentWithImage(String username, String password, String role, MultipartFile image)
			throws Exception {
		// Generate unique filename
		String imageName = UUID.randomUUID().toString() + "_" + image.getOriginalFilename();

		// Ensure directory exists
		Path uploadPath = Paths.get(UPLOAD_DIR);
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		// Save the image to disk
		Path imagePath = uploadPath.resolve(imageName);
		Files.copy(image.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);

		// Create image URL (accessible path, like "/student-images/filename.jpg")
		String imageUrl = "/student-images/" + imageName;

		// Save student data
		Student stu = new Student();
		stu.setStudentusername(username);
		stu.setStudentpassword(password);
		stu.setRole(role);
		stu.setImgurl(imageUrl);
		srep.save(stu);

		return imageUrl;
	}

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

	public String updatebyid(Long id, Student newdata) {
		Student existing = new Student();
		existing = srep.findById(id).orElse(null);
		if (existing == null) {
			return "Record not match for this data base";
		}
		if (newdata.getUserId() == 0.0 && newdata.getStudentusername() == null && newdata.getStudentpassword() == null
				&& newdata.getRole() == null && newdata.getImgurl() == null) {
			return "New data is not provided for the old data updataion";
		}

		if (newdata.getStudentusername() != null) {
			existing.setStudentusername(newdata.getStudentusername());
		}

		if (newdata.getStudentpassword() != null) {
			existing.setStudentpassword(newdata.getStudentpassword());
		}

		if (newdata.getRole() != null) {
			existing.setRole(newdata.getRole());
		}
		if (newdata.getImgurl() != null) {
			existing.setImgurl(newdata.getImgurl());
		}
		srep.save(existing);
		return "Record Updated Sucessfully";
	}

	public Student loginStudent(String Username, String Password) {
		return srep.findByStudentusernameAndStudentpassword(Username, Password)
				.orElseThrow(() -> new RuntimeException("Invalid credentials"));
	}
}
