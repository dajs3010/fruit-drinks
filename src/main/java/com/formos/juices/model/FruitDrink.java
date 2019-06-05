package com.formos.juices.model;

import com.formos.juices.model.type.SizeType;

import java.util.List;

public class FruitDrink {

    private List<Portion> portions;
    private SizeType size;

    protected FruitDrink(List<Portion> portions, SizeType size) {
        this.portions = portions;
        this.size = size;
    }

    public static FruitDrink createFruitDrink(List<Portion> portions, SizeType size) {
        return new FruitDrink(portions, size);
    }

    public List<Portion> getPortions() {
        return portions;
    }

    public SizeType getSize() {
        return size;
    }
}
