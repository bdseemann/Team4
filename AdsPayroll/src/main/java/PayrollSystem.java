import java.util.ArrayList;
import java.util.List;

/**
 * Created by adeweese on 7/17/2018.
 */
public class PayrollSystem {

    private static PayrollSystem instance = new PayrollSystem();
    private List<Employee> employees = new ArrayList<Employee>();

    public boolean addEmployee(Employee employee) {
        return employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployee(String id) {
        for (Employee employee : employees) {
            if (id.equals(employee.getId())) {
                return employee;
            }
        }
        return null;
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

    public static PayrollSystem getInstance() {
        return instance;
    }
}
