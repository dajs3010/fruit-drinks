package com.formos.juices.model;

import com.formos.juices.model.type.Ingredient;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Portion {

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

    public static Portion createStrawberryIngredient() {
        return new Portion(Ingredient.Strawberry, 50, Inventory.getInventory().getStrawberry());
    }

    public static Portion createBananaIngredient() {
        return new Portion(Ingredient.Banana, 50, Inventory.getInventory().getBanana());
    }

    public static Portion createMangoIngredient() {
        return new Portion(Ingredient.Mango, 50, Inventory.getInventory().getMango());
    }

    public static Portion createIceIngredient() {
        return new Portion(Ingredient.Ice, 30, Inventory.getInventory().getIce());
    }

    public static Portion createCondensedMilkIngredient() {
        return new Portion(Ingredient.CondensedMilk, 20, Inventory.getInventory().getCondensedMilk());
    }

    public static Portion createSugarIngredient() {
        return new Portion(Ingredient.Sugar, 8, Inventory.getInventory().getSugar());
    }

    public static List<Portion> getComplements() {
        return Arrays.asList(createIceIngredient(), createCondensedMilkIngredient(), createSugarIngredient());
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
