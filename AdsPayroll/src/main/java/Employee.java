/**
 * Created by adeweese on 7/17/2018.
 */
public class Employee {
	private String name;
	private Dollars hourlyRate;
	private String id;
	private String type = "HOURLY";
	private String state;
	private EmployeeAccount account;

	public Employee() {
		this.setAccount(new EmployeeAccount());
	}

	public EmployeeAccount getAccount() {
		return account;
	}

	public void setAccount(EmployeeAccount account) {
		this.account = account;
		account.setEmployee(this);
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

	public boolean pay() {
		return getAccount().pay();
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
}
