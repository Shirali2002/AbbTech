package hw7.test.oldTest;


import hw7.concretes.Dog;
import hw7.concretes.Family;
import hw7.concretes.Man;
import hw7.concretes.Woman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestFamilyOldFunctions {
    Family family1;
    Family family2;
    Family family3;

    @BeforeEach
    public void testEnv(){
        /** Family 1 */
        Man father1 = new Man("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Woman mother1 = new Woman("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Woman child1 = new Woman("child1", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Dog pet1 = new Dog("Toplan", 3, 65, "eat", "drink", "sleep", "run");
        family1 = new Family(mother1, father1, pet1, child1);

        /** Family 2 which equals to family 1 */
        Man father2 = new Man("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Woman mother2 = new Woman("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Woman child2 = new Woman("child1", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Dog pet2 = new Dog("Toplan", 3, 65, "eat", "drink", "sleep", "run");
        family2 = new Family(mother2, father2, pet2, child2);

        /** Family 3 which not equals to family 1 */
        Man father3 = new Man("father", "Samirov", 1990, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Woman mother3 = new Woman("mother", "Samirova", 1990, 52,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Man child3 = new Man("child1", "Samirov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Dog pet3 = new Dog("Toplan", 3, 65, "eat", "drink", "sleep", "run");
        family3 = new Family(mother3, father3, pet3, child3);
    }

    @Test
    public void testToString(){
        String res = "Family{mother=Woman{name='mother', surname='Adigozelova', year=2012, iq=50, " +
                "schedule=[[monday, do homework], [saturday, Take the dog for a walk.]]}, " +
                "father=Man{name='father', surname='Adigozelov', year=2012, iq=50, " +
                "schedule=[[monday, do homework], [saturday, Take the dog for a walk.]]}, " +
                "children=[Woman{name='child1', surname='Adigozelova', year=2012, iq=50, " +
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
        Man father1 = new Man("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Woman mother1 = new Woman("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Woman child1 = new Woman("child1", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Dog pet1 = new Dog("Toplan", 3, 65, "eat", "drink", "sleep", "run");

        Woman child2 = new Woman("child1", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});

        Family family1Test = new Family(mother1, father1, pet1, child1, child2);

        assertNotEquals(family1Test, this.family1);
        assertTrue(family1.addChild(child2));
        assertEquals(family1Test, this.family1);
    }

    @Test
    public void testDeleteChildByIndex(){
        Man father1 = new Man("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Woman mother1 = new Woman("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Dog pet1 = new Dog("Toplan", 3, 65, "eat", "drink", "sleep", "run");

        Family family1Test = new Family(mother1, father1, pet1);

        assertNotEquals(family1Test, family1);
        assertTrue(family1.deleteChild(0));
        assertEquals(family1Test, family1);
    }

    @Test
    public void testDeleteChildByWrongIndex(){
        Man father1 = new Man("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Woman mother1 = new Woman("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Dog pet1 = new Dog("Toplan", 3, 65, "eat", "drink", "sleep", "run");

        Family family1Test = new Family(mother1, father1, pet1);

        assertNotEquals(family1Test, family1);
        assertFalse(family1.deleteChild(2));
        assertNotEquals(family1Test, family1);
    }

    @Test
    public void testDeleteChildByObject(){
        Man father1 = new Man("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Woman mother1 = new Woman("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Dog pet1 = new Dog("Toplan", 3, 65, "eat", "drink", "sleep", "run");

        Woman child1 = new Woman("child1", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Family family1SetChild = new Family(mother1, father1, pet1, child1); // for setting status of child1 as CHILD

        Family family1Test = new Family(mother1, father1, pet1);

        assertNotEquals(family1Test, family1);
        assertTrue(family1.deleteChild(child1));
        assertEquals(family1Test, family1);
    }

    @Test
    public void testDeleteChildByWrongObject(){
        Man father1 = new Man("father", "Adigozelov", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Woman mother1 = new Woman("mother", "Adigozelova", 2012, 50,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});
        Dog pet1 = new Dog("Toplan", 3, 65, "eat", "drink", "sleep", "run");

        Woman child1 = new Woman("child1Diff", "Adigozelova", 2012, 50,
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
