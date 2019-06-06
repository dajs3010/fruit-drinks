package com.formos.juices.service.impl;

import com.formos.juices.model.Inventory;
import com.formos.juices.model.Portion;
import com.formos.juices.model.type.SizeType;
import com.formos.juices.service.IMenuOptionReaderService;
import com.formos.juices.service.IMenuService;
import com.formos.juices.service.IPortionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService implements IMenuService {

    private final IPortionService portionsService;
    private final IMenuOptionReaderService menuOptionReaderService;

    public MenuService(IPortionService portionsService, IMenuOptionReaderService menuOptionReaderService) {
        this.portionsService = portionsService;
        this.menuOptionReaderService = menuOptionReaderService;
    }

    public boolean printPrincipalMenu() {
        int selectedOption = menuOptionReaderService.getPrincipalMenuOption();
        switch (selectedOption) {
            case 1:
                Inventory.getInventory().generateReport();
                return printPrincipalMenu();
            case 2:
                return false;
            case 3:
                return true;
            default:
                menuOptionReaderService.printInvalidOptionWarning();
                return printPrincipalMenu();
        }
    }


    public List<Portion> getPortions() {
        int selectedFruit = menuOptionReaderService.getFruitMenuOption();
        switch (selectedFruit) {
            case 1:
                return portionsService.getStrawberryDrinkPortions();
            case 2:
                return portionsService.getBananaDrinkPortions();
            case 3:
                return portionsService.getMangoDrinkPortions();
            case 4:
                return portionsService.getStrawberryAndBananaDrinkPortions();
            case 5:
                return portionsService.getStrawberryAndMangoDrinkPortions();
            case 6:
                return portionsService.getBananaAndMangoDrinkPortions();
            default:
                menuOptionReaderService.printInvalidOptionWarning();
                return getPortions();
        }
    }


    public SizeType getDrinkSize() {
        int selectedSize = menuOptionReaderService.getSizeMenuOption();
        switch (selectedSize) {
            case 1:
                return SizeType.Small;
            case 2:
                return SizeType.Medium;
            case 3:
                return SizeType.Large;
            default:
                menuOptionReaderService.printInvalidOptionWarning();
                return getDrinkSize();
        }
    }
}
