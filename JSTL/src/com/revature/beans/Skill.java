package com.revature.beans;

import java.util.Arrays;

public class Skill {
	
	private int id;
	private String skill;
	private short coolnessFactor;
	private String[] trainers;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public short getCoolnessFactor() {
		return coolnessFactor;
	}
	public void setCoolnessFactor(short coolnessFactor) {
		this.coolnessFactor = coolnessFactor;
	}
	public String[] getTrainers() {
		return trainers;
	}
	public void setTrainers(String[] trainers) {
		this.trainers = trainers;
	}
	public Skill() {
		super();
	}
	public Skill(int id, String skill, short coolnessFactor, String[] trainers) {
		super();
		this.id = id;
		this.skill = skill;
		this.coolnessFactor = coolnessFactor;
		this.trainers = trainers;
	}
	@Override
	public String toString() {
		return "Skill [id=" + id + ", skill=" + skill + ", coolnessFactor=" + coolnessFactor + ", trainers="
		    + Arrays.toString(trainers) + "]";
	}
}
