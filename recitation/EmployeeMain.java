package recitation;

public class EmployeeMain {
    public static void main(String[] args) {

        Employee emp = new Employee(1, "John Doe", 50000);

        System.out.println(emp.getEmployeeName());
        System.out.println(emp.getEmployeeSalary());

        System.out.println(emp.calculateAnnualSalary());
        System.out.println(emp.showSummary());
    }
}
