package hw13.ui.inter;

import hw13.App;
import hw13.util.MenuUtil;
import hw13.util.Util;

public abstract class AbstractMenu {
  public void startMenu(){
    while (App.isOnline()){
      MenuUtil.displayMainMenu();
      String choice = Util.getStringWithScanner("Please enter your choice: ");
      switch (choice) {
        case "1" -> fillWithTestData();
        case "2" -> displayListOfFamilies();
        case "3" -> displayFamiliesCountGreaterThanNumber();
        case "4" -> displayFamiliesCountLessThanNumber();
        case "5" -> displayNumberOfFamiliesWithSpecifiedCount();
        case "6" -> createNewFamily();
        case "7" -> deleteFamilyByIndex();
        case "8" -> editFamilyByIndex();
        case "9" -> removeAllChildrenGreaterThanSpecifiedAge();
        case "exit" -> appExit();
        default -> System.out.println("Input is not in choices!");
      }
    }
  }

  public abstract void appExit();

  public abstract void removeAllChildrenGreaterThanSpecifiedAge();

  public abstract void editFamilyByIndex();

  public abstract void deleteFamilyByIndex();

  public abstract void createNewFamily();

  public abstract void displayNumberOfFamiliesWithSpecifiedCount();

  public abstract void displayFamiliesCountLessThanNumber();

  public abstract void displayFamiliesCountGreaterThanNumber();

  public abstract void displayListOfFamilies();

  public abstract void fillWithTestData();

}

