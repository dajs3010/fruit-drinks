package com.formos.juices.service.impl;

import com.formos.juices.model.Inventory;
import com.formos.juices.model.Portion;
import com.formos.juices.model.type.SizeType;
import com.formos.juices.service.IMenuOptionReaderService;
import com.formos.juices.service.IMenuService;
import com.formos.juices.service.IPortionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Portion> fruitsPortions = new ArrayList<>();
        switch (selectedFruit) {
            case 1:
                fruitsPortions = portionsService.getStrawberryDrinkPortions();
                break;
            case 2:
                fruitsPortions = portionsService.getBananaDrinkPortions();
                break;
            case 3:
                fruitsPortions = portionsService.getMangoDrinkPortions();
                break;
            case 4:
                fruitsPortions = portionsService.getStrawberryAndBananaDrinkPortions();
                break;
            case 5:
                fruitsPortions = portionsService.getStrawberryAndMangoDrinkPortions();
                break;
            case 6:
                fruitsPortions = portionsService.getBananaAndMangoDrinkPortions();
                break;
            default:
                menuOptionReaderService.printInvalidOptionWarning();
                getPortions();
        }
        return fruitsPortions;
    }


    public SizeType getDrinkSize() {
        int selectedSize = menuOptionReaderService.getSizeMenuOption();
        SizeType size = null;
        switch (selectedSize) {
            case 1:
                size = SizeType.Small;
                break;
            case 2:
                size = SizeType.Medium;
                break;
            case 3:
                size = SizeType.Large;
                break;
            default:
                menuOptionReaderService.printInvalidOptionWarning();
                getDrinkSize();
        }
        return size;
    }
}
