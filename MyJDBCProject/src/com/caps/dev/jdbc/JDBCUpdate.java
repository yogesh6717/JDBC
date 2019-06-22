package com.caps.dev.jdbc;
import java.sql.*;
import java.util.*;

//THis program will Update the Databse
public class JDBCUpdate {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Load the Driver

			java.sql.Driver div = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(div);
			System.out.println("Driver Loaded...");
			//Get Connection via Driver

			String url = "jdbc:mysql://127.0.0.1:3306/caps_mumbai";
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter user : ");
			String user = sc.nextLine();
			System.out.println("Enter password : ");
			String password = sc.nextLine();
			conn =DriverManager.getConnection(url, user, password);

			System.out.println("Connection Established.....");
			//Issue SQL Query via Conn
			
			String query = "UPDATE users_info"
					+" SET username = ?,email = ?"
					+" WHERE user_id = ? AND password = ?";
			pstmt = conn.prepareStatement(query); 
			System.out.println("Enter UserID and Password to Update ur Data");
			System.out.println("Enter user_id :" );
			int userid = Integer.parseInt(sc.nextLine());
			

			System.out.println("Enter Password :");
			String passwd = sc.nextLine();
		
			
			System.out.println("Enter new Username :");
			String username = sc.nextLine();
			

			System.out.println("Enter new Email :");
			String email = sc.nextLine();

		
			pstmt.setInt(3, userid);
			pstmt.setString(1, username);
			pstmt.setString(2, email);
			pstmt.setString(4, passwd);
			
			int i = pstmt.executeUpdate();
			if(i>=1)
			{
			
			System.out.println("Data Updated....");
			}
			else
			{
				System.out.println("Failed to Update Data...");
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
