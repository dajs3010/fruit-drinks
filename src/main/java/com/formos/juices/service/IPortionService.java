package com.formos.juices.service;

import com.formos.juices.model.Portion;

import java.util.List;

public interface IPortionService {

    List<Portion> getStrawberryDrinkIngredients();

    List<Portion> getBananaDrinkIngredients();

    List<Portion> getMangoDrinkIngredients();

    List<Portion> getStrawberryAndBananaDrinkIngredients();

    List<Portion> getStrawberryAndMangoDrinkIngredients();

    List<Portion> getBananaAndMangoDrinkIngredients();

    List<Portion> getAllFruitsIngredients();

}
