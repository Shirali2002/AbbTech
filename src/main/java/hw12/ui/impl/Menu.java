package hw12.ui.impl;

import hw12.controller.FamilyController;
import hw12.model.impl.Family;
import hw12.model.impl.Man;
import hw12.model.impl.Woman;
import hw12.model.inter.AbstractHuman;
import hw12.ui.inter.AbstractMenu;
import hw12.util.MenuUtil;
import hw12.util.Util;

import java.util.List;
import java.util.stream.IntStream;

public class Menu extends AbstractMenu {
  private static final Menu menuInstance = new Menu();
  private final FamilyController controller = FamilyController.getInstance();

  private Menu() {
  }

  public static Menu getInstance() {
    return menuInstance;
  }

  @Override
  public void removeAllChildrenGreaterThanSpecifiedAge() {
    int age = Util.getIntWithScanner("Please enter interested age: ");
    controller.deleteAllChildrenOlderThan(age);
  }

  @Override
  public void editFamilyByIndex() {
    MenuUtil.displayEditMenu();
    int choice = Util.getIntWithScanner("\tPlease enter your choice: ");

    switch (choice) {
      case 1 -> birthBabySpecifiedFamily();
      case 2 -> adoptChildSpecifiedFamily();
      case 3 -> System.out.println("Completed!");
      default -> System.out.println("Input is invalid!");
    }

  }

  private void adoptChildSpecifiedFamily() {
    displayListOfFamilies();
    int index = Util.getIntWithScanner("Please enter id: ");

    AbstractHuman child = getGender().equals("MAN")
        ? getNewMan("son")
        : getNewWoman("daughter");

    controller.getFamilyById(Util.getIndexFromHumanToMachine(index)).ifPresent(family ->
      controller.adoptChild(family, child)
    );
  }

  private String getGender(){
    MenuUtil.displayGenderMenu();
    int choice = Util.getIntWithScanner("Please enter choice: ");
    return switch (choice) {
      case 1 -> "MAN";
      case 2 -> "WOMAN";
      default -> getGender();
    };
  }

  private void birthBabySpecifiedFamily() {
    displayListOfFamilies();
    int index = Util.getIntWithScanner("Please enter id: ");
    String boyName = Util.getStringWithScanner("Please enter name(if baby is boy): ");
    String girlName = Util.getStringWithScanner("Please enter name(if baby is girl): ");
    controller.getFamilyById(Util.getIndexFromHumanToMachine(index)).ifPresent(family ->
        controller.bornChild(family, boyName, girlName)
        );
  }

  @Override
  public void deleteFamilyByIndex() {
    displayListOfFamilies();
    int index = Util.getIntWithScanner("Please enter id for delete: ");
    controller.deleteFamilyByIndex(Util.getIndexFromHumanToMachine(index));
  }

  @Override
  public void createNewFamily() {
    Woman mother = getNewWoman("mother");
    Man father = getNewMan("father");
    controller.createNewFamily(father, mother);
  }



  @Override
  public void displayNumberOfFamiliesWithSpecifiedCount() {
    int countMember = Util.getIntWithScanner("Please enter the number of member: ");
    System.out.println(controller.countFamiliesWithMemberNumber(countMember));
  }

  @Override
  public void displayFamiliesCountLessThanNumber() {
    int countMember = Util.getIntWithScanner("Please enter the number of member: ");
    List<Family> matchedFamilies = controller.getFamiliesLessThan(countMember);
    matchedFamilies.forEach(this::printFamilyList);
  }

  @Override
  public void displayFamiliesCountGreaterThanNumber() {
    int countMember = Util.getIntWithScanner("Please enter the number of member: ");
    List<Family> matchedFamilies = controller.getFamiliesBiggerThan(countMember);
    matchedFamilies.forEach(this::printFamilyList);
  }

