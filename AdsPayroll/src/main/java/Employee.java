import java.util.ArrayList;
import java.util.List;

/**
 * Created by adeweese on 7/17/2018.
 */
public class Employee {
	private String name;
	private Dollars hourlyRate;
	private String id;
	private String type = "HOURLY";
	private String state;
	private List<EmployeeAccount> checks = new ArrayList<EmployeeAccount>();

	public Employee() {
	}

	public List<EmployeeAccount> getChecks() {
		return checks;
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

	public void addCheck(EmployeeAccount check) {
		checks.add(check);
	}

	public EmployeeAccount getOpenAcount() {
		for (EmployeeAccount account : checks) {
			if (!account.isPaid()) {
				return account;
			}
		}
		EmployeeAccount newAccount = new EmployeeAccount();
		newAccount.setEmployee(this);
		checks.add(newAccount);
		return newAccount;
	}

	public EmployeeAccount getLastPaidAccount() {
		for (int i = checks.size() - 1; i >= 0; i--) {
			if (checks.get(i).isPaid()) {
				return checks.get(i);
			}
		}
		throw new RuntimeException("No Paid Account Found");
	}

	public List<EmployeeAccount> getAccounts() {
		return checks;
	}
}
