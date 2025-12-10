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

    public String getEmployeeCode() {
        String firstThree = employee_name.substring(0, 3).toUpperCase();
        return firstThree + "-" + employee_id;
    }

  
    public boolean isEligibleForPromotion() {
        return employee_salary > 30000;
    }

    public String showSummary() {
        return "\n--- Employee Summary ---" +
               "\nID: " + employee_id +
               "\nName: " + employee_name +
               "\nEmployee Code: " + getEmployeeCode() +
               "\nMonthly Salary: " + getEmployeeSalary() +
               "\nEligible for Promotion: " + (isEligibleForPromotion() ? "Yes" : "No") +
               "\n------------------------\n";
    }
}
