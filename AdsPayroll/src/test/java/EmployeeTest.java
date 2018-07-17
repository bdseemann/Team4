import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by adeweese on 7/17/2018.
 */
public class EmployeeTest {
    @Test
    public void calculatesBasePay() {

        Employee subject = new Employee();
        subject.setHourlyRate(Dollars.parse("5"));
        subject.setHoursWorked(5d);

        boolean result = subject.pay();

        assertTrue(result);
        assertEquals(Dollars.parse("25.00"), subject.getBasePay());
    }

    @Test
    public void calculatesGrossPay() {

        Employee subject = new Employee();
        subject.setHourlyRate(Dollars.parse("250"));
        subject.setHoursWorked(10d);

        boolean result = subject.pay();

        assertTrue(result);
        assertEquals(Dollars.parse("2500.00"), subject.getGrossPay());
    }

    @Test
    public void calculatesFederalIncomeTax() {

        Employee subject = new Employee();
        subject.setHourlyRate(Dollars.parse("10"));
        subject.setHoursWorked(10d);

        boolean result = subject.pay();

        assertTrue(result);
        assertEquals(Dollars.parse("25.00"), subject.getFederalIncomeTax());
    }

    @Test
    public void calculatesNetPay() {

        Employee subject = new Employee();
        subject.setHourlyRate(Dollars.parse("10"));
        subject.setHoursWorked(10d);

        boolean result = subject.pay();

        assertTrue(result);
        assertEquals(Dollars.parse("75.00"), subject.getNetPay());
    }
}