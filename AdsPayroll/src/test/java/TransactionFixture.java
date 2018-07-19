public class TransactionFixture {
    private String employeeNumber;
    private String transactionType;
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setData(String data) {
        PayrollSystem.getInstance().processTransaction(employeeNumber, transactionType, data);
    }
}
