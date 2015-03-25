package com.qiubai.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.qiubai.dao.CharacterDao;
import com.qiubai.dao.impl.CharacterDaoImpl;
import com.qiubai.entity.Character;
import com.qiubai.server.CharacterManager;

public class TestCharacterDao {

	@Test
	public void test() {
		CharacterDao characterDao = new CharacterDaoImpl();
		/*Character character = new Character();
		character.setUserid(22);
		character.setChar_title("测试");
		character.setChar_time(new Date());
		character.setChar_context("视神经低级到基金帝王家地位及低价位i家地位将低价位ID积极为降低为降低叫哦我京东网建瓯的禁卫军");
		
		boolean addFlag = characterDao.addCharacter(character);
		System.out.println(addFlag);*/
		
		//加入到数据库中
		/*CharacterManager cm = new CharacterManager();
		List<Character> characters = cm.getByUrl("http://www.pengfu.com/xiaohua_1.html");
		for(Character character:characters){
			if(characterDao.getCharacterByTitle(character.getChar_title())){
				return;
			}
			
			characterDao.addCharacter(character);
		}*/
		
	//	System.out.println(characterDao.getCharacter("我aa"));
		
		System.out.println(characterDao.getCharacter().get(2).getChar_context());
	}

}
