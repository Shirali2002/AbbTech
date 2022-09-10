package hw13.model.inter;

public interface HumanCreatorInter {
    AbstractHuman bornChild();
    AbstractHuman bornChild(String maleName, String femaleName);
}
