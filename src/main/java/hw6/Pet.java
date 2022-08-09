package hw6;

import hw6.enums.Species;

import java.util.Arrays;
import java.util.Objects;


public class Pet {
    /**
     * All variables, constructors and methods use default access modifier.
     * Because i want to use these classes only in hw5 package
     */
    /** FIELDS */
    private Species species;
    private String nickname;
    private Integer age;
    private Integer trickLevel;
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

    public Pet(Species species, String nickname){
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(Species species, String nickname, int age, int trickLevel, String... habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age>=0 ? age : null;
        this.trickLevel = trickLevel>=0 ? trickLevel : null;
        this.habits = habits;
    }

    /** GETTERS AND SETTERS */
    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
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
        this.age = age>=0 ? age : null;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel>=0 ? trickLevel : null;
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
        /** I am using Objects class. Because if I use for example age.equals, in this case if age is null, I will get error.*/
        return  Objects.equals(age, pet.age) &&
                Objects.equals(nickname, pet.nickname) &&
                Objects.equals(trickLevel, pet.trickLevel) &&
                Objects.equals(species, pet.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age, trickLevel);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (species == null) return "";
        else {
            String speciesName = species.name().charAt(0)+species.name().substring(1).toLowerCase();
            stringBuilder.append(speciesName).append("{");
            stringBuilder.append(speciesName).append(species.isCanFly() ? " can fly. " : " can not fly. ");
            stringBuilder.append(speciesName).append(String.format(" has %d legs. ", (Integer) species.getNumberOfLegs()));
            stringBuilder.append(speciesName).append(species.isHasFur() ? " has fur. " : " has not fur. ");

        };

        if (nickname == null) return stringBuilder.append('}').toString();
        else stringBuilder.append("nickname='").append(nickname).append('\'');
        if (age != null) stringBuilder.append(", age=").append(age);
        if (trickLevel != null) stringBuilder.append(", trickLevel=").append(trickLevel);
        if (habits != null) stringBuilder.append(", habits=").append(Arrays.toString(habits));
        stringBuilder.append('}');

        return stringBuilder.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Garbage collector removed %s class's object. The object is %s.\n", this.getClass().getName(), this);
        super.finalize();
    }
}
