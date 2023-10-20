import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class User {
    protected int userID;
    protected String name;
    protected Date dateOfBirth;
    protected String address;
    protected String PAN;

    public User(int userID, String name, Date dateOfBirth, String address, String PAN) {
        this.userID = userID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.PAN = PAN;
    }
}

class Admin extends User {
    private Date dateOfJoining;
    private double salary;
    private int permissibleOperations;

    public Admin(int userID, String name, Date dateOfBirth, String address, String PAN, Date dateOfJoining, double salary, int permissibleOperations) {
        super(userID, name, dateOfBirth, address, PAN);
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
        this.permissibleOperations = permissibleOperations;
    }

    public void addNewStock(Item item, ArrayList<Item> stock) {
        stock.add(item);
    }

    public void deleteStock(int itemCode, ArrayList<Item> stock) {
        for (Item item : stock) {
            if (item.getItemCode() == itemCode && item.getAvailableQty() == 0) {
                stock.remove(item);
                System.out.println("Item with item code " + itemCode + " has been deleted.");
                return;
            }
        }
        System.out.println("Item deletion failed. Either the item doesn't exist or its available quantity is not zero.");
    }

    public void modifyStock(int itemCode, double newPrice, int newAvailableQty, ArrayList<Item> stock) {
        for (Item item : stock) {
            if (item.getItemCode() == itemCode) {
                item.setPrice(newPrice);
                item.setAvailableQty(newAvailableQty);
                System.out.println("Item with item code " + itemCode + " has been modified.");
                return;
            }
        }
        System.out.println("Item modification failed. Item with item code " + itemCode + " not found.");
    }

    public int getPermissibleOperations() {
        return permissibleOperations;
    }
}

class General extends User {
    private Date dateOfJoining;
    private double salary;
    private int dutyHourPerDay;

    public General(int userID, String name, Date dateOfBirth, String address, String PAN, Date dateOfJoining, double salary, int dutyHourPerDay) {
        super(userID, name, dateOfBirth, address, PAN);
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
        this.dutyHourPerDay = dutyHourPerDay;
    }

    public void sellItem(int itemCode, int quantity, ArrayList<Item> stock, ArrayList<Sell> sales) {
        for (Item item : stock) {
            if (item.getItemCode() == itemCode && item.getAvailableQty() >= quantity) {
                Sell sell = new Sell(new Date(), itemCode, quantity, item.getPrice() * quantity);
                sales.add(sell);
                item.setAvailableQty(item.getAvailableQty() - quantity);
                System.out.println(quantity + " units of item with item code " + itemCode + " sold successfully.");
                return;
            }
        }
        System.out.println("Item sale failed. Item not found or insufficient quantity available.");
    }

    public void returnItem(int itemCode, int quantity, ArrayList<Item> stock, ArrayList<Return> returns) {
        for (Item item : stock) {
            if (item.getItemCode() == itemCode && !(item instanceof FoodItem)) {
                Return returnItem = new Return(new Date(), itemCode, quantity, item.getPrice() * quantity);
                returns.add(returnItem);
                item.setAvailableQty(item.getAvailableQty() + quantity);
                System.out.println(quantity + " units of non-food item with item code " + itemCode + " returned successfully.");
                return;
            }
        }
        System.out.println("Item return failed. Non-food item not found or trying to return a food item.");
    }

    public void displayStock(int itemCode, ArrayList<Item> stock) {
        for (Item item : stock) {
            if (item.getItemCode() == itemCode) {
                System.out.println("Item Details - Item Code: " + item.getItemCode() +
                        ", Price: " + item.getPrice() +
                        ", Available Quantity: " + item.getAvailableQty());
                return;
            }
        }
        System.out.println("Item with item code " + itemCode + " not found.");
    }

    public void displaySell(Date startDate, Date endDate, ArrayList<Sell> sales) {
        System.out.println("Sales within the date range:");
        for (Sell sell : sales) {
            if (sell.getDateOfSell().after(startDate) && sell.getDateOfSell().before(endDate)) {
                System.out.println("Date: " + sell.getDateOfSell() +
                        ", Item Code: " + sell.getItemCode() +
                        ", Quantity: " + sell.getQuantity() +
                        ", Total Amount: " + sell.getTotalAmount());
            }
        }
    }
}

class Item {
    private int itemCode;
    private double price;
    private int availableQty;

    public Item(int itemCode, double price, int availableQty) {
        this.itemCode = itemCode;
        this.price = price;
        this.availableQty = availableQty;
    }

    public int getItemCode() {
        return itemCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
    }
}

class FoodItem extends Item {
    private Date dateOfExpiry;

    public FoodItem(int itemCode, double price, int availableQty, Date dateOfExpiry) {
        super(itemCode, price, availableQty);
        this.dateOfExpiry = dateOfExpiry;
    }

    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }
}

class NonFoodItem extends Item {
    private int returnCount;

