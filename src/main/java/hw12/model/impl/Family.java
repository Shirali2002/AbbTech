package hw12.model.impl;

import hw12.model.enums.Status;
import hw12.model.inter.AbstractHuman;
import hw12.model.inter.AbstractPet;
import hw12.model.inter.HumanCreatorInter;

import java.time.LocalDate;
import java.util.*;

/**
 * Family class is keep the Family members.
 */
public class Family implements HumanCreatorInter {
  private final List<AbstractHuman> children;
  private final Set<AbstractPet> pets;
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
    this.pets = new HashSet<>();

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
    this.children.addAll(children);
    setFamilyToParent(mother, father);
    setFamilyToChildren(children);
  }

  public Family(Woman mother, Man father, Set<AbstractPet> pet) {
    this.mother = mother;
    this.father = father;
    this.pets.addAll(pet);
    setFamilyToParent(mother, father);
  }

  public Family(Woman mother, Man father, Set<AbstractPet> pet, List<AbstractHuman> children) {
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
    LocalDate localDate = LocalDate.now();
    int iq = father.getIq()!=null && mother.getIq()!=null
        ? (father.getIq() + mother.getIq()) / 2
        : 0;
    if (childSex) {
      int nameIndex = random.nextInt(boyNameList.size());
      child = new Man(
          boyNameList.get(nameIndex),
          father.getSurname(),
          String.format("%d/%d/%d", localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear()),
          iq
      );
    } else {
      int nameIndex = random.nextInt(girlNameList.size());
      child = new Woman(
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

  private String getMainPartOfToString(String s){
    return s.substring(s.indexOf('{'));
  }

  public String prettyFormat(){
    StringBuilder res = new StringBuilder("family:\n");
    res.append("\tmother: ").append(getMainPartOfToString(mother.toString())).append(",\n");
    res.append("\tfather: ").append(getMainPartOfToString(father.toString())).append(",\n");

    if (children.size()>0){
      res.append("\tchildren:\n");
      for (AbstractHuman child: children) {
        String className = child.getClass().toString();
        if (className.endsWith("Man")) {
          res.append("\t\tboy: ").append(getMainPartOfToString(child.toString())).append(",\n");
        } else if (className.endsWith("Woman")) {
          res.append("\t\tgirl: ").append(getMainPartOfToString(child.toString())).append(",\n");
        }
      }
    }

    if (pets.size()>0){
      res.append("\tpets: [");
      for (AbstractPet pet: pets) {
        res.append('{');
        res.append("species=").append(pet.getSpecies().toString()).append(", ");
        res.append("nickname='").append(pet.getNickname()).append("', ");
        res.append("age=").append(pet.getAge()).append(", ");
        res.append("trickLevel=").append(pet.getTrickLevel()).append(", ");
        res.append("habits=").append(pet.getHabits());
        res.append('}').append(", ");
      }
      res.delete(res.length()-2,res.length());
      res.append(']');
    }

    res.append("\n");
    return res.toString();
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

