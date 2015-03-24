package com.qiubai.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qiubai.dao.CharacterDao;
import com.qiubai.dao.impl.CharacterDaoImpl;

public class TestCharacterDao {

	@Test
	public void test() {
		CharacterDao character = new CharacterDaoImpl();
//		boolean addFlag = character.addCharacter("123", "234", "333");
//		System.out.println(addFlag);
	}

}
