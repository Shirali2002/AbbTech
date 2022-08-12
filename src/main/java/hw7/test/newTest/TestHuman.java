package hw7.test.newTest;

import hw7.abstracts.AbstractHuman;
import hw7.concretes.Man;
import hw7.concretes.Woman;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class TestHuman {
    AbstractHuman human;
    Man man;
    Woman woman;

    @Test
    public void testAbstractHumanGreetPetByOverride(){
        human = Mockito.mock(AbstractHuman.class);
        human.greetPet();
        Mockito.verify(human).greetPet();
    }

    @Test
    public void testManRepairCar(){
        man = Mockito.mock(Man.class);
        man.repairCar();
        Mockito.verify(man).repairCar();
    }

    @Test
    public void testWomanMakeUp(){
        woman = Mockito.mock(Woman.class);
        woman.makeUp();
        Mockito.verify(woman).makeUp();
    }
}
