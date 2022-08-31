package hw10.test;

import hw10.controller.FamilyController;
import hw10.model.impl.Dog;
import hw10.model.impl.Family;
import hw10.model.impl.Man;
import hw10.model.impl.Woman;
import hw10.model.inter.AbstractHuman;
import hw10.model.inter.AbstractPet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Set;
import java.util.stream.Collectors;

public class TestFamilyController {
  FamilyController controller = FamilyController.getInstance();
  FamilyController mockFamilyController;

  Man father1;
  Woman mother1;
  Family family1;

  Man father2;
  Woman mother2;
  Family family2;

  @BeforeEach
  public void testEnv() {
    mockFamilyController = Mockito.mock(FamilyController.class);

    father1 = new Man("father1", "Adigozelov", "12/10/1980");
    mother1 = new Woman("mother1", "Adigozelova", "12/10/1982");
    family1 = new Family(mother1, father1);

    father2 = new Man("father2", "Adigozelov", "12/10/1980", 58);
    mother2 = new Woman("mother2", "Adigozelova", "12/10/1982", 23);
    family2 = new Family(mother2, father2);
  }

  @AfterEach
  public void clean() {
    controller.getAllFamilies().clear();
  }

  @Test
  public void testGetAllFamilies() {
    Assertions.assertEquals(0, controller.getAllFamilies().size());
  }

  @Test
  public void testDisplayAllFamilies() {
    mockFamilyController.displayAllFamilies();
    Mockito.verify(mockFamilyController).displayAllFamilies();
  }

  @Test
  public void getFamiliesBiggerThan() {
    mockFamilyController.getFamiliesBiggerThan(5);
    Mockito.verify(mockFamilyController).getFamiliesBiggerThan(5);
  }

  @Test
  public void getFamiliesLessThan() {
    mockFamilyController.getFamiliesLessThan(5);
    Mockito.verify(mockFamilyController).getFamiliesLessThan(5);
  }

  @Test
  public void testCountFamiliesWithMemberNumber() {
    Woman child2 = new Woman("child2", "Adigozelova", "12/10/2012");
    family2.addChild(child2);

    controller.addFamily(family1);
    controller.addFamily(family2);

    int count = controller.countFamiliesWithMemberNumber(3);

    Assertions.assertEquals(1, count);
  }

  @Test
  public void testAddFamily() {
    controller.addFamily(family1);

    int length = controller.getAllFamilies().size();
    Assertions.assertEquals(1, length);
  }

  @Test
  public void testAddSameFamily() {
    controller.addFamily(family1);
    controller.addFamily(family1);

    int length = controller.getAllFamilies().size();
    Assertions.assertEquals(1, length);
  }

  @Test
  public void testCreateNewFamily() {
    controller.createNewFamily(father1, mother1);

    int length = controller.getAllFamilies().size();
    Assertions.assertEquals(1, length);
  }

  @Test
  public void testCreateSameNewFamily() {
    controller.createNewFamily(father1, mother1);
    controller.createNewFamily(father1, mother1);

    int length = controller.getAllFamilies().size();
    Assertions.assertEquals(1, length);
  }

  @Test
  public void testDeleteFamilyByIndex() {
    Woman child2 = new Woman("child2", "Adigozelova", "12/10/2012");
    family2.addChild(child2);

    controller.addFamily(family1);
    controller.addFamily(family2);

    int oldLength = controller.getAllFamilies().size();
    Assertions.assertEquals(2, oldLength);

    controller.deleteFamilyByIndex(1);
    int newLength = controller.getAllFamilies().size();
    Assertions.assertEquals(1, newLength);
  }

  @Test
  public void testBornChild() {
    controller.createNewFamily(father2, mother2);
    int index = controller.getAllFamilies().indexOf(family2);
    controller.bornChild(family2, "Samir", "Kemale");
    String childName = controller.getAllFamilies().get(index)
        .getChildren().get(0).getName();

    Assertions.assertTrue(childName.equals("Samir") || childName.equals("Kemale"));
  }

  @Test
  public void testAdoptChild() {
    controller.createNewFamily(father2, mother2);
    int index = controller.getAllFamilies().indexOf(family2);
    Woman child = new Woman("child", "Adigozelova", "12/10/2012");
    controller.adoptChild(family2, child);
    AbstractHuman childInList = controller.getAllFamilies().get(index)
        .getChildren().get(0);

    Assertions.assertEquals(childInList, child);
  }

  @Test
  public void testAdoptChildCheckLength() {
    controller.createNewFamily(father2, mother2);
    int index = controller.getAllFamilies().indexOf(family2);
    Woman child = new Woman("child", "Adigozelova", "12/10/2012");
    controller.adoptChild(family2, child);
    int childListSize = controller.getAllFamilies().get(index)
        .getChildren().size();

    Assertions.assertEquals(1, childListSize);
  }

