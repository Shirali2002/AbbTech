package hw3;

import java.util.Scanner;

public class WorkingWithStringsAdvanced {
    private final String[][] scedule = new String[7][2];
    private final Scanner sc = new Scanner(System.in);
    private boolean whileChecker = true;


    public WorkingWithStringsAdvanced(){
        scedule[0][0] = "Sunday";
        scedule[0][1] = "do home work";
        scedule[1][0] = "Monday";
        scedule[1][1] = "go to courses; watch a film";
        scedule[2][0] = "Tuesday";
        scedule[2][1] = "go to gym";
        scedule[3][0] = "Wednesday";
        scedule[3][1] = "read a book";
        scedule[4][0] = "Thursday";
        scedule[4][1] = "go to ABBTech";
        scedule[5][0] = "Friday ";
        scedule[5][1] = "take care of the trees";
        scedule[6][0] = "Saturday ";
        scedule[6][1] = "go to park";
    }

    public void start(){
        weekPlanner();
    }

    private void weekPlanner(){
        while (whileChecker){
            System.out.println("Please, input the day of the week:");
            String weekDayInput = sc.nextLine().trim().toLowerCase();

            if (weekDayInput.startsWith("change") || weekDayInput.startsWith("reschedule")){
                String[] weekSplit = weekDayInput.split(" ");
                rescheduler(weekSplit[weekSplit.length-1]);

            }else {
                printScedule(weekDayInput);
            }
        }

    }

    private void rescheduler(String weekDay){
        String task;
        switch (weekDay) {
            case "monday":
                System.out.println("Please, input new tasks for Monday.");
                task = sc.nextLine();
                scedule[1][1] = task;
                break;
            case "tuesday":
                System.out.println("Please, input new tasks for Tuesday.");
                task = sc.nextLine();
                scedule[2][1] = task;
                break;
            case "wednesday":
                System.out.println("Please, input new tasks for Wednesday.");
                task = sc.nextLine();
                scedule[3][1] = task;
                break;
            case "thursday":
                System.out.println("Please, input new tasks for Thursday.");
                task = sc.nextLine();
                scedule[4][1] = task;
                break;
            case "friday":
                System.out.println("Please, input new tasks for Friday.");
                task = sc.nextLine();
                scedule[5][1] = task;
                break;
            case "saturday":
                System.out.println("Please, input new tasks for Saturday.");
                task = sc.nextLine();
                scedule[6][1] = task;
                break;
            case "sunday":
                System.out.println("Please, input new tasks for Sunday.");
                task = sc.nextLine();
                scedule[0][1] = task;
                break;
            default:
                System.out.println("Sorry, I don't understand you, please try again.");
        }

    }

    private void printScedule(String weekDay){
        switch (weekDay) {
            case "monday":
                System.out.printf("Your tasks for Monday: %s\n", scedule[1][1]);
                break;
            case "tuesday":
                System.out.printf("Your tasks for Tuesday: %s\n", scedule[2][1]);
                break;
            case "wednesday":
                System.out.printf("Your tasks for Wednesday: %s\n", scedule[3][1]);
                break;
            case "thursday":
                System.out.printf("Your tasks for Thursday: %s\n", scedule[4][1]);
                break;
            case "friday":
                System.out.printf("Your tasks for Friday: %s\n", scedule[5][1]);
                break;
            case "saturday":
                System.out.printf("Your tasks for Saturday: %s\n", scedule[6][1]);
                break;
            case "sunday":
                System.out.printf("Your tasks for Sunday: %s\n", scedule[0][1]);
                break;
            case "exit":
                System.out.println("Thank you for using week planner.");
                whileChecker = false;
                break;
            default:
                System.out.println("Sorry, I don't understand you, please try again.");
        }
    }
}
