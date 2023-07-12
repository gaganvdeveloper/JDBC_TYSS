package com.tyss.airplane.controller;

import java.util.Scanner;

import com.tyss.airplane.view.AirPlaneView;

public class AirPlaneController {

	public static void main(String[] args) {
		System.out.println("Welcome to AirPlane Application...");
		Scanner sc = new Scanner(System.in);
		AirPlaneView apv = new AirPlaneView();

		while (true) {
			System.out.println(
					"Select Option \n1) Save-AirPlane \n2) update-Airplane-Price \n3) find-AirPlane-By-Id \n4) findAll-AirPlanes \n5) Delete-AirPlane-By-Id \n6) Sort-By-Name \n7) Sort-By-Price \n8) Sort-By-Speed");
			switch (sc.nextInt()) {

			case 1:
				apv.saveAirPlane();
				break;
			case 2:
				apv.UpdateAirPlaneName();
				break;
			case 3:
				apv.findAirPlaneById();
				break;
			case 4:
				apv.findAllAirPLane();
				break;
			case 5:
				apv.deleteAirPlaneById();
				break;
			case 6:
				apv.sortByName();
				break;
			default:
				System.err.println("Invalid Choice...");
				break;
			}
		}

	}
}
