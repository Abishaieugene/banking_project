import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class BankingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a new bank account with an initial balance of Rs 10000
        System.out.println("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        System.out.println("Enter Account Holder Name: ");
        String accountHolderName = scanner.nextLine();

        double initialBalance = 10000.0;
        BankAccount account = new BankAccount(accountNumber, accountHolderName, initialBalance);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Display Account Details");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    account.displayAccountDetails();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 5:
                    System.out.println("Thankyou for using the Abi's Banking System. Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            // Check if balance is Rs 9500 or less
            if (account.getBalance() <= 9500) {
                System.out.println(" Exiting...");
                exit = true;
            }
        }

        scanner.close();
    }
}
