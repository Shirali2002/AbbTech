package hw1;

import java.util.Random;
import java.util.Scanner;

public class NumbersAdvanced {
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rnd = new Random();

    /**
     * When check100 is true, the game is numberGame and the 100 filter should be checked.
       If false, the game is eventGame, no filter 100 is needed.
    */
    private static boolean check100;

    // start game
    public static void startGame() {
        System.out.println("""
                Well-known event game   [1]
                Number guess game       [2]
                Which game do you want to play?""");
        String option = sc.nextLine();
        if (option.equals("1")) {
            eventGame();
            check100 = false;
        } else if (option.equals("2")) {
            numberGame();
            check100 = true;
        } else {
            System.out.println("Enter correct option");
            startGame();
        }
    }


    // event game
    private static void eventGame() {
        String[][] questionArr = {{"1941", "When did the World War II begin?"},
                                  {"1914", "When did the World War I begin?"},
                                  {"3000", "Building of the Great Pyramid?(B.C.)"}};

        int randomNumber = rnd.nextInt(questionArr.length - 1);
        int year = Integer.parseInt(questionArr[randomNumber][0]);
        String question = questionArr[randomNumber][1];

        System.out.println(question);

        mainGame(year);
    }

    // Number game
    private static void numberGame() {
        int randomNumber = rnd.nextInt(100);
        mainGame(randomNumber);
    }


    private static void mainGame(int mainNumber) {
        int[] enteredNumbers = new int[1];
        int[] enteredNumbersArchive;
        int enteredNumber;
        int count = 0;

        System.out.println("Enter your name.");
        String name = sc.nextLine();

        System.out.println("Let the game begin!");
        while (true) {
            System.out.println("Guess the number!");

            // adding new element
            if (count != 0) {                           // first time do not expand any array, just add first element to array.
                enteredNumbersArchive = enteredNumbers; // save array to Archive.
                enteredNumbers = new int[count + 1];    // expand array
                for (int k = 0; k < count; k++) {
                    enteredNumbers[k] = enteredNumbersArchive[k];
                }
            }
            enteredNumber = inputHandle();
            enteredNumbers[count] = enteredNumber;


            // checking part
            if (enteredNumber > mainNumber) {
                System.out.println("Your number is too big. Please, try again.");
            } else if (enteredNumber < mainNumber) {
                System.out.println("Your number is too small. Please, try again.");
            } else { // enteredNumber == randomNumber
                // we wrote this case at the end because it is the least likely to happen.
                // If we write it at the beginning, we will waste time checking it every time.
                System.out.printf("Congratulations, %s!\n", name);

                enteredNumbers = sortDesc(enteredNumbers);
                System.out.println("Your numbers:");
                for (int number : enteredNumbers) {
                    System.out.print(number + " ");
                }
                break;
            }

            count++;
        }
    }

    // input handle
    private static int inputHandle() {
        String input = sc.nextLine();
        boolean isParsable = true;  // if isParsable true, it means the input is number.
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '0' && input.charAt(i) != '1' &&
                    input.charAt(i) != '2' && input.charAt(i) != '3' &&
                    input.charAt(i) != '4' && input.charAt(i) != '5' &&
                    input.charAt(i) != '6' && input.charAt(i) != '7' &&
                    input.charAt(i) != '8' && input.charAt(i) != '9') {
                isParsable = false; // --> input is not number.
                break;
            }
        }
        if (isParsable) {
            if (input.length() < 10){ // It is due to the limit of the integer.
                int enteredNumber = Integer.parseInt(input);
                if (check100) {
                    if (enteredNumber <= 100) { // if check100 is false, program will not filter this option.
                        return enteredNumber;
                    } else {
                        System.out.println("Enter number between 0-100.");
                        return inputHandle();
                    }
                } else { // check100 == false --> game is eventGame
                    return enteredNumber;
                }
            } else {
                System.out.println("Enter a shorter and real number.");
                return inputHandle();
            }
        } else {
            System.out.println("Enter number.");
            return inputHandle();
        }
    }

    // Sorting
    private static int[] sortDesc(int[] arr) { // Bubble sort algorithm. Larger to smaller.
        int arrLen = arr.length;
        for (int i = 0; i < arrLen - 1; i++) {
            for (int j = 0; j < arrLen - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
