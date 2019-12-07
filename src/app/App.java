package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    static final ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static final ArrayList<Integer> botPositions = new ArrayList<Integer>();

    static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        // Game components
        char space = ' ';
        char line = '|';
        char hLine = '-';
        char plus = '+';

        // Game board
        char[][] game = { { space, line, space, line, space }, { hLine, plus, hLine, plus, hLine },
                { space, line, space, line, space }, { hLine, plus, hLine, plus, hLine },
                { space, line, space, line, space }, };

        // infinite loop for the game until winner or draw
        while (true) {

            // ask user to enter a number to choose a case to place X or O in the game
            System.out.print("Enter your Placement (1-9): ");

            int userInput = in.nextInt();

            // check if there if it's already taken try again
            while (playerPositions.contains(userInput) || botPositions.contains(userInput)) {
                System.out.print("This case is already selected please try again: ");
                userInput = in.nextInt();
            }

            play(game, userInput, "player");

            String result = winner();

            if (result.length() > 0) {
                System.out.println(winner());
                break;
            }
            // Bot turn
            Random n = new Random();
            int botNumber = n.nextInt(9) + 1;

            // check if there if it's already taken try again
            while (playerPositions.contains(botNumber) || botPositions.contains(botNumber)) {
                botNumber = n.nextInt(9) + 1;
            }

            play(game, botNumber, "bot");

            printGame(game);

            result = winner();

            if (result.length() > 0) {
                System.out.println(winner());
                break;
            }

        }
    }

    // method printing the game board with 2 for loops
    public static void printGame(char[][] game) {

        for (char[] r : game) {
            for (char c : r) {
                System.out.print(c);

            }
            System.out.println();

        }
    }

    // method for logic to change the char into what char place user selected
    public static void play(char[][] game, int position, String userSymbol) {

        char symbol = ' ';

        if (userSymbol.equals("player")) {
            symbol = 'X';
            playerPositions.add(position);

        } else if (userSymbol.equals("bot")) {
            botPositions.add(position);
            symbol = 'O';

        }

        switch (position) {

        case 1:
            game[0][0] = symbol;
            break;
        case 2:
            game[0][2] = symbol;
            break;
        case 3:
            game[0][4] = symbol;
            break;
        case 4:
            game[2][0] = symbol;
            break;
        case 5:
            game[2][2] = symbol;
            break;
        case 6:
            game[2][4] = symbol;
            break;
        case 7:
            game[4][0] = symbol;
            break;
        case 8:
            game[4][2] = symbol;
            break;
        case 9:
            game[4][4] = symbol;
            break;

        default:

            System.out.println("Please enter a valid number 0-9");

            break;

        }

    }

    public static String winner() {

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);

        List col1 = Arrays.asList(1, 4, 7);
        List col2 = Arrays.asList(2, 5, 8);
        List col3 = Arrays.asList(3, 6, 9);

        List diag1 = Arrays.asList(1, 5, 9);
        List diag2 = Arrays.asList(7, 5, 3);

        List<List> checkWinner = new ArrayList<List>();

        checkWinner.add(topRow);
        checkWinner.add(midRow);
        checkWinner.add(botRow);

        checkWinner.add(col1);
        checkWinner.add(col2);
        checkWinner.add(col3);

        checkWinner.add(diag1);
        checkWinner.add(diag2);

        for (List list : checkWinner) {

            if (playerPositions.containsAll(list)) {
                return "You Win";

            } else if (botPositions.containsAll(list)) {
                return "The Bot wins";

            } else if (playerPositions.size() + botPositions.size() == 9) {
                return "Draw";

            }

        }
        return "";

    }
}