package com.qsp.employee_management_sysyem.daolayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qsp.employee_management_sysyem.connectionlayer.Getconnection;
import com.qsp.employee_management_sysyem.entitylayer.Employee;

public class EmployeeDao {
	Connection con=Getconnection.getConnectionObject();
	public boolean saveEmployee(Employee emp) {
		//design a method to insert data into database
	
		String insertquery="insert into employee values(?,?,?,?,?)";
		
		try {
			PreparedStatement pstm=con.prepareStatement(insertquery);
			pstm.setInt(1, emp.getEmpid());
			pstm.setString(2, emp.getName());
			pstm.setString(3, emp.getEmail()); 
			pstm.setDouble(4, emp.getSalary());
			pstm.setInt(5, emp.getAge());
			
			int row=pstm.executeUpdate();
			return row>0;
			
		
		}catch(SQLException e) {
			e.printStackTrace();
		
	}
		return false;
}



	


//design a method to fetch all employee details
   public List<Employee> getAllEmployee(){  //list used to store all data
	   
	   String selectquery="select * from employee";
	   List<Employee> empList=new ArrayList<Employee>();
	   
	   try {
		   PreparedStatement pstm=con.prepareStatement(selectquery);
		   //execute query
		   ResultSet set=pstm.executeQuery();
		   
		   while(set.next()) {
			   int empid=set.getInt("empid");
			   String name=set.getString("name");
			   String email=set.getString("email");
			   double salary=set.getDouble("salary");
			   int age=set.getInt("age");
			   
			   
			 //we have to bind data into employee object
			   Employee emp=new Employee();
			   emp.setEmpid(empid);
			   emp.setName(name);
			   emp.setEmail(email);
			   emp.setSalary(salary);
			   emp.setAge(age);
			   
			   //add employee object into list
			   empList.add(emp);
		   }
	   }catch(SQLException e) {
		   e.printStackTrace();
	   }
	   return empList;
   }
   







 //design a method to fetch employee record based on id
public Employee getEmployeeById(int id) {     //here our return type is employee bcz we are returning e and e type is employee
	String sql="select * from employee where empid=?";
	try {
	PreparedStatement pstm=con.prepareStatement(sql);
	pstm.setInt(1, id);
	ResultSet set=pstm.executeQuery();
	
	if(set.next()) {
		int empid=set.getInt("empid");
		String name=set.getString("name");
		String email=set.getString("email");
		Double salary=set.getDouble("salary");
		int age=set.getInt("age");
		
		
		
		//bind data into object
		Employee e=new Employee();
		e.setEmpid(empid);
		e.setName(name);
		e.setEmail(email);
		e.setSalary(salary);
		e.setAge(age);
		
		return e;
	}
}catch(SQLException e) {
	e.printStackTrace();
     }
	return null;
   }







//design a method to delete employee details based on empid
public boolean deleteEmployeeById(int id) {
	String sql="delete from employee where empid=?";
	try {
	PreparedStatement pstm=con.prepareStatement(sql);
	pstm.setInt(1, id);
	int row=pstm.executeUpdate();
	
	return row>0;
	
}catch(SQLException e) {
	e.printStackTrace();
}
	return false;
   }






//design a method to update employee name based on empid
public boolean updateEmployeeByID(int id,String name) {
	String updatequery="update employee set name=? where empid=?";
	try {
	PreparedStatement pstm=con.prepareStatement(updatequery);
	pstm.setString(1, name);
	pstm.setInt(2, id);
	
	int row=pstm.executeUpdate();
	return row>0;
	
}catch(SQLException e) {
	e.printStackTrace();
}
	return false;
}
}













