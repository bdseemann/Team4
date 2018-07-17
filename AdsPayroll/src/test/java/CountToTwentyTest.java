import org.junit.Assert;
import org.junit.Test;

public class CountToTwentyTest {
	@Test
	public void testCountToTwenty() {
		Integer i = 0;
		for (Object o : new Object[20]) {
			i++;
		}
		Assert.assertEquals(i, Integer.valueOf(20));
	}
}
