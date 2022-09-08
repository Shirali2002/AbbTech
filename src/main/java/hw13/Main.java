package hw13;

import hw13.controller.FamilyController;
import hw13.model.enums.DayOfWeek;
import hw13.model.impl.*;

import java.util.*;


class Main {
  public static void main(String[] args) {
    Man father1 = new Man("father", "Adigozelov", "01/02/2012", 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Woman mother1 = new Woman("mother", "Adigozelova", "01/02/2012", 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Woman child1 = new Woman("child1", "Adigozelova", "01/02/2012", 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Man child2 = new Man("child1", "Adigozelova", "01/02/2012", 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Dog pet1 = new Dog("Toplan", 3, 65,
        new HashSet<>(Arrays.asList("eat", "drink", "sleep", "run")));
    Fish fish1 = new Fish("fish", 3, 65,
        new HashSet<>(Arrays.asList("swim", "sleep")));
    Family family1 = new Family(mother1, father1, new HashSet<>(List.of(pet1, fish1)), new ArrayList<>(List.of(child1, child2)));

    System.out.println(family1.prettyFormat());



//    main1();
//    Man father1 = new Man("father1", "Adigozelov", "12/10/1980");
//    System.out.println(father1.getClass().toString().endsWith("Man"));
//    Woman mother1 = new Woman("mother1", "Adigozelova", "30/09/1982");
//    Family family = new Family(mother1, father1);
//    family.addPet(new Dog("auye", 2, 50
//        , new HashSet<>(Arrays.asList("eat", "drink"))));
//    family.addPet(new Dog("sdfs", 5, 23
//        , new HashSet<>(Arrays.asList("sleep", "run"))));
//    System.out.println(family.getPets());
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
