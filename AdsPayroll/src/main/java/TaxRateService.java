import java.util.HashMap;

public class TaxRateService {
	private static final HashMap<String, Double> STATE_TAX_RATES = new HashMap<>();;
	private static final HashMap<String, Double> FEDERAL_TAX_RATES = new HashMap<>();;
	static {
		STATE_TAX_RATES.put("MI", .0395d);
		STATE_TAX_RATES.put("WI", .0510d);
		STATE_TAX_RATES.put("IL", .0460d);
		FEDERAL_TAX_RATES.put("INCOME", .25d);
	}

	public static Double getStateTaxRate(String state) {
		return STATE_TAX_RATES.get(state);
	}

	public static double getFederalIncomeTaxRate() {
		return FEDERAL_TAX_RATES.get("INCOME");
	}
}
