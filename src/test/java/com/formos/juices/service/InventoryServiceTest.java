package com.formos.juices.service;

import com.formos.juices.model.Inventory;
import com.formos.juices.model.Portion;
import com.formos.juices.service.impl.InventoryService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InventoryServiceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @InjectMocks
    private InventoryService inventoryService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void updateInventory_inventoryIsNotAvailableForFruitIngredient_throwException() throws Exception {
        Inventory.getInventory().useStrawberry(900);
        int used = 150;
        final Exception exception = Assertions.assertThrows(Exception.class,
                () -> inventoryService.updateInventory(Portion.createStrawberryPortion(), used));
        Assert.assertEquals(
                "Inventory is not enough for Strawberry",
                exception.getMessage()
        );
    }

    @Test
    public void updateInventory_inventoryWillBeNotEnoughToMakeMoreDrinks_printWarning() throws Exception {
        Inventory.getInventory().useBanana(600);
        int used = 150;
        inventoryService.updateInventory(Portion.createBananaPortion(), used);
        Assert.assertTrue(outContent.toString().contains("WARNING"));
    }

    @Test
    public void updateInventory_validationIsOk_updateInventory() throws Exception {
        int used = 150;
        int expectedInventory = 850;
        inventoryService.updateInventory(Portion.createMangoPortion(), used);
        Assert.assertEquals(expectedInventory, Inventory.getInventory().getMango());
    }

}
