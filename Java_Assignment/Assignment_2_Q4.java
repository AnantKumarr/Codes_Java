import java.util.Scanner;

class OddEvenCounter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of test cases");
        int n = input.nextInt();

        int[][] testCases = new int[n][];
        for (int i = 0; i < n; i++) {
        System.out.println("Enter the size of array" +i);
            int numElements = input.nextInt();
            testCases[i] = new int[numElements];
        System.out.println("Enter the element of array");    
            for (int j = 0; j < numElements; j++) {
                testCases[i][j] = input.nextInt();
            }
        }

        int overallOddCount = 0;
        int overallEvenCount = 0;
        
        for (int i = 0; i < n; i++) {
            int oddCount = 0;
            int evenCount = 0;
            
            for (int num : testCases[i]) {
                if (num % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
            
            overallOddCount += oddCount;
            overallEvenCount += evenCount;

            System.out.println("In Test Case " + (i + 1) + ": Odd Count is " + oddCount + ", Even Count is " + evenCount);
        }

        
        System.out.println("Overall Odd Count is " + overallOddCount);
        System.out.println("Overall Even Count is  " + overallEvenCount);
    }
}