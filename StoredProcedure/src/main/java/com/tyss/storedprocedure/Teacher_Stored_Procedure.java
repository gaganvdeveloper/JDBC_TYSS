package com.tyss.storedprocedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Teacher_Stored_Procedure {
	public static void main(String[] args) {

		try (Connection con = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/school?user=postgres&password=root");
				CallableStatement cs = con.prepareCall(
						"call create_teacher_records(102,'Akshy','male',22,'akshy@gmail.com',789621452, 'O+ve')")) {

			cs.execute();
			System.out.println("Record Inserted...");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception");
		}

	}
}
