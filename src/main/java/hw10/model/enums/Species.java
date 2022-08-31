package hw10.model.enums;

public enum Species {
    DOG(false, 4, true),
    DOMESTICCAT(false, 4, true),
    FISH(false, 0, false),
    ROBOCAT(false, 4, false),
    UNKNOWN;


    private Boolean canFly;
    private Number numberOfLegs;
    private Boolean hasFur;


    Species() {
    }

    Species(Boolean canFly, Number numberOfLegs, Boolean hasFur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }

    public Boolean isCanFly() {
        return canFly;
    }

    public Number getNumberOfLegs() {
        return numberOfLegs;
    }

    public Boolean isHasFur() {
        return hasFur;
    }
}
