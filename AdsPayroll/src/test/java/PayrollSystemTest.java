import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by adeweese on 7/17/2018.
 */
public class PayrollSystemTest {

    private String testDate = "1/1/1900";

    @Test
    public void addEmployee() {
        PayrollSystem subject = new PayrollSystem();
        Employee employee = new Employee();
        employee.setName("Bob");

        subject.addEmployee(employee);

        assertEquals(1, subject.getEmployees().size());
    }

    @Test
    public void payEmployee() {
        PayrollSystem subject = new PayrollSystem();
        Employee employee = new Employee();
        employee.setName("Bob");
        employee.setHourlyRate(Dollars.parse("5"));
        employee.getOpenAcount().setHoursWorked(5d);
        subject.addEmployee(employee);

        subject.pay(testDate);

        assertEquals(Dollars.parse("25.00"), subject.getEmployees().get(0).getLastPaidAccount().getBasePay());
    }

    @Test
    public void payEmployeeById() {
        PayrollSystem subject = new PayrollSystem();
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("Bob");
        employee.setHourlyRate(Dollars.parse("5"));
        employee.getOpenAcount().setHoursWorked(5d);
        subject.addEmployee(employee);

        Employee retrievedEmployee = subject.getEmployee("1");

        assertEquals("Bob", retrievedEmployee.getName());
    }

    @Test(expected = RuntimeException.class)
    public void payEmployeeByIdWhereEmployeeIdDoesntExist() {
        PayrollSystem subject = new PayrollSystem();

        subject.getEmployee("1");

    }

    @Test
    public void processTransaction() {
        PayrollSystem subject = new PayrollSystem();
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("Bob");
        employee.setHourlyRate(Dollars.parse("5"));
        employee.getOpenAcount().setHoursWorked(5d);
        subject.addEmployee(employee);

        Double doubleData = 2d;
        subject.processTransaction("1", PayrollSystem.TRANSACTION_TYPE_HOURS_WORKED, "2");

        assertTrue(doubleData.equals(employee.getOpenAcount().getHoursWorked()));

    }

    @Test(expected = RuntimeException.class)
    public void processTransactionWhereTransactionTypeIsWrong() {
        PayrollSystem subject = new PayrollSystem();
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("Bob");
        employee.setHourlyRate(Dollars.parse("5"));
        employee.getOpenAcount().setHoursWorked(5d);
        subject.addEmployee(employee);

        Double doubleData = 2d;
        subject.processTransaction("1", "BAD_TRANSACTION_TYPE", "2");

    }

}