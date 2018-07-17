import org.joda.money.Money;

public class PaymentFixture {
    private String name;
    private Money hourlyRate;
    private int hoursWorked;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Money hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public boolean isPay() {
        return true;
    }


    public Money basePay() {
        return hourlyRate.multipliedBy(hoursWorked);
    }

}
