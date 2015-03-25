package com.qiubai.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qiubai.dao.CharacterDao;
import com.qiubai.dao.impl.CharacterDaoImpl;
import com.qiubai.entity.Character;
import com.qiubai.server.CharacterManager;
import com.qiubai.tool.ReadProperties;


@Path("/CharacterService")
public class CharacterService {
	
	private CharacterDao characterDao = new CharacterDaoImpl();
	
	
	@GET
	@Path("/getCharacters")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Character> getCharacters(){
		List<Character> chars = characterDao.getCharacter();
		return chars;
		
	}
	
	/**
	 * 定时的从网站上读数据，往数据库中添加
	 * @return
	 */
	@GET
	@Path("/addCharacter")
	@Produces(MediaType.TEXT_PLAIN)
	public String addCharacter(){
		
		CharacterManager cm = new CharacterManager();
		List<Character> characters = cm.getByUrl(ReadProperties.read("website", "pengfu_character"));
		for(Character character:characters){
			if(characterDao.getCharacterByTitle(character.getChar_title())){
				return "Exist";
			}
			
			characterDao.addCharacter(character);
		}
		return "success";
	}
}
