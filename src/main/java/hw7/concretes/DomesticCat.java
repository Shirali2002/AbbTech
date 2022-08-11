package hw7.concretes;

import hw7.abstracts.FoulInter;
import hw7.abstracts.AbstractPet;
import hw7.enums.Species;

public class DomesticCat extends AbstractPet implements FoulInter {

    static {
        System.out.printf("a new class is being loaded(%s).\n", DomesticCat.class.getName());
    }

    public DomesticCat() {
        super();
    }

    public DomesticCat(String nickname) {
        super(nickname);
        this.setSpecies(Species.DOMESTICCAT);
    }

    public DomesticCat(String nickname, int age, int trickLevel, String... habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(Species.DOMESTICCAT);
    }

    @Override
    public void respond() {
        System.out.printf("Hello, owner. I am - %s. I miss you!\n", this.getNickname());
    }

    @Override
    public void foul() {
        System.out.println("I need to cover it up");
    }
}
