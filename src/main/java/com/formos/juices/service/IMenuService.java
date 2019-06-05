package com.formos.juices.service;

import com.formos.juices.model.Portion;
import com.formos.juices.model.type.SizeType;

import java.util.List;

public interface IMenuService {

    boolean printPrincipalMenu();

    List<Portion> getPortions();

    SizeType getDrinkSize();

}
