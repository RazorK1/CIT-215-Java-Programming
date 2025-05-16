import java.text.DecimalFormat;

public class BankAccount {
    private String name;
    private int accountNumber;
    private double balance;

    //////////////// Default Constructor
    public BankAccount() {
        this.name = "";
        this.accountNumber = 101;
        this.balance = 500.00;
    }

    ///////////////// Constructor with Parameters
    public BankAccount(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    ////////////////// Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAccountNumber() { return accountNumber; }
    public void setAccountNumber(int accountNumber) { this.accountNumber = accountNumber; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    ///////////// toString() method
    public String toString() {
        //return "Account Holder: " + name + "\n Account Number: " + accountNumber + "\n Balance: $" + balance;
        DecimalFormat df = new DecimalFormat("0.00");
        return "Account Holder: " + name +
                "\n Account Number: " + accountNumber +
                "\n Balance: $" + df.format(balance);
    }

    ////////////////// Deposit Method
    public String deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return toString();
        } else {
            return "Error: Amount must be positive!";
        }
    }

    /////////////////// Withdraw Method
    public String withdraw(double amount) {
        if (amount > balance) {
            return "Error: Amount exceeds balance! This is NOT Chase bank!";
        } else if (amount < 1 || amount > 200) {
            return "Error: Withdrawal must be between $1-$200!";
        } else {
            balance -= amount;
            return toString();
        }
    }
}
