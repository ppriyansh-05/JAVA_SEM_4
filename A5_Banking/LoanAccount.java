public class LoanAccount extends Account {

    private double loanAmount;

    public LoanAccount(String acctNo, double loanAmount) {
        super(acctNo, 0);
        this.loanAmount = loanAmount;
    }

    @Override
    public void deposit(double amt) {
        loanAmount -= amt;
        System.out.println("Loan Paid: " + amt);
    }

    @Override
    public void withdraw(double amt) {
        System.out.println("Withdraw not allowed");
    }

    public void payEMI(double amt) {
        loanAmount -= amt;
        System.out.println("EMI Paid: " + amt);
    }

    @Override
    public void display() {
        System.out.println("Loan Account: " + acctNo + " Remaining Loan: " + loanAmount);
    }
}