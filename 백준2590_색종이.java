/*
5
3
0
1
1
0

-->

2


*/


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coloredPapers = new int[7]; // Array to store the counts of each colored paper size (1 to 6)

        // Read the counts of each colored paper size
        for (int i = 1; i <= 6; i++) {
            coloredPapers[i] = scanner.nextInt();
        }

        // Array to store the number of boards required for each size
        int[] boardsNeeded = new int[7];

        // Size 6 x 6
        boardsNeeded[6] = coloredPapers[6];

        // Size 5 x 5
        boardsNeeded[5] = coloredPapers[5];

        // Size 4 x 4
        boardsNeeded[4] = coloredPapers[4];
        boardsNeeded[6] -= 5 * coloredPapers[4]; // Reduce size 6 x 6 boards used for size 4 x 4

        // Size 3 x 3
        boardsNeeded[3] = coloredPapers[3];
        int size3Leftover = coloredPapers[3] % 4; // Leftover size 3 x 3 colored papers
        if (size3Leftover > 0) {
            boardsNeeded[6] -= (5 - size3Leftover) * 4; // Reduce size 6 x 6 boards used for leftover size 3 x 3
            boardsNeeded[5] -= (7 - size3Leftover) * 4; // Reduce size 5 x 5 boards used for leftover size 3 x 3
            boardsNeeded[4] -= (6 - size3Leftover) * 4; // Reduce size 4 x 4 boards used for leftover size 3 x 3
        }

        // Size 2 x 2
        boardsNeeded[2] = coloredPapers[2];
        int size2Leftover = coloredPapers[2] % 9; // Leftover size 2 x 2 colored papers
        if (size2Leftover > 0) {
            boardsNeeded[6] -= (36 - size2Leftover) / 4; // Reduce size 6 x 6 boards used for leftover size 2 x 2
            boardsNeeded[5] -= (20 - size2Leftover) / 4; // Reduce size 5 x 5 boards used for leftover size 2 x 2
            boardsNeeded[4] -= (12 - size2Leftover) / 4; // Reduce size 4 x 4 boards used for leftover size 2 x 2
            boardsNeeded[3] -= (4 - size2Leftover) / 4;  // Reduce size 3 x 3 boards used for leftover size 2 x 2
        }

        // Size 1 x 1
        boardsNeeded[1] = coloredPapers[1];
        int size1Leftover = coloredPapers[1] % 36; // Leftover size 1 x 1 colored papers
        if (size1Leftover > 0) {
            boardsNeeded[6] -= 36 - size1Leftover; // Reduce size 6 x 6 boards used for leftover size 1 x 1
            boardsNeeded[5] -= 20 - size1Leftover; // Reduce size 5 x 5 boards used for leftover size 1 x 1
            boardsNeeded[4] -= 12 - size1Leftover; // Reduce size 4 x 4 boards used for leftover size 1 x 1
            boardsNeeded[3] -= 4 - size1Leftover;  // Reduce size 3 x 3 boards used for leftover size 1 x 1
            boardsNeeded[2] -= 1 - size1Leftover;  // Reduce size 2 x 2 boards used for leftover size 1 x 1
        }

        // Calculate the total number of boards needed
        int totalBoards = Arrays.stream(boardsNeeded).sum();

        // Print the result
        System.out.println(totalBoards);
    }
}
