public class SavingsAccount extends Account {

    private double minBalance;

    public SavingsAccount(String acctNo, double balance, double minBalance) {
        super(acctNo, balance);
        this.minBalance = minBalance;
    }

    @Override
    public void withdraw(double amt) {
        if ((balance - amt) < minBalance) {
            System.out.println("Minimum balance required");
        } else {
            balance -= amt;
            System.out.println("Savings Withdraw: " + amt);
        }
    }

    @Override
    public void display() {
        System.out.println("Savings Account: " + acctNo + " Balance: " + balance);
    }
}