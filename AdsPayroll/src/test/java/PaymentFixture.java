public class PaymentFixture {
    private Employee subject = new Employee();

    public void setName(String name) {
        this.subject.setName(name);
    }

    public void setHourlyRate(String hourlyRate) {
        this.subject.setHourlyRate(Dollars.parse(hourlyRate));
    }

    public void setHoursWorked(double hoursWorked) {
        this.subject.getOpenAcount().setHoursWorked(hoursWorked);
    }

    public boolean pay() {
        return this.subject.getOpenAcount().pay();
    }

    public String basePay() {
        return this.subject.getLastPaidAccount().getBasePay().toCleanString();
    }

    public String grossPay() {
        return this.subject.getLastPaidAccount().getGrossPay().toCleanString();
    }

    public String federalIncomeTax() {
        return this.subject.getLastPaidAccount().getFederalIncomeTax().toCleanString();
    }

    public String netPay() {
        return this.subject.getLastPaidAccount().getNetPay().toCleanString();
    }

}
