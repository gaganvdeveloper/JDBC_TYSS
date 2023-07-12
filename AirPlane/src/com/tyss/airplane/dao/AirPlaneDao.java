package com.tyss.airplane.dao;

import java.util.ArrayList;
import java.util.Collections;

import com.tyss.airplane.model.AirPlane;
import com.tyss.airplane.sorting.MyNameSorting;

public class AirPlaneDao {

	private static ArrayList<AirPlane> list = new ArrayList<>();

	public void saveAirPlane(AirPlane a) {
		if (findById(a.getId()) == null)
			list.add(a);
	}

	public boolean updateAirPlaneName(int id, String name) {
		AirPlane ap = findById(id);
		if (ap != null) {
			ap.setName(name);
			return true;
		}
		return false;
	}

	public AirPlane findById(int id) {
		for (AirPlane ap : list) {
			if (ap.getId() == id)
				return ap;
		}
		return null;
	}

	public ArrayList<AirPlane> findAll() {
		return list;
	}

	public boolean deleteById(int id) {
		for (AirPlane a : list) {
			if (a.getId() == id) {
				list.remove(a);
				return true;
			}
		}
		return false;
	}

	public ArrayList<AirPlane> sortByName() {
		Collections.sort(list, new MyNameSorting());
		return list;
	}

}