  @Override
  public void displayListOfFamilies() {
    List<Family> allFamilies = controller.getAllFamilies();
    IntStream.range(0, allFamilies.size())
        .forEach(i -> printIndexedFamilyList(i, allFamilies.get(i)));
  }

  @Override
  public void fillWithTestData() {
    Man father1 = new Man("father1", "Adigozelov", "12/06/1985", 63);
    Woman mother1 = new Woman("mother1", "Adigozelova", "16/11/1979", 46);
    controller.createNewFamily(father1, mother1);

    Man father2 = new Man("father2", "Adigozelov", "12/10/1980", 58);
    Woman mother2 = new Woman("mother2", "Adigozelova", "12/10/1982", 23);
    controller.createNewFamily(father2, mother2);
    controller.getFamilyById(1).ifPresent(f2 -> {
          f2.bornChild("child1", "child1");
          f2.addChild(new Man("child2", "Adigozelov", "12/10/2015", 60));
          f2.addChild(new Woman("child3", "Adigozelov", "12/10/2000", 50));
    });

    Man father3 = new Man("father3", "Adigozelov", "25/10/1986", 60);
    Woman mother3 = new Woman("mother3", "Adigozelova", "12/04/1987", 50);
    controller.createNewFamily(father3, mother3);
    controller.getFamilyById(2).ifPresent(f3 -> {
      f3.addChild(new Man("child1", "Adigozelov", "12/10/2020", 60));
      f3.addChild(new Woman("child2", "Adigozelov", "12/10/2010", 50));
    });

    System.out.println("Data filled!");
  }

  private void printIndexedFamilyList(int index, Family family) {
    System.out.println(Util.getIndexFromMachineToHuman(index) + "\n" + family.prettyFormat());
    System.out.println("--------------------------------------------------------------------------------------------");
  }

  private void printFamilyList(Family family) {
    System.out.println("\n" + family.prettyFormat());
    System.out.println("--------------------------------------------------------------------------------------------");
  }

  private Man getNewMan(String createdHumanStatus) {
    String fatherName = Util.getStringWithScanner(String.format("Please enter %s's name: ", createdHumanStatus));
    String fatherLastName = Util.getStringWithScanner(String.format("Please enter %s's last name: ", createdHumanStatus));
    int fatherBirthYear = Util.getIntWithScanner(String.format("Please enter %s's birth year: ", createdHumanStatus));
    int fatherBirthMonth = Util.getIntWithScanner(String.format("Please enter %s's birth month: ", createdHumanStatus));
    int fatherBirthDay = Util.getIntWithScanner(String.format("Please enter %s's birthday: ", createdHumanStatus));
    String fatherBirthDate = String.format("%d/%d/%d", fatherBirthDay, fatherBirthMonth, fatherBirthYear);
    int fatherIq = Util.getIntWithScanner(String.format("Please enter %s's iq: ", createdHumanStatus));

    return new Man(fatherName, fatherLastName, fatherBirthDate, fatherIq);
  }

  private Woman getNewWoman(String createdHumanStatus) {
    String motherName = Util.getStringWithScanner(String.format("Please enter %s's name: ", createdHumanStatus));
    String motherLastName = Util.getStringWithScanner(String.format("Please enter %s's last name: ", createdHumanStatus));
    int motherBirthYear = Util.getIntWithScanner(String.format("Please enter %s's birth year: ", createdHumanStatus));
    int motherBirthMonth = Util.getIntWithScanner(String.format("Please enter %s's birth month: ", createdHumanStatus));
    int motherBirthDay = Util.getIntWithScanner(String.format("Please enter %s's birthday: ", createdHumanStatus));
    String motherBirthDate = String.format("%d/%d/%d", motherBirthDay, motherBirthMonth, motherBirthYear);
    int motherIq = Util.getIntWithScanner(String.format("Please enter %s's iq: ", createdHumanStatus));

    return new Woman(motherName, motherLastName, motherBirthDate, motherIq);
  }


}
