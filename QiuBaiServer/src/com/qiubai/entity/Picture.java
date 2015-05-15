package com.qiubai.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Picture {

	private int id;
	private String userid;
	private String pic_title;
	private String pic_time;
	private String pic_extra;

	public Picture() {
		super();
	}

	public Picture(int id, String user_id, String pic_title, String pic_time,
			String pic_extra) {
		super();
		this.id = id;
		this.userid = user_id;
		this.pic_title = pic_title;
		this.pic_time = pic_time;
		this.pic_extra = pic_extra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPic_title() {
		return pic_title;
	}

	public void setPic_title(String pic_title) {
		this.pic_title = pic_title;
	}

	public String getPic_time() {
		return pic_time;
	}

	public void setPic_time(String pic_time) {
		this.pic_time = pic_time;
	}

	public String getPic_extra() {
		return pic_extra;
	}

	public void setPic_extra(String pic_extra) {
		this.pic_extra = pic_extra;
	}

	@Override
	public String toString() {
		return "Picture [id=" + id + ", userid=" + userid + ", pic_title="
				+ pic_title + ", pic_time=" + pic_time + ", pic_extra="
				+ pic_extra + "]";
	}

}
