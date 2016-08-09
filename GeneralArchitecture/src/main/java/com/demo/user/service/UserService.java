package com.demo.user.service;

import com.demo.bean.UserBean;


public interface UserService {
	public UserBean selectUser(UserBean userBean);
	public void insertUser(UserBean userBean);
}
