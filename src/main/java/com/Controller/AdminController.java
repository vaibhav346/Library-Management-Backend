package com.Controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Admin;
import com.Service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

	@Autowired
	AdminService adminser;

	@PostMapping("/save")
	public String save(@RequestBody Admin admin) {
		return adminser.save(admin);

	}

	@GetMapping("/findbyid/{id}")
	public Admin findbyid(@PathVariable Long id) {
		return adminser.findbyid(id);
	}

	@PutMapping("/updatebyid/{id}")
	public String updatebyid(@PathVariable Long id,@RequestBody Admin newdata) {
		return adminser.updatebyid(id, newdata);
	}

	@PostMapping("/login")
	public Admin login(@RequestBody Admin admin) {
		return adminser.login(admin.getAdminusername(), admin.getAdminpassword());
	}

}
