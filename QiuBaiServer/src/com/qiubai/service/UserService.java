package com.qiubai.service;

import java.util.UUID;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService {

	/**
	 * user register
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@POST
	@Path("/register")
	@Produces(value = MediaType.TEXT_PLAIN)
	public String register(@FormParam("email") String email,
			@FormParam("nickname") String nickname,
			@FormParam("password") String password) {
		System.out.println(email);
		System.out.println(nickname);
		System.out.println(password);

		return "success";
	}

	@POST
	@Path("/login")
	@Produces(value = MediaType.TEXT_PLAIN)
	public String login(@FormParam("email") String email,
			@FormParam("password") String password) {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}
}
