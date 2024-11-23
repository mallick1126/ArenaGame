# Java dev.program.Arena.Arena Battle Game

This is a simple Java project that simulates a battle between two players in an arena. The players fight using dice rolls, where the attack and defense strength are influenced by random dice rolls. The winner is the player who remains alive after the battle.

## Features
- **Player Creation**: Players are created with specific attributes (health, strength, attack) using the Builder pattern.
- **Dice Rolling**: A dice roll determines the outcome of attacks and defenses.
- **Arena Fight**: Two players fight in the arena until one player's health reaches 0.
- **Unit Tests**: The project includes unit tests to validate the game logic.


## Prerequisites
To run this project, you'll need:

- **Java 8 or higher**: You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-downloads.html) or use an OpenJDK distribution.
- **Maven**: A build automation tool used in this project. Download it from [Maven's official website](https://maven.apache.org/download.cgi).

## How to Run the Project

### 1. Download and Extract the ZIP File

- Download the ZIP file containing this project.
- Extract the contents of the ZIP file to a directory on your system.

### 2. Open a Terminal/Command Prompt

- Navigate to the extracted project folder in your terminal. For example:
  ```bash
  cd path/to/extracted/project

### 3. Build and Run the Project (Using Maven)
- a. Compile the project:
  ```bash
  mvn clean install
  mvn compile

- b. Run the project:
  ```bash
  mvn exec:java -Dexec.mainClass="Main"

#### This will compile the project and then execute the Main class, which starts the game.

### Example Output:

```bash
Player A attacks Player B
Attack Roll: 4, Defense Roll: 2
Attack Damage: 40, Defense Strength: 50
Net Damage: 0, Player B's remaining health: 100

Player B attacks Player A
Attack Roll: 5, Defense Roll: 1
Attack Damage: 50, Defense Strength: 20
Net Damage: 30, Player A's remaining health: 70

...
Winner: Player A
```

### 4: Run the tests
 - To run unit tests, you can use the following Maven command:
   ```bash
   mvn test

#### This will run the tests in the src/test/java/ directory and validate the correctness of the game logic


### Dependencies
#### This project uses the following dependencies:
- JUnit 5 for unit testing
- Maven for project management and building

#### Ensure that the required dependencies are included in your pom.xml.

