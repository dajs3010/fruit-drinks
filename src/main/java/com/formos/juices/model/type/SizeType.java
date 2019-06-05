package com.formos.juices.model.type;

public enum SizeType {

    Small(300), Medium(500), Large(700);

    private final int quantity;

    SizeType(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
