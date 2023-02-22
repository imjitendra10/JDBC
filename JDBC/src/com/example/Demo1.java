package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class Demo1 {
	public static void main(String[] args)throws ClassNotFoundException, SQLException {
	//try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/jkdb";
		String uname="root";
		String password="root";
		Connection con= DriverManager.getConnection(url, uname,password);
		
		//String q="create table table1(tId int(20) primary key auto_increment, tName varchar(26),tCity varchar(26))";
		String q1="insert into table1( tName, tcity) values(?,?)";
		PreparedStatement pstmt =con.prepareStatement(q1);
		
		pstmt.setString(1, "Jiten");
		pstmt.setString(2, "Mumbai");
		pstmt.setString(1, "Yash");
		pstmt.setString(2, "Pune");
		pstmt.executeUpdate();
	
		Statement stmt=con.createStatement();
	//	stmt.executeUpdate(q);
		
		System.out.println("Table is  created");
	
		
		if(con.isClosed()) {
			System.out.println("Connection is closed");
			
		}
		else {
			System.out.println("Connection is created");
		}
		con.close();
	//}
	//catch(Exception e) {
	
	//System.out.println(e);
		
	//}
		
		
}
}
