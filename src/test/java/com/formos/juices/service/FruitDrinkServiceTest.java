package com.formos.juices.service;

import com.formos.juices.model.Inventory;
import com.formos.juices.model.Portion;
import com.formos.juices.model.type.SizeType;
import com.formos.juices.service.impl.FruitDrinkService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FruitDrinkServiceTest {

    @InjectMocks
    private FruitDrinkService fruitDrinkService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void prepareFruitDrink_portionsOrSizeAreInvalid_throwException() {
        final Exception exception = Assertions.assertThrows(Exception.class,
                () -> fruitDrinkService.prepareFruitDrink(Collections.EMPTY_LIST, null));
        Assert.assertEquals("Can't prepare a drink without ingredients", exception.getMessage());
    }

    @Test
    public void prepareFruitDrink_inventoryIsAvailableForFruitIngredient_updateInventory() throws Exception {
        List<Portion> portions = Arrays.asList(Portion.createBananaPortion());
        SizeType size = SizeType.Small;
        int bananaInventoryExpected = 820;
        fruitDrinkService.prepareFruitDrink(portions, size);
        Assert.assertEquals(bananaInventoryExpected, Inventory.getInventory().getBanana());
    }

    @Test
    public void prepareFruitDrink_inventoryIsAvailableForComplementIngredient_updateInventory() throws Exception {
        List<Portion> portions = Arrays.asList(Portion.createIcePortion());
        SizeType size = SizeType.Small;
        int iceInventoryExpected = 910;
        fruitDrinkService.prepareFruitDrink(portions, size);
        Assert.assertEquals(iceInventoryExpected, Inventory.getInventory().getIce());
    }

    @Test
    public void prepareFruitDrink_inventoryIsNotAvailableForFruitIngredient_throwException() throws Exception {
        Inventory.getInventory().useStrawberry(900);
        List<Portion> portions = Arrays.asList(Portion.createStrawberryPortion());
        SizeType size = SizeType.Large;
        final Exception exception = Assertions.assertThrows(Exception.class,
                () -> fruitDrinkService.prepareFruitDrink(portions, size));
        Assert.assertEquals(
                "Inventory is not enough for Strawberry",
                exception.getMessage()
        );
    }
}
