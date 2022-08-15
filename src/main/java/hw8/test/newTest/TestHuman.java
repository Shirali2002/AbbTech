package hw8.test.newTest;

import hw8.abstracts.AbstractHuman;
import hw8.concretes.Man;
import hw8.concretes.Woman;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
