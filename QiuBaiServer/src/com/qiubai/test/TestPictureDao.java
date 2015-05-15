package com.qiubai.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.qiubai.dao.PictureDao;
import com.qiubai.dao.impl.PictureDaoImpl;
import com.qiubai.entity.Picture;
import com.qiubai.server.PictureManager;
import com.qiubai.tool.DateUtils;

public class TestPictureDao {

	@Test
	public void test() {
		PictureDao pictureDao = new PictureDaoImpl();
		/*Picture picture = new Picture(2, "qiubaiadmin@163.com", "测试2",
				DateUtils.getCurrentTime(),"");

		PictureDao pictureDao = new PictureDaoImpl();
		System.out.println(pictureDao.addPicture(picture));*/
		
		/*PictureManager pictureManager = new PictureManager();
		String url = "http://www.u148.net/image/1";
		PictureDao pictureDao = new PictureDaoImpl();
		List<Picture> lists = pictureManager.getPictureByUrl(url);
		
		for(Picture picture:lists){
			System.out.println(pictureDao.addPicture(picture));
		}*/
		
//		System.out.println(pictureDao.getAllPicture().size());
//		System.out.println(pictureDao.getPictureByTitle("豆瓣多牛人，电影剧照下的神回复（下"));
		
		List<Picture> lists = pictureDao.getLimitPicture(0, 5);
//		List<Picture> lists = pictureDao.getAllPicture();
		for(Picture picture:lists){
			System.out.println(picture.toString());
			System.out.println(picture.getUserid());
			System.out.println("--------");
		}
	}
	
	@Test
	public void test1(){
		PictureDao pictureDao = new PictureDaoImpl();
		Picture picture = pictureDao.getPictureById(111);
		System.out.println(picture);
	}

}
