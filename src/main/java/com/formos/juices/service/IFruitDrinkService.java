package com.formos.juices.service;

import com.formos.juices.model.Portion;
import com.formos.juices.model.type.SizeType;

import java.util.List;

public interface IFruitDrinkService {

    void prepareFruitDrink(List<Portion> portions, SizeType size) throws Exception;

}
