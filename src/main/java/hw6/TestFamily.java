package hw6;


import hw6.enums.Species;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestFamily {
    Family family1;
    Family family2;
    Family family3;

    @BeforeEach
    public void testEnv(){
        /** Family 1 */
        Human father1 = new Human("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human mother1 = new Human("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human child1 = new Human("child1", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Pet pet1 = new Pet(Species.DOG, "Toplan", 3, 65, "eat", "drink", "sleep", "run");
        family1 = new Family(mother1, father1, pet1, child1);

        /** Family 2 which equals to family 1 */
        Human father2 = new Human("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human mother2 = new Human("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human child2 = new Human("child1", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Pet pet2 = new Pet(Species.DOG, "Toplan", 3, 65, "eat", "drink", "sleep", "run");
        family2 = new Family(mother2, father2, pet2, child2);

        /** Family 3 which not equals to family 1 */
        Human father3 = new Human("father", "Samirov", 1990, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human mother3 = new Human("mother", "Samirova", 1990, 52,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human child3 = new Human("child1", "Samirov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Pet pet3 = new Pet(Species.DOG, "Toplan", 3, 65, "eat", "drink", "sleep", "run");
        family3 = new Family(mother3, father3, pet3, child3);
    }

    @Test
    public void testToString(){
        String res = "Family{mother=Human{name='mother', surname='Adigozelova', year=2012, iq=50, " +
                "schedule=[[monday, do homework], [saturday, Take the dog for a walk.]]}, " +
                "father=Human{name='father', surname='Adigozelov', year=2012, iq=50, " +
                "schedule=[[monday, do homework], [saturday, Take the dog for a walk.]]}, " +
                "children=[Human{name='child1', surname='Adigozelova', year=2012, iq=50, " +
                "schedule=[[monday, do homework], [saturday, Take the dog for a walk.]]}], " +
                "pet=Dog{Dog can not fly. Dog has 4 legs. Dog has fur. nickname='Toplan', " +
                "age=3, trickLevel=65, habits=[eat, drink, sleep, run]}}";

        assertEquals(res, family1.toString());
    }

    @Test
    public void testValidEquals(){
        assertEquals(family1, family2);
    }

    @Test
    public void testInvalidEquals(){
        assertNotEquals(family1, family3);
    }

    @Test
    public void testValidHashcode(){
        assertEquals(family1.hashCode(), family2.hashCode());
    }

    @Test
    public void testInvalidHashcode(){
        assertNotEquals(family1.hashCode(), family3.hashCode());
    }

    @Test
    public void testAddChild(){
        Human father1 = new Human("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human mother1 = new Human("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human child1 = new Human("child1", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Pet pet1 = new Pet(Species.DOG, "Toplan", 3, 65, "eat", "drink", "sleep", "run");

        Human child2 = new Human("child1", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});

        Family family1Test = new Family(mother1, father1, pet1, child1, child2);

        assertNotEquals(family1Test, this.family1);
        assertTrue(family1.addChild(child2));
        assertEquals(family1Test, this.family1);
    }

    @Test
    public void testDeleteChildByIndex(){
        Human father1 = new Human("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human mother1 = new Human("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Pet pet1 = new Pet(Species.DOG, "Toplan", 3, 65, "eat", "drink", "sleep", "run");

        Family family1Test = new Family(mother1, father1, pet1);

        assertNotEquals(family1Test, family1);
        assertTrue(family1.deleteChild(0));
        assertEquals(family1Test, family1);
    }

    @Test
    public void testDeleteChildByWrongIndex(){
        Human father1 = new Human("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human mother1 = new Human("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Pet pet1 = new Pet(Species.DOG, "Toplan", 3, 65, "eat", "drink", "sleep", "run");

        Family family1Test = new Family(mother1, father1, pet1);

        assertNotEquals(family1Test, family1);
        assertFalse(family1.deleteChild(2));
        assertNotEquals(family1Test, family1);
    }

    @Test
    public void testDeleteChildByObject(){
        Human father1 = new Human("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human mother1 = new Human("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Pet pet1 = new Pet(Species.DOG, "Toplan", 3, 65, "eat", "drink", "sleep", "run");

        Human child1 = new Human("child1", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Family family1SetChild = new Family(mother1, father1, pet1, child1); // for setting status of child1 as CHILD

        Family family1Test = new Family(mother1, father1, pet1);

        assertNotEquals(family1Test, family1);
        assertTrue(family1.deleteChild(child1));
        assertEquals(family1Test, family1);
    }

    @Test
    public void testDeleteChildByWrongObject(){
        Human father1 = new Human("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Human mother1 = new Human("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Pet pet1 = new Pet(Species.DOG, "Toplan", 3, 65, "eat", "drink", "sleep", "run");

        Human child1 = new Human("child1Diff", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Family family1SetChild = new Family(mother1, father1, pet1, child1); // for setting status of child1 as CHILD

        Family family1Test = new Family(mother1, father1, pet1);

        assertNotEquals(family1Test, family1);
        assertFalse(family1.deleteChild(child1));
        assertNotEquals(family1Test, family1);
    }


    @Test
    public void testCountFamily(){
        assertEquals(3, family1.countFamily());
    }







}
