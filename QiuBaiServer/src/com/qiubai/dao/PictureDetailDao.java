package com.qiubai.dao;

import java.util.List;

import com.qiubai.entity.PictureDetail;

public interface PictureDetailDao {

	/**
	 * 增加图片的详细内容
	 * @param pictureDetail
	 * @return
	 */
	public boolean addPictureDetail(PictureDetail pictureDetail);
	
	/**
	 * 通过id查找是否已经存在PictureDetail
	 * @param id
	 * @return
	 */
	public boolean getPictureById(int id);
	
	
	/**
	 * 通过id查找该id全部的图片信息
	 * @param id
	 * @return
	 */
	public List<PictureDetail> getPictureDetailsByid(int id,int offset,int rows);
}
