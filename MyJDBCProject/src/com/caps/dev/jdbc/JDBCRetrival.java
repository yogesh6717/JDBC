package com.caps.dev.jdbc;
import java.sql.*;

import java.sql.SQLException;
//This program will Retrieve/Read the  Data into Database

public class JDBCRetrival {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			//Load the Driver
			java.sql.Driver div = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(div);
			System.out.println("Driver Loaded....");
			//Get the DB connection via Dirver

			String url = "jdbc:mysql://localhost:3306/caps_mumbai"+"?user=root&password=root";
			conn = DriverManager.getConnection(url);
			System.out.println("Connection Established....");
			//Issue SQL Query via connection
			String query = "SELECT * FROM users_info";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("Query Issued...");
			System.out.println("***********************");

			//Process the Results
			while(rs.next())
			{
				int userid = rs.getInt("user_id");
				String username = rs.getString("username");
				String email = rs.getString("email");

				System.out.println(userid);
				System.out.println(username);
				System.out.println(email);

				//	System.out.println(rs.next());
				System.out.println("========================");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
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
