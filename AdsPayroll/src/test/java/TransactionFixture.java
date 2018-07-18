public class TransactionFixture {
    private Employee employee;
    private String transactionType;
    public void setEmployeeNumber(String employeeNumber) {
        employee = PayrollSystem.getInstance().getEmployee(employeeNumber);
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setData(String data) {
        if ("HoursWorked".equals(transactionType)) {
            employee.getAccount().setHoursWorked(Double.parseDouble(data));
        }
    }


}
