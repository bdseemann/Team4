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
		return employee.getAccount().getBasePay().toCleanString();
	}

	public String gross() {
		return employee.getAccount().getGrossPay().toCleanString();
	}

	public String federalTax() {
		return employee.getAccount().getFederalIncomeTax().toCleanString();
	}

	public String stateTax() {
		return employee.getAccount().getStateTax().toCleanString();
	}

	public String net() {
		return employee.getAccount().getNetPay().toCleanString();
	}
}
