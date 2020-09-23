package aplication;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner ler = new Scanner ( System.in );
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		
		String nameDp;
		System.out.print("Enter department´s name : ");nameDp=ler.nextLine();
		System.out.println("*************************");
		System.out.println("Enter worker data :");
		System.out.println("*******************");
		String workerName;
		System.out.print("Name: ");workerName=ler.nextLine();
		String workerLevel;
		System.out.print("Level: ");workerLevel=ler.nextLine();
		Double baseSalary;
		System.out.print("Base salary: ");baseSalary=ler.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(nameDp));
						
		int numContracts = 0;
		System.out.print("How many contracts to this worker? ");numContracts=ler.nextInt();
		
		for (int c=1 ; c <= numContracts ; c++  ) {
			System.out.printf("Enter contract #%d data:%n",c);
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = formatDate.parse(ler.next());
			System.out.print("Value per hour: ");
			Double valuePerHour = ler.nextDouble();
			System.out.print("Duration (hour): ");
			int hours = ler.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.printf("%n%nEnter month and year to calculation income (MM/YYYY): ");
		String monthAndYear = ler.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.printf("Name: %s%n",worker.getName()); 
		System.out.printf("Department: %s%n",worker.getDepartment().getName());
		System.out.printf("Income for %s: %.2f:",monthAndYear,worker.income(year, month));
		
		
		
		ler.close();
	}

}
