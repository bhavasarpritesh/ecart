package com.bbd.pritesh.model;

import lombok.Data;

@Data
public class UpdatePasswordByUser {
	private String email;
	private String password;
	private String newPassword;
}
