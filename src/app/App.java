package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        // Game components
        char space = ' ';
        char line = '|';
        char hLine = '-';
        char plus = '+';

        // Game board
        char[][] game = { { space, line, space, line, space }, { hLine, plus, hLine, plus, hLine },
                { space, line, space, line, space }, { hLine, plus, hLine, plus, hLine },
                { space, line, space, line, space }, };

        // printing the game board with 2 for loops
        printGame(game);

        // ask user to enter a number to choose a case to place X or O in the game
        System.out.print("Enter your Placement (1-9): ");
        int userInput = in.nextInt();

        // Logic to change the char into what char place user selected
        switch (userInput) {

        case 1:
            game[0][0] = 'X';
            break;
        case 2:
            game[0][2] = 'X';
            break;
        case 3:
            game[0][4] = 'X';
            break;
        case 4:
            game[2][0] = 'X';
            break;
        case 5:
            game[2][2] = 'X';
            break;
        case 6:
            game[2][4] = 'X';
            break;
        case 7:
            game[4][0] = 'X';
            break;
        case 8:
            game[4][2] = 'X';
            break;
        case 9:
            game[4][4] = 'X';
            break;

        }
        printGame(game);
    }

    public static void printGame(char[][] game) {

        for (char[] r : game) {
            for (char c : r) {
                System.out.print(c);

            }
            System.out.println();

        }
    }

}
