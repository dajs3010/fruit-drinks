package com.formos.juices.service.impl;

import com.formos.juices.model.FruitDrink;
import com.formos.juices.model.Portion;
import com.formos.juices.model.type.IngredientType;
import com.formos.juices.model.type.SizeType;
import com.formos.juices.service.IFruitDrinkService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitDrinkService implements IFruitDrinkService {

    private static final int BLENDER_CAPACITY = 100;

    public void prepareFruitDrink(List<Portion> portions, SizeType size) throws Exception {

        if (portions.isEmpty() || size == null) {
            throw new Exception("Can't prepare a drink without ingredients");
        }

        final FruitDrink fruitDrink = FruitDrink.createFruitDrink(portions, size);

        final int blenderPortionsByDrink = fruitDrink.getSize().getQuantity() / BLENDER_CAPACITY;

        for (Portion portion : fruitDrink.getPortions()) {
            int used;
            if (portion.getIngredient().getType().equals(IngredientType.FRUIT)) {
                final int juice = portion.getIngredient().getFruitJuiceBlended();
                final int pulp = portion.getIngredient().getFruitPulpForBlend();
                final int fruitIngredientByDrink = blenderPortionsByDrink * portion.getQuantity();
                used = (fruitIngredientByDrink * pulp) / juice;
            } else {
                used = blenderPortionsByDrink * portion.getQuantity();
            }
            if (portion.getActualInventory() - used <= 0) {
                throw new Exception("Inventory is not enough for " + portion.getIngredient());
            }
            portion.getIngredient().getUpdateInventoryConsumer().accept(used);
        }
    }

}
