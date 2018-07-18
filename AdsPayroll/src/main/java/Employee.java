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
    private String type;

    public Dollars getNetPay() {
        return netPay;
    }

    public void setNetPay(Dollars netPay) {
        this.netPay = netPay;
    }

    private Dollars netPay;

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
            this.setNetPay(this.getGrossPay().minus(this.getFederalIncomeTax()));
            return true;
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
            return false;
        }
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

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
