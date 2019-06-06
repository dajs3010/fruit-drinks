package com.formos.juices.service;

import com.formos.juices.model.Portion;
import com.formos.juices.model.type.SizeType;
import com.formos.juices.service.impl.MenuService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class MenuServiceTest {

    @Mock
    private IPortionService portionsService;

    @Mock
    private IMenuOptionReaderService menuOptionReaderService;

    @InjectMocks
    private MenuService menuService;

    private List<Portion> portions;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        portions = new ArrayList<>();
    }

    @Test
    public void printPrincipalMenu_choseSellDrinkOption_returnFalse() {
        Mockito.when(menuOptionReaderService.getPrincipalMenuOption()).thenReturn(2);
        final boolean actual = menuService.printPrincipalMenu();
        Assert.assertFalse(actual);
    }

    @Test
    public void printPrincipalMenu_choseExitOption_returnTrue() {
        Mockito.when(menuOptionReaderService.getPrincipalMenuOption()).thenReturn(3);
        final boolean actual = menuService.printPrincipalMenu();
        Assert.assertTrue(actual);
    }

    @Test
    public void printFruitMenu_choseBananaOption_returnBananaPortion() {
        Mockito.when(menuOptionReaderService.getFruitMenuOption()).thenReturn(2);
        Mockito.when(portionsService.getBananaDrinkPortions()).thenReturn(portions);
        final List<Portion> actual = menuService.getPortions();
        Assert.assertEquals(portions, actual);
    }

    @Test
    public void printFruitMenu_choseMangoOption_returnMangoPortion() {
        Mockito.when(menuOptionReaderService.getFruitMenuOption()).thenReturn(3);
        Mockito.when(portionsService.getMangoDrinkPortions()).thenReturn(portions);
        final List<Portion> actual = menuService.getPortions();
        Assert.assertEquals(portions, actual);
    }

    @Test
    public void printFruitMenu_choseStrawberryAndBananaOption_returnStrawberryAndBananaPortion() {
        Mockito.when(menuOptionReaderService.getFruitMenuOption()).thenReturn(4);
        Mockito.when(portionsService.getStrawberryAndBananaDrinkPortions()).thenReturn(portions);
        final List<Portion> actual = menuService.getPortions();
        Assert.assertEquals(portions, actual);
    }

    @Test
    public void printFruitMenu_choseStrawberryAndMangoOption_returnStrawberryAndMangoPortion() {
        Mockito.when(menuOptionReaderService.getFruitMenuOption()).thenReturn(5);
        Mockito.when(portionsService.getStrawberryAndMangoDrinkPortions()).thenReturn(portions);
        final List<Portion> actual = menuService.getPortions();
        Assert.assertEquals(portions, actual);
    }

    @Test
    public void printFruitMenu_choseBananaAndMangoOption_returnBananaAndMangoPortion() {
        Mockito.when(menuOptionReaderService.getFruitMenuOption()).thenReturn(6);
        Mockito.when(portionsService.getBananaAndMangoDrinkPortions()).thenReturn(portions);
        final List<Portion> actual = menuService.getPortions();
        Assert.assertEquals(portions, actual);
    }

    @Test
    public void printSizeMenu_choseSmallSizeOption_returnSmallSize() {
        Mockito.when(menuOptionReaderService.getSizeMenuOption()).thenReturn(1);
        final SizeType actual = menuService.getDrinkSize();
        Assert.assertEquals(SizeType.Small, actual);
    }

    @Test
    public void printSizeMenu_choseMediumSizeOption_returnSmallSize() {
        Mockito.when(menuOptionReaderService.getSizeMenuOption()).thenReturn(2);
        final SizeType actual = menuService.getDrinkSize();
        Assert.assertEquals(SizeType.Medium, actual);
    }

    @Test
    public void printSizeMenu_choseLargeSizeOption_returnSmallSize() {
        Mockito.when(menuOptionReaderService.getSizeMenuOption()).thenReturn(3);
        final SizeType actual = menuService.getDrinkSize();
        Assert.assertEquals(SizeType.Large, actual);
    }

}
