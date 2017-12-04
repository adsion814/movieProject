package com.mp.tools;

import java.util.ArrayList;
import java.util.List;

import com.mp.bean.User;




public class UserDao {
	private JDBCUtils util = JDBCUtils.getJDBC();
	public UserDao(){
		util.getConnection();
	}
	public boolean addUser(User ui) throws Exception{
		String sql = "INSERT INTO userinfo (uuid,email,password,identity,name) VALUES(?,?,?,2,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(ui.getUuid());
		params.add(ui.getEmail());
		params.add(ui.getPassword());
		params.add(ui.getName());
		boolean flag =  util.updateByPreparedStatement(sql, params);
		return flag;
	}
	public User checkLogin(String email,String password) throws Exception{
		String sql = "SELECT * FROM userinfo WHERE email = ? AND password = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(email);
		params.add(password);
		User ui = util.findSimpleRefResult(sql, params, User.class);
		return ui;
	}
	public User query(String email) throws Exception{
		String sql = "SELECT * FROM userinfo WHERE email = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(email);
		User ui = util.findSimpleRefResult(sql, params, User.class);
		return ui;
	}
}
