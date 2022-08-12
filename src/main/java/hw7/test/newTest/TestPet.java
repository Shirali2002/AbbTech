package hw7.test.newTest;

import hw7.abstracts.AbstractPet;
import hw7.concretes.Dog;
import hw7.concretes.Fish;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.*;

public class TestPet {
    AbstractPet pet;
    Dog dog;

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
