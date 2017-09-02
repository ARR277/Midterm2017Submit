package design;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmployeeInfo implements Employee{
	
 /*This class can be implemented from Employee interface then add additional methods in EmployeeInfo class.
 * Also, Employee interface can be implemented into an abstract class.So create an Abstract class
 * then inherit that abstract class into EmployeeInfo class.Once you done with designing EmployeeInfo class,
 * go to FortuneEmployee class to apply all the fields and attributes.
 * 
 * Important: YOU MUST USE the 
 * OOP(abstraction,Encapsulation, Inheritance and Polymorphism) concepts in every level possible.
 * Use all kind of keywords(super,this,static,final........)
 *
 */

	/*
	 * declare few static and final fields and some non-static fields
	 */
	//non-static
	private String employeeName = "N/A";
	private int employeeID;
	private String period = "Hourly";
	private double workPerHour = 0.00;
	//static
	private static String companyName = "N/A";
	private static String department = "N/A";
	private static String benefit = "N/A";
	//final
	final private int hoursPerWeek = 40;

	/*
	 * You must implement the logic for below 2 methods and 
	 * following 2 methods are prototype as well for other methods need to be design,
	 * as you will come up with the new ideas.
	 */
	
	/*
	 * you must have multiple constructor.
	 * Must implement below constructor.
	 */
	public EmployeeInfo(int employeeId){
		this.employeeID = employeeId;
	}
    public EmployeeInfo(String name, int employeeId){
		employeeName = name;
		this.employeeID = employeeId;
	}
	public EmployeeInfo(String employeeName, int employeeId, double workPerHour){
		this.employeeID = employeeId;
		this.employeeName = employeeName;
		this.workPerHour = workPerHour;
	}
	public EmployeeInfo(String employeeName, int employeeId, double workPerHour, String period){
		this.employeeID = employeeId;
		this.employeeName = employeeName;
		this.workPerHour = workPerHour;
		this.period = period;
	}
	/*
	 * This methods should calculate Employee bonus based on salary and performance.
	 * Then it will return the total yearly bonus. So you need to implement the logic.
	 * Hints: 10% of the salary for best performance, 8% of the salary for average performance and so on. 
	 * You can set arbitrary number for performance.
	 * So you probably need to send 2 arguments.
	 * 
	 */

	//best to worst : 5 to 1
	public static int calculateEmployeeBonus(double salary, int perform){
		int total;
		if(perform==5) total = (int) (salary*1.10);
		else if(perform==4) total = (int) (salary*1.08);
		else if(perform==3) total = (int) (salary*1.06);
		else if(perform==2) total = (int) (salary*1.04);
		else if(perform==1) total = (int) (salary*1.02);
		else total = (int) salary;
		return total;
	}

	public String getPeriod(){
		return period+" wage: $";
	}

	//employeeId() will return employee id.
	public int employeeId(){
		return employeeID;
	}

	//employeeName() will return employee name
	public String employeeName(){
		return employeeName;
	}

	//assignDepartment() will assign employee to departments
	public void assignDepartment(){ System.out.println(" "+department+" "); }

	//employee benefit
	public void benefitLayout(){System.out.println(" "+benefit+" "); }

	public static String getCompanyName() { return companyName; }

	public void setEmployeeID(int Id){
		employeeID = Id;
	}

	public void setEmployeeName(String name){
		employeeName = name;
	}

	public String getEmployeeName(){
		return employeeName;
	}

	public void setWorkPerHour(double workPerHour){ this.workPerHour = workPerHour; }

	public static void setCompanyName(String companyName) { EmployeeInfo.companyName = companyName; }

	public static void setDepartment(String department) { EmployeeInfo.department = department; }

	public static void setBenefit(String benefit) { EmployeeInfo.benefit = benefit; }

	/*
	 * This methods should calculate Employee Pension based on salary and numbers of years with the company.
	 * Then it will return the total pension. So you need to implement the logic.
	 * Hints: pension will be 5% of the salary for 1 year, 10% for 2 years with the company and so on.
	 * 
	 */
	public static int calculateEmployeePension(double salary){
		int total;
		double percent;
		double monthToYear;
		Scanner sc  = new Scanner(System.in);
		System.out.println("  Possible Pension: ");
		System.out.println("Please enter start date in format (example: May,2015): ");
		String joiningDate = sc.nextLine();
		System.out.println("Please enter today's date in format (example: August,2017): ");
		String todaysDate = sc.nextLine();
        String convertedJoiningDate = DateConversion.convertDate(joiningDate);
        String convertedTodaysDate = DateConversion.convertDate(todaysDate);

        //implement numbers of year from above two dates
		//Calculate pension

		//month
		String currMonth = convertedTodaysDate.substring( 0, convertedTodaysDate.indexOf("/") );
		String prevMonth = convertedJoiningDate.substring( 0, convertedJoiningDate.indexOf("/") );
		int month = Integer.parseInt(currMonth) + (12-Integer.parseInt(prevMonth));
		//year
		String currYear = convertedTodaysDate.substring( convertedTodaysDate.indexOf("/")+1 );
		String prevYear = convertedJoiningDate.substring( convertedJoiningDate.indexOf("/")+1 );
		int year = Integer.parseInt(currYear) - Integer.parseInt(prevYear);

		if(month==12){
			year++;
			month = 0;
		}
		else if(month>12){
			year++;
			month -= 12;
		}

		monthToYear = month/12.0;
		percent = (year+monthToYear)*0.05;
		total = (int)(salary*year*percent);
		return total;
	}

	public static int calculateEmployeePension(double salary, String prev, String curr){
		int total;
		double percent;
		double monthToYear;

		String convertedJoiningDate = DateConversion.convertDate(prev);
		String convertedTodaysDate = DateConversion.convertDate(curr);

		//implement numbers of year from above two dates
		//Calculate pension

		//month
		String currMonth = convertedTodaysDate.substring( 0, convertedTodaysDate.indexOf("/") );
		String prevMonth = convertedJoiningDate.substring( 0, convertedJoiningDate.indexOf("/") );
		int month = Integer.parseInt(currMonth) + (12-Integer.parseInt(prevMonth));
		//year
		String currYear = convertedTodaysDate.substring( convertedTodaysDate.indexOf("/")+1 );
		String prevYear = convertedJoiningDate.substring( convertedJoiningDate.indexOf("/")+1 );
		int year = Integer.parseInt(currYear) - Integer.parseInt(prevYear);

		if(month==12){
			year++;
			month = 0;
		}
		else if(month>12){
			year++;
			month -= 12;
		}

		monthToYear = month/12.0;
		percent = (year+monthToYear)*0.05;
		total = (int)(salary*year*percent);
		return total;
	}

	public int calculateSalary() {
		// TODO Auto-generated method stub
		double salary;
		if(period.equalsIgnoreCase("weekly")) salary = workPerHour * hoursPerWeek;
		else if(period.equalsIgnoreCase("bi-weekly")) salary = 2*workPerHour * hoursPerWeek;
		else if(period.equalsIgnoreCase("semi-monthly")) salary = (13*workPerHour * hoursPerWeek)/6;
		else if(period.equalsIgnoreCase("monthly")) salary = (13*workPerHour * hoursPerWeek)/3;
		else if(period.equalsIgnoreCase("quarterly")) salary = 13*workPerHour * hoursPerWeek;
		else if(period.equalsIgnoreCase("annually")) salary = 52*workPerHour * hoursPerWeek;
		else salary = workPerHour;
		return (int) salary;
	}

	private static class DateConversion {

		public DateConversion(Months months){

		}

		public static String convertDate(String date) {
			String [] extractMonth = date.split(",");
			String givenMonth = extractMonth[0];
			int monthDate = whichMonth(givenMonth);
			String actualDate = monthDate + "/" + extractMonth[1];
			return actualDate;
		}

		public static int whichMonth(String givenMonth) {
			Months months = Months.valueOf(givenMonth);
			int date = 0;
			switch (months) {
				case January:
					date = 1;
					break;
				case February:
					date = 2;
					break;
				case March:
					date = 3;
					break;
				case April:
					date = 4;
					break;
				case May:
					date = 5;
					break;
				case June:
					date = 6;
					break;
				case July:
					date = 7;
					break;
				case August:
					date = 8;
					break;
				case September:
					date = 9;
					break;
				case October:
					date = 10;
					break;
				case November:
					date = 11;
					break;
				case December:
					date = 12;
					break;
				default://No month given
					date = 0;
					break;
			}
			return date;

		}
	}
}
