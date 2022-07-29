package com.bbd.pritesh.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbd.pritesh.jwt.AuthTokenFilter;
import com.bbd.pritesh.jwt.JwtTokenUtil;
import com.bbd.pritesh.model.UpdatePassword;
import com.bbd.pritesh.model.UpdatePasswordByUser;
import com.bbd.pritesh.model.UpdateProfile;
import com.bbd.pritesh.model.User;
import com.bbd.pritesh.repo.IUserRepo;
import com.bbd.pritesh.request.UserRequest;
import com.bbd.pritesh.response.Response;
import com.bbd.pritesh.response.UserResponse;
import com.bbd.pritesh.service.IUserService;
import com.bbd.pritesh.service.impl.UserDetailsImpl;
import com.bbd.pritesh.util.EmailUtil;


@RestController
@RequestMapping("/user")
@CrossOrigin("${cross}")
public class UserController {

	@Autowired
	private IUserService service;
	@Autowired
	private IUserRepo repo;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtils;
	@Autowired
	private EmailUtil emailUtil;
	 private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@PostMapping("/save")
	public ResponseEntity<Response> saveUser(@Valid @RequestBody User user){
	
		if(repo.existsByEmail(user.getEmail())){
			logger.info("Email "+user.getEmail()+" is already exists");
			return ResponseEntity.badRequest().body(Response.send("Email "+user.getEmail()+" is already exists", false));
		}
		User u=service.saveUser(user);
		logger.info("User register successfully with id="+u.getId());
		return new ResponseEntity<Response>(Response.send("User register successfully with id="+u.getId(), true),HttpStatus.CREATED );

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getOneUser(@PathVariable String id){
		User user=service.getUserByEmail(id);
		System.out.println(user);
		if(user!=null) {
			logger.info("Email is already exits");
			return new  ResponseEntity<Response>(Response.send("Email is already exits", true),HttpStatus.OK);
		}
		else {
			logger.info("Email is avaliable");
			return new  ResponseEntity<Response>(Response.send("Email is avaliable", false),HttpStatus.OK);
		}

	}

	@PutMapping("/update")
	public ResponseEntity<Response> updateUser(@RequestBody User user){
		User u=service.updateUser(user);
		logger.info("User update with id="+u.getId());
		return ResponseEntity.ok(Response.send("User update with id="+u.getId(), true));
	} 

	@DeleteMapping("/deleteone/{id}")
	public ResponseEntity<Response> deleteUser(@PathVariable Integer id){
		service.deleteUserById(id);
		return ResponseEntity.ok(Response.send("User deleted id="+id, true));

	}
	@PatchMapping("/updatepassword")
	public ResponseEntity<Response> updatePassword(@RequestBody UpdatePassword up){
		 service.updatePassword(up.getPassword(), up.getEmail());
		 logger.info("Password updated successfully");
		 return ResponseEntity.ok(Response.send("Password updated successfully", true));
	}
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> users=service.getAllUser();
		return ResponseEntity.ok(users);

	}
	@GetMapping("/getcount")
	public ResponseEntity<Integer> getAllUserCount(){
		return ResponseEntity.ok(service.getUserCount());

	}
	@GetMapping("/generateotp/{email}")
	public ResponseEntity<Response> getOtpForPassword(@PathVariable String email){
		Integer otp=0;
		if(!repo.existsByEmail(email)) {
			 logger.info("User with "+email+" email is not exist");
			return ResponseEntity.badRequest().body(Response.send("User with "+email+" email is not exist", false));
		}
		else {
			Random rnd = new Random();
		    int number = rnd.nextInt(999999);
		    otp=Integer.parseInt(String.format("%06d", number));
				String text = 
						"Hello User,"
						+ " OTP for password reset is= : " + otp +"";
				emailUtil.sendEmail(email, "Recover Password!!", text);
				 logger.info("otp has been generated for password recovery");
		    return ResponseEntity.ok(Response.send(otp.toString(), true));
		}
	

	}
	@GetMapping("/generate/{email}")
	public ResponseEntity<Response> getOtpForSignUp(@PathVariable String email){
		Integer otp=0;
		if(repo.existsByEmail(email)) {
			logger.info("User with "+email+" email is Already Exits");
			return ResponseEntity.badRequest().body(Response.send("User with "+email+" email is Already Exits", false));
		}
		else {
			Random rnd = new Random();
		    int number = rnd.nextInt(999999);
		    otp=Integer.parseInt(String.format("%06d", number));
				String text = 
						"Hello User,"
						+ " OTP for password sign up is= : " + otp +"";
				emailUtil.sendEmail(email, "Sign up!!", text);
				logger.info("otp has been generated for sign up");
		    return ResponseEntity.ok(Response.send(otp.toString(), true));
		}

	}
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserRequest userRequest) throws IOException, NullPointerException{
		if(!repo.existsByEmail(userRequest.getEmail())){
			logger.info("User with "+userRequest.getEmail()+" email is not exist");
			return ResponseEntity.badRequest().body(Response.send("User with "+userRequest.getEmail()+" email is not exist", false));
		}
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getEmail(), userRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtTokenUtils.generateJwtToken(authentication);
		logger.info("jwt token has genereated");
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String username=service.getUserName(userDetails.getEmail());
        Long mobile=service.getUserMobile(userDetails.getEmail());
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		UserResponse us=new UserResponse();
		us.setId(userDetails.getId());
		us.setToken(jwt);
		us.setUsername(userDetails.getUsername());
		us.setRoles(roles);
		us.setEmail(userDetails.getEmail());
		us.setName(username);
		us.setMobile(mobile);
		logger.info("login has been suceefully");
		return ResponseEntity.ok(us);
	}
	@PatchMapping("/updateprofile")
	public ResponseEntity<Response> updateProfile(@RequestBody UpdateProfile up){
		 service.updateProfile(up.getName(), up.getEmail(),up.getMobile());
		 logger.info("profile updated suceefully");
		 return ResponseEntity.ok(Response.send("Profile updated successfully", true));
	}
	@PatchMapping("/updatepasswordby")
	public ResponseEntity<Response> updatePasswordByUser(@RequestBody UpdatePasswordByUser up){
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(up.getEmail(), up.getPassword()));
			service.updatePassword(up.getNewPassword(), up.getEmail());
			logger.info("Password updated successfully");
			return ResponseEntity.ok(Response.send("Password updated successfully", true));
		
	}
	

}
