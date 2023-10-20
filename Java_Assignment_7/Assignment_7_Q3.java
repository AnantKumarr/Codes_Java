import java.util.Scanner;

interface BankOperations {
    void deposit(double amount);
    void withdraw(double amount);
    double checkBalance();
}

class BankAccount implements BankOperations {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit amount: " + amount);
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount. Amount should be greater than 0.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw amount: " + amount);
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    @Override
    public double checkBalance() {
        System.out.println("Current balance: " + balance);
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}

class BankAccountManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[10];
        int numAccounts = 0;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new bank account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    if (numAccounts < accounts.length) {
                        System.out.print("Enter account number: ");
                        int accountNumber = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter account holder name: ");
                        String accountHolderName = scanner.nextLine();
                        System.out.print("Enter initial balance: ");
                        double initialBalance = scanner.nextDouble();
                        accounts[numAccounts] = new BankAccount(accountNumber, accountHolderName, initialBalance);
                        numAccounts++;
                        System.out.println("Account added successfully.");
                    } else {
                        System.out.println("Maximum number of accounts reached.");
                    }
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    int depositAccountNumber = scanner.nextInt();
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = scanner.nextDouble();

                    for (int i = 0; i < numAccounts; i++) {
                        if (accounts[i].getAccountNumber() == depositAccountNumber) {
                            accounts[i].deposit(depositAmount);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    int withdrawAccountNumber = scanner.nextInt();
                    System.out.print("Enter the withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();

                    for (int i = 0; i < numAccounts; i++) {
                        if (accounts[i].getAccountNumber() == withdrawAccountNumber) {
                            accounts[i].withdraw(withdrawAmount);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    int checkBalanceAccountNumber = scanner.nextInt();

                    for (int i = 0; i < numAccounts; i++) {
                        if (accounts[i].getAccountNumber() == checkBalanceAccountNumber) {
                            accounts[i].checkBalance();
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
