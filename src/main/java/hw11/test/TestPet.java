package hw11.test;

import hw11.model.inter.AbstractPet;
import hw11.model.impl.Dog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class TestPet {
    Dog dog;
    Dog pet1;
    Dog pet2;
    Dog pet3;
    AbstractPet pet;

    @BeforeEach
    public void testEnv(){
        pet1 = new Dog("Toplan", 3, 65, new HashSet<>(Arrays.asList("eat", "drink", "sleep", "run")));
        pet2 = new Dog("Toplan", 3, 65, new HashSet<>(Arrays.asList("eat", "drink", "sleep", "run")));
        pet3 = new Dog("Carli", 4, 65, new HashSet<>(Arrays.asList("eat", "drink", "sleep")));
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

    @Test
    public void testDogRespond(){
        pet = Mockito.mock(AbstractPet.class);
        pet.respond();
        Mockito.verify(pet).respond();
    }

    @Test
    public void testDogFoul(){
        dog = Mockito.mock(Dog.class);
        dog.foul();
        Mockito.verify(dog).foul();
    }

}
