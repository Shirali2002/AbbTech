package hw8.test.oldTest;

import hw8.concretes.Dog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class TestPetOldFunctions {
    Dog pet1;
    Dog pet2;
    Dog pet3;

    @BeforeEach
    public void testEnv(){
        pet1 = new Dog("Toplan", 3, 65, "eat", "drink", "sleep", "run");
        pet2 = new Dog("Toplan", 3, 65, "eat", "drink", "sleep", "run");
        pet3 = new Dog("Carli", 4, 65, "eat", "drink", "sleep");
    }

    @Test
    public void testToString() {
        String res = "Dog{Dog can not fly. Dog has 4 legs. Dog has fur. nickname='Toplan', " +
                "age=3, trickLevel=65, habits=[eat, drink, sleep, run]}";
        assertEquals(res, pet1.toString());
    }

    @Test
    public void testValidEquals(){
        assertEquals(pet1, pet2);
    }

    @Test
    public void testInvalidEquals(){
        assertNotEquals(pet1, pet3);
    }

    @Test
    public void testValidHashcode(){
        assertEquals(pet1.hashCode(), pet2.hashCode());
    }

    @Test
    public void testInvalidHashcode(){
        assertNotEquals(pet1.hashCode(), pet3.hashCode());
    }
}
