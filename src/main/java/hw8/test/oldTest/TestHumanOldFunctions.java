package hw8.test.oldTest;

import hw8.abstracts.AbstractHuman;
import hw8.concretes.Man;
import hw8.concretes.Woman;
import hw8.enums.DayOfWeek;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class TestHumanOldFunctions {
    AbstractHuman human;
    AbstractHuman human1;
    AbstractHuman human2;
    AbstractHuman human3;
    Man man;
    Woman woman;

    @BeforeEach
    public void testEnv(){
        human1 = new Man("Ferhad", "Adigozelov", 2012, 50,
            Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.FRIDAY, "Take the dog for a walk."));
        human2 = new Man("Ferhad", "Adigozelov", 2012, 50,
            Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.FRIDAY, "Take the dog for a walk."));
        human3 = new Man("Ferid", "Adigozelov", 1990, 50,
            Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.FRIDAY, "Take the dog for a walk."));
    }

    @Test
    public void TestValidEquals() {
        assertEquals(human1, human2);
    }

    @Test
    public void TestInvalidEquals() {
        assertNotEquals(human1, human3);
    }

    @Test
    public void TestValidHashcode() {
        assertEquals(human1.hashCode(), human2.hashCode());
    }

    @Test
    public void TestInvalidHashcode() {
        assertNotEquals(human1.hashCode(), human3.hashCode());
    }

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
