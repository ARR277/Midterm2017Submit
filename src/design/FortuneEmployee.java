package design;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class FortuneEmployee {

	/**
	 * FortuneEmployee class has a main methods where you will be able to create Object from
	 * EmployeeInfo class to use fields and attributes.Demonstrate as many methods as possible 
	 * to use with proper business work flow.Think as a Software Architect, Product Designer and 
	 * as a Software Developer.(employee.info.system) package is given as an outline,you need to elaborate
	 * more to design an application that will meet for fortune 500 Employee Information
	 * Services.
	 *
	 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
	 *
	 **/

	public static void main(String[] args) {
		EmployeeInfo.setCompanyName("Marlon & Cebb Inc.");
		EmployeeInfo.setDepartment("CSI Department");
		EmployeeInfo.setBenefit("Retirement Plan");
		Random rand = new Random();
		ArrayList<String> arrayList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter A FilePath To Retrieve the List of 500 Employee w/ Start Date: ");
		String retrieve = sc.nextLine();
		System.out.print("Enter A FilePath To Store the List to a Specific File: ");
		String give = sc.nextLine();
		EmployeeInfo empled4 = new EmployeeInfo("Finn Martin", 987456120, 21, "monthly");

		System.out.println("\n1.)\n  Employee Name: "+empled4.employeeName());
		System.out.println("  Employee ID: "+empled4.employeeId());
		double print4 = empled4.calculateSalary();
		System.out.println("  "+empled4.getPeriod()+print4);
		System.out.println("  Possible Bonus: + $"+EmployeeInfo.calculateEmployeeBonus(print4, rand.nextInt(6)));
		System.out.print("  Benefit: ");
		empled4.benefitLayout();
		System.out.println("  Pension: $"+EmployeeInfo.calculateEmployeePension(print4));

		EmployeeInfo empled5 = new EmployeeInfo("Nathan Hughe", 234167009, 25, "monthly");
		System.out.println("\n2.)\n  Employee Name: "+empled5.employeeName());
		System.out.println("  Employee ID: "+empled5.employeeId());
		double print5 = empled5.calculateSalary();
		System.out.println("  "+empled5.getPeriod()+print5);
		System.out.println("  Possible Bonus: + $"+EmployeeInfo.calculateEmployeeBonus(print5, rand.nextInt(6)));
		System.out.print("  Benefit: ");
		empled5.benefitLayout();
		System.out.println("  Pension: $"+EmployeeInfo.calculateEmployeePension(print5));

		String line;
		try {
			FileReader fr = new FileReader(new File(retrieve));
			BufferedReader br = new BufferedReader(fr);

			while((line = br.readLine())!=null) {
				arrayList.add(line);
			}
			br.close();
		}catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			System.err.println("File Not Found!! Terminate Application");
			System.exit(0);
			//System.out.println(fnfe.getMessage());
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		Iterator<String> it = arrayList.iterator();
		int i=0, employeeID, workPerHour;
		String [] prevYear = new String[arrayList.size()];
		EmployeeInfo [] employeeList = new EmployeeInfo[arrayList.size()];
		while(it.hasNext()){
			employeeID = rand.nextInt(899999999)+100000000;
			workPerHour = rand.nextInt(45)+10;
			String nameDate = it.next();
			String name = nameDate.substring(0, nameDate.indexOf("("));
			prevYear[i] = nameDate.substring(nameDate.indexOf("(")+1, nameDate.indexOf(")"));
			employeeList[i] = new EmployeeInfo(name, employeeID, workPerHour, "Annually");
			i++;
		}

		for(int in=0; in<employeeList.length; in++){
			System.out.println(employeeList[in].employeeName()+"  "+employeeList[in].employeeId());
		}

		try {
			double calculate;
			PrintWriter pw = new PrintWriter(new File(give));
			for (int print=0; print<employeeList.length; print++){
				String currentDate = "August,2017";
				pw.println("Name: "+employeeList[print].employeeName());
				pw.println("ID: "+employeeList[print].employeeId());
				calculate = employeeList[print].calculateSalary();
				pw.println(employeeList[print].getPeriod()+calculate);
				pw.println("Possible Bonus: "+EmployeeInfo.calculateEmployeeBonus(calculate, rand.nextInt(6)));
				pw.println("Possible Pension: "+EmployeeInfo.calculateEmployeePension(calculate, prevYear[print], currentDate));
			}
			pw.close();
		}catch (FileNotFoundException fnfe){
			System.err.println("File Not Found!! Terminate Application");
			fnfe.printStackTrace();
		}

		/*
		EmployeeInfo empled1 = new EmployeeInfo(123456789);
		empled1.setEmployeeName("Charles Minn");
		empled1.setWorkPerHour(15.00);

		System.out.println("\n\tCompany Name: "+EmployeeInfo.getCompanyName());
		System.out.print("\tDepartment:");
		empled1.assignDepartment();

		System.out.println("\n1.)\n  Employee Name: "+empled1.employeeName());
		System.out.println("  Employee ID: "+empled1.employeeId());
		double print1 = empled1.calculateSalary();
		System.out.println("  "+empled1.getPeriod()+print1);
		System.out.println("  Possible Bonus: + $"+EmployeeInfo.calculateEmployeeBonus(print1, rand.nextInt(6)));
		System.out.print("  Benefit: ");
		empled1.benefitLayout();
		System.out.println("  Possible Pension: $"+EmployeeInfo.calculateEmployeePension(print1));

		EmployeeInfo empled2 = new EmployeeInfo("Mariam Lass", 234109876);
		empled2.setWorkPerHour(20.00);

		System.out.println("\n2.)\n  Employee Name: "+empled2.employeeName());
		System.out.println("  Employee ID: "+empled2.employeeId());
		double print2 = empled2.calculateSalary();
		System.out.println("  "+empled2.getPeriod()+print2);
		System.out.println("  Possible Bonus: + $"+EmployeeInfo.calculateEmployeeBonus(print2, rand.nextInt(6)));
		System.out.print("  Benefit: ");
		empled2.benefitLayout();
		System.out.println("  Possible Pension: $"+EmployeeInfo.calculateEmployeePension(print2));

		EmployeeInfo empled3 = new EmployeeInfo("Simon Petrokov", 190765586, 30);

		System.out.println("\n3.)\n  Employee Name: "+empled3.employeeName());
		System.out.println("  Employee ID: "+empled3.employeeId());
		double print3 = empled3.calculateSalary();
		System.out.println("  "+empled3.getPeriod()+print3);
		System.out.println("  Possible Bonus: + $"+EmployeeInfo.calculateEmployeeBonus(print3, rand.nextInt(6)));
		System.out.print("  Benefit: ");
		empled3.benefitLayout();
		System.out.println("  Possible Pension: $"+EmployeeInfo.calculateEmployeePension(print3));
*/

	}

}
