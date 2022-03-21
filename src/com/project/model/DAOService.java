package com.project.model;

import java.sql.ResultSet;

public interface DAOService {
public void connectDB();
public boolean verifyLogin(String email,String password);
public void insertReg(String name,String city,String email,String mobile);
public ResultSet getReg();
public void deleteReg(String email);
public void updateReg(String email,String mobile);

}
