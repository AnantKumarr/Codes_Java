import java.util.Scanner;
import java.util.ArrayList;

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

     public static int compare(Account account1, Account account2) {
        return Float.compare(account1.availableBalance, account2.availableBalance);
    }
}

class BankingApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.println("Enter the how many account you want to create");
        n=input.nextInt();
        ArrayList <Account> list = new ArrayList <Account>();

        

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. create a new account");
            System.out.println("2. Delete an account");
            System.out.println("3. Update Details");
            System.out.println("4. Get Details");
            System.out.println("5. Deposit");
            System.out.println("6. Withdraw");
            System.out.println("7. Total Accounts Created");
            System.out.println("8. compare accounts");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    Account accn=new Account();
                    accn.setDetails();
                    list.add(accn);
                    break;

                case 2:
                    boolean b=false;
                    System.out.println("Enter the account number of the account which you want to delete");
                    int account_number_toDelete=input.nextInt();

                    

                    for(Account a:list )
                    {
                        if(a.getAccountNumber()== account_number_toDelete){
                        list.remove(a);
                        b=true;
                        System.out.println("Account succesfully deleted");
                        break;
                        }
                        
                    }
                    if(b==false)
                    System.out.println("Account not found");
                    break;

                case 3:
                    
                    System.out.print("Enter Account Number to update details: ");
                    int AccountNumber_toUpdate = input.nextInt();
                    boolean c=false;

                    for (Account a : list) {
                        if (a.getAccountNumber() == AccountNumber_toUpdate) {
                            a.updateDetails(AccountNumber_toUpdate);
                            c=true;
                            break;
                        }
                    }
                    if(c==false)
                    System.out.println("Account not found");
                    break;

                case 4:
                    boolean d=false;
                    System.out.print("Enter Account Number to get details: ");
                    int getAccountNumber = input.nextInt();
                    for (Account a : list) {
                        if (a.getAccountNumber() == getAccountNumber) {
                            d=true;
                            a.getDetails();
                            break;
                        }
                    }
                    if(d==false)
                    System.out.println("Account not found");
                    break;
                case 5:
                    boolean e=false;
                    System.out.print("Enter Account Number to deposit: ");
                    int depositAccountNumber = input.nextInt();
                    for (Account a : list) {
                        if (a.getAccountNumber() == depositAccountNumber) {
                            System.out.print("Enter amount to deposit: ");
                            float amount = input.nextFloat();
                            a.deposit(amount);
                            e=true;
                            break;
                        }
                    }
                    if(e=false)
                    System.out.println("Account not found");

                    break;
                case 6:
                    boolean f=false;
                
                    System.out.print("Enter Account Number to withdraw: ");
                    int withdrawAccountNumber = input.nextInt();
                    for (Account a : list) {
                        if (a.getAccountNumber() == withdrawAccountNumber) {
                            System.out.print("Enter amount to withdraw: ");
                            float amount = input.nextFloat();
                            a.withdraw(amount);
                            f=true;
                            break;
                        }
                    }
                    if(f=false)
                    System.out.println("Account not found");
                    break;
                case 7:
                    System.out.println("Total accounts created: " + Account.getTotalAccountCreated());
                    break;
                
                case 8:
                System.out.print("Enter the first account number to compare: ");
                int accountNumber1 = input.nextInt();
                System.out.print("Enter the second account number to compare: ");
                int accountNumber2 = input.nextInt();
                Account account1 = null;
                Account account2 = null;

    
                for (Account a : list) {
                   if (a.getAccountNumber() == accountNumber1) {
                   account1 = a;
                }
                if (a.getAccountNumber() == accountNumber2) {
                account2 = a;
                }
            }

    if (account1 != null || account2 != null) {
        int result = Account.compare(account1, account2);
        if (result < 0) {
            System.out.println("Account " + accountNumber1 + " has less balance than " + accountNumber2);
        } else if (result > 0) {
            System.out.println("Account " + accountNumber2 + " has less balance than" + accountNumber1);
        } else if(result==0)
            System.out.println("Both accounts have the same balance.");
        
    } else {
        System.out.println("One or both of the accounts were not found.");
    }
    break;

                case 9:
                    System.out.println("Exiting...");
                    break;


                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 9);

        input.close();
    }
}
