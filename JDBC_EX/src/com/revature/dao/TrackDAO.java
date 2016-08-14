package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.revature.bean.Genre;
import com.revature.bean.Track;
import com.revature.service.ServiceLocator;

//SQL,PL/SQL,tables, columns, rows, etc.
public class TrackDAO {
	private Connection conn;
	static private Properties columns;
	static{
		columns = new Properties();
		try {
			columns.load(TrackDAO.class.getClassLoader().getResourceAsStream("track.properties"));
		} catch (IOException e) {e.printStackTrace();}
	}
	public TrackDAO(){
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "demo";
//		String pass = "demo";
		try{ 
			//conn = DriverManager.getConnection(url,user,pass);
			conn = ServiceLocator.getChinookDatabase().getConnection();
			conn.setAutoCommit(false);//Enable transactions
		}
		catch(Exception e){}
		//ACID properties
		//A: Atomic-all or nothing.
		//C: Consistent - fail? rollback... success? commit
		//I: Isolation - no concurrency issues.
		//D: Durable - (Not likely to deal with it) maintains integrity through physical errors
	}
	
	@Override
	protected void finalize() throws Throwable {
		if(conn != null && !conn.isClosed()) conn.close();
		super.finalize();
	}

	//Track is a Domain Obj,Java Bean
	public void createTrack(Track obj){
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO TRACK(TRACKID,NAME,COMPOSER,MILLISECONDS,UNITPRICE,BYTES)"+
				"VALUES(?,?,?,?,?,?)");
			pstmt.setInt(1, obj.getTrackid());
			pstmt.setString(2, obj.getName());
			pstmt.setString(3, obj.getComposer());
			pstmt.setInt(4, obj.getMilliseconds());
			pstmt.setDouble(5, obj.getUnitPrice());
			pstmt.setInt(6, obj.getBytes());
			pstmt.executeUpdate();
			conn.commit();
		} catch (Throwable e) {
			try {
				conn.rollback();
			} catch (SQLException e2) {
				 e2.printStackTrace();
			}
		}
	}
	public Track getTrackById(int id){
		try {
			Track obj;
			String query = "SELECT TRACKID,NAME,COMPOSER,MILLISECONDS,BYTES,UNITPRICE FROM TRACK WHERE TRACKID = ?";
			ResultSet rs;
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				obj = new Track(
						rs.getInt(columns.getProperty("id")),
						rs.getString(columns.getProperty("name")),
						rs.getString(columns.getProperty("composer")),
						rs.getInt(columns.getProperty("time")),
						rs.getInt(columns.getProperty("bytes")),
						rs.getDouble(columns.getProperty("price")));
				if(obj.getTrackid()==id) return obj;
			}
		} catch (Throwable e) {
			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	public List<Track> getAllTracks(){
		List<Track> trackList = new ArrayList<Track>();
		try {
			String query = "SELECT TRACKID,NAME,COMPOSER,MILLISECONDS,BYTES,UNITPRICE FROM TRACK";
			ResultSet rs;
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);//run query
			//OBJECT RELATIONAL MAPPING
			while(rs.next()){
				Track obj = new Track(
						rs.getInt(columns.getProperty("id")),
						rs.getString(columns.getProperty("name")),
						rs.getString(columns.getProperty("composer")),
						rs.getInt(columns.getProperty("time")),
						rs.getInt(columns.getProperty("bytes")),
						rs.getDouble(columns.getProperty("price")));
				trackList.add(obj);
			}
		} catch (Throwable e) {
			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return trackList;
	}
	public boolean updateTrack(Track obj){throw new UnsupportedOperationException();}
	public boolean deleteTrack(Track obj){throw new UnsupportedOperationException();}
	public void createGenre(Genre obj){
		try {
			String query = "INSERT INTO GENRE(NAME) VALUES(?)";
			PreparedStatement pstmt = conn.prepareStatement(query, new String[]{"GENREID"});
			pstmt.setString(1, obj.getName());
			int insertedRows = pstmt.executeUpdate();//run query
			if(insertedRows == 1){
				ResultSet rs = pstmt.getGeneratedKeys();
				while(rs!=null && rs.next()){
					int id = rs.getInt(1);
					System.out.println("Generated key was: "+id);
					obj.setId(id);
				}
			}
			conn.commit();
		} catch (Throwable e) {
			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	public void createCustomer(String fname,String lname,String email){
		//call a stored procedure
		try {
			int customerId = -1;
			String sql = "call PRO_NAME_UGLY(?,?,?,?)";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, fname);
			cstmt.setString(2, lname);
			cstmt.setString(3, email);
			cstmt.registerOutParameter(4, Types.INTEGER);
			cstmt.execute();
			
			customerId = cstmt.getInt(4);
			System.out.println("Procedure set customer ID to " +customerId);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
