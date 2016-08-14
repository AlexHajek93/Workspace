package com.revature.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO {
	private static Map<Integer,Trainee> database = new HashMap<Integer,Trainee>();
	static{
		database.put(1, new Trainee(1,"Dan Pickles","IT"));
	}
	public void insert(Trainee obj){
		database.put(obj.getId(), obj);
	}
	public Trainee getById(int id){
		return database.get(id);
	}
	public List<Trainee> getAll(){
		return new ArrayList<Trainee>(database.values());
	}
}
