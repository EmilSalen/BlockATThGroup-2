package recitation;

public class Employee {

    private int employee_id;
    private String employee_name;
    private double employee_salary;

    
    public Employee(int employee_id, String employee_name, double employee_salary) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
    }


    public int getEmployeeId() {
        return employee_id;
    }

    public void setEmployeeId(int employee_id) {
        this.employee_id = employee_id;
    }

  
    public String getEmployeeName() {
        return employee_name;
    }

    public void setEmployeeName(String employee_name) {
        this.employee_name = employee_name;
    }


    public String getEmployeeSalary() {
        return String.format("Pesos %,.2f", employee_salary);
    }

    // ➤ Feature 1: Calculate Annual Salary
    public String calculateAnnualSalary() {
        double annual = employee_salary * 12;
        return String.format("₱%,.2f", annual);
    }


    public String showSummary() {
        return "\n--- Employee Summary ---" +
               "\nID: " + employee_id +
               "\nName: " + employee_name +
               "\nMonthly Salary: " + getEmployeeSalary() +
               "\nAnnual Salary: " + calculateAnnualSalary() +
               "\n------------------------\n";
    }
}
