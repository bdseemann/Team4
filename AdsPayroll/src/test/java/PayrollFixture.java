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
		return employee.getBasePay().toCleanString();
	}

	public String gross() {
		return employee.getGrossPay().toCleanString();
	}

	public String federalTax() {
		return employee.getFederalIncomeTax().toCleanString();
	}

	public String stateTax() {
		return "not implemented";
	}

	public String net() {
		return employee.getNetPay().toCleanString();
	}
}
