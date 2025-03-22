import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from coffee_machine import CoffeeMachine



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
