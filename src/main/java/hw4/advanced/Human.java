package hw4.advanced;


import java.util.Random;

public class Human {
    /**
     * All variables, constructors and methods use default access modifier.
     * Because I want to use these classes only inside the hw4 package.
     */
    /**Fields(Variables)*/
    String name;
    String surname;
    int year;
    int iq;
    Pet pet;
    Human mother;
    Human father;
    String[][] schedule; //[day of the week] x [type of the activity]

    /**Constructors*/
    Human() {
    }

    Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    Human(String name, String surname, int year, int iq, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    /**Behaviours(Methods)*/
    void greetPet() {
        if (!hasPet()){
            return;
        }

        System.out.printf("Hello, %s\n", pet.nickname);

    }

    void describePet() {
        if (!hasPet()){
            return;
        }
        System.out.printf("I have a %s, he is %d years old, he is %s\n",
                pet.species, pet.age, pet.trickLevel<=50?"almost not sly":"very sly");
    }

    boolean feedPet(boolean isTimeFeed){
        if (!hasPet()){
            return false;
        }

        boolean result = false;

        if (isTimeFeed){
            result = true;
        } else {
            int pseudorandom = new Random().nextInt(99)+1;
            if (this.pet.trickLevel > pseudorandom)     result = true;
        }

        if (result) System.out.printf("Hm... I will feed Jack's %s/\n", this.pet.nickname);
        else System.out.println("I think Jack is not hungry.");

        return result;

    }

    private boolean hasPet(){
        return this.pet != null;
    }

    @Override
    public String toString() {
        if (hasPet()){
            return "Human{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", year=" + year +
                    ", iq=" + iq +
                    ", mother=" + mother.name + " " + mother.surname +
                    ", father=" + father.name + " " + father.surname +
                    ", pet=" + pet.toString() +
                    '}';
        } else {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", year=" + year +
                    ", iq=" + iq +
                    ", mother=" + mother.name + " " + mother.surname +
                    ", father=" + father.name + " " + father.surname +
                    '}';
        }

    }

}
