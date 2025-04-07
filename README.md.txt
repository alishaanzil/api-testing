# API Testing Project using TestNG and RestAssured

## Project Overview
This project demonstrates API testing using RestAssured and TestNG. The focus is on:
- Implementing temporary test solutions
- Identifying and documenting technical debt
- Reducing complexity without refactoring

## Tools Used
- Java
- Maven
- TestNG
- RestAssured

## How to Run
1. Clone the repository.
2. Run `mvn test` or execute `testng.xml` from your IDE.

## Temporary Solutions
- `testGetUsers`: Only verifies the status code. Future improvement: Validate the full response payload.
- `testDeleteUser`: Basic status code check. Future plan: Validate user deletion by sending a GET after DELETE.

## Technical Debt & Improvements
-- Lack of proper error handling in POST/PUT requests.
- No schema validation or logging mechanism in place.
- Some endpoints may fail under load; retry logic is not implemented yet.

 Improvement Plan
- Add assertions for data validation.
- Introduce data-driven testing using DataProviders.
- Refactor code to separate test data from logic.

## Contributor
Alisha Anzil
