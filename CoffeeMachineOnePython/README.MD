
```markdown
# Coffee Machine Project

See projekt simuleerib kohvimasina tööd, kus saab valmistada erinevaid kohvijooke, täita masina ressursse, võtta raha välja ja vaadata ressursside taset. Projekt on kirjutatud Pythonis ja sisaldab ka testimist.

## Projekti ülesehitus

Projekt koosneb järgmisest failide ja kaustade struktuurist:

```markdown
coffee_machine_project/
├── coffee_machine.py     # Peamine loogika kohvimasina käitumise jaoks
├── __init__.py           # Kausta mooduliks muutmiseks (tühi fail)
├── tests/
│   ├── test_coffee_machine.py  # Testid kohvimasina funktsioonide jaoks
│   └── __init__.py             # Testide kausta mooduliks muutmiseks (tühi fail)
└── README.md            # Projekti info ja juhised
```

### Failide kirjeldus

- **`coffee_machine.py`**: Sisaldab kogu kohvimasina funktsionaalsust, sealhulgas jookide valmistamist, ressursside täitmist ja raha väljavõtmist.
- **`tests/test_coffee_machine.py`**: Testifail, mis kontrollib erinevaid kohvimasina funktsioone, nagu ressursside täitmine, raha väljavõtmine ja jookide valmistamine.
- **`__init__.py`**: Tühi fail, mis määratleb kaustad moodulitena, et neid saaks Pythonis importida.

## Nõuded

Projekti käivitamiseks ja testimiseks on vajalik Python 3.x.

## Kuidas käivitada?

1. **Projekti käivitamine**:
   Kohvimasina programmi saab käivitada järgmiselt:
   ```bash
   python coffee_machine.py
   ```

   Programm käivitab interaktiivse käsurea, kus saate sisestada järgmisi käske:
   - `buy`: Kohvi ostmine (vali espresso, latte või cappuccino).
   - `fill`: Masina ressursside täitmine (vesi, piim, kohvioad, topsid).
   - `take`: Raha võtmine masina kassast.
   - `remaining`: Järelejäänud ressursside taseme vaatamine.
   - `exit`: Programmist väljumine.

2. **Testide käivitamine**:
   Projekti testid on kirjutatud `unittest` raamistikus. Testide käivitamiseks:
   ```bash
   python -m unittest discover tests
   ```

   See käsk leiab ja käivitab kõik testid `tests/` kaustast.

## Näited

### 1. Kohvimasina käivitamine
```
Write action (buy, fill, take, remaining, exit):
```

- **buy**: Kui valite `buy`, küsitakse, millist kohvijooki soovite osta (espresso, latte, cappuccino).
- **fill**: Valige `fill` ressursside täitmiseks (vesi, piim, kohvioad, ühekordsed topsid).
- **take**: Valige `take` raha väljavõtmiseks masinast.
- **remaining**: Valige `remaining`, et näha praegust ressursside taset.

### 2. Testimine
Testid katavad kohvimasina põhifunktsionaalsust ja ressursi taseme muutusi:

```bash
python -m unittest discover tests
```

Tulemuseks on testide edukas läbimine või ebaõnnestumine koos detailse info ja vigade logiga.

## Autorid

Projekt on loodud hariduslikel eesmärkidel, et õppida Pythoni programmeerimist ja tarkvara testimist.
```

See `README.md` fail annab kasutajale kogu vajaliku teabe projekti kohta, kuidas seda kasutada ja testida.
