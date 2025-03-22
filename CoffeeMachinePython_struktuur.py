import os

# Defineeritakse projekti kaustade ja failide struktuur Pythoni jaoks (Java projekti struktuuri sarnaselt)
python_project_structure_single_file = {
    "CoffeeMachine_Python": [
        "src/coffee_machine.py",
        "tests/test_coffee_machine.py",
        "out/",
        "lib/junit-4.13.2.jar",  # Simuleeritud failid, nagu oli Java projektis
        "lib/hamcrest-core-1.3.jar",  # Simuleeritud failid, nagu oli Java projektis
        "README.md",
        "requirements.txt"
    ]
}

# Funktsioon kaustade ja failide loomiseks
def create_python_project_structure(structure):
    for root, files in structure.items():
        for file_path in files:
            # Luuakse kaustad, kui neid veel ei ole
            full_dir = os.path.join(root, os.path.dirname(file_path))
            os.makedirs(full_dir, exist_ok=True)
            
            # Luuakse failid
            full_file_path = os.path.join(root, file_path)
            if not file_path.endswith("/"):  # Väldib tühjade kaustade loomiseks faili avamist
                with open(full_file_path, 'w') as file:
                    pass  # Loob tühja faili

# Loome Pythoni projekti struktuuri
create_python_project_structure(python_project_structure_single_file)
