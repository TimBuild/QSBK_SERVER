package com.qiubai.dao;

import java.util.List;

import com.qiubai.entity.Character;

public interface CharacterDao {
	/**
	 * 增加文字版块的标题和正文以及时间 userid,char_title,char_context,char_time
	 * 
	 * @param character
	 * @return
	 */
	public boolean addCharacter(Character character);
	
	/**
	 * 通过标题来检索数据库中有没有该记录
	 * @param char_title
	 * @return
	 */
	public boolean getCharacterByTitle(String char_title);
	
	
	public List<Character> getCharacter();

}
