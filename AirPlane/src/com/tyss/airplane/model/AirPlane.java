package com.tyss.airplane.model;

public class AirPlane {

	private int id;
	private String name;
	private int no_Of_Engines;
	private int sitting_Capacity;
	private int weight;
	private int max_Speed;
	private int fuel_Capacity;

	@Override
	public String toString() {
		return "AirPlane Details : \n  \nid=" + id + ",\n name=" + name + ",\n no_Of_Engines=" + no_Of_Engines
				+ ",\n sitting_Capacity=" + sitting_Capacity + ",\n weight=" + weight + ",\n max_Speed=" + max_Speed
				+ ",\n fuel_Capacity=" + fuel_Capacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFuel_Capacity() {
		return fuel_Capacity;
	}

	public void setFuel_Capacity(int fuel_Capacity) {
		this.fuel_Capacity = fuel_Capacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNo_Of_Engines() {
		return no_Of_Engines;
	}

	public void setNo_Of_Engines(int no_Of_Engines) {
		this.no_Of_Engines = no_Of_Engines;
	}

	public int getSitting_Capacity() {
		return sitting_Capacity;
	}

	public void setSitting_Capacity(int sitting_Capacity) {
		this.sitting_Capacity = sitting_Capacity;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getMax_Speed() {
		return max_Speed;
	}

	public void setMax_Speed(int max_Speed) {
		this.max_Speed = max_Speed;
	}

}
