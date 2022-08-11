package hw7.concretes;

import hw7.abstracts.AbstractHuman;
import hw7.abstracts.AbstractPet;
import hw7.abstracts.HumanCreator;
import hw7.enums.Status;

import java.time.LocalDate;
import java.util.*;

public class Family implements HumanCreator {
    /**
     * FIELDS
     */
    private final Woman mother;
    private final Man father;
    private AbstractHuman[] children;
    private AbstractPet pet;

    private List<String> boyNameList;
    private List<String> girlNameList;


    /** STATIC BLOCK */
    static {
        System.out.printf("a new class is being loaded(%s).\n", Family.class.getName());
    }

    /** INSTANCE BLOCK */ {
        System.out.printf("a new object is created(%s).\n", this.getClass());

        /** initialize process default array for children array.
         * If user do not initialize children array, children will not get null. */
        this.children = new AbstractHuman[0];

        this.boyNameList = Arrays.asList("Natiq", "Samir", "Talib", "Rafiq", "Royal");
        this.girlNameList = Arrays.asList("Zohre", "Sehla", "Gunay", "Meleyke", "Hemide");
    }

    /**
     * CONSTRUCTORS
     */
    public Family(Woman mother, Man father) {
        this.mother = mother;
        this.father = father;
        setFamilyToParent(mother, father);
    }

    public Family(Woman mother, Man father, AbstractHuman... children) {
        this.mother = mother;
        this.father = father;
        this.children = children;
        setFamilyToParent(mother, father);
        setFamilyToChildren(children);
    }

    public Family(Woman mother, Man father, AbstractPet pet) {
        this.mother = mother;
        this.father = father;
        this.pet = pet;
        setFamilyToParent(mother, father);
    }

    public Family(Woman mother, Man father, AbstractPet pet, AbstractHuman... children) {
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.pet = pet;
        setFamilyToParent(mother, father);
        setFamilyToChildren(children);
    }

    /**
     * GETTERS AND SETTERS
     */
    public AbstractHuman getMother() {
        return mother;
    }

    public AbstractHuman getFather() {
        return father;
    }

    public AbstractHuman[] getChildren() {
        return children;
    }

    /**
     * Do not need setChildren because of addChild method.
     */
//    public void setChildren(Human[] children) {
//        this.children = children;
//    }
    public AbstractPet getPet() {
        return pet;
    }

    public void setPet(AbstractPet pet) {
        this.pet = pet;
    }

    /**
     * FUNCTIONAL INTERFACE
     */
    /* We use functional interface because we have to check both addChild and deleteChild methods
     *  and if we do not use functional interface, we have to duplicate our code. */
    interface isDone {
        boolean check(int oldLen, int newLen);
    }

    /**
     * BEHAVIOURS
     */

    /**
     * PRIVATES
     */
    private void addChildProcess(AbstractHuman child){
        AbstractHuman[] newChildren = new AbstractHuman[children.length + 1];
        System.arraycopy(children, 0, newChildren, 0, children.length);
        newChildren[newChildren.length - 1] = child;
        this.children = newChildren;
        child.setFamily(this);
        child.setStatus(Status.CHILD);
    }

    private void deleteChildProcess(int index) {
        children[index].setFamily(null);
        children[index].setStatus(Status.NONE);
        AbstractHuman[] newChildren = new AbstractHuman[children.length - 1];
        System.arraycopy(this.children, 0, newChildren, 0, index);
        System.arraycopy(this.children, index+1, newChildren, index, newChildren.length-index);
        this.children = newChildren;
    }

    private boolean childProcessCheck(int oldLen, int newLen, isDone fn) {
        return fn.check(oldLen, newLen);
    }

    private void setFamilyToChildren(AbstractHuman[] children) {
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

    /**
     * PUBLICS
     */


    public boolean addChild(AbstractHuman child) {
        int oldLen = children.length;
        addChildProcess(child);
        return childProcessCheck(oldLen, children.length, (oldLenFn, newLenFn) -> oldLenFn + 1 == newLenFn);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.length) return false;
        int oldLen = children.length;
        deleteChildProcess(index);
        return childProcessCheck(oldLen, children.length, (oldLenFn, newLenFn) -> oldLenFn - 1 == newLenFn);
    }

    public boolean deleteChild(AbstractHuman child) {
        if (child == null) return false;
        int oldLen = children.length;
        for (int i = 0; i < children.length; i++)
            /** Here firstly, we use the hashcode because it is easy to compare hashcode for processor.
             * And if hashcode is equal, we compare with equals for more accuracy.*/
            if (child.hashCode()==children[i].hashCode() && child.equals(children[i]))
                deleteChildProcess(i);
        return childProcessCheck(oldLen, children.length, (oldLenFn, newLenFn) -> oldLenFn - 1 == newLenFn);
    }

    public int countFamily() {
        return children.length + 2;
    }

    @Override
    public AbstractHuman bornChild() {
        Random random = new Random();
        boolean childSex = random.nextBoolean();
        AbstractHuman child;
        if (childSex){
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
        child.setIq((father.getIq()+mother.getIq())/2);
        child.setStatus(Status.CHILD);
        child.setFamily(this);

        addChild(child);

        return child;
    }


    /**
     * OBJECT IMPLEMENTS
     */
    @Override
    public boolean equals(Object o) {
        /** Here we equate only the mother and father of the family.
         *  Because if mother and father are equal, it means that the family is also equal.*/
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        Family family = (Family) o;
        return mother.equals(family.mother) &&
                father.equals(family.father) &&
                Arrays.equals(children, family.children) &&
                Objects.equals(pet, family.pet);

    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father, pet);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName().substring(getClass().getName().lastIndexOf('.') + 1)); // get the class name with dynamic form
        stringBuilder.append('{');
        stringBuilder.append("mother=").append(mother);
        stringBuilder.append(", father=").append(father);
        if (children != null) stringBuilder.append(", children=").append(Arrays.toString(children));
        if (pet != null) stringBuilder.append(", pet=").append(pet);
        stringBuilder.append('}');

        return stringBuilder.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Garbage collector removed %s class's object. The object is %s.\n", this.getClass().getName(), this);
        super.finalize();
    }
}

