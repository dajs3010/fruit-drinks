package com.formos.juices.service;

import com.formos.juices.model.Portion;
import com.formos.juices.service.impl.PortionService;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PortionServiceTest {

    @InjectMocks
    private PortionService portionService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getStrawberryDrinkIngredients_returnIngredients() {
        final List<Portion> actual = portionService.getStrawberryDrinkIngredients();
        final List<Portion> expected = new ArrayList<>(Arrays.asList(
                Portion.createIceIngredient(),
                Portion.createCondensedMilkIngredient(),
                Portion.createSugarIngredient(),
                Portion.createStrawberryIngredient()));
        Assert.assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void getBananaDrinkIngredients_returnIngredients() {
        final List<Portion> actual = portionService.getBananaDrinkIngredients();
        final List<Portion> expected = new ArrayList<>(Arrays.asList(
                Portion.createIceIngredient(),
                Portion.createCondensedMilkIngredient(),
                Portion.createSugarIngredient(),
                Portion.createBananaIngredient()));
        Assert.assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void getMangoDrinkIngredients_returnIngredients() {
        final List<Portion> actual = portionService.getMangoDrinkIngredients();
        final List<Portion> expected = new ArrayList<>(Arrays.asList(
                Portion.createIceIngredient(),
                Portion.createCondensedMilkIngredient(),
                Portion.createSugarIngredient(),
                Portion.createMangoIngredient()));
        Assert.assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void getStrawberryAndBananaDrinkIngredients_returnIngredients() {
        final List<Portion> actual = portionService.getStrawberryAndBananaDrinkIngredients();
        final List<Portion> expected = new ArrayList<>(Arrays.asList(
                Portion.createIceIngredient(),
                Portion.createCondensedMilkIngredient(),
                Portion.createSugarIngredient(),
                Portion.createStrawberryIngredient(),
                Portion.createBananaIngredient()));
        Assert.assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void getStrawberryAndMangoDrinkIngredients_returnIngredients() {
        final List<Portion> actual = portionService.getStrawberryAndMangoDrinkIngredients();
        final List<Portion> expected = new ArrayList<>(Arrays.asList(
                Portion.createIceIngredient(),
                Portion.createCondensedMilkIngredient(),
                Portion.createSugarIngredient(),
                Portion.createStrawberryIngredient(),
                Portion.createMangoIngredient()));
        Assert.assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void getBananaAndMangoDrinkIngredients_returnIngredients() {
        final List<Portion> actual = portionService.getBananaAndMangoDrinkIngredients();
        final List<Portion> expected = new ArrayList<>(Arrays.asList(
                Portion.createIceIngredient(),
                Portion.createCondensedMilkIngredient(),
                Portion.createSugarIngredient(),
                Portion.createBananaIngredient(),
                Portion.createMangoIngredient()));
        Assert.assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void getAllFruitsIngredients_returnIngredients() {
        final List<Portion> actual = portionService.getAllFruitsIngredients();
        final List<Portion> expected = new ArrayList<>(Arrays.asList(
                Portion.createIceIngredient(),
                Portion.createCondensedMilkIngredient(),
                Portion.createSugarIngredient(),
                Portion.createStrawberryIngredient(),
                Portion.createBananaIngredient(),
                Portion.createMangoIngredient()));
        Assert.assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }


}
