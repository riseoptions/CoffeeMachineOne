class CoffeeMachine:
    def __init__(self):
        # Masina algsed ressursid
        self.resources = {
            'water': 400,
            'milk': 540,
            'coffee_beans': 120,
            'disposable_cups': 9,
            'cash': 550
        }
        # Jookide retseptid (vajaminevad ressursid)
        self.espresso = {'water': 250, 'milk': 0, 'coffee_beans': 16, 'disposable_cups': 1, 'cash': 4}
        self.latte = {'water': 350, 'milk': 75, 'coffee_beans': 20, 'disposable_cups': 1, 'cash': 7}
        self.cappuccino = {'water': 200, 'milk': 100, 'coffee_beans': 12, 'disposable_cups': 1, 'cash': 6}

    def print_resources(self):
        """Prindib välja praegused ressursid."""
        print(f"The coffee machine has:")
        print(f"{self.resources['water']} ml of water")
        print(f"{self.resources['milk']} ml of milk")
        print(f"{self.resources['coffee_beans']} g of coffee beans")
        print(f"{self.resources['disposable_cups']} disposable cups")
        print(f"${self.resources['cash']} of money")
        print()

    def make_coffee(self, drink):
        """Valmistab kohvi, kui on piisavalt ressursse."""
        if all(self.resources[res] >= drink[res] for res in drink if res != 'cash'):
            for res in drink:
                if res != 'cash':
                    self.resources[res] -= drink[res]
            self.resources['cash'] += drink['cash']
            print("I have enough resources, making you a coffee!")
        else:
            for res in drink:
                if self.resources[res] < drink[res]:
                    print(f"Sorry, not enough {res}!")
                    return
        print()

    def fill_resources(self):
        """Täidab ressursse kasutaja sisendi põhjal."""
        self.resources['water'] += int(input("Write how many ml of water you want to add: "))
        self.resources['milk'] += int(input("Write how many ml of milk you want to add: "))
        self.resources['coffee_beans'] += int(input("Write how many grams of coffee beans you want to add: "))
        self.resources['disposable_cups'] += int(input("Write how many disposable cups you want to add: "))
        print()

    def take_cash(self):
        """Võtab kogu raha välja ja näitab summat."""
        print(f"I gave you ${self.resources['cash']}")
        self.resources['cash'] = 0
        print()

    def process_input(self, action):
        """Käitleb kasutaja tegevust."""
        if action == "buy":
            choice = input("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
            if choice == "1":
                self.make_coffee(self.espresso)
            elif choice == "2":
                self.make_coffee(self.latte)
            elif choice == "3":
                self.make_coffee(self.cappuccino)
            elif choice == "back":
                return

        elif action == "fill":
            self.fill_resources()

        elif action == "take":
            self.take_cash()

        elif action == "remaining":
            self.print_resources()

def main():
    coffee_machine = CoffeeMachine()
    while True:
        action = input("Write action (buy, fill, take, remaining, exit): ")
        if action == "exit":
            break
        coffee_machine.process_input(action)

if __name__ == "__main__":
    main()
