import os

# Kaustade ja failide struktuur
project_structure = {
    "CoffeeMachine": [
        "src/machine/CoffeeMachine.java",
        "test/machine/CoffeeMachineTest.java",
        "lib/junit-4.13.2.jar",
        "lib/hamcrest-core-1.3.jar",
        "README.md",
        "build.gradle"
    ]
}

# Funktsioon kaustade ja failide loomiseks
def create_project_structure(structure):
    for root, files in structure.items():
        for file_path in files:
            # Luuakse kaustad, kui neid veel ei ole
            full_dir = os.path.join(root, os.path.dirname(file_path))
            os.makedirs(full_dir, exist_ok=True)
            
            # Luuakse failid
            full_file_path = os.path.join(root, file_path)
            with open(full_file_path, 'w') as file:
                pass  # Loob tühja faili

# Loome projekti struktuuri
create_project_structure(project_structure)
