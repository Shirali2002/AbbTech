package hw8.test.oldTest;

import hw8.abstracts.AbstractHuman;
import hw8.concretes.Man;
import hw8.enums.DayOfWeek;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class TestHumanOldFunctions {
    AbstractHuman human1;
    AbstractHuman human2;
    AbstractHuman human3;

    @BeforeEach
    public void testEnv(){
        human1 = new Man("Ferhad", "Adigozelov", 2012, 50,
                new String[][]{{DayOfWeek.MONDAY.name(), "do homework"}, {DayOfWeek.FRIDAY.name(), "Take the dog for a walk."}});
        human2 = new Man("Ferhad", "Adigozelov", 2012, 50,
                new String[][]{{DayOfWeek.MONDAY.name(), "do homework"}, {DayOfWeek.FRIDAY.name(), "Take the dog for a walk."}});
        human3 = new Man("Ferid", "Adigozelov", 1990, 50,
                new String[][]{{DayOfWeek.MONDAY.name(), "do homework"}, {DayOfWeek.FRIDAY.name(), "Take the dog for a walk."}});
    }

    @Test
    public void TestToString() {
        String res = "Man{name='Ferhad', surname='Adigozelov', year=2012, iq=50, " +
                "schedule=[[MONDAY, do homework], [FRIDAY, Take the dog for a walk.]]}";
        assertEquals(res, human1.toString());
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
}
