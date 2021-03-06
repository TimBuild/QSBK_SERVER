package com.qiubai.service;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qiubai.dao.PictureDao;
import com.qiubai.dao.PictureDetailDao;
import com.qiubai.dao.impl.PictureDaoImpl;
import com.qiubai.dao.impl.PictureDetailDaoImpl;
import com.qiubai.entity.Character;
import com.qiubai.entity.Picture;
import com.qiubai.entity.PictureDetail;
import com.qiubai.server.PictureDetailManager;
import com.qiubai.server.PictureManager;

@Path("/PictureService")
public class PictureService {
	
	private PictureDao pictureDao = new PictureDaoImpl();
	private PictureDetailDao pictureDetailDao = new PictureDetailDaoImpl();

	/**
	 * 先增加Picture
	 * @return
	 */
	/*@GET
	@Path("/addPicture")
	@Produces(MediaType.TEXT_PLAIN)
	public String addPicture() {

		PictureDao pictureDao = new PictureDaoImpl();

		PictureManager pictureManager = new PictureManager();
		String url = "http://www.u148.net/image/1";
		List<Picture> lists = pictureManager.getPictureByUrl(url);

		for (Picture picture : lists) {
			if (pictureDao.getPictureByTitle(picture.getPic_title())) {
				return "Exist";
			} else {
				pictureDao.addPicture(picture);
			}
		}

		return "success";
	}*/

	/**
	 * 然后再增加PictureDetail
	 * @return
	 */
	/*@GET
	@Path("/addPictureDetail")
	@Produces(MediaType.TEXT_PLAIN)
	public String addPictureDetail() {
		PictureDao pictureDao = new PictureDaoImpl();
		PictureDetailManager pictureDetailManager = new PictureDetailManager();
		PictureDetailDao pictureDetailDao = new PictureDetailDaoImpl();
		List<Picture> pictures = pictureDao.getAllPicture();
		
		for (Picture picture : pictures) {
			String pic_url = picture.getPic_extra();
			if (pic_url != null) {
				int id = picture.getId();
				if (!pictureDetailDao.getPictureById(id)) {
					List<PictureDetail> pictureDetails = pictureDetailManager
							.getPictureDetailByUrl(pic_url, id);
					for (PictureDetail pictureDetail : pictureDetails) {
						pictureDetailDao.addPictureDetail(pictureDetail);
					}
				}
			}
		}

		return "success";
	}*/
	
	
	@POST
	@Path("/getPictures")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Picture> getPictures(@FormParam("offset") String offset,
			@FormParam("rows") String rows) {

		List<Picture> pictures = pictureDao.getLimitPicture(
				Integer.parseInt(offset), Integer.parseInt(rows));
		if(pictures!=null){
			pictures.add(new Picture());
		}
		return pictures;

	}
	
	@POST
	@Path("/getPictureDetailsLimit")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<PictureDetail> getPictureDetail(@FormParam("id") String id,
			@FormParam("offset") String offset, @FormParam("rows") String rows) {
		List<PictureDetail> pictureDetails = pictureDetailDao
				.getPictureDetailsByid(Integer.parseInt(id),
						Integer.parseInt(offset), Integer.parseInt(rows));
		if (pictureDetails != null) {
			pictureDetails.add(new PictureDetail());
		}
		return pictureDetails;
	}
	
	@POST
	@Path("/getPictureById")
	@Produces({ MediaType.APPLICATION_JSON })
	public Picture getPictureById(@FormParam("id") String id) {
		Picture picture = pictureDao.getPictureById(Integer.parseInt(id));
		return picture;
	}
}
