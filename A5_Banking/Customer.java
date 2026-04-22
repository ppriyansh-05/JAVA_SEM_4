import java.util.ArrayList;

public class Customer {

    private String custId;
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String custId, String name) {
        this.custId = custId;
        this.name = name;
        accounts = new ArrayList<>();
    }

    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    public String getCustId() {
        return custId;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void displayCustomer() {
        System.out.println("\nCustomer: " + name);
        for (Account acc : accounts) {
            acc.display();
        }
    }
}