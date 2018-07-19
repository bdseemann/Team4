import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by adeweese on 7/17/2018.
 */
public class EmployeeAccountTest {
	private Employee employee;
	private EmployeeAccount subject;
	@Before
	public void before() {
		employee = new Employee();
		subject = employee.getOpenAcount();
	}

    @Test
    public void hourlyCalculatesBasePay() {

		employee.setType("HOURLY");
		employee.setHourlyRate(Dollars.parse("5"));
        subject.setHoursWorked(5d);

        boolean result = subject.pay();

        assertTrue(result);
        assertEquals(Dollars.parse("25.00"), subject.getBasePay());
    }

    @Test
    public void salaryCalculatesBasePay() {

		employee.setType("SALARY");
		employee.setHourlyRate(Dollars.parse("5000"));
        subject.setHoursWorked(5d);

        boolean result = subject.pay();

        assertTrue(result);
        assertEquals(Dollars.parse("5000.00"), subject.getBasePay());
    }

    @Test
    public void calculatesGrossPay() {

		employee.setType("HOURLY");
		employee.setHourlyRate(Dollars.parse("250"));
        subject.setHoursWorked(10d);

        boolean result = subject.pay();

        assertTrue(result);
        assertEquals(Dollars.parse("2500.00"), subject.getGrossPay());
    }

    @Test
    public void calculatesFederalIncomeTax() {

		employee.setType("HOURLY");
		employee.setHourlyRate(Dollars.parse("10"));
        subject.setHoursWorked(10d);

        boolean result = subject.pay();

        assertTrue(result);
        assertEquals(Dollars.parse("25.00"), subject.getFederalIncomeTax());
    }

    @Test
    public void calculatesStateTaxMichigan() {

		employee.setType("HOURLY");
		employee.setHourlyRate(Dollars.parse("10"));
        subject.setHoursWorked(10d);
		employee.setState("MI");

        boolean result = subject.pay();

        assertTrue(result);
        assertEquals(Dollars.parse("3.95"), subject.getStateTax());
    }

    @Test
    public void calculatesStateTaxWisconsin() {

		employee.setType("HOURLY");
		employee.setHourlyRate(Dollars.parse("10"));
        subject.setHoursWorked(10d);
		employee.setState("WI");

        boolean result = subject.pay();

        assertTrue(result);
        assertEquals(Dollars.parse("5.10"), subject.getStateTax());
    }

    @Test
    public void calculatesStateTaxIllinois() {

		employee.setType("HOURLY");
		employee.setHourlyRate(Dollars.parse("10"));
        subject.setHoursWorked(10d);
		employee.setState("IL");

        boolean result = subject.pay();

        assertTrue(result);
        assertEquals(Dollars.parse("4.60"), subject.getStateTax());
    }

    @Test
    public void calculatesNetPay() {

		employee.setType("HOURLY");
		employee.setHourlyRate(Dollars.parse("10"));
        subject.setHoursWorked(10d);

        boolean result = subject.pay();

        assertTrue(result);
        assertEquals(Dollars.parse("75.00"), subject.getNetPay());
    }
}