package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Admin;
import com.Repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository admin;

	public String save(Admin ad) {
		admin.save(ad);
		return "Admin save sucessfully";
	}

	public List<Admin> finall() {
		return admin.findAll();
	}

	public String deltebyid(Long id) {
		admin.deleteById(id);
		return "Admin delted sucessfully";
	}

	public Admin findbyid(Long id) {
		return admin.findById(id).orElse(null);
	}

	public String updatebyid(Long id, Admin newdata) {
		Admin existing = new Admin();
		existing = admin.findById(id).orElse(null);
		if (existing == null) {
			return "Record not match for thhis data base";
		}

		if (newdata.getAdminId() == 0 && newdata.getAdminusername() == null && newdata.getAdminpassword() == null
				&& newdata.getAdminrole() == null && newdata.getAdminimgurl() == null) {
			return "newdata data is not provided for the data updataion";
		}

		if (newdata.getAdminusername() != null) {
			existing.setAdminusername(newdata.getAdminusername());
		}

		if (newdata.getAdminpassword() != null) {
			existing.setAdminpassword(newdata.getAdminpassword());
		}
		if (newdata.getAdminrole() != null) {
			existing.setAdminrole(newdata.getAdminrole());
		}

		if (newdata.getAdminimgurl() != null) {
			existing.setAdminimgurl(newdata.getAdminimgurl());
		}
		admin.save(existing);
		return "Record updated sucessfully";
	}

	public Admin loginAdmin(String adminusername, String adminpassword) {
		return admin.findByAdminusernameAndAdminpassword(adminusername, adminpassword)
				.orElseThrow(() -> new RuntimeException("Invalid credentials"));
	}

}
