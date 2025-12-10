import javax.swing.JOptionPane;
import java.util.ArrayList;

class Car {
    private String companyName; // Pangalan ng kumpanya ng kotse
    private String modelName;   // Modelong pangalan ng kotse
    private int year;           // Taon ng paggawa ng kotse
    private double mileage;     // Kilometer na nalakbay ng kotse

    // Constructor para mag-create ng bagong Car object
    public Car(String companyName, String modelName, int year, double mileage) {
        this.companyName = companyName;
        this.modelName = modelName;
        setYear(year);  // Ginagamit ang setter para sa validation
        this.mileage = mileage;
    }

    // Getter at Setter para sa companyName
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) {
        if (!companyName.isEmpty()) this.companyName = companyName; // Siguraduhing hindi empty
    }

    // Getter at Setter para sa modelName
    public String getModelName() { return modelName; }
    public void setModelName(String modelName) {
        if (!modelName.isEmpty()) this.modelName = modelName; // Siguraduhing hindi empty
    }

    // Getter at Setter para sa year
    public int getYear() { return year; }
    public void setYear(int year) {
        if (year > 1885 && year <= 2025) this.year = year; // Valid na taon lamang
    }

    // Getter lang para sa mileage (hindi pwedeng baguhin directly)
    public double getMileage() { return mileage; }

    // Method para dagdagan ang mileage kapag nag-drive
    public void drive(double distance) {
        if (distance > 0) mileage += distance; // Dagdagan lang kung positive ang distance
    }

    // Method para makuha ang buong impormasyon ng kotse
    public String getInfo() {
        return "Company: " + companyName +
               "\nModel: " + modelName +
               "\nYear: " + year +
               "\nMileage: " + mileage + " km\n";
    }
}

public class CarManagementSystem {
    private static ArrayList<Car> cars = new ArrayList<>(); // Listahan ng lahat ng kotse

    public static void main(String[] args) {
        String menu;
        do {
            // GUI menu gamit ang JOptionPane
            menu = JOptionPane.showInputDialog(
                "Car Management System\n" +
                "1. Add Car\n" +
                "2. View All Cars\n" +
                "3. Drive a Car\n" +
                "4. Search Car\n" +
                "5. Delete Car\n" +
                "6. Summary Report\n" +
                "7. Exit\n" +
                "Enter your choice:"
            );

            // Switch-case para sa pagpili ng menu option
            switch (menu) {
                case "1": addCar(); break;      // Magdagdag ng kotse
                case "2": viewCars(); break;    // Ipakita lahat ng kotse
                case "3": driveCar(); break;    // Mag-drive ng kotse (update mileage)
                case "4": searchCar(); break;   // Hanapin ang kotse
                case "5": deleteCar(); break;   // Burahin ang kotse
                case "6": summaryReport(); break; // Ipakita summary ng lahat ng kotse
                case "7": JOptionPane.showMessageDialog(null, "Exiting system..."); break; // Lumabas
                default: JOptionPane.showMessageDialog(null, "Invalid choice!"); // Invalid input
            }
        } while (!menu.equals("7")); // Ulitin hanggang piliin ang Exit
    }

    // Method para magdagdag ng bagong kotse
    private static void addCar() {
        String company = JOptionPane.showInputDialog("Enter company name:");
        String model = JOptionPane.showInputDialog("Enter model name:");
        int year = Integer.parseInt(JOptionPane.showInputDialog("Enter year:"));
        double mileage = Double.parseDouble(JOptionPane.showInputDialog("Enter mileage:"));
        cars.add(new Car(company, model, year, mileage)); // Idagdag sa listahan
        JOptionPane.showMessageDialog(null, "Car added successfully!");
    }

    // Method para ipakita lahat ng kotse
    private static void viewCars() {
        if (cars.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Walang kotse sa listahan.");
            return;
        }
        StringBuilder list = new StringBuilder();
        for (Car car : cars) {
            list.append(car.getInfo()).append("----------------\n"); // Ilista ang bawat kotse
        }
        JOptionPane.showMessageDialog(null, list.toString());
    }

    // Method para mag-drive ng kotse at dagdagan ang mileage
    private static void driveCar() {
        if (cars.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Walang kotse na ma-drive.");
            return;
        }
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            list.append(i).append(": ").append(cars.get(i).getCompanyName())
                .append(" ").append(cars.get(i).getModelName()).append("\n");
        }
        int choice = Integer.parseInt(JOptionPane.showInputDialog("Piliin ang kotse:\n" + list));
        double distance = Double.parseDouble(JOptionPane.showInputDialog("Ilagay ang layo ng biyahe:"));
        cars.get(choice).drive(distance); // Tawagin ang drive method
        JOptionPane.showMessageDialog(null, "Mileage updated!");
    }

    // Method para maghanap ng kotse ayon sa company o model
    private static void searchCar() {
        String keyword = JOptionPane.showInputDialog("Ilagay ang company o model para hanapin:");
        StringBuilder results = new StringBuilder();
        for (Car car : cars) {
            if (car.getCompanyName().equalsIgnoreCase(keyword) || car.getModelName().equalsIgnoreCase(keyword)) {
                results.append(car.getInfo()).append("----------------\n");
            }
        }
        if (results.length() == 0) JOptionPane.showMessageDialog(null, "Walang nahanap na kotse.");
        else JOptionPane.showMessageDialog(null, results.toString());
    }

    // Method para burahin ang kotse mula sa listahan
    private static void deleteCar() {
        if (cars.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Walang kotse na pwedeng burahin.");
            return;
        }
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            list.append(i).append(": ").append(cars.get(i).getCompanyName())
                .append(" ").append(cars.get(i).getModelName()).append("\n");
        }
        int choice = Integer.parseInt(JOptionPane.showInputDialog("Piliin ang kotse na burahin:\n" + list));
        cars.remove(choice); // Burahin ang napiling kotse
        JOptionPane.showMessageDialog(null, "Car deleted successfully!");
    }

    // Method para ipakita summary ng lahat ng kotse
    private static void summaryReport() {
        if (cars.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Walang kotse sa listahan.");
            return;
        }
        double totalMileage = 0;
        for (Car car : cars) totalMileage += car.getMileage(); // Kalkulahin ang total mileage
        double avgMileage = totalMileage / cars.size(); // Kalkulahin ang average mileage
        JOptionPane.showMessageDialog(null,
            "Total cars: " + cars.size() +
            "\nAverage mileage: " + String.format("%.2f", avgMileage) + " km");
    }
}
