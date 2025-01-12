Youxel Automation Testing Project
Project Overview
This repository contains automation test cases for the search and filtering feature of the Noon e-commerce platform. The primary goal is to validate the search functionality with a price filter.

Features Tested
Search Functionality: Verifies the ability to search for products based on keywords.
Price Filter: Validates that products returned by the search fall within the specified price range.
Tools & Frameworks
Programming Language: Java
Automation Tool: Selenium WebDriver
Test Framework: TestNG
Build Tool: Maven
Version Control: Git
Test Cases Implemented
Search with Price Filter
Searches for "laptop" and applies a price filter.
Validates that the products' prices are within the specified range.
Getting Started
Prerequisites
Java Development Kit (JDK) 8 or higher.
Maven installed and configured.
Browser driver for Selenium (e.g., ChromeDriver).
Clone the repository:
bash
Copy code
git clone https://github.com/AbdullaMaghrabi/youxel_Automation.git
Running Tests
Navigate to the project directory:

bash
Copy code
cd youxel_Automation
Execute the tests using Maven:

bash
Copy code
mvn test
Project Structure
src/main/java: Page Object Model (POM) classes.
src/test/java: Test cases implemented using TestNG.
pom.xml: Maven configuration file for dependencies.
Contributing
Contributions are welcome! Please create a pull request with a detailed description of changes.

Contact
For any inquiries, reach out to Abdulla Maghrabi.
