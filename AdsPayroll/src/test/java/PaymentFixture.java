public class PaymentFixture {
    private Employee subject = new Employee();

    public void setName(String name) {
        this.subject.setName(name);
    }

    public void setHourlyRate(String hourlyRate) {
        this.subject.setHourlyRate(Dollars.parse(hourlyRate));
    }

    public void setHoursWorked(double hoursWorked) {
        this.subject.setHoursWorked(hoursWorked);
    }

    public boolean pay() {
        return this.subject.pay();
    }

    public String basePay() {
        return this.subject.getBasePay().toCleanString();
    }

    public String grossPay() {
        return this.subject.getGrossPay().toCleanString();
    }

}
