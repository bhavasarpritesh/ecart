package com.bbd.pritesh.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bbd.pritesh.exception.UserAlredyExits;
import com.bbd.pritesh.exception.UserNotFound;
import com.bbd.pritesh.model.User;
import com.bbd.pritesh.repo.IUserRepo;
import com.bbd.pritesh.service.IUserService;


@Service
public class UserServiceImpl implements IUserService,UserDetailsService {

	@Autowired
	private IUserRepo repo;
	@Autowired
	private PasswordEncoder encoder;
	@Override
	public User saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		System.out.println(user);
		User u= repo.getById(user.getId());
		String p=u.getPassword();
		BeanUtils.copyProperties(user, u);
		System.out.println("service"+u);
		if(user.getPassword()!=null) {
		u.setPassword(encoder.encode(user.getPassword()));
		}
		else {
			u.setPassword(p);
		}
		return repo.save(u);
	}

	@Override
	public User getUserByEmail(String email) {
	  return repo.findByEmail(email).orElseThrow(()->new UserNotFound("user not found email="+email));
	
	}

	@Override
	public void deleteUserById(Integer id) {
		repo.deleteById(id);
		

	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		   User user = repo.findByEmail(email)
	                .orElseThrow(() -> new UsernameNotFoundException("User Not found with email: " + email));
	        return UserDetailsImpl.build(user);
	
	}

	@Transactional
	@Override
	public void updatePassword(String password, String email) {
	    getUserByEmail(email);
		String p=encoder.encode(password);
		System.out.println(p);
		 repo.updatePassword(p, email);
	}

	@Override
	public List<User> getAllUser() {
		return repo.findAll();
	}

	@Override
	public Integer getUserCount() {
			return repo.getUserCount();
	}

	@Override
	public String getUserName(String email) {
		return repo.getUserName(email);
		
	}

	@Override
	public Long getUserMobile(String email) {
		return repo.getUserMobile(email);
	}
    @Transactional
	@Override
	public void updateProfile(String name, String email, Long mobile) {
		repo.updateProfile(name, email, mobile);
		
	}
	

}
