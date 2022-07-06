package hw1;

import java.util.Random;
import java.util.Scanner;

public class Numbers {
    public static void start(){
        numbers();
    }

    private static void numbers(){
        Scanner sc = new Scanner(System.in);
        int randomNumber = new Random().nextInt(100); // I don't save the object because i will use it only 1 time.

        System.out.println("Enter your name."); // It is not requested in the task, but I think it is needed.
        String name = sc.nextLine();

        System.out.println("Let the game begin!");
        while (true){
            System.out.println("Guess the number!"); // It is also not requested in the task.
            int enteredNumber = sc.nextInt();

            if (enteredNumber > randomNumber){
                System.out.println("Your number is too big. Please, try again.");
            } else if (enteredNumber < randomNumber){
                System.out.println("Your number is too small. Please, try again.");
            } else { // enteredNumber == randomNumber
                // we wrote this case at the end because it is the least likely to happen.
                // If we write it at the beginning, we will waste time checking it every time.
                System.out.printf("Congratulations, %s!", name);
                break;
            }

        }
    }
}
