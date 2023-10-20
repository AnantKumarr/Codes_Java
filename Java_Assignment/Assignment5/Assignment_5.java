import java.sql.SQLOutput;
import java.util.Scanner;


public class Assignment_5 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter the number of accounts that you want to create: ");
        n=sc.nextInt();
        Account []user=new Account[n];

        for(int i=0;i<n;i++)
        {
            user[i]=new Account();
            System.out.println("Enter the details for user "+(i+1));
            user[i].setDetails();
        }
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Update Details");
            System.out.println("2. Get Details");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            
            switch (choice)
            {
                case 1:
                System.out.println("Enter the account number ");
                int accountNo=sc.nextInt();
                for(Account e:user)
                {
                    if(e.getAccountNumber()==accountNo)
                    {
                        e.updateDetails(accountNo);
                        break;
                    }
                    else
                    {
                        System.out.println("Account number not found ");
                        break;
                    }
                }
                    break;

                case 2:
                    System.out.println("Enter the account number ");
                    accountNo=sc.nextInt();
                    for(Account e:user)
                    {
                        if(e.getAccountNumber()==accountNo)
                        {
                            e.getDetails(accountNo);
                            break;
                        }
                        else
                        {
                            System.out.println("Account number not found ");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the account number ");
                    accountNo=sc.nextInt();
                    for(Account e:user)
                    {
                        if(e.getAccountNumber()==accountNo)
                        {
                            System.out.println("Enter the money that you want to deposit  : ");
                            float money=sc.nextFloat();
                            e.deposit(accountNo,money);
                            break;
                        }
                        else
                        {
                            System.out.println("Account number not found ");
                            break;
                        }
                    }break;
                case 4:
                    System.out.println("Enter the account number ");
                    accountNo=sc.nextInt();
                    for(Account e:user)
                    {
                        if(e.getAccountNumber()==accountNo)
                        {
                            System.out.println("Enter the amount which you want to withdraw");
                            float money =sc.nextFloat();
                            e.withdraw(accountNo,money);
                            break;
                        }
                        else
                        {
                            System.out.println("Account number not found ");
                            break;
                        }
                    }break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }while(choice!=5);



    }
}

class Account {
    Scanner sc = new Scanner(System.in);
    private int accountNumber;
    private String accountType;
    private String serviceBranchIFSC;
    private float minimumBalance;
    private float availableBalance;
    private int customerID;
    private String customerName;
    private static int totalAccountCreated;

    Account() {

    }

    public void setDetails() {
        System.out.println("Enter the account number : ");
        accountNumber = sc.nextInt();

        System.out.println("Enter the type of account ");
        accountType = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter the service branch IFSC : ");
        serviceBranchIFSC = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter the minimum balance required to be in the account to be operational : ");
        minimumBalance = sc.nextFloat();

        System.out.println("Enter the available balance ");
        availableBalance = sc.nextFloat();

        System.out.println("Enter the customerId : ");
        customerID=sc.nextInt();

        System.out.println("Enter thr customer name : ");
        customerName = sc.nextLine();
        sc.nextLine();

    }

    public void getDetails(int accountNo) {
        System.out.println("The account number is " + accountNumber);
        System.out.println("Account type is " + accountType);
        System.out.println("Service Branch IFSC is " + serviceBranchIFSC);
        System.out.println("Minimum balance of the account is " + minimumBalance);
        System.out.println("Available balance in the account is " + availableBalance);
        System.out.println("Customer Id is : "+customerID);
        System.out.println("Account Holder name is : " + customerName);

    }

    public void updateDetails(int accountNo) {
        int pick;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Update the Customer Id : ");
            System.out.println("2. Update the minimum balance of account : ");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            pick = sc.nextInt();

            switch (pick) {
                case 1:
                    System.out.println("Enter the new customer Id :");
                    customerID = sc.nextInt();
                    break;
                case 2:
                    System.out.println("Enter thr new minimum balance account");
                    minimumBalance = sc.nextInt();
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");

            }
        } while (pick != 3);
    }

    public float getBalance(int accountNo) {
        return availableBalance;
    }

    public void deposit(int accountNo, float amount) {
        System.out.println("Cash Deposited Successfully !");
        availableBalance += amount;
    }

    public void withdraw(int accountNo, float amount)
    {
        System.out.println("Cash withdrawn successfully !");
        availableBalance-=amount;
    }

    public static int totalAccount()
    {
        return totalAccountCreated;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

}
