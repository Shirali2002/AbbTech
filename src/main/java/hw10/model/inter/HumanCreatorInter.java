package hw10.model.inter;

import hw10.model.inter.AbstractHuman;

public interface HumanCreatorInter {
    hw10.model.inter.AbstractHuman bornChild();
    AbstractHuman bornChild(String maleName, String femaleName);
}
