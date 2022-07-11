package hw3;

import java.util.Scanner;

public class WorkingWithStringsSimple {
    private final String[][] scedule = new String[7][2];
    private final Scanner sc = new Scanner(System.in);

    /** array filling process in constructor*/
    public WorkingWithStringsSimple(){
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
        /** print message*/
        String result;

        boolean whileChecker = true;
        while (whileChecker){
            System.out.println("Please, input the day of the week:");
            String weekDayInput = sc.nextLine();

            /** selection process*/
            switch (weekDayInput.toLowerCase().trim()){
                case "monday":
                    result = "Your tasks for Monday: %s\n" + scedule[1][1];
                    break;
                case "tuesday":
                    result = "Your tasks for Tuesday: %s\n" + scedule[2][1];

                    break;
                case "wednesday":
                    result = "Your tasks for Wednesday: %s\n" + scedule[3][1];

                    break;
                case "thursday":
                    result = "Your tasks for Thursday: %s\n" + scedule[4][1];

                    break;
                case "friday":
                    result = "Your tasks for Friday: %s\n" + scedule[5][1];
                    break;
                case "saturday":
                    result = "Your tasks for Saturday: %s\n" + scedule[6][1];
                    break;
                case "sunday":
                    result = "Your tasks for Sunday: %s\n" + scedule[0][1];
                    break;
                case "exit":
                    result = "Thank you for using week planner.";
                    whileChecker = false;
                    break;
                default:
                    result = "Sorry, I don't understand you, please try again.";
            }
            System.out.println(result);
        }
    }
}
