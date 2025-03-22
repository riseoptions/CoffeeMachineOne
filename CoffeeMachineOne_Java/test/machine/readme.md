Kui soovime lisada testfailid Java projektile, mis sisaldab kohvimasina loogikat, saame kasutada **JUnit** teeki testimiseks. Siin on näide testfailide struktuurist ja JUnit-i testide kirjutamisest, et kontrollida projekti funktsionaalsust.

### 1. **Failide ja kaustade struktuur koos testfailidega:**
```
CoffeeMachine/
├── src/
│   └── machine/
│       └── CoffeeMachine.java
├── test/
│   └── machine/
│       └── CoffeeMachineTest.java
├── out/
├── lib/
│   └── junit-4.13.2.jar  (JUnit teek testimiseks)
│   └── hamcrest-core-1.3.jar (JUniti lisateek)
├── README.md
└── build.gradle / pom.xml (võib sisaldada JUnit teegi sõltuvust)
```

### 2. **JUnit teegi sõltuvuse lisamine:**

Kui kasutad **Gradle** või **Maven** build süsteemi, lisa JUnit teek projekti sõltuvustesse. Kui käsitsi testid, siis lisa `lib/` kausta vajalikud JAR-failid ja tagada, et need on `classpath`-is.

- **Gradle** `build.gradle`:
```groovy
dependencies {
    testImplementation 'junit:junit:4.13.2'
}
```

- **Maven** `pom.xml`:
```xml
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### 3. **Testfaili `CoffeeMachineTest.java` loomine:**

```java
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
```

### 4. **Selgitus:**

- **`setUp()` meetod**: See meetod käivitatakse enne iga testi, et seadistada algväärtused (näiteks kohvimasina ressursid).
- **`testInitValues()`**: Testime, kas algväärtustamine (`initValues()`) töötab õigesti ja masinal on õiged ressursid.
- **`testMakeEspresso()` ja `testMakeLatte()`**: Kontrollime, kas kohvimasin suudab espresso ja latte teha ning kas ressursse vähendatakse õigesti.
- **`testEmptyCashDrawer()`**: Testime, kas raha tühjendamine töötab korrektselt.
- **`testFillResources()`**: Testime, kas masina ressursse saab õigesti juurde lisada.

### 5. **Testide käivitamine:**

Kui kasutad näiteks IntelliJ IDE-d või NetBeans-i, saad testid käivitada lihtsalt JUnit-i testrunneriga. Kui kasutad käsurida, saad testid käivitada näiteks Gradle'i või Maveniga:

- **Gradle**:
  ```bash
  ./gradlew test
  ```

- **Maven**:
  ```bash
  mvn test
  ```

See lisab projekti testimisvõimalused ning tagab, et kohvimasina programm töötab ootuspäraselt!
