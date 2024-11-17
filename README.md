# Library Management System

## Overview
A simple Library Management System that provides functionality to manage books, members, and loans. This system is designed to demonstrate Object-Oriented Programming (OOP) principles, SOLID design principles, and clean code practices.

## Features
- **Book Management**: Add, remove, search, and display books.
- **Member Management**: Register, manage, and display members.
- **Loan Management**: Borrow and return books, check overdue loans, and display current loans.

## Running the Application
- Clone the repository to your local machine.
- Open the project in Eclipse or any Java-compatible IDE.
- Run the `LibraryManager` class to test the core functionality of the system.

## Testing
- Ensure JUnit 5 is added to the project dependencies.
- Write and run unit tests for the main operations, such as adding/removing books, registering members, and managing loans.
- Verify the test results in the IDE or generate a test report.

## Technologies Used
- Java (version 17 or later).
- JUnit 5 for testing.

## Clean Code Practices
- **Encapsulation**: All classes use private fields with public getters and setters where necessary.
- **Abstraction**: Abstracted complex logic into well-defined methods.
- **Single Responsibility Principle**: Each class has one well-defined purpose.
- **Open/Closed Principle**: Classes are open for extension but closed for modification.

## Project Structure
- `src/main/java/libraryManagementSystem`: Contains the main implementation classes, such as `Book`, `ElectronicBook`, `LibraryManager`, `Loan`, `Member`, and `PremiumMember`.
- `src/test/java/libraryTest`: Contains test classes for validating the system's functionality.

## Future Enhancements
- Implement a simple Command Line Interface (CLI) for user interaction.
- Add functionality to send notifications for overdue books.
- Integrate a database for persistent storage of books, members, and loans.
