import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adeweese on 7/17/2018.
 */
public class PayrollSystemTest {

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
        employee.getAccount().setHoursWorked(5d);
        subject.addEmployee(employee);

        subject.pay();

        assertEquals(Dollars.parse("25.00"), subject.getEmployees().get(0).getAccount().getBasePay());
    }
}