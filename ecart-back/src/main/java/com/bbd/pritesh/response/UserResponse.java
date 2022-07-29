package com.bbd.pritesh.response;

import java.util.List;

import lombok.Data;

@Data
public class UserResponse {
	    private String token;
	    private int id;
	    private String username;
	    private String email;
	    private List<String> roles;
	    private String name;
	    private Long mobile;
}
