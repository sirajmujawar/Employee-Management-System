package com.qsp.employee_management_sysyem.connectionlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Getconnection {

	public static Connection getConnectionObject() {
		String url="jdbc:postgresql://localhost:5432/ems_db";
		String user="postgres";
		String pwd="Siraj@123";
	 try {
		Class.forName("org.postgresql.Driver");
		
		Connection con=DriverManager.getConnection(url,user,pwd);
		System.out.println("object is created ");
		return con;
	}
	 
	 catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	 catch(SQLException s) {
		s.printStackTrace();
	 }
	 return null;
	}
}

	


