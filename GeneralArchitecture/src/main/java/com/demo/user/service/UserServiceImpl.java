package com.demo.user.service;

import org.springframework.stereotype.Service;

import com.demo.bean.UserBean;
import com.demo.user.dao.UserDao;
import com.demo.utils.BaseDao;

@Service
public class UserServiceImpl extends BaseDao implements UserService{
	

	public UserBean selectUser(UserBean userBean) {
		UserDao userDao = this.sqlSessionTemplate.getMapper(UserDao.class);
		userBean = userDao.selectUser(userBean);
		return userBean;
	}

	public void insertUser(UserBean userBean) {
		UserDao userDao = this.sqlSessionTemplate.getMapper(UserDao.class);
		userDao.insertUser(userBean);
	}

}
