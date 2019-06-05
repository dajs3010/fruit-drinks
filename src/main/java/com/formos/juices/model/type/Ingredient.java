package com.formos.juices.model.type;

import com.formos.juices.model.Inventory;

import java.util.function.Consumer;

public enum Ingredient {

    Strawberry(IngredientType.FRUIT, quantity -> Inventory.getInventory().useStrawberry(quantity), 100, 100),
    Banana(IngredientType.FRUIT, quantity -> Inventory.getInventory().useBanana(quantity), 120, 100),
    Mango(IngredientType.FRUIT, quantity -> Inventory.getInventory().useMango(quantity), 140, 100),

    Ice(IngredientType.COMPLEMENT, quantity -> Inventory.getInventory().useIce(quantity), 0, 0),
    CondensedMilk(IngredientType.COMPLEMENT, quantity -> Inventory.getInventory().useCondensedMilk(quantity), 0, 0),
    Sugar(IngredientType.COMPLEMENT, quantity -> Inventory.getInventory().useSugar(quantity), 0, 0);

    private final IngredientType type;
    private final Consumer<Integer> updateInventoryConsumer;
    private final int fruitPulpForBlend;
    private final int fruitJuiceBlended;

    Ingredient(IngredientType type, Consumer<Integer> updateInventoryConsumer, int fruitPulpForBlend, int fruitJuiceBlended) {
        this.type = type;
        this.updateInventoryConsumer = updateInventoryConsumer;
        this.fruitPulpForBlend = fruitPulpForBlend;
        this.fruitJuiceBlended = fruitJuiceBlended;
    }

    public IngredientType getType() {
        return type;
    }

    public Consumer<Integer> getUpdateInventoryConsumer() {
        return updateInventoryConsumer;
    }

    public int getFruitPulpForBlend() {
        return fruitPulpForBlend;
    }

    public int getFruitJuiceBlended() {
        return fruitJuiceBlended;
    }
}
