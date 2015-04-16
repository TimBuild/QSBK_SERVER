package com.qiubai.service;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qiubai.dao.CommentDao;
import com.qiubai.dao.impl.CommentDaoImpl;
import com.qiubai.entity.Comment;
import com.qiubai.entity.CommentWithUser;

@Path("CommentService")
public class CommentService {
	
	private CommentDao commentDao = new CommentDaoImpl();
	
	@POST
	@Path("/addComment/{token}")
	@Produces({ MediaType.TEXT_PLAIN })
	public String addComment(@PathParam("token") String token, 
			@FormParam("newsid") String newsid, 
			@FormParam("userid") String userid,
			@FormParam("content") String content){
		return null;
	}
	
	@POST
	@Path("/getComments")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<CommentWithUser> getComments(@FormParam("newsid") String newsid,
			@FormParam("offset") String offset, 
			@FormParam("length") String length){
		if("".equals(newsid) || "".equals(offset) || "".equals(length)){
			return null;
		} else {
			return commentDao.getComments(newsid, Integer.parseInt(offset), Integer.parseInt(length));
		}
	}
}
