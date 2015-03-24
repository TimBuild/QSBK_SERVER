package com.qiubai.test;

import java.util.Date;

import org.junit.Test;

import com.qiubai.dao.CharacterDao;
import com.qiubai.dao.impl.CharacterDaoImpl;
import com.qiubai.entity.Character;

public class TestCharacterDao {

	@Test
	public void test() {
		CharacterDao characterDao = new CharacterDaoImpl();
		Character character = new Character();
		character.setUserid(22);
		character.setChar_title("测试");
		character.setChar_time(new Date());
		character.setChar_context("视神经低级到基金帝王家地位及低价位i家地位将低价位ID积极为降低为降低叫哦我京东网建瓯的禁卫军");
		
		boolean addFlag = characterDao.addCharacter(character);
		System.out.println(addFlag);
	}

}
