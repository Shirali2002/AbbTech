package hw8.test.newTest;

import hw8.abstracts.AbstractPet;
import hw8.concretes.Dog;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
