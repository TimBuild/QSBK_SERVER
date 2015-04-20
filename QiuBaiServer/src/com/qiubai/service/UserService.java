package com.qiubai.service;

import java.util.UUID;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qiubai.dao.UserDao;
import com.qiubai.dao.impl.UserDaoImpl;
import com.qiubai.entity.User;
import com.qiubai.tool.VerifyInformationTool;
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
		if(VerifyInformationTool.verifyRegisterInformation(email, nickname, password)){
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
	
	/**
	 * login
	 * @param userid
	 * @param password
	 * @return
	 */
	@POST
	@Path("/login")
	@Produces({ MediaType.APPLICATION_JSON })
	public User login(@FormParam("userid") String userid,
			@FormParam("password") String password) {
		if(VerifyInformationTool.verifyLoginInformation(userid, password)){
			return userDao.login(userid, password);
		} else {
			return null;
		}
	}
	
	/**
	 * forget password
	 * @param userid
	 * @return
	 */
	@POST
	@Path("/forgetPassword")
	@Produces({ MediaType.TEXT_PLAIN })
	public String forgetPassword(@FormParam("userid") String userid){
		if(VerifyInformationTool.verifyForgetPasswordInformation(userid)){
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
	
}
