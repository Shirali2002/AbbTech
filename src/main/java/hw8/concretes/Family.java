package hw8.concretes;

import hw8.abstracts.AbstractHuman;
import hw8.abstracts.AbstractPet;
import hw8.abstracts.HumanCreator;
import hw8.enums.Status;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/**
 * Family class is keep the Family members.
 */
public class Family implements HumanCreator {
  private List<AbstractHuman> children;
  private Set<AbstractPet> pet;

  private final Woman mother;
  private final Man father;
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

    this.boyNameList = Arrays.asList("Natiq", "Samir", "Talib", "Rafiq", "Royal");
    this.girlNameList = Arrays.asList("Zohre", "Sehla", "Gunay", "Meleyke", "Hemide");
  }

  public Family(Woman mother, Man father) {
    this.mother = mother;
    this.father = father;
    setFamilyToParent(mother, father);
  }

  public Family(Woman mother, Man father, List<AbstractHuman> children) {
    this.mother = mother;
    this.father = father;
    this.children = children;
    setFamilyToParent(mother, father);
    setFamilyToChildren(children);
  }

  public Family(Woman mother, Man father, Set<AbstractPet> pet) {
    this.mother = mother;
    this.father = father;
    this.pet = pet;
    setFamilyToParent(mother, father);
  }

  public Family(Woman mother, Man father, Set<AbstractPet> pet, List<AbstractHuman> children) {
    this.mother = mother;
    this.father = father;
    this.children = children;
    this.pet = pet;
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

  public Set<AbstractPet> getPet() {
    return pet;
  }

  public void setPet(Set<AbstractPet> pet) {
    this.pet = pet;
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
    System.out.println(children.size());
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

  private void setFamilyToParent(Woman mother, Man father) {
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
    if (childSex) {
      int nameIndex = random.nextInt(boyNameList.size());
      child = new Man(
          boyNameList.get(nameIndex),
          father.getSurname(),
          LocalDate.now().getYear()
      );
    } else {
      int nameIndex = random.nextInt(girlNameList.size());
      child = new Woman(
          girlNameList.get(nameIndex),
          father.getSurname(),
          LocalDate.now().getYear()
      );
    }
    child.setIq((father.getIq() + mother.getIq()) / 2);
    child.setStatus(Status.CHILD);
    child.setFamily(this);

    addChild(child);

    return child;
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
        && Objects.deepEquals(pet, family.pet);

  }

  @Override
  public int hashCode() {
    return Objects.hash(mother, father, pet, children);
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
    if (pet != null) {
      stringBuilder.append(", pet=").append(pet);
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

