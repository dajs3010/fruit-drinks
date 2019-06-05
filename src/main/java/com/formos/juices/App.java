package com.formos.juices;

import com.formos.juices.model.Inventory;
import com.formos.juices.model.Portion;
import com.formos.juices.model.type.SizeType;
import com.formos.juices.service.IFruitDrinkService;
import com.formos.juices.service.IMenuService;
import com.formos.juices.service.impl.FruitDrinkService;
import com.formos.juices.service.impl.MenuService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(App.class, args);
        IFruitDrinkService fruitDrinkService = (FruitDrinkService) ctx.getBean("fruitDrinkService");
        IMenuService menuService = (MenuService) ctx.getBean("menuService");

        Inventory.initializeInventory();
        Inventory.getInventory().generateReport();

        boolean haveToExit;

        do {
            haveToExit = menuService.printPrincipalMenu();
            try {
                if (!haveToExit) {
                    final List<Portion> fruitPortions = menuService.getPortions();
                    final SizeType sizeType = menuService.getDrinkSize();
                    fruitDrinkService.prepareFruitDrink(fruitPortions, sizeType);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!haveToExit);


    }

}
