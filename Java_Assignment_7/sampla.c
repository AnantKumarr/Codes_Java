#include <stdio.h>

// Function to check if a number is prime
int isPrime(int num) {
    if (num <= 1)
        return 0; // 0 and 1 are not prime
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0)
            return 0; // Not prime
    }
    return 1; // Prime
}

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

    int temp = 0;
    int originalOddNumber = oddNumber; // Store the original oddNumber

    // Reverse the oddNumber
    while (oddNumber > 0) {
        int digit = oddNumber % 10;
        temp = temp * 10 + digit;
        oddNumber /= 10;
    }

    // Display the reversed number formed with digits at odd places
    printf("Number formed with digits at odd places (in reverse order): %d\n", temp);

    int factors[100]; // Array to store factors
    int factorCount = 0; // Counter for factors

    for (int i = 1; i <= temp; i++) {
        if (temp % i == 0) {
            factors[factorCount] = i;
            factorCount++;
        }
    }

    printf("All factors: ");
    for (int i = 0; i < factorCount; i++) {
        printf("%d ", factors[i]);
    }
    printf("\n");

    printf("(e) Prime-Factors of %d: ", temp);
    for (int i = 0; i < factorCount; i++) {
        if (isPrime(factors[i])) {
            printf("%d ", factors[i]);
        }
    }
    printf("\n");

    printf("(f) Non Prime-Factors: ");
    for (int i = 0; i < factorCount; i++) {
        if (!isPrime(factors[i])) {
            printf("%d ", factors[i]);
        }
    }
    printf("\n");
    
    return 0;
}
