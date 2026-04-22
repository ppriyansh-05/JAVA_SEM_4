import java.util.ArrayList;
import java.util.Scanner;

public class BankingApp {

    static ArrayList<Customer> customers = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n1. Create Customer & Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Pay Loan EMI");
            System.out.println("5. Display All");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createCustomer();
                    break;

                case 2:
                    depositAmount();
                    break;

                case 3:
                    withdrawAmount();
                    break;

                case 4:
                    payEMI();
                    break;

                case 5:
                    displayAll();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);
    }

    static void createCustomer() {
        System.out.print("Enter Customer ID: ");
        String id = sc.next();
        System.out.print("Enter Name: ");
        String name = sc.next();

        Customer c = new Customer(id, name);

        System.out.print("1. Savings  2. Loan: ");
        int type = sc.nextInt();

        if (type == 1) {
            System.out.print("Enter Account No: ");
            String accNo = sc.next();
            System.out.print("Enter Balance: ");
            double bal = sc.nextDouble();

            SavingsAccount sa = new SavingsAccount(accNo, bal, 1000);
            c.addAccount(sa);

        } else {
            System.out.print("Enter Loan Account No: ");
            String accNo = sc.next();
            System.out.print("Enter Loan Amount: ");
            double loan = sc.nextDouble();

            LoanAccount la = new LoanAccount(accNo, loan);
            c.addAccount(la);
        }

        customers.add(c);
    }

    static Account findAccount(String accNo) {
        for (Customer c : customers) {
            for (Account a : c.getAccounts()) {
                if (a.getAcctNo().equals(accNo)) {
                    return a;
                }
            }
        }
        return null;
    }

    static void depositAmount() {
        System.out.print("Enter Account No: ");
        String accNo = sc.next();

        Account acc = findAccount(accNo);

        if (acc != null) {
            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble();
            acc.deposit(amt);
        } else {
            System.out.println("Account not found");
        }
    }

    static void withdrawAmount() {
        System.out.print("Enter Account No: ");
        String accNo = sc.next();

        Account acc = findAccount(accNo);

        if (acc != null) {
            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble();
            acc.withdraw(amt);
        } else {
            System.out.println("Account not found");
        }
    }

    static void payEMI() {
        System.out.print("Enter Loan Account No: ");
        String accNo = sc.next();

        Account acc = findAccount(accNo);

        if (acc instanceof LoanAccount) {
            System.out.print("Enter EMI Amount: ");
            double amt = sc.nextDouble();
            ((LoanAccount) acc).payEMI(amt);
        } else {
            System.out.println("Not a Loan Account");
        }
    }

    static void displayAll() {
        for (Customer c : customers) {
            c.displayCustomer();
        }
    }
}