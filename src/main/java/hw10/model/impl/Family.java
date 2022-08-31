package hw10.model.impl;

import hw10.model.impl.Man;
import hw10.model.impl.Woman;
import hw10.model.inter.AbstractHuman;
import hw10.model.inter.AbstractPet;
import hw10.model.inter.HumanCreatorInter;
import hw10.model.enums.Status;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/**
 * Family class is keep the Family members.
 */
public class Family implements HumanCreatorInter {
  private final List<AbstractHuman> children;
  private final Set<AbstractPet> pets;
  private final hw10.model.impl.Woman mother;
  private final hw10.model.impl.Man father;
  private final List<String> boyNameList;
  private final List<String> girlNameList;


  static {
    System.out.printf("a new class is being loaded(%s).\n", Family.class.getName());
  }

  {
    System.out.printf("a new object is created(%s).\n", this.getClass());

    /* initialize process default array for children array.
       If user do not initialize children array, children will not get null. */
    this.children = new ArrayList<>();
    this.pets = new HashSet<>();

    this.boyNameList = Arrays.asList("Natiq", "Samir", "Talib", "Rafiq", "Royal");
    this.girlNameList = Arrays.asList("Zohre", "Sehla", "Gunay", "Meleyke", "Hemide");
  }

  public Family(hw10.model.impl.Woman mother, hw10.model.impl.Man father) {
    this.mother = mother;
    this.father = father;
    setFamilyToParent(mother, father);
  }

  public Family(hw10.model.impl.Woman mother, hw10.model.impl.Man father, List<AbstractHuman> children) {
    this.mother = mother;
    this.father = father;
    this.children.addAll(children);
    setFamilyToParent(mother, father);
    setFamilyToChildren(children);
  }

  public Family(hw10.model.impl.Woman mother, hw10.model.impl.Man father, Set<AbstractPet> pet) {
    this.mother = mother;
    this.father = father;
    this.pets.addAll(pet);
    setFamilyToParent(mother, father);
  }

  public Family(hw10.model.impl.Woman mother, hw10.model.impl.Man father, Set<AbstractPet> pet, List<AbstractHuman> children) {
    this.mother = mother;
    this.father = father;
    this.children.addAll(children);
    this.pets.addAll(pet);
    setFamilyToParent(mother, father);
    setFamilyToChildren(children);
  }

  public AbstractHuman getMother() {
    return mother;
  }

  public AbstractHuman getFather() {
    return father;
  }

  public List<AbstractHuman> getChildren() {
    return children;
  }

  public Set<AbstractPet> getPets() {
    return pets;
  }

  /* We use functional interface because we have to check both addChild and deleteChild methods
   *  and if we do not use functional interface, we have to duplicate our code. */
  interface IsDone {
    boolean check(int oldLen, int newLen);
  }

  private boolean addChildProcess(AbstractHuman child) {
    child.setFamily(this);
    child.setStatus(Status.CHILD);
    int oldLen = children.size();
    children.add(child);
    return childProcessCheck(
        oldLen,
        children.size(),
        (oldLenFn, newLenFn) -> oldLenFn + 1 == newLenFn);
  }

  private boolean deleteChildProcess(int index) {
    int oldLen = children.size();
    if (index < 0 || index >= oldLen){
      return false;
    }
    children.get(index).setFamily(null);
    children.get(index).setStatus(Status.NONE);
    children.remove(index);
    return childProcessCheck(
        oldLen,
        children.size(),
        (oldLenFn, newLenFn) -> oldLenFn - 1 == newLenFn);
  }

  private boolean childProcessCheck(int oldLen, int newLen, IsDone isDone) {
    return isDone.check(oldLen, newLen);
  }

  private void setFamilyToChildren(List<AbstractHuman> children) {
    for (AbstractHuman child : children) {
      child.setFamily(this);
      child.setStatus(Status.CHILD);
    }
  }

