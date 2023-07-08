package com.tyss.functioncall;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class FunctionCall {
	public static void main(String[] args) {
		
		
		try(Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/school","postgres","root")) {
			
			CallableStatement cs=con.prepareCall("select count_by_gender(?)");
			cs.setString(1, "female");
			ResultSet rs=cs.executeQuery();
			
			rs.next();
			int result=rs.getInt(1);
			
			System.out.println("The Result IS : "+result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
