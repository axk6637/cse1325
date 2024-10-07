#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function prototypes
void fillBingoCard(int bingoCard[5][5]);
void printBingoCard(int bingoCard[5][5]);
int pickNumber(int calledNumbers[], int count);
int markNumber(int bingoCard[5][5], int number);
int checkRow(int bingoCard[5][5]);
int checkColumn(int bingoCard[5][5]);
int checkDiagonal(int bingoCard[5][5]);

int main() {
    int bingoCard[5][5];  // The player's Bingo card
    int calledNumbers[75] = {0};  // Track numbers that have been called
    int count = 0, number;
    char response[10];
    int gameWon = 0;

    srand(time(0));  // Seed random number generator

    // Fill the Bingo card and print it
    fillBingoCard(bingoCard);
    printBingoCard(bingoCard);

    FILE *file = fopen("BINGO.card", "w+");

    // Main game loop
    while (!gameWon && count < 75) {
        number = pickNumber(calledNumbers, count);
        printf("The next number is %c%d\n", "BINGO"[(number - 1) / 15], number);
        printf("Do you have it? (y/n) ");
        scanf("%s", response);

        if (response[0] == 'y') {
            if (!markNumber(bingoCard, number)) {
                printf("That value is not on your card, are you cheating?\n");
            } else {
                // Check for a winning condition
                if (checkRow(bingoCard) || checkColumn(bingoCard) || checkDiagonal(bingoCard)) {
                    printf("BINGO! You won!\n");
                    gameWon = 1;
                }
            }
        }
        count++;
        printBingoCard(bingoCard);
    }

    // Close the file
    fclose(file);
    return 0;
}

// Function to fill the Bingo card with unique random numbers
void fillBingoCard(int bingoCard[5][5]) {
    int usedNumbers[75] = {0};  // To track used numbers
    int number, col, row;

    for (col = 0; col < 5; col++) {
        for (row = 0; row < 5; row++) {
            if (col == 2 && row == 2) {  // Free space
                bingoCard[row][col] = 0;
                continue;
            }

            do {
                number = rand() % 15 + (col * 15) + 1;  // Generate random number for the column
            } while (usedNumbers[number - 1]);

            usedNumbers[number - 1] = 1;  // Mark the number as used
            bingoCard[row][col] = number;
        }
    }
}

// Function to print the Bingo card to the screen
void printBingoCard(int bingoCard[5][5]) {
    // Print the header
    printf("   B     I     N     G     O  \n");
    printf("-------------------------------\n");

    // Loop through each row of the Bingo card
    for (int row = 0; row < 5; row++) {
        for (int col = 0; col < 5; col++) {
            // Print the vertical borders
            if (col == 0) {
                printf("| ");
            }

            // Print the numbers or "X" for the center (free space)
            if (bingoCard[row][col] == 0) {
                printf(" X  | ");
            } else {
                printf("%2d  | ", bingoCard[row][col]);  // Adjust spacing for 2-digit numbers
            }
        }
        printf("\n-------------------------------\n");  // End of row with a dashed line
    }
}
// Function to pick a random number that hasn’t been called yet
int pickNumber(int calledNumbers[], int count) {
    int number;
    do {
        number = rand() % 75 + 1;
    } while (calledNumbers[number - 1]);

    calledNumbers[number - 1] = 1;  // Mark the number as called
    return number;
}

// Function to mark a number on the Bingo card if it exists
int markNumber(int bingoCard[5][5], int number) {
    for (int row = 0; row < 5; row++) {
        for (int col = 0; col < 5; col++) {
            if (bingoCard[row][col] == number) {
                bingoCard[row][col] = 0;  // Mark the number as "called" by setting it to 0
                return 1;  // Return true if the number was found
            }
        }
    }
    return 0;  // Return false if the number was not found
}

// Function to check if any row is completed (all zeros)
int checkRow(int bingoCard[5][5]) {
    for (int row = 0; row < 5; row++) {
        int complete = 1;
        for (int col = 0; col < 5; col++) {
            if (bingoCard[row][col] != 0) {
                complete = 0;
                break;
            }
        }
        if (complete) return 1;  // Row is complete
    }
    return 0;
}

// Function to check if any column is completed (all zeros)
int checkColumn(int bingoCard[5][5]) {
    for (int col = 0; col < 5; col++) {
        int complete = 1;
        for (int row = 0; row < 5; row++) {
            if (bingoCard[row][col] != 0) {
                complete = 0;
                break;
            }
        }
        if (complete) return 1;  // Column is complete
    }
    return 0;
}

// Function to check if either diagonal is completed (all zeros)
int checkDiagonal(int bingoCard[5][5]) {
    int complete = 1;
    for (int i = 0; i < 5; i++) {
        if (bingoCard[i][i] != 0) complete = 0;
    }
    if (complete) return 1;

    complete = 1;
    for (int i = 0; i < 5; i++) {
        if (bingoCard[i][4 - i] != 0) complete = 0;
    }
    return complete;
}
