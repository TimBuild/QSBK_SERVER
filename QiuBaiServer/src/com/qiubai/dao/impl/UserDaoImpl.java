package com.qiubai.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.qiubai.dao.UserDao;
import com.qiubai.entity.User;
import com.qiubai.tool.C3P0DBConnectionPool;
import com.qiubai.tool.ReadProperties;

public class UserDaoImpl implements UserDao{

	QueryRunner runner = new QueryRunner();
	
	@Override
	public User getUser(String userid) {
		Connection conn = (Connection) C3P0DBConnectionPool.getConnection();
		User user = null;
		try {
			user = runner.query(conn, ReadProperties.read("sql", "getUser"), new BeanHandler<>(User.class), userid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null || !conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public boolean register(User user) {
		Connection conn = (Connection) C3P0DBConnectionPool.getConnection();
		Object param[] = {user.getUserid(), user.getNickname(), user.getPassword(), user.getToken()}; 
		try {
			int result = runner.update(conn, ReadProperties.read("sql", "register"), param);
			if(result > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null || !conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public User login(String userid, String password) {
		Connection conn = (Connection) C3P0DBConnectionPool.getConnection();
		User user = null;
		try {
			user = runner.query(conn, ReadProperties.read("sql", "login"), new BeanHandler<User>(User.class), userid, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null || !conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

}
