package hw4.simple;

public class Main {
    public static void main(String[] args) {
        firstPart();
        secondPart();
    }
    public static void firstPart() {
        // Family 1
        Human ramin = new Human("Ramin", "Adigozelov", 1987);   // Father
        Human nigar = new Human("Nigar", "Ceferova", 1988);     // Mother
        Pet toplan = new Pet("dog", "Toplan", 3, 65, new String[]{"eat", "drink", "sleep", "run"}); // Pet 1
        Pet mestan = new Pet("cat", "Mestan");  // Pet 2
        Human ferid = new Human("Ferid", "Adigozelov", 2012, 50, toplan, nigar, ramin,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});   // child 1
        Human samire = new Human("Samire", "Adigozelova", 2014, 48, mestan, nigar, ramin,
                new String[][]{{"monday", "play video game"}, {"sunday", "play with mestan"}});         // child 2
        Human ruslan = new Human("Ruslan", "Adigozelov", 2018, nigar, ramin);         // child 3

        // Family 2
        Human fazil = new Human();  // Father
        fazil.name = "Fazil";
        fazil.surname = "Suleymanov";
        fazil.year = 1994;

        Pet favpet = new Pet();     // Pet
        favpet.species = "bird";
        favpet.nickname = "Favpet";

        Human aydan = new Human("Aydan", "Suleymanova", 1996);     // Mother

        Human nicat = new Human("Nicat", "Suleymanov", 2018, 47, favpet, aydan, fazil,
                new String[][]{{"monday", "do homework"}, {"saturday", "go to park."}});   // child

    }

    public static void secondPart() {
        // Family 1
        Human ramin /*Father*/ = new Human("Ramin", "Adigozelov", 1987);
        Human nigar /*Mother*/ = new Human("Nigar", "Ceferova", 1988);
        Pet toplan /*Child's Pet*/ = new Pet("dog", "Toplan", 3, 45, new String[]{"eat", "drink", "sleep", "run"});
        Human ferid /*Child*/ = new Human("Ferid", "Adigozelov", 2012, 50, toplan, nigar, ramin,
                new String[][]{{"monday", "do homework"}, {"saturday", "Take the dog for a walk."}});

        /** Human's methods for child.*/
        ferid.describePet();
        ferid.greetPet();
        System.out.println(ferid);

        System.out.println();

        /**Pet's methods*/
        toplan.eat();
        toplan.foul();
        toplan.respond();
        System.out.println(toplan);

    }



}
