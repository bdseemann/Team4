import java.util.ArrayList;
import java.util.List;

/**
 * Created by adeweese on 7/17/2018.
 */
public class PayrollSystem {

    private List<Employee> employees = new ArrayList<Employee>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void pay() {
        for (Employee employee: employees) {
            employee.setBasePay(employee.getHourlyRate().times(employee.getHoursWorked()));
        }
    }
}
