package com.formos.juices.service.impl;

import com.formos.juices.model.Portion;
import com.formos.juices.service.IPortionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortionService implements IPortionService {

    public List<Portion> getStrawberryDrinkPortions() {
        List<Portion> portions = initializeIngredientsList();
        portions.add(Portion.createStrawberryPortion());
        return portions;
    }

    public List<Portion> getBananaDrinkPortions() {
        List<Portion> portions = initializeIngredientsList();
        portions.add(Portion.createBananaPortion());
        return portions;
    }

    public List<Portion> getMangoDrinkPortions() {
        List<Portion> portions = initializeIngredientsList();
        portions.add(Portion.createMangoPortion());
        return portions;
    }

    public List<Portion> getStrawberryAndBananaDrinkPortions() {
        List<Portion> portions = initializeIngredientsList();
        portions.add(Portion.createStrawberryPortion());
        portions.add(Portion.createBananaPortion());
        return portions;
    }

    public List<Portion> getStrawberryAndMangoDrinkPortions() {
        List<Portion> portions = initializeIngredientsList();
        portions.add(Portion.createStrawberryPortion());
        portions.add(Portion.createMangoPortion());
        return portions;
    }

    public List<Portion> getBananaAndMangoDrinkPortions() {
        List<Portion> portions = initializeIngredientsList();
        portions.add(Portion.createBananaPortion());
        portions.add(Portion.createMangoPortion());
        return portions;
    }

    private List<Portion> initializeIngredientsList() {
        return new ArrayList<>(Portion.getComplements());
    }

}
