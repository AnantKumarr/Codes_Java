#include <stdio.h>

int factorial(int number) {
    int fact = 1;

    for (int i = 1; i <= number; i++) {
        fact *= i;
    }

    return fact;
}

int sumFactorialEvenDigits(int number) {
    int digit;
    int position = 1;
    int sum = 0;

    while (number > 0) {
        digit = number % 10;

        if (position % 2 == 0) {
            sum += factorial(digit);
        }

        number /= 10;
        position++;
    }

    return sum;
}

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

// Function to reverse a number
int reverse(int n) {
    int sum = 0;
    while (n) {
        int digit = n % 10;
        sum = sum * 10 + digit;
        n = n / 10;
    }
    return sum;
}

int main() {
    int n, num, odd_place = 0, even_place = 0;

    // Input
    printf("Enter an integer: ");
    scanf("%d", &n);

    if (n < 0) {
        n = -n;  // Make sure n is positive
    }

    num = n;
    int place = 1;

    while (num > 0) {
        int digit = num % 10;
        if (place % 2 == 0) {
            even_place = even_place * 10 + digit;
        } else {
            odd_place = odd_place * 10 + digit;
        }
        num /= 10;
        place++;
    }

    printf("Digits at odd places (from left to right): %d\n", reverse(odd_place));
    printf("Digits at even places (from left to right): %d\n", reverse(even_place));

    int sumEvenFactorial = sumFactorialEvenDigits(n);
    printf("Sum of factorial of even digits: %d\n", sumEvenFactorial);

    int temp = reverse(odd_place);

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

    // int sumEvenFactorial = sumFactorialEvenDigits(n);
    // printf("Sum of factorial of even digits: %d\n", sumEvenFactorial);

    return 0;
}
