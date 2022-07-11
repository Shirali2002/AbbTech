package hw3;

import java.util.Scanner;

public class WorkingWithStringsAdvanced {
    private final String[][] scedule = new String[7][2];
    private final Scanner sc = new Scanner(System.in);
    private boolean whileChecker = true;

    /**
     * array filling process in constructor
     */
    public WorkingWithStringsAdvanced() {
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

    /**
     * start process
     */
    public void start() {
        weekPlanner();
    }

    /**
     * input process and method selection process
     */
    private void weekPlanner() {
        while (whileChecker) {
            System.out.println("Please, input the day of the week:");
            String weekDayInput = sc.nextLine().trim().toLowerCase();

            if (weekDayInput.startsWith("change") || weekDayInput.startsWith("reschedule")) {
                String[] weekSplit = weekDayInput.split(" ");
                if (weekSplit.length<2){
                    continue;   // if user entered for example "change", program will continue
                }
                String weekDay = weekSplit[weekSplit.length - 1].substring(0, 1).toUpperCase() +
                                 weekSplit[weekSplit.length - 1].substring(1);
                System.out.printf("Please, input new tasks for %s.\n", weekDay);
                rescheduler(weekDay);

            } else {
                System.out.println(printScedule(weekDayInput));
            }
        }

    }

    /**
     * reschedule process
     */
    private void rescheduler(String weekDay) {
        String task;
        switch (weekDay) {
            case "Monday":
                scedule[1][1] = sc.nextLine();
                break;
            case "Tuesday":
                scedule[2][1] = sc.nextLine();
                break;
            case "Wednesday":
                scedule[3][1] = sc.nextLine();
                break;
            case "Thursday":
                scedule[4][1] = sc.nextLine();
                break;
            case "Friday":
                scedule[5][1] = sc.nextLine();
                break;
            case "Saturday":
                scedule[6][1] = sc.nextLine();
                break;
            case "Sunday":
                scedule[0][1] = sc.nextLine();
                break;
            default:
                System.out.println("OOPS. Sorry, I don't understand you, please try again.");
        }

    }

    /**
     * print process
     */
    private String printScedule(String weekDayInput) {
        String result;

        /** selection process*/
        switch (weekDayInput.toLowerCase().trim()) {
            case "monday":
                result = "Your tasks for Monday: " + scedule[1][1];
                break;
            case "tuesday":
                result = "Your tasks for Tuesday: " + scedule[2][1];

                break;
            case "wednesday":
                result = "Your tasks for Wednesday: " + scedule[3][1];

                break;
            case "thursday":
                result = "Your tasks for Thursday: " + scedule[4][1];

                break;
            case "friday":
                result = "Your tasks for Friday: " + scedule[5][1];
                break;
            case "saturday":
                result = "Your tasks for Saturday: " + scedule[6][1];
                break;
            case "sunday":
                result = "Your tasks for Sunday: " + scedule[0][1];
                break;
            case "exit":
                result = "Thank you for using week planner.";
                whileChecker = false;
                break;
            default:
                result = "Sorry, I don't understand you, please try again.";
        }

        return result;
    }
}
