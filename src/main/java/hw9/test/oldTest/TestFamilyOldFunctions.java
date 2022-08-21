package hw9.test.oldTest;


import hw9.abstracts.AbstractHuman;
import hw9.concretes.Dog;
import hw9.concretes.Family;
import hw9.concretes.Man;
import hw9.concretes.Woman;
import hw9.enums.DayOfWeek;
import hw9.enums.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class TestFamilyOldFunctions {
  Family family;
  Family family1;
  Family family2;
  Family family3;

  @BeforeEach
  public void testEnv() {
    /** Family 1 */
    Man father1 = new Man("father", "Adigozelov", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Woman mother1 = new Woman("mother", "Adigozelova", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Woman child1 = new Woman("child1", "Adigozelova", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Dog pet1 = new Dog("Toplan", 3, 65,
        new HashSet<>(Arrays.asList("eat", "drink", "sleep", "run")));
    family1 = new Family(mother1, father1, new HashSet<>(List.of(pet1)), new ArrayList<>(List.of(child1)));

    /** Family 2 which equals to family 1 */
    Man father2 = new Man("father", "Adigozelov", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Woman mother2 = new Woman("mother", "Adigozelova", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Woman child2 = new Woman("child1", "Adigozelova", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Dog pet2 = new Dog("Toplan", 3, 65,
        new HashSet<>(Arrays.asList("eat", "drink", "sleep", "run")));
    family2 = new Family(mother2, father2, new HashSet<>(List.of(pet2)), new ArrayList<>(List.of(child2)));

    /** Family 3 which not equals to family 1 */
    Man father3 = new Man("father", "Samirov", 1990, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Woman mother3 = new Woman("mother", "Samirova", 1990, 52,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Man child3 = new Man("child1", "Samirov", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Dog pet3 = new Dog("Toplan", 3, 65,
        new HashSet<>(Arrays.asList("eat", "drink", "sleep", "run")));
    family3 = new Family(mother3, father3, new HashSet<>(List.of(pet3)), new ArrayList<>(List.of(child3)));
  }

  @Test
  public void testValidEquals() {
    assertEquals(family1, family2);
  }

  @Test
  public void testInvalidEquals() {
    assertNotEquals(family1, family3);
  }

  @Test
  public void testValidHashcode() {
    assertEquals(family1.hashCode(), family2.hashCode());
  }

  @Test
  public void testInvalidHashcode() {
    assertNotEquals(family1.hashCode(), family3.hashCode());
  }

  @Test
  public void testAddChild() {
    Man father1 = new Man("father", "Adigozelov", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Woman mother1 = new Woman("mother", "Adigozelova", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Woman child1 = new Woman("child1", "Adigozelova", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Dog pet1 = new Dog("Toplan", 3, 65,
        new HashSet<>(Arrays.asList("eat", "drink", "sleep", "run")));

    Woman child2 = new Woman("child1", "Adigozelova", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));

    Family family1Test = new Family(mother1, father1,
        new HashSet<>(List.of(pet1)), new ArrayList<>(List.of(child1, child2)));

    assertNotEquals(family1Test, this.family1);
    assertTrue(family1.addChild(child2));
    assertEquals(family1Test, this.family1);
  }

  @Test
  public void testDeleteChildByIndex() {
    Man father1 = new Man("father", "Adigozelov", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Woman mother1 = new Woman("mother", "Adigozelova", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Dog pet1 = new Dog("Toplan", 3, 65,
        new HashSet<>(Arrays.asList("eat", "drink", "sleep", "run")));

    Family family1Test = new Family(mother1, father1, new HashSet<>(List.of(pet1)));

    assertNotEquals(family1Test, family1);
    assertTrue(family1.deleteChild(0));
    assertEquals(family1Test, family1);
  }

  @Test
  public void testDeleteChildByWrongIndex() {
    Man father1 = new Man("father", "Adigozelov", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Woman mother1 = new Woman("mother", "Adigozelova", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Dog pet1 = new Dog("Toplan", 3, 65,
        new HashSet<>(Arrays.asList("eat", "drink", "sleep", "run")));

    Family family1Test = new Family(mother1, father1, new HashSet<>(List.of(pet1)));


    assertNotEquals(family1Test, family1);
    assertFalse(family1.deleteChild(2));
    assertNotEquals(family1Test, family1);
  }

  @Test
  public void testDeleteChildByObject() {
    Man father1 = new Man("father", "Adigozelov", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Woman mother1 = new Woman("mother", "Adigozelova", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Dog pet1 = new Dog("Toplan", 3, 65,
        new HashSet<>(Arrays.asList("eat", "drink", "sleep", "run")));

    Woman child1 = new Woman("child1", "Adigozelova", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Family family1SetChild = new Family(mother1, father1,
        new HashSet<>(List.of(pet1)), new ArrayList<>(List.of(child1))); // for setting status of child1 as CHILD

    Family family1Test = new Family(mother1, father1, new HashSet<>(List.of(pet1)));

    assertNotEquals(family1Test, family1);
    assertTrue(family1.deleteChild(child1));
    assertEquals(family1Test, family1);
  }

  @Test
  public void testDeleteChildByWrongObject() {
    Man father1 = new Man("father", "Adigozelov", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Woman mother1 = new Woman("mother", "Adigozelova", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Dog pet1 = new Dog("Toplan", 3, 65,
        new HashSet<>(Arrays.asList("eat", "drink", "sleep", "run")));

    Woman child1 = new Woman("child1Diff", "Adigozelova", 2012, 50,
        Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
    Family family1SetChild = new Family(mother1, father1,
        new HashSet<>(List.of(pet1)), new ArrayList<>(List.of(child1))); // for setting status of child1 as CHILD

    Family family1Test = new Family(mother1, father1, new HashSet<>(List.of(pet1)));

    assertNotEquals(family1Test, family1);
    assertFalse(family1.deleteChild(child1));
    assertNotEquals(family1Test, family1);
  }

  @Test
  public void testCountFamily() {
    assertEquals(3, family1.countFamily());
  }

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
