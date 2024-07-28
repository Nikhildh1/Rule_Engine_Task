# Rule Engine Application

## Overview

This project implements a simple 3-tier rule engine application using Java. The system includes a basic UI (command-line), API, backend logic, and data storage. It determines user eligibility based on attributes like age, department, salary, experience, etc. The rules are represented using an Abstract Syntax Tree (AST), allowing dynamic creation, combination, and modification of rules.

## Project Structure

- **`src/main/java/com/example/`**
    - `ASTNode.java` - Defines the structure of an AST node.
    - `RuleParser.java` - Parses rule strings into AST nodes and combines multiple rules.
    - `RuleEvaluator.java` - Evaluates rules against provided data.
    - `RuleStorage.java` - Manages the storage of rules.
    - `RuleEngine.java` - Main class demonstrating rule parsing, combining, and evaluation.

- **`src/test/java/com/example/`**
    - `RuleParserTest.java` - Contains test cases for the `RuleParser` class.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven (for building the project)

### Building the Project

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/Rule_Engine.git
   cd Rule_Engine
   
2. **Build the project using Maven:**
   ```bash
   mvn clean install

3. **Running the Application** \
   The RuleEngine class contains the main method, which demonstrates the rule engine functionality. To run the application:
   ```bash
   mvn exec:java -Dexec.mainClass="com.example.RuleEngine"