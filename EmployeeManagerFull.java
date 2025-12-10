import javax.swing.JOptionPane;
import java.text.NumberFormat;
import java.util.ArrayList;

// Class na nagrerepresenta ng isang empleyado
class Employee {
    private int employee_id; // ID ng empleyado
    private String employee_name; // Pangalan ng empleyado
    private double base_salary; // Base salary per day
    private ArrayList<Double> salaryHistory; // Listahan ng lahat ng salary na natanggap ng empleyado

    // Constructor: kapag gumawa ng bagong Employee, automatic na idadagdag ang unang salary sa history
    public Employee(int id, String name, double baseSalary) {
        this.employee_id = id; // itakda ang ID
        this.employee_name = name; // itakda ang pangalan
        this.base_salary = baseSalary; // itakda ang base salary
        this.salaryHistory = new ArrayList<>(); // gumawa ng listahan para sa salary history
        this.salaryHistory.add(baseSalary); // unang entry sa salary history
    }

    // Getter at Setter para sa ID ng empleyado
    public int getEmployeeId() { return employee_id; }
    public void setEmployeeId(int id) { this.employee_id = id; }

    // Getter at Setter para sa pangalan ng empleyado
    public String getEmployeeName() { return employee_name; }
    public void setEmployeeName(String name) { this.employee_name = name; }

    // Getter para sa base salary na naka-format bilang currency
    public String getEmployeeSalary() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(); // i-format sa currency
        return formatter.format(base_salary);
    }

    // I-calculate ang weekly salary (base salary * 5 araw) at i-format bilang currency
    public String getWeeklySalary() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(base_salary * 5);
    }

    // I-calculate ang monthly salary (base salary * 5 araw * 4 linggo) at i-format bilang currency
    public String getMonthlySalary() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(base_salary * 5 * 4);
    }

    // Update salary ng empleyado at i-save sa history
    public void updateSalary(double newSalary) {
        base_salary = newSalary; // itakda ang bagong base salary
        salaryHistory.add(newSalary); // idagdag sa salary history
    }

    // Ipakita ang buong salary history ng empleyado, kasama ang weekly at monthly
    public String getSalaryHistory() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        StringBuilder history = new StringBuilder(); // ginagamit para buuin ang string ng history
        int count = 1; // bilang para sa bawat entry
        for (double salary : salaryHistory) {
            history.append("Entry ").append(count++) // ipakita kung aling entry ito
                    .append(": ").append(formatter.format(salary)) // base salary
                    .append(", Weekly: ").append(formatter.format(salary * 5)) // weekly salary
                    .append(", Monthly: ").append(formatter.format(salary * 5 * 4)) // monthly salary
                    .append("\n");
        }
        return history.toString(); // ibalik ang buong history bilang string
    }
}

// Main class na nagme-manage ng mga empleyado
public class EmployeeManagerFull {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>(); // listahan ng lahat ng empleyado
        boolean running = true; // flag para sa menu loop

