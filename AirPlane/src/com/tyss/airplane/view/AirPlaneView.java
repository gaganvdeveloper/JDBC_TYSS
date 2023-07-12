package com.tyss.airplane.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.tyss.airplane.dao.AirPlaneDao;
import com.tyss.airplane.model.AirPlane;

public class AirPlaneView {

	private static AirPlaneDao dao = new AirPlaneDao();
	private static Scanner sc = new Scanner(System.in);

	public void saveAirPlane() {
		AirPlane a = new AirPlane();
		System.out.println("Enter AirPlane Id : ");
		a.setId(sc.nextInt());
		System.out.println("Enter Name : ");
		a.setName(sc.next());
		System.out.println("Enter Sitting_Capacity : ");
		a.setSitting_Capacity(sc.nextInt());
		System.out.println("Enter Max-Speed : ");
		a.setMax_Speed(sc.nextInt());
		System.out.println("Enter Number Of Engins..");
		a.setNo_Of_Engines(sc.nextInt());
		System.out.println("Enter Weight In KG's... ");
		a.setWeight(sc.nextInt());
		System.out.println("Enter Fuel-Capacity");
		a.setFuel_Capacity(sc.nextInt());
		dao.saveAirPlane(a);
		System.out.println("AirPlane SavedSuccessfully...");

	}

	public void UpdateAirPlaneName() {
		System.out.println("Enter AirPlane ID : ");
		int id = sc.nextInt();
		AirPlane ap = dao.findById(id);
		if (ap == null) {
			System.err.println("Invalid ID : " + id);
			return;
		}
		System.out.println("Update AirPlane Name : ");
		String name = sc.next();
		dao.updateAirPlaneName(id, name);
		System.out.println("AirPlane Price Update Successfully...");

	}

	public void findAirPlaneById() {
		System.out.println("Enter AirPlane ID : ");
		int id = sc.nextInt();
		AirPlane ap = dao.findById(id);
		if (ap == null)
			System.out.println("Invalid AirPlane ID " + id);
		else {
			System.out.println(ap);
		}
	}

	public void findAllAirPLane() {
		ArrayList<AirPlane> list = dao.findAll();
		for (AirPlane a : list)
			System.out.println(a + "\n");
	}

	public void deleteAirPlaneById() {
		System.out.println("Enter AirPlane ID to delete : ");
		if (dao.deleteById(sc.nextInt())) {
			System.out.println("AirPlane Deleted Successfully...");
		} else
			System.err.println("Invalid Id");
	}

	public void sortByName() {
		System.out.println(dao.sortByName());
	}

}
