package hw9.model.inter;

public interface HumanCreatorInter {
    AbstractHuman bornChild();
    AbstractHuman bornChild(String maleName, String femaleName);
}
