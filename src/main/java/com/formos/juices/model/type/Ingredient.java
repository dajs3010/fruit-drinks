package com.formos.juices.model.type;

import com.formos.juices.model.Inventory;

import java.util.function.Consumer;

import static com.formos.juices.utils.Constants.*;

public enum Ingredient {

    Strawberry(IngredientType.FRUIT, Inventory.getInventory()::useStrawberry, STRAWBERRY_GRAMS_FOR_BLEND, BLENDED_FRUIT_JUICE),
    Banana(IngredientType.FRUIT, Inventory.getInventory()::useBanana, BANANA_GRAMS_FOR_BLEND, BLENDED_FRUIT_JUICE),
    Mango(IngredientType.FRUIT, Inventory.getInventory()::useMango, MANGO_GRAMS_FOR_BLEND, BLENDED_FRUIT_JUICE),

    Ice(IngredientType.COMPLEMENT, Inventory.getInventory()::useIce, ZERO, ZERO),
    CondensedMilk(IngredientType.COMPLEMENT, Inventory.getInventory()::useCondensedMilk, ZERO, ZERO),
    Sugar(IngredientType.COMPLEMENT, Inventory.getInventory()::useSugar, ZERO, ZERO);

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
