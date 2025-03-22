package machine;
import java.util.Scanner;

public class CoffeeMachine {

    // Enum, mis määrab erinevad masina ressursid
    enum MachineResource {
        WATER, MILK, COFFEE_BEANS, DISPOSABLE_CUPS, CASH
    }

    // Muutujad ressursside ja jookide jaoks
    static int[] resourceLevels; // Hoiab masina ressursside taset
    static int[] espresso; // Espresso koostisosade nõuded
    static int[] latte; // Latte koostisosade nõuded
    static int[] cappuccino; // Cappuccino koostisosade nõuded

    public static void main(String[] args) {
        // Skanneri objekt kasutajasisendi lugemiseks
        Scanner scanner = new Scanner(System.in);

        // Initsialiseerime kohvimasina algväärtused
        initValues();
        String query;
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        query = scanner.next(); // Loeb kasutaja sisendi
        System.out.println();

        // Loop jätkub seni, kuni kasutaja valib 'exit'
        boolean breakLoop = query.equals("exit");

        while (!breakLoop) {
            switch (query) {
                case "buy":
                    makeCoffee(); // Valmistame kohvi
                    break;

                case "fill":
                    fillResources(); // Täidame ressursid
                    break;

                case "take":
                    emptyCashDrawer(); // Tühjendame kassa
                    break;

                case "remaining":
                    printResourcesLevel(); // Näitame järelejäänud ressursse
                    break;

                case "exit":
                    breakLoop = true; // Kasutaja lõpetab programmi
                    break;
            }

            if (breakLoop) {
                break;
            }

            // Küsime uuesti tegevust
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            query = scanner.next();
        }
    }

    // Funktsioon algväärtuste seadmiseks (masina ressursid ja jookide koostisosad)
    public static void initValues() {
        resourceLevels = new int[5]; // Seadistame masina algsed ressursid
        resourceLevels[MachineResource.WATER.ordinal()] = 400; // 400 ml vett
        resourceLevels[MachineResource.MILK.ordinal()] = 540; // 540 ml piima
        resourceLevels[MachineResource.COFFEE_BEANS.ordinal()] = 120; // 120 g kohviube
        resourceLevels[MachineResource.DISPOSABLE_CUPS.ordinal()] = 9; // 9 ühekordset tassi
        resourceLevels[MachineResource.CASH.ordinal()] = 550; // $550 sularaha

        // Espresso koostisosad
        espresso = new int[5]; 
        espresso[MachineResource.WATER.ordinal()] = 250;
        espresso[MachineResource.MILK.ordinal()] = 0;
        espresso[MachineResource.COFFEE_BEANS.ordinal()] = 16;
        espresso[MachineResource.DISPOSABLE_CUPS.ordinal()] = 1;
        espresso[MachineResource.CASH.ordinal()] = 4;

        // Latte koostisosad
        latte = new int[5]; 
        latte[MachineResource.WATER.ordinal()] = 350;
        latte[MachineResource.MILK.ordinal()] = 75;
        latte[MachineResource.COFFEE_BEANS.ordinal()] = 20;
        latte[MachineResource.DISPOSABLE_CUPS.ordinal()] = 1;
        latte[MachineResource.CASH.ordinal()] = 7;

        // Cappuccino koostisosad
        cappuccino = new int[5]; 
        cappuccino[MachineResource.WATER.ordinal()] = 200;
        cappuccino[MachineResource.MILK.ordinal()] = 100;
        cappuccino[MachineResource.COFFEE_BEANS.ordinal()] = 12;
        cappuccino[MachineResource.DISPOSABLE_CUPS.ordinal()] = 1;
        cappuccino[MachineResource.CASH.ordinal()] = 6;
    }

