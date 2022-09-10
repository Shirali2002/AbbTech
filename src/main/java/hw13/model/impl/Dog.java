package hw13.model.impl;

import hw13.model.enums.Species;
import hw13.model.inter.AbstractPet;
import hw13.model.inter.FoulInter;

import java.util.Set;

public class Dog extends AbstractPet implements FoulInter {

	static {
		System.out.printf("a new class is being loaded(%s).\n", Dog.class.getName());
	}

	public Dog() {
		this.setSpecies(Species.DOG);
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
