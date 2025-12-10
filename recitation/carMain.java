package recitation;

public class carMain {
    public static void main(String[] args) {

        Car myCar = new Car("Toyota", "Corolla", 2019, 42000);

        System.out.println("Company: " + myCar.getCompanyName());
        System.out.println("Model: " + myCar.getModelName());
        System.out.println("Year: " + myCar.getYear());
        System.out.println("Mileage: " + myCar.getMileage() + " km");

        System.out.println("Car Condition: " + myCar.getCarCondition());
        System.out.println("Needs Maintenance: " + (myCar.needsMaintenance() ? "Yes" : "No"));
    }
}
