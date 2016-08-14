package com.revature.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sorting {
	private static Set<Trainee> classroom;
	static {
		classroom = new HashSet<Trainee>();
		classroom.add(new Trainee(1, "Dan"));
		classroom.add(new Trainee(2, "Nick"));
		classroom.add(new Trainee(3, "Justin"));
		classroom.add(new Trainee(4, "Valencia"));
		classroom.add(new Trainee(5, "Dominic"));
	}

	public static void main(String[] args) {
		Trainee.NameComparator comparator = new Trainee.NameComparator();
		List<Trainee> list = new ArrayList<Trainee>(classroom);
		
		//Collections.sort(list);
		Collections.sort(list,comparator);
		for (Trainee t : list)
			System.out.println(t);
	}
}
