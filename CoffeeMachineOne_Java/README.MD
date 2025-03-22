Kui arendame väikest projekti, nagu näiteks kohvimasina programm Java keeles, siis failide ja kaustade struktuur peaks olema organiseeritud ja lihtsasti mõistetav. Siin on tüüpiline failistruktuur, mida võiks järgida, kui loome Java projekti:

### 1. **Projektijuure kaust**
    - `CoffeeMachine/`
        - **src/** - Siin asub kogu Java kood.
        - **out/** - Siin on kompileeritud klassifailid (kui kompileerime käsurealt või IDE kaudu).
        - **lib/** - Siia lähevad välised teegid või JAR-failid (kui projektis neid on).
        - **build.gradle** või **pom.xml** - Gradle või Maven konfiguratsioonifailid (kui projekt kasutab neid build süsteeme).
        - **README.md** - Dokumentatsioon projekti kohta.

### 2. **`src` kaust**
    - **CoffeeMachine/src/**
        - **machine/** - See kaust sisaldab programmi paketti ja Java allikakoode.
        - **CoffeeMachine.java** - Peamine klass, mis sisaldab kogu programmi loogikat.
        
        Näiteks:
        ```
        CoffeeMachine/
        ├── src/
        │   └── machine/
        │       └── CoffeeMachine.java
        └── README.md
        ```

### Näide failistruktuurist:

```
CoffeeMachine/
├── src/
│   └── machine/
│       └── CoffeeMachine.java
├── out/
├── lib/
├── README.md
└── build.gradle
```

### Kirjeldus:
- **`src/machine/CoffeeMachine.java`** - Selles failis on kogu sinu kohvimasina loogika.
- **`out/`** - Siia pannakse kompileeritud Java klassifailid (näiteks `CoffeeMachine.class`).
- **`lib/`** - Siia lähevad välised teegid või JAR-failid, kui projekt kasutab kolmanda osapoole teeke.
- **`README.md`** - Projekti dokumentatsioon, mis annab ülevaate projekti eesmärgist ja juhised kasutamiseks.
- **`build.gradle` või `pom.xml`** - Build failid, mis on vajalikud juhul, kui projekt kasutab Gradle'i või Mavenit.

### Täiendavad võimalused:
- Kui soovid lisada testimisvõimalusi, siis võiks olla ka `test/` kaust, kus hoiad automaatseid teste.

