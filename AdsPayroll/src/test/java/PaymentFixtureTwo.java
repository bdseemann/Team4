public class PaymentFixtureTwo {
    private Employee employee;

    public void setId(String id) {
        employee = new Employee();
        employee.setId(id);

    }
    public void setName(String name) {
        employee.setName(name);

    }
    public void setType(String type) {
        employee.setType(type);
    }

    public void setPayRate(String payRate) {
        employee.setHourlyRate(Dollars.parse(payRate));
    }

    public boolean add() {
        return PayrollSystem.getInstance().addEmployee(employee);
    }

    public int size() {
        return PayrollSystem.getInstance().getEmployees().size();
    }

}
