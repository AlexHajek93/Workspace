package com.revature.sort;

import java.math.BigDecimal;
import java.util.Comparator;

public class Trainee implements Comparable<Trainee>{
	private int id;
	private String name;
	private BigDecimal salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public Trainee() {
		super();
	}
	public Trainee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Trainee(int id, String name, BigDecimal salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	/**
	 * This trainee will compare itself TO other trainee
	 * @param other
	 */
	public int compareTo(Trainee other) {
		//returns positive, this comes after
		//returns negative, this comes before
		//returns zero, the same
		return this.id-other.id;
	}
	
//	@Override
//	public int hashCode() {
//		int hash = id * name.charAt(0);
//		return hash;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if(!(obj instanceof Trainee))
//			return false;
//		Trainee other = (Trainee) obj;
//		if((this.id==other.id)&&(this.name.equals(other.name))&&(this.salary.equals(other.salary)))
//			return true;
//		return false;
//	}

	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainee other = (Trainee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}

	static class NameComparator implements Comparator<Trainee>{
		/**
		 * Comparator class can COMPARE two trainees
		 */
		@Override
		public int compare(Trainee one, Trainee other) {
			return one.name.compareTo(other.name);
		}
	}
}
