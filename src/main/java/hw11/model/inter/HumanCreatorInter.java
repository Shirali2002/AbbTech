package hw11.model.inter;

import hw11.model.inter.AbstractHuman;

public interface HumanCreatorInter {
    AbstractHuman bornChild();
    AbstractHuman bornChild(String maleName, String femaleName);
}
