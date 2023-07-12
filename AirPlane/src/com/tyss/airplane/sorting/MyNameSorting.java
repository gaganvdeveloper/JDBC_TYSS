package com.tyss.airplane.sorting;

import java.util.Comparator;

import com.tyss.airplane.model.AirPlane;

public class MyNameSorting implements Comparator<AirPlane> {

	@Override
	public int compare(AirPlane o1, AirPlane o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
