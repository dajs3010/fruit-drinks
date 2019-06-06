package com.formos.juices.service.impl;

import com.formos.juices.model.FruitDrink;
import com.formos.juices.model.Portion;
import com.formos.juices.model.type.Ingredient;
import com.formos.juices.model.type.IngredientType;
import com.formos.juices.model.type.SizeType;
import com.formos.juices.service.IFruitDrinkService;
import com.formos.juices.service.IInventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitDrinkService implements IFruitDrinkService {

    private final IInventoryService inventoryService;

    public FruitDrinkService(IInventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    private static final int BLENDER_CAPACITY = 100;

    public void prepareFruitDrink(FruitDrink fruitDrink) throws Exception {

        final List<Portion> portions = fruitDrink.getPortions();
        final SizeType size = fruitDrink.getSize();
        if (portions.isEmpty() || size == null) {
            throw new Exception("Can't prepare a drink without ingredients");
        }

        final int blenderPortionsByDrink = size.getMilliliters() / BLENDER_CAPACITY;

        final int fruitTypePortions = (int) portions.stream()
                .filter(portion -> portion.getIngredient().getType() == IngredientType.FRUIT)
                .count();

        for (Portion portion : portions) {
            int used = getIngredientQuantityUsed(blenderPortionsByDrink, fruitTypePortions, portion);
            inventoryService.updateInventory(portion, used);
        }
    }

    private int getIngredientQuantityUsed(int blenderPortionsByDrink, int fruitTypePortions, Portion portion) {
        final Ingredient ingredient = portion.getIngredient();
        if (IngredientType.FRUIT.equals(ingredient.getType())) {
            final int juice = ingredient.getFruitJuiceBlended();
            final int pulp = ingredient.getFruitPulpForBlend();
            final int fruitIngredientByDrink = blenderPortionsByDrink * (portion.getQuantity() / fruitTypePortions);
            return (fruitIngredientByDrink * pulp) / juice;
        }
        return blenderPortionsByDrink * portion.getQuantity();
    }

}
