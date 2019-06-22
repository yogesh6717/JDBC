package com.caps.dev.jdbc;
import java.sql.*;
import java.util.*;
import java.sql.SQLException;
//This program will Retrieve/Read the  Data into Database


public class JDBCRetriveByUser {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
	//	PreparedStatement pstmt = null;
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

			System.out.println("Enter userID to Retrive Details of USer");
			int userid = Integer.parseInt(sc.nextLine());
			String query = "SELECT * FROM users_info"
					+" WHERE user_id="+userid;
			stmt = conn.createStatement();
			//pstmt = conn.prepareStatement(query);
			//System.out.println("Query Issued...");
			System.out.println("***********************");
			
			//Process the Results
			rs=stmt.executeQuery(query);
			if(rs.next())
			{
				int userid1 = rs.getInt(1);
				String username = rs.getString(2);
				String email = rs.getString(3);
				

				System.out.println(userid1);
				System.out.println(username);
				System.out.println(email);

				
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

