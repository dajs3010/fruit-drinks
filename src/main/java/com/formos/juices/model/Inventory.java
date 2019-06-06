package com.formos.juices.model;

public class Inventory {

    public static int DEFAULT_STARTING_INVENTORY = 1000;

    private int strawberry;
    private int banana;
    private int mango;
    private int ice;
    private int condensedMilk;
    private int sugar;

    private static Inventory inventory;

    protected Inventory(int strawberry, int banana, int mango, int ice, int condensedMilk, int sugar) {
        this.strawberry = strawberry;
        this.banana = banana;
        this.mango = mango;
        this.ice = ice;
        this.condensedMilk = condensedMilk;
        this.sugar = sugar;
    }

    public static void initializeInventory() {
        new Inventory(DEFAULT_STARTING_INVENTORY, DEFAULT_STARTING_INVENTORY, DEFAULT_STARTING_INVENTORY,
                DEFAULT_STARTING_INVENTORY, DEFAULT_STARTING_INVENTORY, DEFAULT_STARTING_INVENTORY);
    }

    public static Inventory getInventory() {
        if (inventory == null) {
            inventory = new Inventory(DEFAULT_STARTING_INVENTORY, DEFAULT_STARTING_INVENTORY, DEFAULT_STARTING_INVENTORY,
                    DEFAULT_STARTING_INVENTORY, DEFAULT_STARTING_INVENTORY, DEFAULT_STARTING_INVENTORY);
        }
        return inventory;
    }

    public void useStrawberry(int quantity) {
        this.strawberry = this.strawberry - quantity;
    }

    public void useBanana(int quantity) {
        this.banana = this.banana - quantity;
    }

    public void useMango(int quantity) {
        this.mango = this.mango - quantity;
    }

    public void useIce(int quantity) {
        this.ice = this.ice - quantity;
    }

    public void useCondensedMilk(int quantity) {
        this.condensedMilk = this.condensedMilk - quantity;
    }

    public void useSugar(int quantity) {
        this.sugar = this.sugar - quantity;
    }

    public int getStrawberry() {
        return strawberry;
    }

    public int getBanana() {
        return banana;
    }

    public int getMango() {
        return mango;
    }

    public int getIce() {
        return ice;
    }

    public int getCondensedMilk() {
        return condensedMilk;
    }

    public int getSugar() {
        return sugar;
    }

    public void generateReport() {
        System.out.println();
        System.out.println("----------------");
        System.out.println("INVENTORY REPORT");
        System.out.println("Strawberry\t\t\t" + this.strawberry + "g");
        System.out.println("Banana\t\t\t\t" + this.banana + "g");
        System.out.println("Mango\t\t\t\t" + this.mango + "g");
        System.out.println("Ice\t\t\t\t" + this.ice + "ml");
        System.out.println("Condensed Milk\t\t\t" + this.condensedMilk + "ml");
        System.out.println("Sugar\t\t\t\t" + this.sugar + "g");
    }
}
