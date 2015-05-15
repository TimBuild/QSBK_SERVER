package com.qiubai.dao;

import java.util.List;

import com.qiubai.entity.Picture;

public interface PictureDao {

	
	/**
	 * 增加一个picture
	 * @param picture
	 * @return
	 */
	public boolean addPicture(Picture picture);
	
	/**
	 * 得到所有的Picture
	 * @return
	 */
	public List<Picture> getAllPicture();
	
	/**
	 * 通过标题来检索是不是数据库中已存在
	 * @param pic_title
	 * @return
	 */
	public boolean getPictureByTitle(String pic_title);
	
	/**
	 * 通过id找所有的数据
	 * @param id
	 * @return
	 */
	public Picture getPictureById(int id);
	
	/**
	 * 通过limit来查询所有的picture信息
	 * @param offset
	 * @param rows
	 * @return
	 */
	public List<Picture> getLimitPicture(int offset,int rows);
}
