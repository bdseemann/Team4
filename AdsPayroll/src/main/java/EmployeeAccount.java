import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class EmployeeAccount {
	private Employee employee;
	private Dollars basePay;
	private double hoursWorked;
	private Dollars grossPay;
	private Dollars federalIncomeTax;
	private Dollars stateTax;
	private Dollars netPay;
	private boolean paid;
	private Dollars qtdGross = Dollars.parse("0");
	private Dollars qtdTax = Dollars.parse("0");
	private Dollars qtdNet = Dollars.parse("0");
	private Dollars ytdGross = Dollars.parse("0");
	private Dollars ytdTax = Dollars.parse("0");
	private Dollars ytdNet = Dollars.parse("0");
	private Date payDate;

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

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public boolean pay(String payDateFromData) throws ParseException {
		Date payDate = new SimpleDateFormat("MM/dd/yyyy").parse(payDateFromData);
		this.setPayDate(payDate);
		this.setBasePay(calculateBasePay());
		this.setGrossPay(this.getBasePay());
		this.setFederalIncomeTax(this.getGrossPay().times(TaxRateService.getFederalIncomeTaxRate()));
		this.setStateTax(calculateStateTax());
		this.setNetPay(this.getGrossPay().minus(this.getFederalIncomeTax()).minus(this.getStateTax()));

		List<EmployeeAccount> accounts = employee.getAccounts();

		for (int i = accounts.size(); i > 0; i--) {
			EmployeeAccount previousAccount = accounts.get(i-1);
			Calendar startCalendar = new GregorianCalendar();
			startCalendar.setTime(previousAccount.getPayDate());
			Calendar endCalendar = new GregorianCalendar();
			endCalendar.setTime(payDate);

			int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
			int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

			if (diffMonth <= 3) {
				this.setQtdGross(previousAccount.getQtdGross().plus(this.getGrossPay()));
				this.setQtdTax(previousAccount.getQtdTax().plus(this.getFederalIncomeTax()).plus(this.getStateTax()));
				this.setQtdNet(previousAccount.getQtdNet().plus(this.getNetPay()));
			}

			if (diffYear == 0) {
				this.setYtdGross(previousAccount.getYtdGross().plus(this.getGrossPay()));
				this.setYtdTax(previousAccount.getYtdTax().plus(this.getFederalIncomeTax()).plus(this.getStateTax()));
				this.setYtdNet(previousAccount.getYtdNet().plus(this.getNetPay()));
			}
		}

		this.setPaid(true);
		return true;
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

	public Dollars getQtdGross() {
		return qtdGross;
	}

	public void setQtdGross(Dollars qtdGross) {
		this.qtdGross = qtdGross;
	}

	public Dollars getQtdTax() {
		return qtdTax;
	}

	public void setQtdTax(Dollars qtdTax) {
		this.qtdTax = qtdTax;
	}

	public Dollars getQtdNet() {
		return qtdNet;
	}

	public void setQtdNet(Dollars qtdNet) {
		this.qtdNet = qtdNet;
	}

	public Dollars getYtdGross() {
		return ytdGross;
	}

	public void setYtdGross(Dollars ytdGross) {
		this.ytdGross = ytdGross;
	}

	public Dollars getYtdTax() {
		return ytdTax;
	}

	public void setYtdTax(Dollars ytdTax) {
		this.ytdTax = ytdTax;
	}

	public Dollars getYtdNet() {
		return ytdNet;
	}

	public void setYtdNet(Dollars ytdNet) {
		this.ytdNet = ytdNet;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Date getPayDate() {
		return payDate;
	}
}
