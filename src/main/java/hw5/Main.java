package hw5;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
//        Human father = new Human("father", "Adigozelov", 2012, 50,
//                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
//        Human fatherNew = new Human("father", "Adigozelov", 2012, 50,
//                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
//
//
//
//        Human mother = new Human("mother", "Adigozelova", 2012, 50,
//                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
//        Human motherNew = new Human("mother", "Adigozelova", 2012, 50,
//                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
//
//        Human child1 = new Human("child1", "Adigozelova", 2012, 50,
//                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
//        Human child1New = new Human("child1", "Adigozelova", 2012, 50,
//                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});

//        Human child2 = new Human("child2", "Adigozelova", 2012, 50,
//                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
//        Human child3 = new Human("child3", "Adigozelova", 2012, 50,
//                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
//
//        Pet toplan = new Pet("dog", "Toplan", 3, 65, "eat", "drink", "sleep", "run");
//        Pet toplanNew = new Pet("dog", "Toplan", 3, 65, "eat", "drink", "sleep", "run");

//        Pet mestan = new Pet("dog", "Toplan", 3, 65, new String[]{"eat", "drink", "sleep", "run"});

//        Family family1 = new Family(mother, father, toplan, child1);
//        Family family2 = new Family(motherNew, fatherNew, toplanNew, child1New);

//        System.out.println(family1.equals(family2));

//        System.out.println(child1.getFamily());
//        System.out.println(child2.getFamily());
//
//        System.out.println(child1.equals(child2));

//        System.out.println(Arrays.toString(family1.getChildren()));
//        System.out.println(child1==child1New);
//        System.out.println(child1.hashCode()==child1New.hashCode());
//        System.out.println(child1.equals(child1New));
//        System.out.println(family1.deleteChild(child1New));
//        System.out.println(Arrays.toString(family1.getChildren()));




//        Family family2 = new Family(motherNew, fatherNew, new Human[]{child1New, child2}, toplanNew);
//        System.out.println(family1.equals(family2));



//        Family family = new Family(mother, father, new Human[]{child1, child3});
//        family.addChild(child2);
//        System.out.println(child3.getFamily());
//        System.out.println(family.deleteChild(1));
////        System.out.println(family);
//        System.out.println(child3.getFamily());
////        System.out.println(child1.getFamily());
    }
//        firstPart();
//        secondPart();
//    }
//
//    public static void thirdPart() {
//        Human ramin /*Father*/ = new Human("Ramin", "Adigozelov", 1987);
//        Human nigar /*Mother*/ = new Human("Nigar", "Ceferova", 1988);
//        Pet toplan /*Child's Pet*/ = new Pet("dog", "Toplan", 3, 45, new String[]{"eat", "drink", "sleep", "run"});
//        Human ferid /*Child*/ = new Human("Ferid", "Adigozelov", 2012, 50, toplan, nigar, ramin,
//                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
//        Human ruslan /*Child*/ = new Human("Ruslan", "Adigozelov", 2018, nigar, ramin);
//
//
//    }



//    public static void firstPart() {
//        // Family 1
//        Human ramin = new Human("Ramin", "Adigozelov", 1987);   // Father
//        Human nigar = new Human("Nigar", "Ceferova", 1988);     // Mother
//        Pet toplan = new Pet("dog", "Toplan", 3, 65, new String[]{"eat", "drink", "sleep", "run"}); // Pet 1
//        Pet mestan = new Pet("cat", "Mestan");  // Pet 2
//        Human ferid = new Human("Ferid", "Adigozelov", 2012, 50, toplan, nigar, ramin,
//                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});   // child 1
//        Human samire = new Human("Samire", "Adigozelova", 2014, 48, mestan, nigar, ramin,
//                new String[][]{{"monday", "play video game"}, {"sunday", "play with mestan"}});         // child 2
//        Human ruslan = new Human("Ruslan", "Adigozelov", 2018, nigar, ramin);         // child 3
//
//        // Family 2
//        Human fazil = new Human();  // Father
//        fazil.setName("Fazil");
//        fazil.setSurname("Suleymanov");
//        fazil.setYear(1994);
//
//        Pet favpet = new Pet();     // Pet
//        favpet.setSpecies("bird");
//        favpet.setNickname("Favpet");
//
//        Human aydan = new Human("Aydan", "Suleymanova", 1996);     // Mother
//
//        Human nicat = new Human("Nicat", "Suleymanov", 2018, 47, favpet, aydan, fazil,
//                new String[][]{{"monday", "do homework"}, {"saturday", "go to park."}});   // child
//
//    }
//
//    public static void secondPart() {
//        // Family 1
//        Human ramin /*Father*/ = new Human("Ramin", "Adigozelov", 1987);
//        Human nigar /*Mother*/ = new Human("Nigar", "Ceferova", 1988);
//        Pet toplan /*Child's Pet*/ = new Pet("dog", "Toplan", 3, 45, new String[]{"eat", "drink", "sleep", "run"});
//        Human ferid /*Child*/ = new Human("Ferid", "Adigozelov", 2012, 50, toplan, nigar, ramin,
//                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
//        Human ruslan = new Human("Ruslan", "Adigozelov", 2018, nigar, ramin);         // child 2
//
//
//        /** Human's methods for child.*/
//        ferid.describePet();
//        ferid.greetPet();
//        System.out.println(ferid);
//        System.out.println(ferid.feedPet(false));
//
//        System.out.println();
//
//        ruslan.describePet();
//        ruslan.greetPet();
//        System.out.println(ruslan);
//        System.out.println(ruslan.feedPet(true));
//
//        System.out.println();
//
//        /**Pet's methods*/
//        toplan.eat();
//        toplan.foul();
//        toplan.respond();
//        System.out.println(toplan);
//
//    }


}
