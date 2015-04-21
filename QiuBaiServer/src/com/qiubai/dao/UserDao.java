package com.qiubai.dao;

import com.qiubai.entity.User;

public interface UserDao {

	/**
	 * user login
	 * 
	 * @param userid
	 * @param password
	 * @return
	 */
	public User login(String userid, String password);

	/**
	 * get user via userid
	 * 
	 * @param userid
	 * @return
	 */
	public User getUser(String userid);

	/**
	 * use register
	 * 
	 * @param user
	 * @return
	 */
	public boolean register(User user);
	
	/**
	 * get user include password
	 * @param userid
	 * @return
	 */
	public User getUserIncludePassword(String userid);
	
	/**
	 * change nickname
	 * @param userid
	 * @param nickname
	 * @return true: success; false: fail
	 */
	public boolean changeNickname(String userid, String nickname);
}