  @Test
  public void testAdoptSameChild() {
    controller.createNewFamily(father2, mother2);
    int index = controller.getAllFamilies().indexOf(family2);
    Woman child1 = new Woman("child1", "Adigozelova", "12/10/2012");
    Woman child2 = new Woman("child2", "Adigozelova", "12/10/2012");
    controller.adoptChild(family2, child1);
    controller.adoptChild(family2, child2);
    int childListSize = controller.getAllFamilies().get(index)
        .getChildren().size();

    Assertions.assertEquals(1, childListSize);
  }

  @Test
  public void testDeleteAllChildrenOlderThan() {
    Woman child11 = new Woman("child11", "Adigozelova", "12/10/2006");
    Man child12 = new Man("child12", "Adigozelov", "12/10/2020");
    family1.addChild(child11);
    family1.addChild(child12);

    Woman child21 = new Woman("child21", "Adigozelova", "12/10/2020");
    Man child22 = new Man("child22", "Adigozelov", "12/10/2009");
    Man child23 = new Man("child23", "Adigozelov", "12/10/2020");
    Man child24 = new Man("child24", "Adigozelov", "12/10/2009");
    family2.addChild(child21);
    family2.addChild(child22);
    family2.addChild(child23);
    family2.addChild(child24);

    controller.addFamily(family1);
    controller.addFamily(family2);

    int oldSum = (int) controller.getAllFamilies().stream()
        .map(f -> f.getChildren().size())
        .collect(Collectors.summarizingInt(Integer::intValue)).getSum();

    Assertions.assertEquals(6, oldSum);

    controller.deleteAllChildrenOlderThan(10);

    int newSum = (int) controller.getAllFamilies().stream()
        .map(f -> f.getChildren().size())
        .collect(Collectors.summarizingInt(Integer::intValue)).getSum();

    Assertions.assertEquals(3, newSum);
  }
  
  @Test
  public void testDeleteAllChildrenOlderThanWithOneEmptyFamily() {
    Woman child21 = new Woman("child11", "Adigozelova", "12/10/2009");
    Man child22 = new Man("child12", "Adigozelov", "12/10/2015");
    family2.addChild(child21);
    family2.addChild(child22);

    controller.addFamily(family1);
    controller.addFamily(family2);

    int oldSum = (int) controller.getAllFamilies().stream()
        .map(f -> f.getChildren().size())
        .collect(Collectors.summarizingInt(Integer::intValue)).getSum();

    Assertions.assertEquals(2, oldSum);

    controller.deleteAllChildrenOlderThan(12);

    int newSum = (int) controller.getAllFamilies().stream()
        .map(f -> f.getChildren().size())
        .collect(Collectors.summarizingInt(Integer::intValue)).getSum();

    Assertions.assertEquals(1, newSum);
  }

  @Test
  public void testDeleteAllChildrenOlderThanWithAllEmptyFamilies() {
    controller.addFamily(family1);
    controller.addFamily(family2);

    int oldSum = (int) controller.getAllFamilies().stream()
        .map(f -> f.getChildren().size())
        .collect(Collectors.summarizingInt(Integer::intValue)).getSum();

    Assertions.assertEquals(0, oldSum);

    controller.deleteAllChildrenOlderThan(12);

    int newSum = (int) controller.getAllFamilies().stream()
        .map(f -> f.getChildren().size())
        .collect(Collectors.summarizingInt(Integer::intValue)).getSum();

    Assertions.assertEquals(0, newSum);
  }

  @Test
  public void testCount() {
    controller.addFamily(family1);
    controller.addFamily(family2);

    int count = controller.count();
    Assertions.assertEquals(2, count);
  }

  @Test
  public void testGetFamilyById() {
    controller.addFamily(family1);
    controller.addFamily(family2);

    Family familyInList = controller.getFamilyById(0);

    Assertions.assertEquals(family1, familyInList);
  }

  @Test
  public void testGetFamilyByIdIndexOutOfBounds() {
    controller.addFamily(family1);
    controller.addFamily(family2);

    Family familyInList = controller.getFamilyById(3);

    Assertions.assertNull(familyInList);
  }

  @Test
  public void testGetPets(){
    AbstractPet pet1 = new Dog();
    family1.addPet(pet1);
    controller.addFamily(family1);

    Assertions.assertEquals(1, controller.getPets(0).size());
  }

  @Test
  public void testAddPet(){
    AbstractPet pet1 = new Dog();
    controller.addFamily(family1);

    controller.addPet(0, pet1);
    Set<AbstractPet> petSet = controller.getAllFamilies().get(0).getPets();
    Assertions.assertTrue(petSet.contains(pet1));
  }

  @Test
  public void testAddNullPet(){
    controller.addFamily(family1);

    controller.addPet(0, null);
    Set<AbstractPet> petSet = controller.getAllFamilies().get(0).getPets();
    Assertions.assertEquals(0, petSet.size());
  }
}
