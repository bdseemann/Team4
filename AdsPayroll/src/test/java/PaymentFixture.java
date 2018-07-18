public class PaymentFixture {
    private Employee subject = new Employee();

    public void setName(String name) {
        this.subject.setName(name);
    }

    public void setHourlyRate(String hourlyRate) {
        this.subject.setHourlyRate(Dollars.parse(hourlyRate));
    }

    public void setHoursWorked(double hoursWorked) {
        this.subject.getAccount().setHoursWorked(hoursWorked);
    }

    public boolean pay() {
        return this.subject.pay();
    }

    public String basePay() {
        return this.subject.getAccount().getBasePay().toCleanString();
    }

    public String grossPay() {
        return this.subject.getAccount().getGrossPay().toCleanString();
    }

    public String federalIncomeTax() {
        return this.subject.getAccount().getFederalIncomeTax().toCleanString();
    }

    public String netPay() {
        return this.subject.getAccount().getNetPay().toCleanString();
    }

}
