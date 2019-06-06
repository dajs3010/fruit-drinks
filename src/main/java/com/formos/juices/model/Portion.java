package com.formos.juices.model;

import com.formos.juices.model.type.Ingredient;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Portion {

    private static final int FRUIT_JUICE_PER_BLEND = 50;
    private static final int ICE_PER_BLEND = 30;
    private static final int CONDENSED_MILK_PER_BLEND = 20;
    private static final int SUGAR_PER_BLEND = 8;

    private Ingredient ingredient;
    private int quantity;
    private int actualInventory;

    protected Portion(Ingredient ingredient, int quantity, int actualInventory) {
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.actualInventory = actualInventory;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getActualInventory() {
        return actualInventory;
    }

    public static Portion createStrawberryPortion() {
        return new Portion(Ingredient.Strawberry, FRUIT_JUICE_PER_BLEND, Inventory.getInventory().getStrawberry());
    }

    public static Portion createBananaPortion() {
        return new Portion(Ingredient.Banana, FRUIT_JUICE_PER_BLEND, Inventory.getInventory().getBanana());
    }

    public static Portion createMangoPortion() {
        return new Portion(Ingredient.Mango, FRUIT_JUICE_PER_BLEND, Inventory.getInventory().getMango());
    }

    public static Portion createIcePortion() {
        return new Portion(Ingredient.Ice, ICE_PER_BLEND, Inventory.getInventory().getIce());
    }

    public static Portion createCondensedMilkPortion() {
        return new Portion(Ingredient.CondensedMilk, CONDENSED_MILK_PER_BLEND, Inventory.getInventory().getCondensedMilk());
    }

    public static Portion createSugarPortion() {
        return new Portion(Ingredient.Sugar, SUGAR_PER_BLEND, Inventory.getInventory().getSugar());
    }

    public static List<Portion> getComplements() {
        return Arrays.asList(createIcePortion(), createCondensedMilkPortion(), createSugarPortion());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portion portion = (Portion) o;
        return quantity == portion.quantity &&
                actualInventory == portion.actualInventory &&
                ingredient == portion.ingredient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient, quantity, actualInventory);
    }

    @Override
    public String toString() {
        return "Portion{" +
                "ingredient=" + ingredient +
                ", quantity=" + quantity +
                ", actualInventory=" + actualInventory +
                '}';
    }
}
