public class EmployeeSetupFixture {
    private Employee employee;

    public boolean clearEmployees(){
        return PayrollSystem.getInstance().reset();
    }

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

    public void setState(String state) {
        employee.setState(state);
    }

    public boolean add() {
        return PayrollSystem.getInstance().addEmployee(employee);
    }

    public int size() {
        return PayrollSystem.getInstance().getEmployees().size();
    }

}
