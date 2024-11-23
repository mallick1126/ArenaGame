# Java Arena Battle Game

This is a simple Java project that simulates a battle between two players in an arena. The players fight using dice rolls, where the attack and defense strength are influenced by random dice rolls. The winner is the player who remains alive after the battle.

## Project Structure

```plaintext
/project-root
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── Player.java      # Player class representing each participant
│   │       ├── Dice.java        # Dice class to handle dice rolls
│   │       ├── Arena.java       # Arena class where the fight happens
│   │       └── Main.java        # Entry point to run the game
│   └── test/
│       └── java/
│           └── ArenaTest.java    # Unit tests for the Arena functionality
├── pom.xml                       # Maven project configuration file
```


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
  mvn compile

- b. Run the project:
  ```bash
  mvn exec:java -Dexec.mainClass="Main"

#### This will compile the project and then execute the Main class, which starts the game.

### 4: Run the tests (optional)
 - To run unit tests, you can use the following Maven command:
   ```bash
   mvn test

#### This will execute all the test cases, including tests for the Arena functionality.

### Code Examples
The project contains the following Java classes:

- **Player.java**: This class represents a player in the arena with attributes like name, health, strength, and attack. It also provides methods to check health status and reduce health after taking damage.
- **Dice.java**: This class handles dice rolls. It allows specifying the number of sides on the die and provides a method to roll the dice.
- **Arena.java**: This class manages the battle between two players. It takes two players as input, simulates the fight by rolling dice for attack and defense, and determines the winner.
- **Main.java**: This is the entry point for the program. It creates two players, sets up the arena, and starts the fight.
- **ArenaTest.java**: This class contains unit tests for the Arena class to ensure its functionality.