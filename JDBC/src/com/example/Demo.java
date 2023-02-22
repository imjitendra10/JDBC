package com.example;

//import java.lang.invoke.StringConcatFactory;

/*step to follow to connect java application with the database
 * 1. import the package --> java.sql.*;
 * 2. load and register the driver --> com.mysql.jdbc.driver
 * 3. establish the connection
 * 4. create the statement
 * 5. execute the query
 * 6. process the results
 * close the connection
 */

import java.sql.*;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/learndb";
		String uname = "root";
		String password = "root";
		String query = "select * from employee";
		// to inert data -->
	// 	String query = "insert into employee values (7, 'Monika', 'Rawat', 'Karad', 5363)";
		Connection con = DriverManager.getConnection(url, uname, password);
		Statement stmt = con.createStatement();
		
				 // to fetch the data from the database 
		  ResultSet rs =  stmt.executeQuery(query);
		//  while (rs.next()) // to print all the rows
		  //{
		    rs.next(); // to print single rows
		 String userData = rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3) + " : " +rs.getString(4); 
	//	 String userData1 = rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3) + " : " +rs.getString(4); 
		  
		  
		  System.out.println(userData);
	//	  System.out.println(userData1);
		//  }
		 

		// To insert the data into database
	//	int count = stmt.executeUpdate(query);
		//System.out.println(count);
		stmt.close();
		con.close();

	}

}
