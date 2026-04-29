package com.qsp.employee_management_sysyem.controllerlayer;

import java.util.List;
import java.util.Scanner;

import com.qsp.employee_management_sysyem.daolayer.EmployeeDao;
import com.qsp.employee_management_sysyem.entitylayer.Employee;

public class EmployeeController {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EmployeeDao dao=new EmployeeDao();
		while(true) {
			System.out.println("welcome to employee management system");
			System.out.println("=========================================");
			System.out.println("1.for insert employee details");
			System.out.println("2.for fetch all employee details");
			System.out.println("3.for fetch employee details based on Id");
			System.out.println("4.for delete employee by id");
			System.out.println("5.for update employee by ID");
			System.out.println("6.for exit from application");
			
			
			System.out.println("please enter your choice");
			int choice=sc.nextInt();//this is user to choose the choice
			
			
			switch(choice) {
			case 1:{
				System.out.println("---------please enter empid-----------");
				int empid=sc.nextInt();
				
				sc.nextLine();//for between int and string
				
				System.out.println("---------please enter empname-----------");
				String name=sc.nextLine();
				
				
				System.out.println("---------please enter empemail-----------");
				String email=sc.nextLine();
				
				
				System.out.println("---------please enter empsalary-----------");
				double salary=sc.nextDouble();
				
				
				System.out.println("---------please enter empage-----------");
				int age=sc.nextInt();
				
				//binding the data into object
				Employee emp=new Employee();
				emp.setEmpid(empid);
				emp.setName(name);
				emp.setEmail(email);
				emp.setSalary(salary);
				emp.setAge(age);
			
				
				boolean b=dao.saveEmployee(emp);//to check data is inserted are not
				if(b) {
					System.out.println("data is inserted---");
				}else {
					System.out.println("data is not inserted");
				}
				break;
			}
			

			
			
			
			

			// fetch all employee details(this comment is given by me)
			case 2:{
				System.out.println("--------employee details----------");
				
				List<Employee> emp=dao.getAllEmployee();
				if(emp!=null) {
					for(Employee e:emp) {
						System.out.println(e.getEmpid());
						System.out.println(e.getName());
						System.out.println(e.getEmail());
						System.out.println(e.getSalary());
						System.out.println(e.getAge());
						System.out.println("-----------------------");
						
					}
				}else {
					System.err.println("employee table is empty");
				}
			}
			break;
			
			
		


			
			
		   // fetch employee record based on id		
	case 3:{
		System.out.println("please provide EMPID to fetch record");
		int empid=sc.nextInt();
		Employee emp=dao.getEmployeeById(empid);
		
		
		if(emp!=null) {
			System.out.println("Empid:"+emp.getEmpid());
			System.out.println("name:"+emp.getName());
			System.out.println("email:"+emp.getEmail());
			System.out.println("salary:"+emp.getSalary());
			System.out.println("age:"+emp.getAge());
		}else {
			System.out.println("given id is not found");
		}
		break;
	}







	//delete employee details based on empid
	case 4:{
		System.out.println("please enter empid to delete employee");
		int empid=sc.nextInt();
		boolean b=dao.deleteEmployeeById(empid);
		if(b) {
			System.out.println("data is deleted");
		}else {
			System.out.println("given id is not found");
		}
		break;
	}








	//update employee name based on empid
	case 5:{
		System.out.println("please enter employee id");
		int empid=sc.nextInt();
		sc.nextLine();
		System.out.println("please enter name");
		String name=sc.nextLine();
		boolean value=dao.updateEmployeeByID(empid, name);
		if(value) {
			System.out.println("data is updated");
		}
		else {
			System.out.println("data is not updated");
		}
		
		
		break;
	}




	// for exit from application
	case 6:{
		System.out.println("succesfully exit");
		System.exit(0);
	}
	default:{
		System.out.println("please enter valid choice");
	}
			}
		}
	}

}






		