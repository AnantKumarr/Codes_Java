#include <stdio.h>

int main() {
    int n;
    
    // Input
    printf("Enter an integer (0 <= n <= 999999999): ");
    scanf("%d", &n);
    
    if (n < 0 || n > 999999999) {
        printf("Invalid input. Please enter a valid integer between 0 and 999999999.\n");
        return 1;
    }
    
    int oddNumber = 0;
    int isEvenPlace = 0; // Start with the first (odd) place
    
    while (n > 0) {
        int digit = n % 10;
        
        if (!isEvenPlace) {
            oddNumber = oddNumber * 10 + digit;
        }
        
        isEvenPlace = !isEvenPlace; // Toggle to the next place
        n /= 10;
    }
    
    // Display the number formed with digits at odd places in reverse order
    printf("Number formed with digits at odd places (in reverse order): ");
    while (oddNumber > 0) {
        int digit = oddNumber % 10;
        printf("%d ", digit);
        oddNumber /= 10;
    }
    printf("\n");
    
    return 0;
}
