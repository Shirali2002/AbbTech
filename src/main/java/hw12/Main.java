package hw12;

import hw12.controller.FamilyController;
import hw12.model.impl.Dog;
import hw12.model.impl.Man;
import hw12.model.impl.Woman;


class Main {
  public static void main(String[] args) {
    main1();
    Woman mother1 = new Woman("mother1", "Adigozelova", "30/09/1982");
    System.out.println("\nHuman toString: " + mother1 +"\n\n\n");
  }

  public static void main1() {
    FamilyController controller = FamilyController.getInstance();

    Man father1 = new Man("father1", "Adigozelov", "12/10/1980");
    Woman mother1 = new Woman("mother1", "Adigozelova", "30/09/1982");

    Man father2 = new Man("father2", "Adigozelov", "20/01/2000");
    Woman mother2 = new Woman("mother2", "Adigozelova", "01/05/2002");

    controller.createNewFamily(father1, mother1);
    controller.createNewFamily(father2, mother2);

    controller.displayAllFamilies();

    System.out.println("\n\n");

    Man father3 = new Man("father3", "Adigozelov", "12/10/1980");
    Woman mother3 = new Woman("mother3", "Adigozelova", "12/10/1982");
    controller.createNewFamily(father3, mother3);
    controller.deleteFamilyByIndex(2);
    controller.displayAllFamilies();

    System.out.println("\n\n");

    controller.getFamilyById(0).ifPresent(optionalFamily ->
        System.out.println(controller.bornChild(optionalFamily, "Kamil", "Samira")));

    System.out.println("\n\n");

    Man child1 = new Man("child1", "Adigozelov", "12/10/2010");
    System.out.println(controller.adoptChild(controller.getFamilyById(1).orElse(null), child1));

    System.out.println("\n\n");

    controller.deleteAllChildrenOlderThan(20);

    System.out.println("\n\n");

    System.out.println(controller.count());

    System.out.println("\n\n");

    controller.addPet(0, new Dog());
    System.out.println(controller.getPets(0));

    System.out.println("\n\n");

    System.out.println(controller.countFamiliesWithMemberNumber(2));

    System.out.println("\n\n");

    controller.getFamiliesBiggerThan(2);

    System.out.println("\n\n");

    controller.getFamiliesLessThan(3);

    System.out.println("\n\n");

  }
}
