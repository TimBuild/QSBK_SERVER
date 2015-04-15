package com.qiubai.dao;

import com.qiubai.entity.User;

public interface UserDao {
	
	public User login(String userid, String password);
	public User getUser(String userid);
	public boolean register(User user);
}
