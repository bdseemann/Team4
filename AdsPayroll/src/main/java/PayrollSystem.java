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

    public boolean pay() {
        try {
            for (Employee employee : employees) {
                employee.pay();
            }
            return true;
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
            return false;
        }
    }
}
