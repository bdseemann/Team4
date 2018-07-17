import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by adeweese on 7/17/2018.
 */
public class PayrollSystem {

    private List<Employee> employees = new ArrayList<Employee>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }
}
