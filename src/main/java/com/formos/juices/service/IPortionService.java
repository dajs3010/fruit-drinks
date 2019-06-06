package com.formos.juices.service;

import com.formos.juices.model.Portion;

import java.util.List;

public interface IPortionService {

    List<Portion> getStrawberryDrinkPortions();

    List<Portion> getBananaDrinkPortions();

    List<Portion> getMangoDrinkPortions();

    List<Portion> getStrawberryAndBananaDrinkPortions();

    List<Portion> getStrawberryAndMangoDrinkPortions();

    List<Portion> getBananaAndMangoDrinkPortions();

}
