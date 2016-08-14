package com.revature.app;

import java.util.List;

import com.revature.bean.Track;
import com.revature.dao.TrackDAO;

public class App {
	public static void main(String[] args) {
		TrackDAO dao = new TrackDAO();
		List<Track> fromDB = dao.getAllTracks();
		for (Track t : fromDB) {
			System.out.println(t);
		}
//		Track t = dao.getTrackById(20);
//		System.out.println(t);
//		
//		dao.createGenre(new Genre(1,"Folk Metal"));
//		
//		dao.createCustomer("Rick", "Astley", "ra@gmail.com");
	}
}
