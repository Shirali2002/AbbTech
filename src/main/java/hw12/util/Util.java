package hw12.util;

import hw12.exception.FamilyOverflowException;
import hw12.model.impl.Family;

import java.util.Scanner;

public class Util {
  public static final int familySizeLimit = 5;

  public static Scanner getNewScanner(){
    return new Scanner(System.in);
  }

  public static int getIntWithScanner(String inputMessage){
    Scanner sc = Util.getNewScanner();
    System.out.println(inputMessage);
    System.out.print(">>> ");
    try {
      return sc.nextInt();
    } catch (NumberFormatException ex){
      System.out.println("Input is invalid!");
      return getIntWithScanner(inputMessage);
    }
  }

  public static String getStringWithScanner(String inputMessage){
    Scanner sc = Util.getNewScanner();
    System.out.println(inputMessage);
    System.out.print(">>> ");
    return sc.nextLine();
  }

  public static int getIndexFromMachineToHuman(int indexMachine){
    return indexMachine+1;
  }

  public static int getIndexFromHumanToMachine(int indexMachine){
    return indexMachine-1;
  }

  public static void checkFamilySize (Family family) throws FamilyOverflowException{
      if (family.countFamily() >= familySizeLimit){
        throw new FamilyOverflowException();
      }
  }
}
