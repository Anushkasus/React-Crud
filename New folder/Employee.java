//write a class for employee to calculate salary &personal info, basic+agp; deduction=5%(gross);net=gross-deduction in java 

//write a program check leap year
//write a program calculate simple intrest and input from the user
//write a program simple class to find out the area and perimeter of rectangle and box 
//write a program for binary to octal conversion
//write a program octal to decimal
//write a program print reverse pyramid of * pattern
//write a program to find fibonacci series upto 10 numbers
//write a program to display all prime numbers from 1 to n 

public class Employee {
    private String name;
    private int employeeId;
    private double basicSalary;
    private double agp;
    public Employee(String name, int employeeId, double basicSalary, double agp) {
        this.name = name;
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
        this.agp = agp;
    }
    
    // Calculate Gross Salary
    public double calculateGrossSalary() {
        return basicSalary + agp;
    }
    
    // Calculate Deductions (5% of Gross Salary)
    public double calculateDeductions() {
        double grossSalary = calculateGrossSalary();
        return 0.05 * grossSalary;
    }
    
    // Calculate Net Salary
    public double calculateNetSalary() {
        double grossSalary = calculateGrossSalary();
        double deductions = calculateDeductions();
        return grossSalary - deductions;
    }
    
    // Display Employee Information
    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: Rs" + basicSalary);
        System.out.println("AGP: Rs" + agp);
        System.out.println("Gross Salary: Rs" + calculateGrossSalary());
        System.out.println("Deductions: Rs" + calculateDeductions());
        System.out.println("Net Salary: Rs" + calculateNetSalary());
    }
    
    public static void main(String[] args) {
          Employee employee = new Employee("Anu Sawant", 1012, 90000.0, 2000.0);
                employee.displayEmployeeInfo();
    }
}
