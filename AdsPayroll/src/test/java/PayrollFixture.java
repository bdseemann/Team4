public class PayrollFixture {
	private Employee employee;
	private String payDate;

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public boolean pay() {
		return PayrollSystem.getInstance().pay();
	}

	public void setId(String employeeNumber) {
		employee = PayrollSystem.getInstance().getEmployee(employeeNumber);
	}

	public String name() {
		return employee.getName();
	}

	public String base() {
		return employee.getLastPaidAccount().getBasePay().toCleanString();
	}

	public String gross() {
		return employee.getLastPaidAccount().getGrossPay().toCleanString();
	}

	public String federalTax() {
		return employee.getLastPaidAccount().getFederalIncomeTax().toCleanString();
	}

	public String stateTax() {
		return employee.getLastPaidAccount().getStateTax().toCleanString();
	}

	public String net() {
		return employee.getLastPaidAccount().getNetPay().toCleanString();
	}

	public String qtdGross() {
		return "Not Implemented";
	}

	public String qtdTax() {
		return "Not Implemented";
	}

	public String qtdNet() {
		return "Not Implemented";
	}

	public String ytdGross() {
		return "Not Implemented";
	}

	public String ytdTax() {
		return "Not Implemented";
	}

	public String ytdNet() {
		return "Not Implemented";
	}
}
