package com.te.daoServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoLogin {
	public static boolean validate(String name,String pass){  
		boolean status=false;  
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db?user=root&password=root");  
		      
		PreparedStatement ps=con.prepareStatement("select * from UserDetails where name=? and pass=?");  
		ps.setString(1,name);  
		ps.setString(2,pass);  
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		          
		}catch(Exception e){
			e.printStackTrace();
			}  
		return status;  
		}  

}
