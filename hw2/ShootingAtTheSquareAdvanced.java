package hw2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ShootingAtTheSquareAdvanced {
    private final Scanner sc = new Scanner(System.in);
    private final char[][] square = new char[5][5];
    private final int[][] targets = new int[3][2]; // {x, y}


    // Constructor
    public ShootingAtTheSquareAdvanced() {
        for (char[] chars : square) {        // We fill it with '-' in constructor and we will replace it with '*' if necessary
            Arrays.fill(chars, '-');
        }

        Random rnd = new Random();
        int axisX = rnd.nextInt(5);
        int axisY = rnd.nextInt(5);
        int direction = rnd.nextInt(2);

        if (direction==0){  // horizontal
            for (int i = 0; i < targets.length ; i++) {
                if (axisX>0 && axisX<4) {
                    targets[i][0] = axisX + i - 1;
                    targets[i][1] = axisY;
                } else if (axisX == 0){
                    targets[i][0] = axisX + i;
                    targets[i][1] = axisY;
                } else {
                    targets[i][0] = axisX + i - 2;
                    targets[i][1] = axisY;
                }
            }

        } else {    // vertical
            for (int i = 0; i < targets.length ; i++) {
                if (axisY>0 && axisY<4) {
                    targets[i][0] = axisX;
                    targets[i][1] = axisY + i - 1;
                } else if (axisY == 0){
                    targets[i][0] = axisX;
                    targets[i][1] = axisY + i;
                } else {
                    targets[i][0] = axisX;
                    targets[i][1] = axisY + i - 2;
                }
            }
        }
    }

    public void start() {
        System.out.println("All set. Get ready to rumble!");
        shootingGame();
    }

    private void shootingGame() {
        printSquare();
        int count = targets.length;
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

            boolean check = false;
            for (int[] target : targets) {
                if (target[0] == axisX && target[1] == axisY) {
                    replaceWith(axisX, axisY, 'x');
                    target[0] = -1;
                    target[1] = -1;
                    count--;
                    check = true;
                    break;
                }
            }
            if (!check) {
                replaceWith(axisX, axisY, '*');
            }

            System.out.println("-----------------\n\n");
            printSquare();

            if (count == 0) {
                System.out.println("You have won!");
                break;
            }
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
            if (    input.charAt(i) != '0' && input.charAt(i) != '1' &&
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
