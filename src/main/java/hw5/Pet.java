package hw5;

import java.util.Arrays;
import java.util.Objects;


class Pet {
    /**
     * All variables, constructors and methods use default access modifier.
     * Because i want to use these classes only in hw5 package
     */
    /** FIELDS */
    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    static {
        System.out.printf("a new class is being loaded(%s).\n", Pet.class.getName());
    }

    {
        System.out.printf("a new object is created(%s).\n", this.getClass());
    }

    /** CONSTRUCTORS */
    public Pet(){
    }

    public Pet(String species, String nickname){
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String... habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    /** GETTERS AND SETTERS */
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    /** BEHAVIOURS */
    public void eat() {
        System.out.println("I am eating");
    }

    public void respond() {
        System.out.printf("Hello, owner. I am - %s. I miss you!\n", this.nickname);
    }

    public void foul() {
        System.out.println("I need to cover it up");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        Pet pet = (Pet) o;
        return age == pet.age &&
                trickLevel == pet.trickLevel &&
                species.equals(pet.species) &&
                nickname.equals(pet.nickname);
//                Objects.equals(species, pet.species) &&
//                Objects.equals(nickname, pet.nickname);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(species, nickname, age, trickLevel);
        result = 31 * result + Arrays.hashCode(habits);
        return result;
    }

    @Override
    public String toString() {
        if (nickname==null){
            return "";
        } else if (age==0 && trickLevel==0 && habits == null){
            return species+"{" +
                    "nickname='" + nickname + '\'' +
                    '}';
        }else {
            return species + "{" +
                    "nickname='" + nickname + '\'' +
                    ", age=" + age +
                    ", trickLevel=" + trickLevel +
                    ", habits=" + Arrays.toString(habits) +
                    '}';
        }
    }
}
