package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Admin;
import com.Service.AdminService;

@RestController
@RequestMapping("/Admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

	@Autowired
	AdminService adminser;

	@PostMapping("/save")
	public String save(@RequestBody Admin admin) {
		return adminser.save(admin);

	}

	@GetMapping("/findall")
	public List<Admin> findalld() {
		return adminser.finall();
	}

	@GetMapping("/findbyid")
	public Admin findbyid(Long id) {
		return adminser.findbyid(id);
	}

	@DeleteMapping("/deletebyid/{id}")
	public String deletebyid(@PathVariable Long id) {
		return adminser.deltebyid(id);
	}
	
	@PostMapping("/adminlogin")
	public Admin adminlogin(@RequestBody Admin admin)
	{
		return adminser.loginAdmin(admin.getAdminusername(), admin.getAdminpassword());
	}

}
