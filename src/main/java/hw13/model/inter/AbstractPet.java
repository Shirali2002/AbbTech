package hw13.model.inter;

import hw13.model.enums.Species;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public abstract class AbstractPet implements Serializable {
    /**
     * All variables, constructors and methods use default access modifier.
     * Because i want to use these classes only in hw5 package
     */
    /**
     * FIELDS
     */
    private Species species;
    private String nickname;
    private Integer age;
    private Integer trickLevel;
    private Set<String> habits;

//    static {
//        System.out.printf("a new class is being loaded(%s).\n", AbstractPet.class.getName());
//    }

    {
//        System.out.printf("a new object is created(%s).\n", this.getClass());
        this.species = Species.UNKNOWN;
        habits = new HashSet<>();
    }

    /**
     * CONSTRUCTORS
     */
    public AbstractPet() {
    }

    public AbstractPet(Set<String> habits) {
        this.habits = habits;
    }

    public AbstractPet(String nickname) {
        this.nickname = nickname;
    }

    public AbstractPet(String nickname, int age, int trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age >= 0 ? age : null;
        this.trickLevel = trickLevel >= 0 ? trickLevel : null;
        this.habits = habits;
    }

    /**
     * GETTERS AND SETTERS
     */
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
        this.age = age >= 0 ? age : null;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel >= 0 ? trickLevel : null;
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    /**
     * BEHAVIOURS
     */
    public void eat() {
        System.out.println("I am eating");
    }

    public abstract void respond();


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        AbstractPet pet = (AbstractPet) o;
        /** I am using Objects class. Because if I use for example age.equals, in this case if age is null, I will get error.*/
        return Objects.equals(age, pet.age) &&
                Objects.equals(nickname, pet.nickname) &&
                Objects.equals(trickLevel, pet.trickLevel) &&
                Objects.equals(species, pet.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age, trickLevel);
    }

    public String prettyPet(){
        StringBuilder sb = new StringBuilder();
        sb.append("{species=").append(species.name());
        if (nickname != null) sb.append(", nickname='").append(nickname).append('\'');
        if (age != null) sb.append(", age=").append(age);
        if (trickLevel != null) sb.append(", trickLevel=").append(trickLevel);
        if (habits.size() != 0) sb.append(", habits=").append(habits);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (species == null) return "";

        String speciesName = species.name().charAt(0) + species.name().substring(1).toLowerCase();
        sb.append(speciesName).append("{");

        if(species != Species.UNKNOWN){
            sb.append(speciesName).append(species.isCanFly() ? " can fly. " : " can not fly. ");
            sb.append(speciesName).append(String.format(" has %d legs. ", (Integer) species.getNumberOfLegs()));
            sb.append(speciesName).append(species.isHasFur() ? " has fur. " : " has not fur. ");
        }

        if (nickname == null) return sb.append('}').toString();
        else sb.append("nickname='").append(nickname).append('\'');
        if (age != null) sb.append(", age=").append(age);
        if (trickLevel != null) sb.append(", trickLevel=").append(trickLevel);
        if (habits.size() != 0) sb.append(", habits=").append(habits);
        sb.append('}');

        return sb.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Garbage collector removed %s class's object. The object is %s.\n", this.getClass().getName(), this);
        super.finalize();
    }
}
