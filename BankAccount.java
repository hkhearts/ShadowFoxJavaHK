import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private String ownerName;
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    public BankAccount(String ownerName, String accountNumber, double balance) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial balance: $" + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: $" + amount + " | New Balance: $" + balance);
        System.out.println("Deposit successful. New balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount + " | New Balance: $" + balance);
            System.out.println("Withdrawal successful. New balance: $" + balance);
        }
    }

    public void display() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Owner Name: ");
        String ownerName = scanner.nextLine();
        System.out.print("Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Initial Balance: $");
        double balance = scanner.nextDouble();
        BankAccount account = new BankAccount(ownerName, accountNumber, balance);
        System.out.println("Operations:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Display Owner Name and Balance");
        System.out.println("4. Transaction History");
        System.out.println("5. Exit");
        int choice;
        do {
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.display();
                    break;
                case 4:
                    account.displayTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank You For using HK's Bank");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }
}
