package hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestCases {
    /** Tests for Family class */

    @Test
    public void addChildTest() {
        Human father = new Human("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human mother = new Human("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});

        Human child1 = new Human("child1", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});

        Human child2 = new Human("child2", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});

        Pet toplan = new Pet("dog", "Toplan", 3, 65, "eat", "drink", "sleep", "run");

        Family family = new Family(mother, father, toplan, child1);

        family.addChild(child2);

        Family familyResult = new Family(mother, father, toplan, child1, child2);

        assertEquals(family, familyResult);
    }

    @Test
    public void deleteChildIndexTest() {
        Human father = new Human("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human mother = new Human("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});

        Human child1 = new Human("child1", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});

        Human child2 = new Human("child2", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Pet toplan = new Pet("dog", "Toplan", 3, 65, "eat", "drink", "sleep", "run");

        Family family = new Family(mother, father, toplan, child1, child2);
        family.deleteChild(1);

        Family familyResult = new Family(mother, father, toplan, child1);

        assertEquals(family, familyResult);
    }

    @Test
    public void deleteChildObjTest() {
        Human father = new Human("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human mother = new Human("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});

        Human child1 = new Human("child1", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});

        Human child2 = new Human("child2", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human child2New = new Human("child2", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Pet toplan = new Pet("dog", "Toplan", 3, 65, "eat", "drink", "sleep", "run");

        Family family = new Family(mother, father, toplan, child1, child2);
        family.deleteChild(child2New);

        Family familyResult = new Family(mother, father, toplan, child1);

        assertEquals(family, familyResult);
    }

    @Test
    public void familyEqualsTest() {
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


        Pet toplan = new Pet("dog", "Toplan", 3, 65, "eat", "drink", "sleep", "run");
        Pet toplanNew = new Pet("dog", "Toplan", 3, 65, "eat", "drink", "sleep", "run");

        Family family1 = new Family(mother, father, toplan, child1);
        Family family2 = new Family(motherNew, fatherNew, toplanNew, child1New);

        assertEquals(family2, family1);
    }

    @Test
    public void countFamilyTest() {
        Human father = new Human("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human mother = new Human("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});

        Human child1 = new Human("child1", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human child2 = new Human("child2", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Family family1 = new Family(mother, father, child1, child2);

        assertEquals(4, family1.countFamily());
    }

    /** Tests for Human class */
    @Test
    public void equalsHumanTest(){
        Human human = new Human("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human humanTest = new Human("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});

        assertEquals(humanTest, human);
    }


    @Test
    public void equalsHumanWithFamilyTest() {
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


        Pet toplan = new Pet("dog", "Toplan", 3, 65, "eat", "drink", "sleep", "run");
        Pet toplanNew = new Pet("dog", "Toplan", 3, 65, "eat", "drink", "sleep", "run");

        Family family1 = new Family(mother, father, toplan, child1);
        Family family2 = new Family(motherNew, fatherNew, toplanNew, child1New);

        assertEquals(child1, child1New);
    }


    /** Tests for Pet class */
    @Test
    public void equalsPetTest() {
        Pet toplan1 = new Pet("dog", "Toplan", 3, 65, "eat", "drink", "sleep", "run");
        Pet toplan2 = new Pet("dog", "Toplan", 3, 65, "eat", "drink", "sleep", "run");

        assertEquals(toplan1, toplan2);
    }

}