  private void setFamilyToParent(hw10.model.impl.Woman mother, hw10.model.impl.Man father) {
    mother.setFamily(this);
    mother.setStatus(Status.MOTHER);
    father.setFamily(this);
    father.setStatus(Status.FATHER);
  }

  public boolean addChild(AbstractHuman child) {
    int oldLen = children.size();
    addChildProcess(child);
    return childProcessCheck(
        oldLen,
        children.size(),
        (oldLenFn, newLenFn) -> oldLenFn + 1 == newLenFn);
  }

  public boolean deleteChild(int index) {
    if (index < 0 || index >= children.size()) {
      return false;
    }
    return deleteChildProcess(index);
  }

  public boolean deleteChild(AbstractHuman child) {
    if (child == null) {
      return false;
    }
    return deleteChildProcess(children.indexOf(child));
  }


  public int countFamily() {
    return children.size() + 2;
  }

  @Override
  public AbstractHuman bornChild() {
    Random random = new Random();
    boolean childSex = random.nextBoolean();
    AbstractHuman child;
    LocalDate localDate = LocalDate.now();
    int iq = father.getIq()!=null && mother.getIq()!=null
        ? (father.getIq() + mother.getIq()) / 2
        : 0;
    if (childSex) {
      int nameIndex = random.nextInt(boyNameList.size());
      child = new hw10.model.impl.Man(
          boyNameList.get(nameIndex),
          father.getSurname(),
          String.format("%d/%d/%d", localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear()),
          iq
      );
    } else {
      int nameIndex = random.nextInt(girlNameList.size());
      child = new hw10.model.impl.Woman(
          girlNameList.get(nameIndex),
          father.getSurname(),
          String.format("%d/%d/%d", localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear()),
          iq
      );
    }
    child.setStatus(Status.CHILD);
    child.setFamily(this);

    addChild(child);

    return child;
  }

  @Override
  public AbstractHuman bornChild(String maleName, String femaleName) {
    Random random = new Random();
    boolean childSex = random.nextBoolean();
    AbstractHuman child;
    LocalDate localDate = LocalDate.now();
    int iq = father.getIq()!=null && mother.getIq()!=null
        ? (father.getIq() + mother.getIq()) / 2
        : 0;
    if (childSex) {
      child = new Man(
          maleName,
          father.getSurname(),
          String.format("%d/%d/%d", localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear()),
          iq
      );
    } else {
      child = new Woman(
          femaleName,
          father.getSurname(),
          String.format("%d/%d/%d", localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear()),
          iq
      );
    }
    child.setStatus(Status.CHILD);
    child.setFamily(this);

    addChild(child);

    return child;
  }

  public void addPet(AbstractPet pet){
    if (pet != null){
      this.pets.add(pet);
    }
  }

  @Override
  public boolean equals(Object o) {
    /* Here we equate only the mother and father of the family.
     *  Because if mother and father are equal, it means that the family is also equal.*/
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (this == o) {
      return true;
    }
    Family family = (Family) o;
    return mother.equals(family.mother)
        && father.equals(family.father)
        && children.equals(family.children)
        && Objects.deepEquals(pets, family.pets);

  }

  @Override
  public int hashCode() {
    return Objects.hash(mother, father, pets, children);
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName()
        .substring(getClass()
            .getName().lastIndexOf('.') + 1)); // get the class name with dynamic form
    stringBuilder.append('{');
    stringBuilder.append("mother=").append(mother);
    stringBuilder.append(", father=").append(father);
    if (children != null) {
      stringBuilder.append(", children=").append(children);
    }
    if (pets != null) {
      stringBuilder.append(", pet=").append(pets);
    }
    stringBuilder.append('}');

    return stringBuilder.toString();
  }

  @Override
  protected void finalize() throws Throwable {
    System.out.printf(
        "Garbage collector removed %s class's object. The object is %s.\n",
        this.getClass().getName(),
        this);
    super.finalize();
  }
}

