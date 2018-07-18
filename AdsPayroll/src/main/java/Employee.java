/**
 * Created by adeweese on 7/17/2018.
 */
public class Employee {
	private String name;
	private Dollars hourlyRate;
	private Dollars basePay;
	private double hoursWorked;
	private Dollars grossPay;
	private Dollars federalIncomeTax;
	private String id;
	private String type = "HOURLY";
	private String state;
	private Dollars stateTax;
	private Dollars netPay;

	public Dollars getNetPay() {
		return netPay;
	}

	public void setNetPay(Dollars netPay) {
		this.netPay = netPay;
	}

	public Dollars getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(Dollars hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dollars getBasePay() {
		return basePay;
	}

	public void setBasePay(Dollars basePay) {
		this.basePay = basePay;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public boolean pay() {
		try {
			if ("HOURLY".equals(this.type)) {
				this.setBasePay(this.getHourlyRate().times(this.getHoursWorked()));
			} else {
				this.setBasePay(this.getHourlyRate());
			}
			this.setGrossPay(this.getBasePay());
			this.setFederalIncomeTax(this.getGrossPay().times(0.25d));
			this.setStateTax(calculateStateTax());
			this.setNetPay(this.getGrossPay().minus(this.getFederalIncomeTax()).minus(this.getStateTax()));
			return true;
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return false;
		}
	}

	private Dollars calculateStateTax() {
		Dollars stateTax = Dollars.parse("0");
		if (this.getState() != null) {
			switch (this.getState()) {
				case "MI": {
					stateTax = this.getBasePay().times(.0395d);
					break;
				}
				case "WI": {
					stateTax = this.getBasePay().times(.0510d);
					break;
				}
				case "IL": {
					stateTax = this.getBasePay().times(.0460d);
					break;
				}
				default: {
				}
			}
		}
		return stateTax;
	}

	public Dollars getGrossPay() {
		return grossPay;
	}

	public void setGrossPay(Dollars grossPay) {
		this.grossPay = grossPay;
	}

	public Dollars getFederalIncomeTax() {
		return federalIncomeTax;
	}

	public void setFederalIncomeTax(Dollars federalIncomeTax) {
		this.federalIncomeTax = federalIncomeTax;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Dollars getStateTax() {
		return stateTax;
	}

	public void setStateTax(Dollars stateTax) {
		this.stateTax = stateTax;
	}
}
