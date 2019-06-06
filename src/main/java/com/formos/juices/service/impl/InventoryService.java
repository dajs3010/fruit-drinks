package com.formos.juices.service.impl;

import com.formos.juices.model.Portion;
import com.formos.juices.model.type.Ingredient;
import com.formos.juices.service.IInventoryService;
import org.springframework.stereotype.Service;

@Service
public class InventoryService implements IInventoryService {

    private static final int DRINKS_INVENTORY_WARNING = 4;

    @Override
    public void updateInventory(Portion portion, int used) throws Exception {
        validateInventory(portion, used);
        portion.getIngredient().getUpdateInventoryConsumer().accept(used);
    }

    private void validateInventory(Portion portion, int used) throws Exception {
        final Ingredient ingredient = portion.getIngredient();
        final int actualInventory = portion.getActualInventory();
        if (actualInventory - used <= 0) {
            throw new Exception("Inventory is not enough for " + ingredient);
        }
        if (actualInventory - (used * DRINKS_INVENTORY_WARNING) <= 0) {
            System.out.println("WARNING: Inventory will not be available for " + ingredient +
                    " to prepare " + DRINKS_INVENTORY_WARNING + " more drinks");
        }
    }
}
