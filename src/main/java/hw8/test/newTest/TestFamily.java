package hw8.test.newTest;

import hw8.abstracts.AbstractHuman;
import hw8.concretes.Dog;
import hw8.concretes.Family;
import hw8.concretes.Man;
import hw8.concretes.Woman;
import hw8.enums.DayOfWeek;
import hw8.enums.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

public class TestFamily {
    Family family;


    @Test
    public void testBornChildIsMethodWorkWithoutError(){
        family = Mockito.mock(Family.class);
        family.bornChild();
        Mockito.verify(family).bornChild();
    }

    @Test
    public void testBornChildIsNewChildCreated(){
        Man father1 = new Man("father", "Adigozelov", 2012, 50,
            Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
        Woman mother1 = new Woman("mother", "Adigozelova", 2012, 50,
            Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
        Woman child1 = new Woman("child1", "Adigozelova", 2012, 50,
            Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
        Dog pet1 = new Dog("Toplan", 3, 65,
            new HashSet<>(Arrays.asList("eat", "drink", "sleep", "run")));
        family = new Family(mother1, father1, new HashSet<>(List.of(pet1)), new ArrayList<>(List.of(child1)));

        AbstractHuman newChild = family.bornChild();
        System.out.println(newChild);
        System.out.println(family);

        Assertions.assertNotNull(newChild);
    }

    @Test
    public void testBornChildIsChildCorrect(){
        Man father1 = new Man("father", "Adigozelov", 2012, 50,
            Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
        Woman mother1 = new Woman("mother", "Adigozelova", 2012, 50,
            Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
        Woman child1 = new Woman("child1", "Adigozelova", 2012, 50,
            Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
        Dog pet1 = new Dog("Toplan", 3, 65,
            new HashSet<>(Arrays.asList("eat", "drink", "sleep", "run")));
        family = new Family(mother1, father1, new HashSet<>(List.of(pet1)), new ArrayList<>(List.of(child1)));

        AbstractHuman newChild = family.bornChild();

        Assertions.assertNotNull(newChild.getName(), "new child name must not null.");
        Assertions.assertEquals(father1.getSurname(), newChild.getSurname(), "surname is not correct.");
        Assertions.assertNotNull(newChild.getYear(), "new child year must not null.");
        Assertions.assertEquals(((father1.getIq()+mother1.getIq())/2), newChild.getIq(), "iq is not correct.");
        Assertions.assertEquals(Status.CHILD, newChild.getStatus(), "status is not correct.");
        Assertions.assertEquals(family, newChild.getFamily(), "family is not correct.");


    }


}
