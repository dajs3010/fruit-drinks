package com.formos.juices.model.type;

import static com.formos.juices.utils.Constants.*;

public enum SizeType {

    Small(SMALL_DRINK_MILLILITERS), Medium(MEDIUM_DRINK_MILLILITERS), Large(LARGE_DRINK_MILLILITERS);

    private final int milliliters;

    SizeType(int milliliters) {
        this.milliliters = milliliters;
    }

    public int getMilliliters() {
        return milliliters;
    }
}
