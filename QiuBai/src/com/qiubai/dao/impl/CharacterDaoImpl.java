package com.qiubai.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.qiubai.dao.CharacterDao;
import com.qiubai.entity.Character;
import com.qiubai.tool.C3P0DBConnectionPool;
import com.qiubai.tool.ReadProperties;

public class CharacterDaoImpl implements CharacterDao {

	private QueryRunner queryRunner = new QueryRunner();

	@Override
	public boolean addCharacter(Character character) {
		Connection conn = (Connection) C3P0DBConnectionPool.getConnection();

		try {
			conn.setAutoCommit(false);
			int ret = -1;
			ret = queryRunner.update(conn,
					ReadProperties.read("sql", "addCharacter"),
					character.getUserid(), character.getChar_title(),
					character.getChar_context(), character.getChar_time());
			if (ret > 0) {
				conn.commit();
				return true;
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
