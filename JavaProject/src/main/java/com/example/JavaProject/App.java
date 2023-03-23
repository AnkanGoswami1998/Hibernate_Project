//// Hibernate project on student management
//// user can operate if only they provide right username&password

package com.example.JavaProject;

import java.util.Scanner;

import StudentImpl.ServiceImpl;

public class App {
  public static void main(String[] args) {
	  
	  /*Configuration cfg = new Configuration().configure();
	  SessionFactory sf = cfg.buildSessionFactory();
      System.out.println(sf);
      Session s = sf.openSession();
      Transaction tr = s.beginTransaction();
      Student s1 = new Student(1,"Ankan","Java","7980165425");
      Student s2 = new Student(2, "Akash", "C++", "99036524578");
      Student s3 = new Student(3, "Rajiv", ".net", "9856451256");
      s.save(s3);
      s.save(s2);
      s.save(s1);
      tr.commit();
      System.out.println("object saved");*/
	   
	  ServiceImpl s = new ServiceImpl();  //// Making object of serviceimpl class
	  Scanner sc = new Scanner(System.in); //// scanner class
	  String name = "ANKAN"; //// username
	  String pass = "123"; //// password
	  System.out.println("........Student Management........."); ////username password menu
	  System.out.println("Enter your Username:");
	  String user = sc.next().toUpperCase();  //// input from user
	  System.out.println("Enter your Password:");
	  String p = sc.next();
	  if(user.equals(name)&&(pass.equals(p)))  //// Applying logic
		   {
			    System.out.println("---------Enter your choice-----------");
				System.out.println("1: Adding a new Student");
				System.out.println("2: Deleting Student");
				System.out.println("3: Getting studentdetails");
				System.out.println("4: Updating studentdetails");
				int choice = sc.nextInt();
				switch (choice) { //// using switch case
				case 1 : s.addStudent();  //// calling methods of Servicimpl class
				break;
				case 2 : s.delStudent();
				break;
				case 3 : s.getStudent();
				break;
				case 4 : s.updateStudent();
				break;
				default : System.out.println("Wrong Input.....");
				}
			   
			  
		  }
		 
	  
	  else {
		  System.out.println("Wrong Username or password.....");
	  }
		
	   
      
  }


}
