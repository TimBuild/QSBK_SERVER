package com.qiubai.service;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qiubai.dao.UserDao;
import com.qiubai.dao.impl.UserDaoImpl;
import com.qiubai.entity.User;
import com.qiubai.util.JavaMail;

@Path("/UserService")
public class UserService {

	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * user register
	 * @param email
	 * @param nickname
	 * @param password
	 * @return
	 */
	@POST
	@Path("/register")
	@Produces(value = MediaType.TEXT_PLAIN)
	public String register(@FormParam("email") String email,
			@FormParam("nickname") String nickname,
			@FormParam("password") String password) {
		if(verifyRegisterInformation(email, nickname, password)){
			if(userDao.getUser(email) != null){
				return "exist";
			} else {
				User user = new User();
				user.setUserid(email);
				user.setNickname(nickname);
				user.setPassword(password);
				user.setIcon("null");
				user.setToken(UUID.randomUUID().toString());
				if(userDao.register(user)){
					return "success";
				} else {
					return "fail";
				}
			}
		} else {
			return "fail";
		}
	}
	
	public boolean verifyRegisterInformation(String email, String nickname, String password){
		String regex = "^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if("".equals(email.trim()) || !matcher.matches()){
			return false;
		} else if("".equals(nickname.trim()) || nickname.trim().length() > 10 || nickname.trim().length() < 3) {
			return false;
		} else if("".equals(password) || password.length() > 20 || password.length() < 6){
			return false;
		} else {
			return true;
		}
	}
	
	@POST
	@Path("/login")
	@Produces({ MediaType.APPLICATION_JSON })
	public User login(@FormParam("userid") String userid,
			@FormParam("password") String password) {
		if(verifyLoginInformation(userid, password)){
			return userDao.login(userid, password);
		} else {
			return null;
		}
	}
	
	public boolean verifyLoginInformation(String email, String password){
		String regex = "^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if("".equals(email.trim()) || !matcher.matches()){
			return false;
		} else if("".equals(password)) {
			return false;
		} else {
			return true;
		}
	}
	
	@POST
	@Path("/forgetPassword")
	@Produces({ MediaType.TEXT_PLAIN })
	public String forgetPassword(@FormParam("userid") String userid){
		if(verifyForgetPasswordInformation(userid)){
			User user = userDao.getUserIncludePassword(userid);
			if(user != null){
				JavaMail javaMail = new JavaMail();
				if(javaMail.sendEmail("糗事百科", "糗事百科" + "<br/>尊敬的：" + user.getNickname() + 
						"<br/>您的密码为：" + user.getPassword() + "<br/>请立即登录糗百手机客户端修改密码。", user.getUserid())){
					return "success";
				} else {
					return "fail";
				}
			} else {
				return "fail";
			}
		} else {
			return "fail";
		}
	}
	
	public boolean verifyForgetPasswordInformation(String email){
		String regex = "^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if("".equals(email.trim()) || !matcher.matches()){
			return false;
		} else {
			return true;
		}
	}
	
}
