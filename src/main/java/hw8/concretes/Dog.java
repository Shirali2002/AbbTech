package hw8.concretes;

import hw8.abstracts.AbstractPet;
import hw8.abstracts.FoulInter;
import hw8.enums.Species;

import java.util.Set;

public class Dog extends AbstractPet implements FoulInter {

	static {
		System.out.printf("a new class is being loaded(%s).\n", Dog.class.getName());
	}

	public Dog() {
	}

	public Dog(String nickname) {
		super(nickname);
		this.setSpecies(Species.DOG);
	}

	public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
		super(nickname, age, trickLevel, habits);
		this.setSpecies(Species.DOG);
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
