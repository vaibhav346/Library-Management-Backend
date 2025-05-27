package com.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
	Optional<Admin> findByAdminusernameAndAdminpassword(String adminusername, String Adminpassword );

}
