package hw13.test;

import hw13.model.enums.DayOfWeek;
import hw13.model.impl.Man;
import hw13.model.impl.Woman;
import hw13.model.inter.AbstractHuman;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class TestHuman {
    AbstractHuman human;
    AbstractHuman human1;
    AbstractHuman human2;
    AbstractHuman human3;
    Man man;
    Woman woman;

    @BeforeEach
    public void testEnv(){
        human1 = new Man("Ferhad", "Adigozelov", "12/10/2012", 50,
            Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.FRIDAY, "Take the dog for a walk."));
        human2 = new Man("Ferhad", "Adigozelov", "12/10/2012", 50,
            Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.FRIDAY, "Take the dog for a walk."));
        human3 = new Man("Ferid", "Adigozelov", "12/10/1990", 50,
            Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.FRIDAY, "Take the dog for a walk."));
    }

    @Test
    public void testDescribeAge(){
        Assertions.assertEquals("12/10/2012", human1.describeAge());
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
