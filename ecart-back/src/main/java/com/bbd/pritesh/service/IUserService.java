package com.bbd.pritesh.service;

import java.util.List;

import com.bbd.pritesh.model.User;

public interface IUserService {
      User saveUser(User user);
      User updateUser(User user);
      User getUserByEmail(String email);
      void deleteUserById(Integer id);
      void updatePassword(String password,String email);
      List<User> getAllUser();
      Integer getUserCount();
      String getUserName(String email);
      Long getUserMobile(String email);
	  void updateProfile(String name, String email, Long mobile);
}
