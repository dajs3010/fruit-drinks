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
        final List<Portion> actual = portionService.getStrawberryDrinkPortions();
        final List<Portion> expected = new ArrayList<>(Arrays.asList(
                Portion.createIcePortion(),
                Portion.createCondensedMilkPortion(),
                Portion.createSugarPortion(),
                Portion.createStrawberryPortion()));
        Assert.assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void getBananaDrinkIngredients_returnIngredients() {
        final List<Portion> actual = portionService.getBananaDrinkPortions();
        final List<Portion> expected = new ArrayList<>(Arrays.asList(
                Portion.createIcePortion(),
                Portion.createCondensedMilkPortion(),
                Portion.createSugarPortion(),
                Portion.createBananaPortion()));
        Assert.assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void getMangoDrinkIngredients_returnIngredients() {
        final List<Portion> actual = portionService.getMangoDrinkPortions();
        final List<Portion> expected = new ArrayList<>(Arrays.asList(
                Portion.createIcePortion(),
                Portion.createCondensedMilkPortion(),
                Portion.createSugarPortion(),
                Portion.createMangoPortion()));
        Assert.assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void getStrawberryAndBananaDrinkIngredients_returnIngredients() {
        final List<Portion> actual = portionService.getStrawberryAndBananaDrinkPortions();
        final List<Portion> expected = new ArrayList<>(Arrays.asList(
                Portion.createIcePortion(),
                Portion.createCondensedMilkPortion(),
                Portion.createSugarPortion(),
                Portion.createStrawberryPortion(),
                Portion.createBananaPortion()));
        Assert.assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void getStrawberryAndMangoDrinkIngredients_returnIngredients() {
        final List<Portion> actual = portionService.getStrawberryAndMangoDrinkPortions();
        final List<Portion> expected = new ArrayList<>(Arrays.asList(
                Portion.createIcePortion(),
                Portion.createCondensedMilkPortion(),
                Portion.createSugarPortion(),
                Portion.createStrawberryPortion(),
                Portion.createMangoPortion()));
        Assert.assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void getBananaAndMangoDrinkIngredients_returnIngredients() {
        final List<Portion> actual = portionService.getBananaAndMangoDrinkPortions();
        final List<Portion> expected = new ArrayList<>(Arrays.asList(
                Portion.createIcePortion(),
                Portion.createCondensedMilkPortion(),
                Portion.createSugarPortion(),
                Portion.createBananaPortion(),
                Portion.createMangoPortion()));
        Assert.assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }

}
