package hw6;

import hw6.enums.DayOfWeek;
import hw6.enums.Species;



class Main {
    public static void main(String[] args) {
        garbageTest();


    }

    public static void garbageTest() {
        for (int i = 0; i < 10000; i++) {
            Human father = new Human("father", "Adigozelov", 2012, 50,
                    new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
            Human fatherNew = new Human("father", "Adigozelov", 2012, 50,
                    new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
            Human mother = new Human("mother", "Adigozelova", 2012, 50,
                    new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
            Human motherNew = new Human("mother", "Adigozelova", 2012, 50,
                    new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
            Human child1 = new Human("child1", "Adigozelova", 2012, 50,
                    new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
            Human child1New = new Human("child1", "Adigozelova", 2012, 50,
                    new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
            Pet toplan = new Pet(Species.DOG, "Toplan", 3, 65, "eat", "drink", "sleep", "run");
            Pet toplanNew = new Pet(Species.DOG, "Toplan", 3, 65, "eat", "drink", "sleep", "run");
            Family family1 = new Family(mother, father, toplan, child1);
            Family family2 = new Family(motherNew, fatherNew, toplanNew, child1New);
        }
    }
}
