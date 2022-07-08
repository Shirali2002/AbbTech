package hw2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ShootingAtTheSquareSimple {
    private final Scanner sc = new Scanner(System.in);
    private final Random rnd = new Random();
    private char[][] square = new char[5][5];
    private int[] target = new int[2]; // {x, y}


    // Constructor
    public ShootingAtTheSquareSimple() {
        for (char[] chars : square) {        // We fill it with '-' in constructor and we will replace it with '*' if necessary
            Arrays.fill(chars, '-');
        }

        target[0] = rnd.nextInt(5);
        target[1] = rnd.nextInt(5);

    }

    public void start() {
        System.out.println("All set. Get ready to rumble!");
        shootingGame();
    }

    private void shootingGame() {
        printSquare();
        while (true) {
            System.out.println("Enter horizontal coordinate for fire!");
            String axisXStr = sc.nextLine();
            int axisX = getInt(axisXStr) - 1;
            if (axisX == -2) {
                continue;
            }


            System.out.println("Enter vertical coordinate for fire!");
            String axisYStr = sc.nextLine();
            int axisY = getInt(axisYStr) - 1;
            if (axisY == -2) {
                continue;
            }

            if (target[0] == axisX && target[1] == axisY) {
                replaceWith(axisX, axisY, 'x');

                System.out.println("-----------------\n\n");
                printSquare();
                System.out.println("You have won!");
                break;
            }
            replaceWith(axisX, axisY, '*');

            System.out.println("-----------------\n\n");
            printSquare();
        }


    }

    private int getInt(String input) {
        if (isParsable(input)) {
            if (input.length() < 10) { // when length larger than 10, we can not get integer from string.(for bound of integer)
                int inputInt = Integer.parseInt(input);
                if (isInRange(inputInt)) {
                    return inputInt;
                } else {
                    System.out.println("Enter existing coordinate!(1-5)\n");
                    return -1;
                }
            } else {
                System.out.println("Enter existing coordinate!(1-5)\n");
                return -1;
            }

        } else {
            System.out.println("Enter number!!!\n");
            return -1;
        }

    }

    private boolean isInRange(int input) {
        return input >= 1 && input <= 5;
    }

    private boolean isParsable(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '0' && input.charAt(i) != '1' &&
                    input.charAt(i) != '2' && input.charAt(i) != '3' &&
                    input.charAt(i) != '4' && input.charAt(i) != '5' &&
                    input.charAt(i) != '6' && input.charAt(i) != '7' &&
                    input.charAt(i) != '8' && input.charAt(i) != '9') {
                return false; // --> input is not number.
            }
        }
        return !input.equals(""); // if input equal to empty string --> return false, else --> return true.
    }

    private void printSquare() {
        System.out.println("0 | 1 | 2 | 3 | 4 | 5 |");
        for (int y = 0; y < square.length; y++) {        // vertical
            System.out.printf("%d |", y + 1);
            for (int x = 0; x < square[y].length; x++) {    // horizontal
                System.out.printf(" %s |", square[y][x]);
            }
            System.out.println();
        }
        System.out.println();

    }

    private void replaceWith(int x, int y, char c) {
        square[y][x] = c;
    }
}
