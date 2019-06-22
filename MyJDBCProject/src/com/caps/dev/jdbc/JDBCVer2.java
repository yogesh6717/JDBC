package com.caps.dev.jdbc;
import java.sql.*;

public class JDBCVer2 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt  = null;
		ResultSet rs = null;

		try {
			//Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Get the Connection
			String url="jdbc:mysql://localhost:3306/caps_mumbai"+"?user=root&password=root";
			conn = DriverManager.getConnection(url);
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
		} catch (Exception e) {
			e.printStackTrace();
		}	finally
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
