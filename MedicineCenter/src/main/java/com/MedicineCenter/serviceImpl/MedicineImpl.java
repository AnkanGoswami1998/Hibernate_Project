package com.MedicineCenter.serviceImpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.MedicineCenter.entity.Medicine;
import com.MedicineCenter.service.MedicineService;

public class MedicineImpl implements MedicineService {

	@Override
	public void addMedicine() {
		Configuration cfg = new Configuration().configure();
    	SessionFactory sf = cfg.buildSessionFactory();
        System.out.println( "sf is ready" );
        Session s = sf.openSession();
        //Medicine m = new Medicine(45, "Zintac", 10.75, "20-09-2024");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of medicine you want to add:");
        int n=sc.nextInt();
        for(int i=0;i<n;i++) {                                                                                     ;
        	System.out.println("Enter Med Id:");
        	int id=sc.nextInt();
        	System.out.println("Enter Med Name:");
        	String name=sc.next();
        	System.out.println("Enter Med Price:");
        	double price=sc.nextDouble();
        	System.out.println("Enter Expiry Date(dd-mm-yyyy):");
        	String date=sc.next();
        	Medicine m = new Medicine(id, name, price, date);
        	s.save(m);
        }
        Transaction tr = s.beginTransaction();
        //s.save(m);
        tr.commit();
        s.close();
        System.out.println("Object saved");

	}

	@Override
	public void findMedbyId() {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Medicine Id you want to see:");
		int n = sc.nextInt();
		Medicine m = s.get(Medicine.class, n);
		System.out.println(m);
		

	}

	@Override
	public void delMed() {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Medicine Id you want to Delete:");
		int n = sc.nextInt();
		Medicine m = s.load(Medicine.class, n);
		Transaction tr = s.beginTransaction();
		s.delete(m);
		tr.commit();
		s.close();
		System.out.println("Object Deleted");
		

	}

	@Override
	public void updateMed() {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Medicine Id you want to Update");
		int n = sc.nextInt();
		Medicine m = s.load(Medicine.class, n);
		Transaction tr = s.beginTransaction();
		System.out.println("Enter updated Med Name");
    	String name=sc.next();
		m.setM_name(name);
		System.out.println("Enter the Expiry Date(dd-mm-yyyy):");
    	String date=sc.next();
		m.setExpiry_date(date);
		System.out.println("Enter updated Med Price:");
    	double price=sc.nextDouble();
		m.setPrice(price);
		s.save(m);
		tr.commit();
		s.close();
		System.out.println("Objects Updated");

	}

}
