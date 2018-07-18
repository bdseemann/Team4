import java.util.HashMap;

public class TaxRateService {
	private static TaxRateService instance = new TaxRateService();
	private HashMap<String, Double> taxRates;

	private TaxRateService() {
		this.taxRates = new HashMap<>();
		taxRates.put("MI", .0395d);
		taxRates.put("WI", .0510d);
		taxRates.put("IL", .0460d);
	}

	public static TaxRateService getInstance() {
		return instance;
	}

	public Double getStateTaxRate(String state) {
		return taxRates.get(state);
	}
}
