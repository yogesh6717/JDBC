package com.caps.dev.jdbc;
import java.sql.*;
import java.util.*;
//This program will Delete the Data from Database
public class JDBCDelete {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Load the Driver

			java.sql.Driver div = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(div);
			System.out.println("Driver Loaded...");
			//Get Connection via Driver

			String url = "jdbc:mysql://localhost:3306/caps_mumbai";
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter user : ");
			String user = sc.nextLine();
			System.out.println("Enter password : ");
			String password = sc.nextLine();
			conn =DriverManager.getConnection(url, user, password);

			System.out.println("Connection Established.....");
			//Issue SQL Query via Conn
			
			String query = "DELETE FROM users_info "
					+"WHERE user_id = ? AND password= ?";
			pstmt = conn.prepareStatement(query); 

			System.out.println("Enter user_id :" );
			int userid = Integer.parseInt(sc.nextLine());
		
			System.out.println("Enter Password :");
			String passwd = sc.nextLine();
			
			pstmt.setInt(1, userid);
			pstmt.setString(2, passwd);

		
			
			int i = pstmt.executeUpdate();
			if(i>0)
			{
			
			System.out.println("Data Deleted...");
			}
			else
			{
				System.out.println("Failed to Delete Data...");
			}


		} catch (SQLException e) {
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
			if(pstmt!=null)
			{
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
			
		}



	}

}
