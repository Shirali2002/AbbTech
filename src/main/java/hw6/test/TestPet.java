package hw6.test;

import hw6.Pet;
import hw6.enums.Species;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestPet {
    Pet pet1;
    Pet pet2;
    Pet pet3;

    @BeforeEach
    public void testEnv(){
        pet1 = new Pet(Species.DOG, "Toplan", 3, 65, "eat", "drink", "sleep", "run");
        pet2 = new Pet(Species.DOG, "Toplan", 3, 65, "eat", "drink", "sleep", "run");
        pet3 = new Pet(Species.DOG, "Carli", 4, 65, "eat", "drink", "sleep");
    }

    @Test
    public void testToString() {
        String res = "Dog{Dog can not fly. Dog has 4 legs. Dog has fur. nickname='Toplan', age=3, " +
                     "trickLevel=65, habits=[eat, drink, sleep, run]}";
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
