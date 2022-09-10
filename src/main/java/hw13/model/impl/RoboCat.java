package hw13.model.impl;

import hw13.model.enums.Species;
import hw13.model.inter.AbstractPet;

import java.util.Set;

public class RoboCat extends AbstractPet {

    static {
        System.out.printf("a new class is being loaded(%s).\n", RoboCat.class.getName());
    }

    public RoboCat() {
        this.setSpecies(Species.ROBOCAT);
    }

    public RoboCat(String nickname) {
        super(nickname);
        this.setSpecies(Species.ROBOCAT);
    }

    public RoboCat(Species species, String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.ROBOCAT);
    }

    @Override
    public void respond() {
        System.out.printf("Hello, owner. I am - %s. I miss you!\n", this.getNickname());
    }

}
