package recitation;

public class EmployeeMain {
    public static void main(String[] args) {

        Employee emp = new Employee(1, "Emil Salen", 50000);

        System.out.println("Employee Code: " + emp.getEmployeeCode());
        System.out.println("Eligible for Promotion: " + 
                           (emp.isEligibleForPromotion() ? "Yes" : "No"));

        System.out.println(emp.showSummary());
    }
}
