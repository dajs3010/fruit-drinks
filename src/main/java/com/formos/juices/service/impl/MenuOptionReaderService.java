package com.formos.juices.service.impl;

import com.formos.juices.service.IMenuOptionReaderService;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class MenuOptionReaderService implements IMenuOptionReaderService {

    private Scanner scanner = new Scanner(System.in);

    public int getPrincipalMenuOption() {
        System.out.println();
        System.out.println("------------------------");
        System.out.println("Please select an option:");
        System.out.println("1. List inventory");
        System.out.println("2. Sell a drink");
        System.out.println("3. Exit");
        return scanner.nextInt();
    }

    public int getFruitMenuOption() {
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("Please select your fruit drink:");
        System.out.println("1. Strawberry");
        System.out.println("2. Banana");
        System.out.println("3. Mango");
        System.out.println("4. Strawberry & Banana");
        System.out.println("5. Strawberry & Mango");
        System.out.println("6. Banana & Mango");
        System.out.println("7. All fruits");
        return scanner.nextInt();
    }

    public int getSizeMenuOption() {
        System.out.println();
        System.out.println("------------------------");
        System.out.println("Please select your size:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        return scanner.nextInt();
    }

    public void printInvalidOptionWarning() {
        System.out.println("---------------");
        System.out.println("Invalid option!");
        System.out.println("---------------");
    }
}
