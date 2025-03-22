import tkinter as tk
from tkinter import messagebox

class CoffeeMachineGUI:

    def __init__(self, root):
        self.water = 400
        self.milk = 540
        self.coffee_beans = 120
        self.disposable_cups = 9
        self.cash = 550

        # Main window
        self.root = root
        root.title("Coffee Machine")

        # Buttons
        self.buy_button = tk.Button(root, text="Buy", command=self.buy_coffee)
        self.buy_button.pack()

        self.fill_button = tk.Button(root, text="Fill", command=self.fill_resources)
        self.fill_button.pack()

        self.take_button = tk.Button(root, text="Take", command=self.take_cash)
        self.take_button.pack()

        self.remaining_button = tk.Button(root, text="Remaining", command=self.show_remaining)
        self.remaining_button.pack()

        self.exit_button = tk.Button(root, text="Exit", command=root.quit)
        self.exit_button.pack()

        # Status label
        self.status_label = tk.Label(root, text="Choose an action")
        self.status_label.pack()

    def buy_coffee(self):
        # Create a new window for selecting coffee
        buy_window = tk.Toplevel(self.root)
        buy_window.title("Select Coffee")

        # Label and radio buttons for coffee selection
        tk.Label(buy_window, text="Select your coffee:").pack()

        coffee_choice = tk.StringVar(value="Espresso")

        tk.Radiobutton(buy_window, text="Espresso", variable=coffee_choice, value="Espresso").pack()
        tk.Radiobutton(buy_window, text="Latte", variable=coffee_choice, value="Latte").pack()
        tk.Radiobutton(buy_window, text="Cappuccino", variable=coffee_choice, value="Cappuccino").pack()

        # Confirm button
        tk.Button(buy_window, text="Confirm", command=lambda: self.confirm_purchase(coffee_choice.get(), buy_window)).pack()

    def confirm_purchase(self, choice, window):
        if choice == "Espresso":
            self.make_espresso()
        elif choice == "Latte":
            self.make_latte()
        elif choice == "Cappuccino":
            self.make_cappuccino()
        window.destroy()  # Close the selection window

    def make_espresso(self):
        if self.water >= 250 and self.coffee_beans >= 16 and self.disposable_cups >= 1:
            self.water -= 250
            self.coffee_beans -= 16
            self.disposable_cups -= 1
            self.cash += 4
            self.status_label.config(text="Espresso made!")
        else:
            self.status_label.config(text="Not enough resources")

    def make_latte(self):
        if self.water >= 350 and self.milk >= 75 and self.coffee_beans >= 20 and self.disposable_cups >= 1:
            self.water -= 350
            self.milk -= 75
            self.coffee_beans -= 20
            self.disposable_cups -= 1
            self.cash += 7
            self.status_label.config(text="Latte made!")
        else:
            self.status_label.config(text="Not enough resources")

    def make_cappuccino(self):
        if self.water >= 200 and self.milk >= 100 and self.coffee_beans >= 12 and self.disposable_cups >= 1:
            self.water -= 200
            self.milk -= 100
            self.coffee_beans -= 12
            self.disposable_cups -= 1
            self.cash += 6
            self.status_label.config(text="Cappuccino made!")
        else:
            self.status_label.config(text="Not enough resources")

    def fill_resources(self):
        self.water += 200
        self.milk += 100
        self.coffee_beans += 50
        self.disposable_cups += 5
        self.status_label.config(text="Resources refilled!")

    def take_cash(self):
        messagebox.showinfo("Take Cash", f"You took ${self.cash}")
        self.cash = 0

    def show_remaining(self):
        remaining = f"Water: {self.water}ml\nMilk: {self.milk}ml\nBeans: {self.coffee_beans}g\nCups: {self.disposable_cups}\nCash: ${self.cash}"
        self.status_label.config(text=remaining)


if __name__ == "__main__":
    root = tk.Tk()
    app = CoffeeMachineGUI(root)
    root.mainloop()
