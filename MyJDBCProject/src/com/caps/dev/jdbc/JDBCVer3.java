package com.caps.dev.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import java.sql.*;

public class JDBCVer3 {

	public static void main(String[] args) {
		//Load the Driver
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/caps_mumbai";
			String path = "E:/Yogesh/Java Application/db.properties"; 
			FileReader fr = new FileReader(path);
			Properties prop = new Properties();
			prop.load(fr);
			conn = DriverManager.getConnection(url,prop);
			System.out.println("Connection Established...");
			String query = "SELECT * FROM users_info";
			stmt=conn.createStatement();
			rs = stmt.executeQuery(query);

			while(rs.next())
			{
				int userid =rs.getInt("user_id");
				String username = rs.getString("username");
				String email = rs.getString("email");

				System.out.println(userid);
				System.out.println(username);
				System.out.println(email);
				
				System.out.println("********************");

			}


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//Get the Connection
 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
	{
	if(conn!=null)
	{
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if(stmt!=null)
	{
		try {
			stmt.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	if(rs!=null)
	{
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

	}

}
