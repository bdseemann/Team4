import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adeweese on 7/17/2018.
 */
public class EmployeeTest {

    @Test
    public void calculatesBasePay() {

        Employee subject = new Employee();
        subject.setName("Bob");
        subject.setHourlyRate(Dollars.parse("5"));
        subject.setHoursWorked(5d);

        boolean result = subject.pay();

        assertTrue(result);
        assertEquals(Dollars.parse("25.00"), subject.getBasePay());
    }
}