    public NonFoodItem(int itemCode, double price, int availableQty, int returnCount) {
        super(itemCode, price, availableQty);
        this.returnCount = returnCount;
    }

    public int getReturnCount() {
        return returnCount;
    }
}

class Sell {
    private Date dateOfSell;
    private int itemCode;
    private int quantity;
    private double totalAmount;

    public Sell(Date dateOfSell, int itemCode, int quantity, double totalAmount) {
        this.dateOfSell = dateOfSell;
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public Date getDateOfSell() {
        return dateOfSell;
    }

    public int getItemCode() {
        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}

class Return {
    private Date dateOfReturn;
    private int itemCode;
    private int quantity;
    private double returnAmount;

    public Return(Date dateOfReturn, int itemCode, int quantity, double returnAmount) {
        this.dateOfReturn = dateOfReturn;
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.returnAmount = returnAmount;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public int getItemCode() {
        return itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getReturnAmount() {
        return returnAmount;
    }
}

 class Test {
    public static void main(String[] args) {
        ArrayList<Item> stock = new ArrayList<>();
        ArrayList<Sell> sales = new ArrayList<>();
        ArrayList<Return> returns = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user type (Admin/General): ");
        String userType = scanner.nextLine();

        if ("Admin".equalsIgnoreCase(userType)) {
            
            System.out.print("Enter your name: ");
            String adminName = scanner.nextLine();
            Admin adminUser = new Admin(1, adminName, new Date(), "Admin Address", "AdminPAN", new Date(), 50000, 3);

            int pick;
            do {
                System.out.println("\nAdmin Operations:");
                System.out.println("1. Add New Stock");
                System.out.println("2. Delete Stock");
                System.out.println("3. Modify Stock");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                pick = scanner.nextInt();
                scanner.nextLine();

                switch (pick) {
                    case 1:
                        System.out.print("Enter Item Code: ");
                        int itemCode = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine(); 
                        System.out.print("Enter Available Quantity: ");
                        int availableQty = scanner.nextInt();
                        scanner.nextLine();
                        Item newItem = new Item(itemCode, price, availableQty);
                        adminUser.addNewStock(newItem, stock);
                        break;
                    case 2:
                        System.out.print("Enter Item Code to delete: ");
                        int deleteItemCode = scanner.nextInt();
                        scanner.nextLine(); 
                        adminUser.deleteStock(deleteItemCode, stock);
                        break;
                    case 3:
                        System.out.print("Enter Item Code to modify: ");
                        int modifyItemCode = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter New Price: ");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter New Available Quantity: ");
                        int newAvailableQty = scanner.nextInt();
                        scanner.nextLine();
                        adminUser.modifyStock(modifyItemCode, newPrice, newAvailableQty, stock);
                        break;
                    case 4:
                        
                        System.out.println("Enter your user type ");
                        userType=scanner.nextLine();
                        if ("General".equalsIgnoreCase(userType)) {
           
            System.out.print("Enter your name: ");
            String generalName = scanner.nextLine();
            General generalUser = new General(2, generalName, new Date(), "General Address", "GeneralPAN", new Date(), 30000, 8);

            while (true) {
                System.out.println("\nGeneral Operations:");
                System.out.println("1. Sell Item");
                System.out.println("2. Return Item");
                System.out.println("3. Display Stock");
                System.out.println("4. Display Sell");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Item Code to sell: ");
                        int sellItemCode = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter Quantity to sell: ");
                        int sellQuantity = scanner.nextInt();
                        scanner.nextLine(); 
                        generalUser.sellItem(sellItemCode, sellQuantity, stock, sales);
                        break;
                    case 2:
                        System.out.print("Enter Item Code to return: ");
                        int returnItemCode = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter Quantity to return: ");
                        int returnQuantity = scanner.nextInt();
                        scanner.nextLine();
                        generalUser.returnItem(returnItemCode, returnQuantity, stock, returns);
                        break;
                    case 3:
                        System.out.print("Enter Item Code to display: ");
                        int displayItemCode = scanner.nextInt();
                        scanner.nextLine(); 
                        generalUser.displayStock(displayItemCode, stock);
                        break;
                    case 4:
                        System.out.print("Enter Start Date (yyyy-MM-dd): ");
                        String startDateStr = scanner.nextLine();
                        System.out.print("Enter End Date (yyyy-MM-dd): ");
                        String endDateStr = scanner.nextLine();

                        
                        Date startDate = java.sql.Date.valueOf(startDateStr);
                        Date endDate = java.sql.Date.valueOf(endDateStr);
                        generalUser.displaySell(startDate, endDate, sales);
                        break;
                    case 5:
                        System.out.println("Exiting General Operations.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid user type. Exiting application.");
        }
            case 5:
                System.out.println("Exiting admin operations");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
            
    }
                }while(pick!=5);
            }
        } 
 }
    