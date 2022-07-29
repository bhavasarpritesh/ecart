package com.bbd.pritesh.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bbd.pritesh.model.User;

public interface IUserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String Email);
	boolean existsByEmail(String email);
	@Modifying
	@Query("UPDATE User SET password=:password WHERE email=:email")
    void updatePassword(String password,String email);
	@Query("SELECT COUNT(*) FROM User")
	Integer getUserCount();
	@Query("SELECT u.name FROM User u WHERE u.email=:email")
	String getUserName(String email);
	@Query("SELECT u.mobile FROM User u WHERE u.email=:email")
	Long getUserMobile(String email);
	@Modifying
	@Query("UPDATE User SET name=:name,mobile=:mobile WHERE email=:email")
    void updateProfile(String name,String email,Long mobile);
}
