package employeemanagement;
public class Employeemanagement {

    // Private instance variables (fully encapsulated)
    private int employee_id;
    private String employee_name;
    private double employee_salary;
    private String employee_position; // Additional feature

    // employee_id
    public int getEmployeeId() {
        return employee_id;
    }

    public void setEmployeeId(int employee_id) {
        this.employee_id = employee_id;
    }

    // employee_name
    public String getEmployeeName() {
        return employee_name;
    }

    public void setEmployeeName(String employee_name) {
        this.employee_name = employee_name;
    }

    // employee_salary (formatted string)
    public String getEmployeeSalary() {
        return "₱" + String.format("%.2f", employee_salary);
    }

    // employee_salary
    public void setEmployeeSalary(double employee_salary) {
        this.employee_salary = employee_salary;
    }

    // Additional feature
    public String getEmployeePosition() {
        return employee_position;
    }

    public void setEmployeePosition(String employee_position) {
        this.employee_position = employee_position;
    }

    // Add feat: Check if employee is a high earner
    public boolean isHighEarner() {
        return employee_salary > 30000;
    }

    // Main method to test encapsulation
    public static void main(String[] args) {
        Employeemanagement emp = new Employeemanagement();

        // Set data using setters
        emp.setEmployeeId(101);
        emp.setEmployeeName("TANGGOL");
        emp.setEmployeeSalary(35000.75);
        emp.setEmployeePosition("Team Leader");

        // Access data using getters
        System.out.println("===EMPLOYEE DETAILS ===");
        System.out.println("ID: " + emp.getEmployeeId());
        System.out.println("Name: " + emp.getEmployeeName());
        System.out.println("Position: " + emp.getEmployeePosition());
        System.out.println("Salary: " + emp.getEmployeeSalary());
        System.out.println("High Earner? " + emp.isHighEarner());
    }
}

