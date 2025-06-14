package com.dto;

public class AdminDTO {

	String adminusername;
	String adminpassword;

	public AdminDTO() {
		super();
	}

	public AdminDTO(String adminusername, String adminpassword) {
		super();
		this.adminusername = adminusername;
		this.adminpassword = adminpassword;
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

}
