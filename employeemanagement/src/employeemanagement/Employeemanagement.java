package employeemanagement;
import java.text.NumberFormat;
import java.util.Locale;

public class Employeemanagement {
    private int employee_id;
    private String employee_name;
    private double employee_salary; //for calculations

    //Employee object
    public Employeemanagement(int id, String name, double salary) {
        this.employee_id = id;
        this.employee_name = name;
        this.employee_salary = salary;
    }

    // Methods for ID
    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    //Methods for Name
    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    // employee salary
    public String getEmployee_salary() {
        
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        return currencyFormatter.format(employee_salary);
    }
    
    //feature 
 
    public double calculateAnnualBonus(double percentage) {
        return this.employee_salary * percentage;
    }
    
    // feature
  
    public void displayDetails() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("ID: " + this.employee_id);
        System.out.println("Name: " + this.employee_name);
        
        
        System.out.println("Salary: " + this.getEmployee_salary()); 
       
    }

    // Main method for Employee class
    public static void main(String[] args) {
       
        Employeemanagement emp1 = new Employeemanagement(101, "Alice Johnson", 55000.75);
     
        //feature
        emp1.displayDetails();

        
        emp1.setEmployee_name("Alice M. Johnson");
        emp1.setEmployee_id(102);
        
        
        System.out.println("\n--- After Modifications ---");
        System.out.println("New ID: " + emp1.getEmployee_id());
        System.out.println("New Name: " + emp1.getEmployee_name());
        System.out.println("Salary (Formatted): " + emp1.getEmployee_salary());
        
        //Calculate and display
        double bonus = emp1.calculateAnnualBonus(0.15); 
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Calculated 15% Bonus: " + currencyFormatter.format(bonus));
      
    }
}