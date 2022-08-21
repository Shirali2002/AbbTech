package hw9.concretes;

import hw9.abstracts.AbstractPet;
import hw9.enums.Species;

import java.util.Set;

public class Fish extends AbstractPet {

    static {
        System.out.printf("a new class is being loaded(%s).\n", Fish.class.getName());
    }

    public Fish() {
        super();
    }

    public Fish(String nickname) {
        super(nickname);
        this.setSpecies(Species.FISH);
    }

    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.FISH);
    }

    @Override
    public void respond() {
        System.out.printf("Hello, owner. I am - %s. I miss you!\n", this.getNickname());
    }

}
