package com.formos.juices.service;

import com.formos.juices.model.FruitDrink;
import com.formos.juices.model.Portion;
import com.formos.juices.model.type.SizeType;
import com.formos.juices.service.impl.FruitDrinkService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FruitDrinkServiceTest {

    @InjectMocks
    private FruitDrinkService fruitDrinkService;

    @Mock
    private IInventoryService inventoryService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void prepareFruitDrink_portionsOrSizeAreInvalid_throwException() {
        List<Portion> portions = Collections.EMPTY_LIST;
        SizeType size = null;
        final Exception exception = Assertions.assertThrows(Exception.class,
                () -> fruitDrinkService.prepareFruitDrink(FruitDrink.createFruitDrink(portions, size)));
        Assert.assertEquals("Can't prepare a drink without ingredients", exception.getMessage());
    }

    @Test
    public void prepareFruitDrink_inventoryIsAvailableForFruitIngredient_updateInventory() throws Exception {
        final Portion bananaPortion = Portion.createBananaPortion();
        List<Portion> portions = Arrays.asList(bananaPortion);
        SizeType size = SizeType.Small;
        int usedBanana = 180;
        Mockito.doNothing().when(inventoryService).updateInventory(bananaPortion, usedBanana);
        fruitDrinkService.prepareFruitDrink(FruitDrink.createFruitDrink(portions, size));
        final int wantedNumberOfInvocations = 1;
        Mockito.verify(inventoryService, Mockito.times(wantedNumberOfInvocations))
                .updateInventory(bananaPortion, usedBanana);
    }

    @Test
    public void prepareFruitDrink_inventoryIsAvailableForComplementIngredient_updateInventory() throws Exception {
        final Portion icePortion = Portion.createIcePortion();
        List<Portion> portions = Arrays.asList(icePortion);
        SizeType size = SizeType.Small;
        int usedIce = 90;
        fruitDrinkService.prepareFruitDrink(FruitDrink.createFruitDrink(portions, size));
        final int wantedNumberOfInvocations = 1;
        Mockito.verify(inventoryService, Mockito.times(wantedNumberOfInvocations))
                .updateInventory(icePortion, usedIce);
    }
}
