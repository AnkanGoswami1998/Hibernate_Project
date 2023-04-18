package com.MedicineCenter;

import java.util.Scanner;

import com.MedicineCenter.serviceImpl.MedicineImpl;


public class App 
{
    public static void main( String[] args )
    {
    	
    MedicineImpl mi = new MedicineImpl();
    System.out.println("-----Welcome To MedicineCenter------");
    Scanner sc = new Scanner(System.in);
    System.out.println("1)Adding new Medicine");
    System.out.println("2)Getting Medicine Details");
    System.out.println("3)Deleting Medicine");
    System.out.println("4)Updating Medicine");
    System.out.println("Enter Your Choice:");
    int choice = sc.nextInt();
    
    switch(choice) {
    case 1 -> mi.addMedicine();
    case 2 -> mi.findMedbyId();
    case 3 -> mi.delMed();
    case 4 -> mi.updateMed();
    default -> System.out.println("Wrong input......");
    }
    }
}
