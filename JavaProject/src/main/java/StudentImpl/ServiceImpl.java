//// Class which implements service interface overriding the methods

package StudentImpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.Student;
import StudentDAo.Service;

public class ServiceImpl implements Service{

	@Override
	public void addStudent() {    //// method of adding student details
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		System.out.println("sf is ready" + sf);
		Session s = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student ID:");
		int ID = sc.nextInt();
		System.out.println("Enter Student Name:");
		String name = sc.next();
		System.out.println("Enter Student Subject:");
		String sub = sc.next();
		System.out.println("Enter Student Contact Number:");
		String con = sc.next();
		Student s1 = new Student(ID, name, sub, con);
		Transaction tr = s.beginTransaction();
		s.save(s1);
		tr.commit();
		System.out.println("Object saved");
		
		
	}

	@Override
	public void delStudent() { //// Method of deleting student
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id of the student you want to delete:");
		int id = sc.nextInt();
		Transaction tr = s.beginTransaction();
		Student s1 = s.get(Student.class, id);
		s.delete(s1);
		tr.commit();
		System.out.println("Deleted Succesfully");
		
	}

	@Override
	public void getStudent() { //// method of get any student detaills
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id of the student you want to Fetch:");
		int id = sc.nextInt();
		Student s1 = s.get(Student.class, id);
		System.out.println(s1);
	}

	@Override
	public void updateStudent() {  ////method of updating student name
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		System.out.println("sf is ready" + sf);
		Session s = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id you want to update:");
		int id = sc.nextInt();
		Student s1 = s.get(Student.class, id);
		System.out.println("Enter the name:");
		String name = sc.next();
		Transaction tr = s.beginTransaction();
		s1.setStu_name(name);
		s.save(s1);
		tr.commit();
		System.out.println("Upadted succesfuly.....");
		
		
	}

}