        // Menu loop: patuloy na magpapakita ng options hanggang pumili ng Exit ang user
        while (running) {
            String menu = "Choose an option:\n"
                    + "1. Add Employee\n"
                    + "2. Show All Employees\n"
                    + "3. Show Salary History\n"
                    + "4. Update Employee Salary\n"
                    + "5. Exit";
            String choiceStr = JOptionPane.showInputDialog(menu);
            if (choiceStr == null) break; // kung nag-cancel, lumabas sa loop

            switch (choiceStr) {
                case "1":
                    addEmployee(employees); // tawagin ang method para magdagdag ng empleyado
                    break;
                case "2":
                    showAllEmployees(employees); // ipakita lahat ng empleyado sa table format
                    break;
                case "3":
                    showSalaryHistory(employees); // ipakita salary history ng isang empleyado
                    break;
                case "4":
                    updateEmployeeSalary(employees); // i-update ang salary at idagdag sa history
                    break;
                case "5":
                    running = false; // itigil ang program
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Choose 1-5."); // error kung mali ang input
            }
        }
    }

    // Method para magdagdag ng empleyado
    private static void addEmployee(ArrayList<Employee> employees) {
        int id = 0;
        String name = "";
        double baseSalary = 0;

        // Input ng Employee ID (numeric only)
        while (true) {
            String inputId = JOptionPane.showInputDialog("Enter Employee ID:");
            if (inputId == null) return; // cancel
            try {
                id = Integer.parseInt(inputId); // i-convert sa integer
                break; // valid input, lumabas sa loop
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. ID must be numeric."); // error kung hindi number
            }
        }

        // Input ng Name (letters only)
        while (true) {
            String inputName = JOptionPane.showInputDialog("Enter Employee Name:");
            if (inputName == null) return;
            if (inputName.matches("[a-zA-Z ]+")) { // letters lang ang pinapayagan
                name = inputName;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Name must contain letters only.");
            }
        }

        // Input ng Base Salary (numeric only)
        while (true) {
            String inputSalary = JOptionPane.showInputDialog("Enter Base Salary per day (Php):");
            if (inputSalary == null) return;
            try {
                baseSalary = Double.parseDouble(inputSalary); // i-convert sa double
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Salary must be numeric.");
            }
        }

        // Gumawa ng bagong Employee at idagdag sa listahan
        Employee emp = new Employee(id, name, baseSalary);
        employees.add(emp);
        JOptionPane.showMessageDialog(null, "Employee successfully added!");
    }

    // Method para ipakita lahat ng empleyado sa table format
    private static void showAllEmployees(ArrayList<Employee> employees) {
        if (employees.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No employees in the list."); // walang data
            return;
        }

        StringBuilder message = new StringBuilder();
        // header ng table
        message.append(String.format("%-5s %-20s %-18s %-18s %-18s%n", "ID", "Name", "Base Salary", "Weekly Salary", "Monthly Salary"));
        message.append("---------------------------------------------------------------------------------\n");

        // loop sa bawat empleyado para ipakita ang details
        for (Employee emp : employees) {
            message.append(String.format("%-5d %-20s %-18s %-18s %-18s%n",
                    emp.getEmployeeId(),
                    emp.getEmployeeName(),
                    emp.getEmployeeSalary(),
                    emp.getWeeklySalary(),
                    emp.getMonthlySalary()));
        }

        JOptionPane.showMessageDialog(null, message.toString(), "Employee Salary Table", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method para ipakita salary history ng isang empleyado
    private static void showSalaryHistory(ArrayList<Employee> employees) {
        if (employees.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No employees in the list."); // walang data
            return;
        }

        String inputId = JOptionPane.showInputDialog("Enter Employee ID to view salary history:");
        if (inputId == null) return;
        try {
            int id = Integer.parseInt(inputId);
            Employee emp = null;
            // hanapin ang empleyado base sa ID
            for (Employee e : employees) {
                if (e.getEmployeeId() == id) {
                    emp = e;
                    break;
                }
            }
            if (emp == null) {
                JOptionPane.showMessageDialog(null, "No employee found with ID " + id);
                return;
            }
            // ipakita ang salary history
            JOptionPane.showMessageDialog(null, "Salary History of " + emp.getEmployeeName() + ":\n\n" + emp.getSalaryHistory());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid ID input.");
        }
    }

    // Method para i-update ang salary ng empleyado
    private static void updateEmployeeSalary(ArrayList<Employee> employees) {
        if (employees.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No employees in the list.");
            return;
        }

        String inputId = JOptionPane.showInputDialog("Enter Employee ID to update salary:");
        if (inputId == null) return;

        try {
            int id = Integer.parseInt(inputId);
            Employee emp = null;
            // hanapin ang empleyado base sa ID
            for (Employee e : employees) {
                if (e.getEmployeeId() == id) {
                    emp = e;
                    break;
                }
            }
            if (emp == null) {
                JOptionPane.showMessageDialog(null, "No employee found with ID " + id);
                return;
            }

            // Input ng bagong salary
            while (true) {
                String inputSalary = JOptionPane.showInputDialog("Enter new Base Salary for " + emp.getEmployeeName() + " (per day): Php");
                if (inputSalary == null) return;
                try {
                    double newSalary = Double.parseDouble(inputSalary);
                    emp.updateSalary(newSalary); // i-update at i-save sa history
                    JOptionPane.showMessageDialog(null, "Salary successfully updated!");
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Salary must be numeric.");
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid ID input.");
        }
    }
}
