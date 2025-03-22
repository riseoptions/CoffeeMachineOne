# CoffeeMachineOne




# Coffee Machine Project

See projekt simuleerib kohvimasina tööd, kus kasutaja saab valmistada erinevaid kohvijooke (espresso, latte, cappuccino), täita masina ressursse (vesi, piim, kohvioad, ühekordsed topsid), vaadata ressursside taset ja võtta raha välja. Projekt on realiseeritud nii **Python** kui ka **Java** keeles.

## Projekti ülesehitus

Mõlema projekti struktuur on sarnane ja sisaldab järgmist:

### Python projekt

```markdown
coffee_machine_project/
├── coffee_machine.py     # Põhiloogika kohvimasina funktsionaalsuse jaoks
├── __init__.py           # Kausta mooduliks muutmiseks
├── tests/
│   ├── test_coffee_machine.py  # Unit testid kohvimasina jaoks
│   └── __init__.py             # Kausta mooduliks muutmiseks
└── README.md            # Projekti kirjeldus ja juhised
```

### Java projekt

```markdown
CoffeeMachine/
├── src/
│   └── machine/
│       └── CoffeeMachine.java  # Peamine klass kohvimasina loogikaga
├── test/
│   └── machine/
│       └── CoffeeMachineTest.java  # JUnit testid kohvimasina jaoks
├── out/                       # Kompileeritud klasside väljundkaust
├── lib/
│   ├── junit-4.13.2.jar       # JUnit teek testimiseks
│   └── hamcrest-core-1.3.jar  # JUniti lisateek
└── README.md                  # Projekti kirjeldus ja juhised
```

## Kuidas käivitada?

### Python projekti käivitamine

1. **Projekti käivitamine**:
   Kohvimasina Pythoni versiooni saab käivitada järgmiselt:
   ```bash
   python coffee_machine.py
   ```

   Programm pakub kasutajale võimalust teha järgmisi toiminguid:
   - `buy`: Kohvi ostmine (espresso, latte või cappuccino).
   - `fill`: Masina ressursside täitmine.
   - `take`: Raha võtmine masina kassast.
   - `remaining`: Järelejäänud ressursside taseme vaatamine.
   - `exit`: Programmi lõpetamine.

2. **Testide käivitamine**:
   Testide käivitamiseks:
   ```bash
   python -m unittest discover tests
   ```

### Java projekti käivitamine

1. **Projekti kompileerimine ja käivitamine**:
   Java projekti saab käivitada NetBeansis, IntelliJ-s või käsurealt. Käsurealt käivitamiseks:
   ```bash
   javac src/machine/CoffeeMachine.java -d out/
   java -cp out/ machine.CoffeeMachine
   ```

2. **JUnit testide käivitamine**:
   Testide käivitamiseks on vaja JUnit ja Hamcrest teeke. Käsurealt saab teste käivitada järgmiselt:
   ```bash
   javac -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar src/machine/CoffeeMachineTest.java -d out/
   java -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:out/ org.junit.runner.JUnitCore machine.CoffeeMachineTest
   ```

   IntelliJ ja NetBeans projektides saab testid käivitada otse IDE testikäivitusega.

## Testid

Mõlemas projektis on testid kirjutatud, et kontrollida kohvimasina põhifunktsioone:

- **Python**: Testid on kirjutatud kasutades `unittest` raamistiku ja asuvad `tests/` kaustas.
- **Java**: Testid on kirjutatud kasutades JUnit raamistiku ja asuvad `test/` kaustas.

## Autorid

Projekt on loodud õppimise ja praktika eesmärgil, et harjutada programmeerimist ja tarkvara testimist nii **Python** kui ka **Java** keeles.
```

### Kokkuvõte

See `README.md` fail sisaldab informatsiooni mõlema projekti kohta ja annab kasutajale juhised, kuidas projekti käivitada, testida ja mõista mõlemas keeles.
