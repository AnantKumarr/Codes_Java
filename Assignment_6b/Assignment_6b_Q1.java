 class Addition {
    public static void main(String[] args) {
        if (args.length >= 2) {
            int sum = 0;
            boolean validInput = true;
            
            for (String arg : args) {
                if (isInteger(arg)) {
                    int num = Integer.parseInt(arg);
                    sum += num;
                } else {
                    System.out.println("Error: Invalid input, please provide valid numbers.");
                    validInput = false;
                    break;
                }
            }
            
            if (validInput) {   
                System.out.println("Add  " + sum);
            }
        } else if (args.length == 1) {
            System.out.println("Error: Add requires at least two numbers");
        } else {
            System.out.println("Error: No numbers to add");
        }
    }
    
    private static boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        
       
        
        return true;
    }
}
