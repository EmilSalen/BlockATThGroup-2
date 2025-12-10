package car;
public class CAR {
    private String company_name;
    private String model_name;
    private int year;
    private int mileage; 


   
    public CAR(String company, String model, int year, int mileage) {
        this.company_name = company;
        this.model_name = model;
        this.year = year;
        this.mileage = mileage;
    }
    
    //Company Name
    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    // Name
    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    // Methods for Year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }
    
    //Feature
    public int calculateCarAge(int currentYear) {
        return currentYear - this.year;
    }
    
    //Feature
    public void drive(int distance) {
        if (distance > 0) {
            this.mileage += distance; // private variable within the class
            System.out.println("\n--- Trip Simulated ---");
            System.out.println("Drove " + distance + " units.");
            System.out.println("New Mileage: " + this.mileage + " units.");
        } else {
            System.out.println("Invalid distance for trip.");
        }
    }

    
    public static void main(String[] args) {
        // Create a Car object
        CAR myCar = new CAR("Toyota", "Camry", 2020, 45000);

        System.out.println("\nInitial Car Details:");
        System.out.println("Company: " + myCar.getCompany_name());
        System.out.println("Model: " + myCar.getModel_name());
        System.out.println("Year: " + myCar.getYear());
        System.out.println("Mileage: " + myCar.getMileage()); // Read-only access

        // Calculate Age (Feature)
        int currentYear = 2025;
        System.out.println("Car Age (in " + currentYear + "): " + myCar.calculateCarAge(currentYear) + " years");
        
        // Simulate a trip (Feature) 
        myCar.drive(500);
        
        // Modify other attributes
        myCar.setCompany_name("Honda");
        myCar.setYear(2021);
        
        // Final State
        System.out.println("\n--- Final Car Details ---");
        System.out.println("Company: " + myCar.getCompany_name());
        System.out.println("Year: " + myCar.getYear());
        System.out.println("Mileage: " + myCar.getMileage());
    }
}