import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by adeweese on 7/17/2018.
 */
public class EmployeeAccountTest {
	private Employee employee;
	private EmployeeAccount subject;
    private String testDate = "1/1/1900";
	@Before
	public void before() {
		employee = new Employee();
		subject = employee.getOpenAcount();
	}

    @Test
    public void hourlyCalculatesBasePay() throws ParseException {

		employee.setType("HOURLY");
		employee.setHourlyRate(Dollars.parse("5"));
        subject.setHoursWorked(5d);

        boolean result = subject.pay(testDate);

        assertTrue(result);
        assertEquals(Dollars.parse("25.00"), subject.getBasePay());
    }

    @Test
    public void salaryCalculatesBasePay() throws ParseException {

		employee.setType("SALARY");
		employee.setHourlyRate(Dollars.parse("5000"));
        subject.setHoursWorked(5d);

        boolean result = subject.pay(testDate);

        assertTrue(result);
        assertEquals(Dollars.parse("5000.00"), subject.getBasePay());
    }

    @Test
    public void calculatesGrossPay() throws ParseException {

		employee.setType("HOURLY");
		employee.setHourlyRate(Dollars.parse("250"));
        subject.setHoursWorked(10d);

        boolean result = subject.pay(testDate);

        assertTrue(result);
        assertEquals(Dollars.parse("2500.00"), subject.getGrossPay());
    }

    @Test
    public void calculatesFederalIncomeTax() throws ParseException {

		employee.setType("HOURLY");
		employee.setHourlyRate(Dollars.parse("10"));
        subject.setHoursWorked(10d);

        boolean result = subject.pay(testDate);

        assertTrue(result);
        assertEquals(Dollars.parse("25.00"), subject.getFederalIncomeTax());
    }

    @Test
    public void calculatesStateTaxMichigan() throws ParseException {

		employee.setType("HOURLY");
		employee.setHourlyRate(Dollars.parse("10"));
        subject.setHoursWorked(10d);
		employee.setState("MI");

        boolean result = subject.pay(testDate);

        assertTrue(result);
        assertEquals(Dollars.parse("3.95"), subject.getStateTax());
    }

    @Test
    public void calculatesStateTaxWisconsin() throws ParseException {

		employee.setType("HOURLY");
		employee.setHourlyRate(Dollars.parse("10"));
        subject.setHoursWorked(10d);
		employee.setState("WI");

        boolean result = subject.pay(testDate);

        assertTrue(result);
        assertEquals(Dollars.parse("5.10"), subject.getStateTax());
    }

    @Test
    public void calculatesStateTaxIllinois() throws ParseException {

		employee.setType("HOURLY");
		employee.setHourlyRate(Dollars.parse("10"));
        subject.setHoursWorked(10d);
		employee.setState("IL");

        boolean result = subject.pay(testDate);

        assertTrue(result);
        assertEquals(Dollars.parse("4.60"), subject.getStateTax());
    }

    @Test
    public void calculatesNetPay() throws ParseException {

		employee.setType("HOURLY");
		employee.setHourlyRate(Dollars.parse("10"));
        subject.setHoursWorked(10d);

        boolean result = subject.pay(testDate);

        assertTrue(result);
        assertEquals(Dollars.parse("75.00"), subject.getNetPay());
    }
}