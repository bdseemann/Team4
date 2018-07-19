import java.util.HashMap;

public class TaxRateService {
	private static HashMap<String, Double> taxRates;

	static {
		taxRates = new HashMap<>();
		taxRates.put("MI", .0395d);
		taxRates.put("WI", .0510d);
		taxRates.put("IL", .0460d);
	}

	public static Double getStateTaxRate(String state) {
		return taxRates.get(state);
	}

	public static double getFederalTaxRate() {
		return .25d;
	}
}
