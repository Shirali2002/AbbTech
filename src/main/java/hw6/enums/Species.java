package hw6.enums;

public enum Species {
    CAT(false, 4, true),
    DOG(false, 4, true),
    BIRD(true, 2, false),
    FISH(false, 0, false),
    HEN(false, 2, false);

    private final boolean canFly;
    private final Number numberOfLegs;
    private final boolean hasFur;

    private Species(boolean canFly, Number numberOfLegs, boolean hasFur){
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public Number getNumberOfLegs() {
        return numberOfLegs;
    }

    public boolean isHasFur() {
        return hasFur;
    }
}
