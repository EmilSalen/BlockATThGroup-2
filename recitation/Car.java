package recitation;

public class Car {

    private String company_name;
    private String model_name;
    private int year;
    private double mileage;

    public Car(String company_name, String model_name, int year, double mileage) {
        this.company_name = company_name;
        this.model_name = model_name;
        this.year = year;
        this.mileage = mileage;
    }

    public String getCompanyName() {
        return company_name;
    }

    public void setCompanyName(String company_name) {
        this.company_name = company_name;
    }

    public String getModelName() {
        return model_name;
    }

    public void setModelName(String model_name) {
        this.model_name = model_name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getMileage() {
        return mileage;
    }


    public boolean needsMaintenance() {
        return mileage > 100000;
    }


    public String getCarCondition() {
        int currentYear = java.time.Year.now().getValue();
        int age = currentYear - year;

        if (age <= 3) {
            return "New";
        } else {
            return "Old";
        }
    }
}