    // Näitab masina ressursside seisu
    public static void printResourcesLevel() {
        System.out.println("The coffee machine has:");
        System.out.println(resourceLevels[MachineResource.WATER.ordinal()] + " ml of water");
        System.out.println(resourceLevels[MachineResource.MILK.ordinal()] + " ml of milk");
        System.out.println(resourceLevels[MachineResource.COFFEE_BEANS.ordinal()] + " g of coffee beans");
        System.out.println(resourceLevels[MachineResource.DISPOSABLE_CUPS.ordinal()] + " disposable cups");
        System.out.println("$" + resourceLevels[MachineResource.CASH.ordinal()] + " of money");
        System.out.println();
    }

    // Tühjendab kassa ja näitab, kui palju raha saadi
    public static void emptyCashDrawer() {
        System.out.println("I gave you $" + resourceLevels[MachineResource.CASH.ordinal()]);
        System.out.println();
        resourceLevels[MachineResource.CASH.ordinal()] = 0;
    }

    // Lubab kasutajal täita masina ressursse
    public static void fillResources() {
        int resourceQuantityAdded;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water you want to add: ");
        resourceQuantityAdded = scanner.nextInt();
        resourceLevels[MachineResource.WATER.ordinal()] += resourceQuantityAdded;

        System.out.println("Write how many ml of milk you want to add: ");
        resourceQuantityAdded = scanner.nextInt();
        resourceLevels[MachineResource.MILK.ordinal()] += resourceQuantityAdded;

        System.out.println("Write how many grams of coffee beans you want to add: ");
        resourceQuantityAdded = scanner.nextInt();
        resourceLevels[MachineResource.COFFEE_BEANS.ordinal()] += resourceQuantityAdded;

        System.out.println("Write how many disposable cups of coffee you want to add: ");
        resourceQuantityAdded = scanner.nextInt();
        resourceLevels[MachineResource.DISPOSABLE_CUPS.ordinal()] += resourceQuantityAdded;
    }

