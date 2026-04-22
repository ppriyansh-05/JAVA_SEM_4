public class Account {

    protected String acctNo;
    protected double balance;

    public Account(String acctNo, double balance) {
        this.acctNo = acctNo;
        this.balance = balance;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        balance += amt;
        System.out.println("Deposited: " + amt);
    }

    public void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawn: " + amt);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void display() {
        System.out.println("Account: " + acctNo + " Balance: " + balance);
    }
}