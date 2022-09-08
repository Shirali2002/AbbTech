package hw12.util;

public class MenuUtil {
  private static final String mainMenuText = """
        
        1. Fill with test data
        2. Display the entire list of families
        3. Display a list of families where the number of people is greater than the specified number
        4. Display a list of families where the number of people is less than the specified number
        5. Calculate the number of families where the number of members is
        6. Create a new family
        7. Delete a family by its index in the general list
        8. Edit a family by its index in the general list
        9. Remove all children over the age of majority
        """;

  private static final String editCaseMenuText = """
        \t1. Give birth to a baby
        \t2. Adopt a child
        \t3. Return to main menu
        """;

  private static final String genderMenuText = """
        \t\t1. Man
        \t\t2. Woman
        """;

  public static String getMainMenuText(){
    return mainMenuText;
  }

  public static String getEditCaseMenuText(){
    return mainMenuText;
  }

  public static String getGenderMenuText(){
    return mainMenuText;
  }

  public static void displayMainMenu(){
    System.out.println(mainMenuText);
  }

  public static void displayEditMenu(){
    System.out.println(editCaseMenuText);
  }

  public static void displayGenderMenu(){
    System.out.println(genderMenuText);
  }


}
