package car;
public class CAR {

    // Private variables
    private String company_name;
    private String model_name;
    private int year;
    private double mileage;

    // company name
    public String getCompanyName() {
        return company_name;
    }

    public void setCompanyName(String company_name) {
        this.company_name = company_name;
    }

    // model name
    public String getModelName() {
        return model_name;
    }

    public void setModelName(String model_name) {
        this.model_name = model_name;
    }

    // year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // fully encapsulated
    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    // Add feat : Calculate car age
    public int getCarAge() {
        return 2025 - year;
    }

    // Add feat 2: Check fuel efficiency
    public boolean isFuelEfficient() {
        return mileage > 15; 
    }

    // test encapsulation
    public static void main(String[] args) {
        CAR car = new CAR();

        // Set data using setters
        car.setCompanyName("Toyota");
        car.setModelName("Vios");
        car.setYear(2018);
        car.setMileage(18.5);

        // Access data using getters
        System.out.println("=== CAR DETAILS ===");
        System.out.println("Company: " + car.getCompanyName());
        System.out.println("Model: " + car.getModelName());
        System.out.println("Year: " + car.getYear());
        System.out.println("Mileage: " + car.getMileage() + " km/L");
        System.out.println("Car Age: " + car.getCarAge() + " years");
        System.out.println("Fuel Efficient? " + car.isFuelEfficient());
    }
}


