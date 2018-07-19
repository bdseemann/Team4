public class PayrollFixture {
	private Employee employee;

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
}
