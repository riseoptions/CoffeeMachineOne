Siin on näide, kuidas saaks testida `CoffeeMachine` klassi Pythoni unit-testidega kasutades `unittest` teeki. 

Loon testid erinevatele funktsioonidele, et kontrollida, kas ressursid vähenevad ja raha lisandub õigesti pärast kohvi valmistamist, ning kas täitmine ja raha väljavõtmine toimivad õigesti.

```python
import unittest
from io import StringIO
from unittest.mock import patch
from coffee_machine import CoffeeMachine

class TestCoffeeMachine(unittest.TestCase):

    def setUp(self):
        # Loon uue CoffeeMachine objekti igale testile
        self.machine = CoffeeMachine()

    @patch('sys.stdout', new_callable=StringIO)
    def test_print_resources(self, mock_stdout):
        # Testime ressursside prindimist
        self.machine.print_resources()
        output = mock_stdout.getvalue()
        expected_output = (
            "The coffee machine has:\n"
            "400 ml of water\n"
            "540 ml of milk\n"
            "120 g of coffee beans\n"
            "9 disposable cups\n"
            "$550 of money\n\n"
        )
        self.assertEqual(output, expected_output)

    def test_make_espresso(self):
        # Testime espresso tegemist ja ressursside vähenemist
        self.machine.make_coffee(self.machine.espresso)
        self.assertEqual(self.machine.resources['water'], 400 - 250)
        self.assertEqual(self.machine.resources['milk'], 540)
        self.assertEqual(self.machine.resources['coffee_beans'], 120 - 16)
        self.assertEqual(self.machine.resources['disposable_cups'], 9 - 1)
        self.assertEqual(self.machine.resources['cash'], 550 + 4)

    def test_make_latte(self):
        # Testime latte tegemist ja ressursside vähenemist
        self.machine.make_coffee(self.machine.latte)
        self.assertEqual(self.machine.resources['water'], 400 - 350)
        self.assertEqual(self.machine.resources['milk'], 540 - 75)
        self.assertEqual(self.machine.resources['coffee_beans'], 120 - 20)
        self.assertEqual(self.machine.resources['disposable_cups'], 9 - 1)
        self.assertEqual(self.machine.resources['cash'], 550 + 7)

    def test_make_cappuccino(self):
        # Testime cappuccino tegemist ja ressursside vähenemist
        self.machine.make_coffee(self.machine.cappuccino)
        self.assertEqual(self.machine.resources['water'], 400 - 200)
        self.assertEqual(self.machine.resources['milk'], 540 - 100)
        self.assertEqual(self.machine.resources['coffee_beans'], 120 - 12)
        self.assertEqual(self.machine.resources['disposable_cups'], 9 - 1)
        self.assertEqual(self.machine.resources['cash'], 550 + 6)

    @patch('builtins.input', side_effect=['1000', '500', '200', '10'])
    def test_fill_resources(self, mock_input):
        # Testime ressursside täitmist
        self.machine.fill_resources()
        self.assertEqual(self.machine.resources['water'], 400 + 1000)
        self.assertEqual(self.machine.resources['milk'], 540 + 500)
        self.assertEqual(self.machine.resources['coffee_beans'], 120 + 200)
        self.assertEqual(self.machine.resources['disposable_cups'], 9 + 10)

    @patch('sys.stdout', new_callable=StringIO)
    def test_take_cash(self, mock_stdout):
        # Testime raha välja võtmist
        self.machine.take_cash()
        self.assertEqual(self.machine.resources['cash'], 0)
        output = mock_stdout.getvalue()
        self.assertEqual(output, "I gave you $550\n\n")

if __name__ == '__main__':
    unittest.main()
```

### Selgitused:
- **`setUp`**: Loob iga testi jaoks uue kohvimasina objekti.
- **`test_print_resources`**: Kontrollib, kas `print_resources` prindib õiged väärtused.
- **`test_make_espresso`, `test_make_latte`, `test_make_cappuccino`**: Kontrollivad, kas ressurssid vähenevad õigesti kohvi valmistamise ajal.
- **`test_fill_resources`**: Kontrollib, kas ressursside täitmine lisab õige hulga vett, piima, kohviube ja tasse.
- **`test_take_cash`**: Kontrollib, kas raha võetakse välja õigesti ja kas väljund on korrektne.

Kasutame `unittest.mock.patch`i, et asendada kasutajasisestused ja jälgida väljundeid, kuna programm eeldab interaktiivset kasutajasisestust.


`coffee_machine.py` faili käsitletakse kui moodulit. Kui failistruktuur on järgmine:

```
coffee_machine_project/
├── coffee_machine.py
└── tests/
    └── test_coffee_machine.py
```

**Lahendus:**

Selleks, et testfail saaks `coffee_machine.py`-d importida, veendu, et kaust on moodulina käsitletav, lisades tühja `__init__.py` faili projekti ja testide kaustadesse. Selleks loo järgmine struktuur:

```
coffee_machine_project/
├── coffee_machine.py
├── __init__.py          # Tühi fail
└── tests/
    ├── test_coffee_machine.py
    └── __init__.py      # Tühi fail
```

Nüüd peaks `test_coffee_machine.py` impordikood välja nägema järgmiselt:

```python
import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from coffee_machine import CoffeeMachine
```

### Täiendused:
1. Lisa tühjad `__init__.py` failid:
   - **`coffee_machine_project/__init__.py`**
   - **`coffee_machine_project/tests/__init__.py`**

See muudab mõlemad kaustad mooduliteks ja võimaldab Pythonil neid importida. Proovi siis uuesti oma testid käivitada.
