public class PaymentFixture {

    private PayrollSystem subject = new PayrollSystem();
    private Employee employee = new Employee();

    public void setName(String name) {
        this.employee.setName(name);
    }

    public void setHourlyRate(String hourlyRate) {
        this.employee.setHourlyRate(Dollars.parse(hourlyRate));
    }

    public void setHoursWorked(double hoursWorked) {
        this.employee.setHoursWorked(hoursWorked);
    }

    public boolean pay() {
        subject.addEmployee(employee);

        return subject.pay();
    }

    public String basePay() {
        return subject.getEmployees().get(0).getBasePay().toCleanString();
    }

}
