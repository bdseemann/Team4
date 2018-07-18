public class EmployeeAccount {
	private Employee employee;
	private Dollars basePay;
	private double hoursWorked;
	private Dollars grossPay;
	private Dollars federalIncomeTax;
	private Dollars stateTax;
	private Dollars netPay;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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

	public Dollars getStateTax() {
		return stateTax;
	}

	public void setStateTax(Dollars stateTax) {
		this.stateTax = stateTax;
	}

	public Dollars getNetPay() {
		return netPay;
	}

	public void setNetPay(Dollars netPay) {
		this.netPay = netPay;
	}

	public boolean pay() {
		try {
			this.setBasePay(calculateBasePay());
			this.setGrossPay(this.getBasePay());
			this.setFederalIncomeTax(this.getGrossPay().times(TaxRateService.getFederalTaxRate()));
			this.setStateTax(calculateStateTax());
			this.setNetPay(this.getGrossPay().minus(this.getFederalIncomeTax()).minus(this.getStateTax()));
			return true;
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
			return false;
		}
	}

	private Dollars calculateBasePay() {
		if ("HOURLY".equals(getEmployee().getType())) {
			return getEmployee().getHourlyRate().times(this.getHoursWorked());
		} else {
			return getEmployee().getHourlyRate();
		}
	}

	private Dollars calculateStateTax() {
		Dollars stateTax = Dollars.parse("0");
		Double taxRate = TaxRateService.getStateTaxRate(getEmployee().getState());
		if (taxRate != null) {
			stateTax = this.getBasePay().times(taxRate);
		}
		return stateTax;
	}
}
