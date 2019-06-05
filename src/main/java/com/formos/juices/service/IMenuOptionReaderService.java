package com.formos.juices.service;

public interface IMenuOptionReaderService {

    int getPrincipalMenuOption();

    int getFruitMenuOption();

    int getSizeMenuOption();

    void printInvalidOptionWarning();

}
