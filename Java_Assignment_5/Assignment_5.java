import java.util.Scanner;

class Account {
    private int accountNumber;
    private String accountType;
    private String serviceBranchIFSC;
    private float minimumBalance;
    private float availableBalance;
    private int customerID;
    private String customerName;
    private static int totalAccountCreated = 0;

    public Account() {
        totalAccountCreated++;
    }

    public void setDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account details:");
        System.out.print("Account Number: ");
        accountNumber = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Account Type: ");
        accountType = scanner.nextLine();
        System.out.print("Service Branch IFSC: ");
        serviceBranchIFSC = scanner.nextLine();
        System.out.print("Minimum Balance: ");
        minimumBalance = scanner.nextFloat();
        availableBalance = minimumBalance;
        System.out.print("Customer ID: ");
        customerID = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Customer Name: ");
        customerName = scanner.nextLine();
    }

    public void updateDetails(int accountNo) {
        Scanner scanner = new Scanner(System.in);
        int pick;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Update the Customer Id : ");
            System.out.println("2. Update the minimum balance of account : ");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            pick = scanner.nextInt();

            switch (pick) {
                case 1:
                    System.out.println("Enter the new customer Id :");
                    customerID = scanner.nextInt();
                    break;
                case 2:
                    System.out.println("Enter thr new minimum balance account");
                    minimumBalance = scanner.nextInt();
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");

            }
        } while (pick != 3);
    }

    public void getDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Service Branch IFSC: " + serviceBranchIFSC);
        System.out.println("Minimum Balance: " + minimumBalance);
        System.out.println("Available Balance: " + availableBalance);
        System.out.println("Customer ID: " + customerID);
        System.out.println("Customer Name: " + customerName);
    }

    public float getBalance() {
        return availableBalance;
    }

    public void deposit(float amount) {
        availableBalance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(float amount) {
        if (availableBalance - amount >= minimumBalance) {
            availableBalance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    public static int getTotalAccountCreated() {
        return totalAccountCreated;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
}

class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("Enter the how many account you want to creat");
        n=scanner.nextInt();
        Account[] accounts = new Account[n];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account();
            System.out.println("Enter the detail of customer: "+(i+1));
            accounts[i].setDetails();
        }

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Update Details");
            System.out.println("2. Get Details");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Total Accounts Created");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number to update details: ");
                    int updateAccountNumber = scanner.nextInt();
                    for (Account account : accounts) {
                        if (account.getAccountNumber() == updateAccountNumber) {
                            account.updateDetails(updateAccountNumber);
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter Account Number to get details: ");
                    int getAccountNumber = scanner.nextInt();
                    for (Account account : accounts) {
                        if (account.getAccountNumber() == getAccountNumber) {
                            account.getDetails();
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Account Number to deposit: ");
                    int depositAccountNumber = scanner.nextInt();
                    for (Account account : accounts) {
                        if (account.getAccountNumber() == depositAccountNumber) {
                            System.out.print("Enter amount to deposit: ");
                            float amount = scanner.nextFloat();
                            account.deposit(amount);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter Account Number to withdraw: ");
                    int withdrawAccountNumber = scanner.nextInt();
                    for (Account account : accounts) {
                        if (account.getAccountNumber() == withdrawAccountNumber) {
                            System.out.print("Enter amount to withdraw: ");
                            float amount = scanner.nextFloat();
                            account.withdraw(amount);
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Total accounts created: " + Account.getTotalAccountCreated());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
