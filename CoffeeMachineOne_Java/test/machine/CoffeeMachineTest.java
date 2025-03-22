package machine;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CoffeeMachineTest {

    // Seadistame algväärtused testide jaoks
    @Before
    public void setUp() {
        CoffeeMachine.initValues();
    }

    // Testime, kas masina algsed ressursid on õiged
    @Test
    public void testInitValues() {
        int[] expectedResourceLevels = {400, 540, 120, 9, 550};
        assertArrayEquals(expectedResourceLevels, CoffeeMachine.resourceLevels);
    }

    // Testime, kas masin suudab kohvi valmistada ja ressursse õigesti vähendada
    @Test
    public void testMakeEspresso() {
        CoffeeMachine.makeCoffee(1);  // 1 = espresso
        assertEquals(150, CoffeeMachine.resourceLevels[CoffeeMachine.MachineResource.WATER.ordinal()]);
        assertEquals(120, CoffeeMachine.resourceLevels[CoffeeMachine.MachineResource.MILK.ordinal()]);
        assertEquals(104, CoffeeMachine.resourceLevels[CoffeeMachine.MachineResource.COFFEE_BEANS.ordinal()]);
        assertEquals(8, CoffeeMachine.resourceLevels[CoffeeMachine.MachineResource.DISPOSABLE_CUPS.ordinal()]);
        assertEquals(554, CoffeeMachine.resourceLevels[CoffeeMachine.MachineResource.CASH.ordinal()]);
    }

    // Testime, kas masin suudab kassasahtlit tühjendada
    @Test
    public void testEmptyCashDrawer() {
        CoffeeMachine.emptyCashDrawer();
        assertEquals(0, CoffeeMachine.resourceLevels[CoffeeMachine.MachineResource.CASH.ordinal()]);
    }

    // Testime, kas masin suudab ressursse juurde lisada
    @Test
    public void testFillResources() {
        CoffeeMachine.fillResources(200, 100, 50, 5);  // Lisame vett, piima, kohviube ja tasse
        assertEquals(600, CoffeeMachine.resourceLevels[CoffeeMachine.MachineResource.WATER.ordinal()]);
        assertEquals(640, CoffeeMachine.resourceLevels[CoffeeMachine.MachineResource.MILK.ordinal()]);
        assertEquals(170, CoffeeMachine.resourceLevels[CoffeeMachine.MachineResource.COFFEE_BEANS.ordinal()]);
        assertEquals(14, CoffeeMachine.resourceLevels[CoffeeMachine.MachineResource.DISPOSABLE_CUPS.ordinal()]);
    }

    // Testime, kas masin suudab latte valmistada ja ressursse õigesti vähendada
    @Test
    public void testMakeLatte() {
        CoffeeMachine.makeCoffee(2);  // 2 = latte
        assertEquals(50, CoffeeMachine.resourceLevels[CoffeeMachine.MachineResource.WATER.ordinal()]);
        assertEquals(465, CoffeeMachine.resourceLevels[CoffeeMachine.MachineResource.MILK.ordinal()]);
        assertEquals(100, CoffeeMachine.resourceLevels[CoffeeMachine.MachineResource.COFFEE_BEANS.ordinal()]);
        assertEquals(8, CoffeeMachine.resourceLevels[CoffeeMachine.MachineResource.DISPOSABLE_CUPS.ordinal()]);
        assertEquals(557, CoffeeMachine.resourceLevels[CoffeeMachine.MachineResource.CASH.ordinal()]);
    }
}
