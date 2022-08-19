package hw8;

import hw8.concretes.Dog;
import hw8.concretes.Family;
import hw8.concretes.Man;
import hw8.concretes.Woman;
import hw8.enums.DayOfWeek;

import java.util.*;


class Main {
	public static void main(String[] args) {
		Man father1 = new Man("father", "Adigozelov", 2012, 50,
				Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
		Woman mother1 = new Woman("mother", "Adigozelova", 2012, 50,
				Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
		Woman child1 = new Woman("child1", "Adigozelova", 2012, 50,
				Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));
		Dog pet1 = new Dog("Toplan", 3, 65,
				new HashSet<>(Arrays.asList("eat", "drink", "sleep", "run")));

		Woman child2 = new Woman("child1", "Adigozelova", 2012, 50,
				Map.of(DayOfWeek.MONDAY, "do homework", DayOfWeek.SATURDAY, "Take the dog for a walk."));

		Family family1Test = new Family(mother1, father1,
				new HashSet<>(List.of(pet1)), new ArrayList<>(List.of(child1)));

		family1Test.addChild(child2);
	}

}
