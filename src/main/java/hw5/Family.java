package hw5;

import java.util.Arrays;
import java.util.Objects;

class Family {
    /** FIELDS */
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    /** STATIC BLOCK */
    static {
        System.out.printf("a new class is being loaded(%s).\n", Family.class.getName());
    }

    /** INSTANCE BLOCK */
    {
        System.out.printf("a new object is created(%s).\n", this.getClass());

        /** initialize process default array for children array.
         * If user do not initialize children array, children will not get null. */
        this.children = new Human[0];
    }

    /** CONSTRUCTORS */
    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        setFamilyToParent(mother, father);
    }

    public Family(Human mother, Human father, Human... children) {
//        mother.setStatus(Status.MOTHER);
//        mother.setStatus(Status.MOTHER);
//        mother.setStatus(Status.MOTHER);
        this.mother = mother;
        this.father = father;
        this.children = children;
        setFamilyToParent(mother, father);
        setFamilyToChildren(children);
    }

    public Family(Human mother, Human father, Pet pet) {
        this.mother = mother;
        this.father = father;
        this.pet = pet;
        setFamilyToParent(mother, father);
    }

    public Family(Human mother, Human father, Pet pet, Human... children) {
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.pet = pet;
        setFamilyToParent(mother, father);
        setFamilyToChildren(children);
    }

    /** GETTERS AND SETTERS */
    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Human[] getChildren() {
        return children;
    }

    /**
     * Do not need setChildren because of addChild method.
     */
//    public void setChildren(Human[] children) {
//        this.children = children;
//    }
    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    /** BEHACIOURS */

    private void setFamilyToChildren(Human[] children) {
        for (Human child : children) {
            child.setFamily(this);
            child.setStatus(Status.CHILD);
        }
    }

    private void setFamilyToParent(Human mother, Human father) {
        mother.setFamily(this);
        mother.setStatus(Status.MOTHER);
        father.setFamily(this);
        father.setStatus(Status.FATHER);
    }

    public void addChild(Human child) {
        Human[] newChildren = new Human[children.length + 1];
        System.arraycopy(children, 0, newChildren, 0, children.length);
        newChildren[newChildren.length - 1] = child;
        this.children = newChildren;
        child.setFamily(this);
        child.setStatus(Status.CHILD);
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.length) {
            return false;
        }
        children[index].setFamily(null);
        children[index].setStatus(Status.NONE);
        Human[] newChildren = new Human[children.length - 1];
        for (int i = 0, j = 0; i < children.length; i++) {
            if (i != index) {
                newChildren[j] = children[i];
                j++;
            }
        }
        this.children = newChildren;
        return true;
    }

    public boolean deleteChild(Human child) {
        if (child == null) return false;
        for (int i = 0; i < children.length; i++) {
            if(children[i].hashCode() == child.hashCode()){
                return deleteChild(i);
            }else if (child.equals(children[i])){
                return deleteChild(i);
            }
        }
        return false;
    }

    public int countFamily() {
        return children.length + 2;
    }


    /** Here we equate only the mother and father of the family.
     *  Because if mother and father are equal, it means that the family is also equal.*/
    @Override
    public boolean equals(Object o) {
        if(o==null || getClass() != o.getClass())   return false;
        if (this == o) return true;
        Family family = (Family) o;
        return mother.equals(family.mother) &&
                father.equals(family.father) &&
                Arrays.equals(children, family.children) &&
                pet.equals(family.pet);

    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father, pet);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + Arrays.toString(children) +
                ", pet=" + pet +
                '}';
    }
}
