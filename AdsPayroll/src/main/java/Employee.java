/**
 * Created by adeweese on 7/17/2018.
 */
public class Employee {

    private String name;
    private Dollars hourlyRate;

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
}