    // Kohvi valmistamine
    public static void makeCoffee() {
        Scanner scanner = new Scanner(System.in);

        // Küsimus, millist kohvi valmistada
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = scanner.next();
        MachineResource sparseResource = MachineResource.CASH;

        switch(choice) {
            case "1":
                // Kontrollime, kas espresso jaoks on piisavalt ressursse
                if (resourceLevels[MachineResource.WATER.ordinal()] < espresso[MachineResource.WATER.ordinal()]) {
                    sparseResource = MachineResource.WATER;
                } else if (resourceLevels[MachineResource.MILK.ordinal()] < espresso[MachineResource.MILK.ordinal()]) {
                    sparseResource = MachineResource.MILK;
                } else if (resourceLevels[MachineResource.COFFEE_BEANS.ordinal()] < espresso[MachineResource.COFFEE_BEANS.ordinal()]) {
                    sparseResource = MachineResource.COFFEE_BEANS;
                } else if (resourceLevels[MachineResource.DISPOSABLE_CUPS.ordinal()] < espresso[MachineResource.DISPOSABLE_CUPS.ordinal()]) {
                    sparseResource = MachineResource.DISPOSABLE_CUPS;
                } else {
                    // Kui ressursse on piisavalt, vähendame neid ja lisame raha
                    resourceLevels[MachineResource.WATER.ordinal()] -= espresso[MachineResource.WATER.ordinal()];
                    resourceLevels[MachineResource.MILK.ordinal()] -= espresso[MachineResource.MILK.ordinal()];
                    resourceLevels[MachineResource.COFFEE_BEANS.ordinal()] -= espresso[MachineResource.COFFEE_BEANS.ordinal()];
                    resourceLevels[MachineResource.DISPOSABLE_CUPS.ordinal()] -= espresso[MachineResource.DISPOSABLE_CUPS.ordinal()];
                    resourceLevels[MachineResource.CASH.ordinal()] += espresso[MachineResource.CASH.ordinal()];
                }
                break;

            case "2":
                // Kontrollime latte jaoks
                if (resourceLevels[MachineResource.WATER.ordinal()] < latte[MachineResource.WATER.ordinal()]) {
                    sparseResource = MachineResource.WATER;
                } else if (resourceLevels[MachineResource.MILK.ordinal()] < latte[MachineResource.MILK.ordinal()]) {
                    sparseResource = MachineResource.MILK;
                } else if (resourceLevels[MachineResource.COFFEE_BEANS.ordinal()] < latte[MachineResource.COFFEE_BEANS.ordinal()]) {
                    sparseResource = MachineResource.COFFEE_BEANS;
                } else if (resourceLevels[MachineResource.DISPOSABLE_CUPS.ordinal()] < latte[MachineResource.DISPOSABLE_CUPS.ordinal()]) {
                    sparseResource = MachineResource.DISPOSABLE_CUPS;
                } else {
                    // Ressursid on piisavad, vähendame neid
                    resourceLevels[MachineResource.WATER.ordinal()] -= latte[MachineResource.WATER.ordinal()];
                    resourceLevels[MachineResource.MILK.ordinal()] -= latte[MachineResource.MILK.ordinal()];
                    resourceLevels[MachineResource.COFFEE_BEANS.ordinal()] -= latte[MachineResource.COFFEE_BEANS.ordinal()];
                    resourceLevels[MachineResource.DISPOSABLE_CUPS.ordinal()] -= latte[MachineResource.DISPOSABLE_CUPS.ordinal()];
                    resourceLevels[MachineResource.CASH.ordinal()] += latte[MachineResource.CASH.ordinal()];
                }
                break;

            case "3":
                // Kontrollime cappuccino jaoks
                if (resourceLevels[MachineResource.WATER.ordinal()] < cappuccino[MachineResource.WATER.ordinal()]) {
                    sparseResource = MachineResource.WATER;
                } else if (resourceLevels[MachineResource.MILK.ordinal()] < cappuccino[MachineResource.MILK.ordinal()]) {
                    sparseResource = MachineResource.MILK;
                } else if (resourceLevels[MachineResource.COFFEE_BEANS.ordinal()] < cappuccino[MachineResource.COFFEE_BEANS.ordinal()]) {
                    sparseResource = MachineResource.COFFEE_BEANS;
                } else if (resourceLevels[MachineResource.DISPOSABLE_CUPS.ordinal()] < cappuccino[MachineResource.DISPOSABLE_CUPS.ordinal()]) {
                    sparseResource = MachineResource.DISPOSABLE_CUPS;
                } else {
                    // Ressursid on piisavad, vähendame neid
                    resourceLevels[MachineResource.WATER.ordinal()] -= cappuccino[MachineResource.WATER.ordinal()];
                    resourceLevels[MachineResource.MILK.ordinal()] -= cappuccino[MachineResource.MILK.ordinal()];
                    resourceLevels[MachineResource.COFFEE_BEANS.ordinal()] -= cappuccino[MachineResource.COFFEE_BEANS.ordinal()];
                    resourceLevels[MachineResource.DISPOSABLE_CUPS.ordinal()] -= cappuccino[MachineResource.DISPOSABLE_CUPS.ordinal()];
                    resourceLevels[MachineResource.CASH.ordinal()] += cappuccino[MachineResource.CASH.ordinal()];
                }
                break;

            case "back":
                return;
        }

        // Kontrollime, kas ressursse on piisavalt või anname teate puuduvast ressursist
        if (sparseResource == MachineResource.CASH) {
            System.out.println("I have enough resources, making you a coffee!");

        } else if(sparseResource == MachineResource.WATER) {
            System.out.println("Sorry, not enough water!");

        }  else if(sparseResource == MachineResource.MILK) {
            System.out.println("Sorry, not enough milk!");

        } else if(sparseResource == MachineResource.COFFEE_BEANS) {
            System.out.println("Sorry, not enough coffee beans!");

        } else {
            System.out.println("Sorry, not enough disposable cups!");
        }

        System.out.println();
    }
}
