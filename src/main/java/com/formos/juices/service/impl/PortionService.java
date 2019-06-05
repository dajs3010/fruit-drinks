package com.formos.juices.service.impl;

import com.formos.juices.model.Portion;
import com.formos.juices.service.IPortionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortionService implements IPortionService {

    public List<Portion> getStrawberryDrinkIngredients() {
        List<Portion> portions = initializeIngredientsList();
        portions.add(Portion.createStrawberryIngredient());
        return portions;
    }

    public List<Portion> getBananaDrinkIngredients() {
        List<Portion> portions = initializeIngredientsList();
        portions.add(Portion.createBananaIngredient());
        return portions;
    }

    public List<Portion> getMangoDrinkIngredients() {
        List<Portion> portions = initializeIngredientsList();
        portions.add(Portion.createMangoIngredient());
        return portions;
    }

    public List<Portion> getStrawberryAndBananaDrinkIngredients() {
        List<Portion> portions = initializeIngredientsList();
        portions.add(Portion.createStrawberryIngredient());
        portions.add(Portion.createBananaIngredient());
        return portions;
    }

    public List<Portion> getStrawberryAndMangoDrinkIngredients() {
        List<Portion> portions = initializeIngredientsList();
        portions.add(Portion.createStrawberryIngredient());
        portions.add(Portion.createMangoIngredient());
        return portions;
    }

    public List<Portion> getBananaAndMangoDrinkIngredients() {
        List<Portion> portions = initializeIngredientsList();
        portions.add(Portion.createBananaIngredient());
        portions.add(Portion.createMangoIngredient());
        return portions;
    }

    public List<Portion> getAllFruitsIngredients() {
        List<Portion> portions = initializeIngredientsList();
        portions.add(Portion.createStrawberryIngredient());
        portions.add(Portion.createBananaIngredient());
        portions.add(Portion.createMangoIngredient());
        return portions;
    }

    private List<Portion> initializeIngredientsList() {
        return new ArrayList<>(Portion.getComplements());
    }

}
