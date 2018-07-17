/**
 * Created by adeweese on 7/17/2018.
 */
public class Employee {

    private String name;
    private Dollars hourlyRate;
    private Dollars basePay;
    private double hoursWorked;

    public Dollars getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Dollars hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dollars getBasePay() {
        return basePay;
    }

    public void setBasePay(Dollars basePay) {
        this.basePay = basePay;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public boolean pay() {
        try {
            this.setBasePay(this.getHourlyRate().times(this.getHoursWorked()));
            return true;
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
            return false;
        }
    }
}
