package com.revature.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Chinook {
//TNS name = Transparent Network Substrate
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	//        driver from^              ^^DNS      ^^port^^SID^
	static String user = "demo";
	static String pass = "demo";
	
	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		//forces the class to be loaded into memory
		//registered drivers in static block
		//Class.forName("oracle.jdbc.OracleDriver");//Prior to JDBC 4.0
		
		//after JDBC 4.0, self-registered Driver class
		Connection conn = DriverManager.getConnection(url,user,pass);
		String sql = "INSERT INTO TRACK(TRACKID,NAME,MEDIATYPEID,COMPOSER,MILLISECONDS,UNITPRICE)"+
				"VALUES(?,?,?,?,?,?)";
		
		//Statement stmt = conn.createStatement();
		//int rows = stmt.executeUpdate(sql);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 3705);
		pstmt.setString(2, "5 Minutes Alone");
		pstmt.setInt(3, 1);
		pstmt.setString(4, "Pantera");
		pstmt.setInt(5, 50000);
		pstmt.setDouble(6, 1.99);
		//PStatements escapes certain chars
		int rows = pstmt.executeUpdate();
		
		System.out.println(rows + " row(s) added.");
	}
}
