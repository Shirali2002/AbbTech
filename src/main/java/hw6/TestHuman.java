package hw6;

import hw6.enums.DayOfWeek;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class TestHuman {
    Human human1;
    Human human2;
    Human human3;

    @BeforeEach
    public void testEnv(){
        human1 = new Human("Ferhad", "Adigozelov", 2012, 50,
                new String[][]{{DayOfWeek.MONDAY.name(), "do homework"}, {DayOfWeek.FRIDAY.name(), "Take the dog for a walk."}});
        human2 = new Human("Ferhad", "Adigozelov", 2012, 50,
                new String[][]{{DayOfWeek.MONDAY.name(), "do homework"}, {DayOfWeek.FRIDAY.name(), "Take the dog for a walk."}});
        human3 = new Human("Ferid", "Adigozelov", 1990, 50,
                new String[][]{{DayOfWeek.MONDAY.name(), "do homework"}, {DayOfWeek.FRIDAY.name(), "Take the dog for a walk."}});
    }

    @Test
    public void TestToString() {
        String res = "Human{name='Ferhad', surname='Adigozelov', year=2012, iq=50, schedule=[[MONDAY, do homework]," +
                " [FRIDAY, Take the dog for a walk.]]}";
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
