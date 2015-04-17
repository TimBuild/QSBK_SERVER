package com.qiubai.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qiubai.dao.CommentDao;
import com.qiubai.dao.UserDao;
import com.qiubai.dao.impl.CommentDaoImpl;
import com.qiubai.dao.impl.UserDaoImpl;
import com.qiubai.entity.Comment;
import com.qiubai.entity.CommentWithUser;
import com.qiubai.entity.User;

@Path("CommentService")
public class CommentService {
	
	private UserDao userDao = new UserDaoImpl();
	private CommentDao commentDao = new CommentDaoImpl();
	
	@POST
	@Path("/addComment/{token}")
	@Produces({ MediaType.TEXT_PLAIN })
	public String addComment(@PathParam("token") String token, 
			@FormParam("newsid") String newsid, 
			@FormParam("userid") String userid,
			@FormParam("content") String content){
		System.out.println("ok");
		if(verifyCommentInformation(token, newsid, userid, content)){
			User user = userDao.getUser(userid);
			if( token.equals(user.getToken()) ){
				return "fail";
			} else {
				Comment comment = new Comment();
				comment.setNewsid(Integer.parseInt(newsid));
				comment.setUserid(userid);
				comment.setContent(content);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = sdf.format(System.currentTimeMillis());
				comment.setTime(time);
				if(commentDao.addComment(comment)){
					return "success";
				} else {
					return "fail";
				}
			}
		} else {
			return "fail";
		}
	}
	
	public boolean verifyCommentInformation(String token, String newsid, String userid, String content){
		if("".equals(token.trim()) || "".equals(newsid.trim()) || "".equals(userid.trim()) || "".equals(content.trim())){
			return false;
		} else if (content.trim().length() > 500){
			return false;
		} else {
			return true;
		}
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
