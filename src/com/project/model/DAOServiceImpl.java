package com.project.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
private Connection con;
private Statement stmnt;

	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","test");
			stmnt=con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean verifyLogin(String email, String password) {
		try {
		ResultSet result=stmnt.executeQuery("select *from loginTable where email='"+email+"' and password='"+password+"'");
		return result.next();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public void insertReg(String name,String city,String email,String mobile) {
		try {
			stmnt.executeUpdate("insert into reg values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ResultSet getReg() {
		
	try {
		ResultSet result=stmnt.executeQuery("select *from reg");
		return result;
	}catch(Exception e) {
		e.printStackTrace();
	}
		return null;
	}

	@Override
	public void deleteReg(String email) {
		try {
			stmnt.executeUpdate("delete from reg where email='"+email+"'");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateReg(String email, String mobile) {
		try {
			stmnt.executeUpdate("update reg set mobile='"+mobile+"' where email='"+email+"'");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
