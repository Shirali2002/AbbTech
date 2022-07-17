package hw4;

import java.util.Arrays;


class Pet {
    /**
     * All variables, constructors and methods use default access modifier.
     * Because i want to use these classes only in hw4 package
     */
    /**Fields(Variables)*/
    String species;
    String nickname;
    int age;
    int trickLevel;
    String[] habits;

    /**Constructors*/
    Pet(){
    }

    Pet(String species, String nickname){
        this.species = species;
        this.nickname = nickname;
    }

    Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    /**Behaviours(Methods)*/
    void eat() {
        System.out.println("I am eating");
    }

    void respond() {
        System.out.printf("Hello, owner. I am - %s. I miss you!\n", this.nickname);
    }

    void foul() {
        System.out.println("I need to cover it up");
    }

    @Override
    public String toString() {
        return species+"{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }
}
