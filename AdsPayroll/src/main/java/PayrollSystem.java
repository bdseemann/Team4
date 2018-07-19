import java.util.ArrayList;
import java.util.List;

/**
 * Created by adeweese on 7/17/2018.
 */
public class PayrollSystem {
    public static final String TRANSACTION_TYPE_HOURS_WORKED = "HoursWorked";

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
        throw new RuntimeException("Employee not found");
    }

    public boolean pay() {
        try {
            for (Employee employee : employees) {
                employee.getOpenAcount().pay();
            }
            return true;
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
            return false;
        }
    }

    public void processTransaction(String id, String transactionType, String data) {
        Employee employee = getEmployee(id);
        if (TRANSACTION_TYPE_HOURS_WORKED.equals(transactionType)) {
            employee.getOpenAcount().setHoursWorked(Double.parseDouble(data));
        } else {
            throw new RuntimeException("Unrecognized transaction type");
        }
    }

    public static PayrollSystem getInstance() {
        return instance;
    }

    public boolean reset() {
        instance = new PayrollSystem();
        return true;
    }
}
