Feature: Employee CRUD

  Scenario: Create employee
    When I execute a request to create an employee
    Then should return that the employee has been successfully created
    And should return the created employee data

  Scenario: Get employees
    When I execute a request to search all employees
    Then should return the list of all employees successfully

  Scenario: Update employee
    Given I successfully created an employee
    When I execute a request to update this employee
    Then should return that the employee has been successfully updated
    And should return the updated employee data

  Scenario: Delete employee
    Given I successfully created an employee
    When I execute a request to remove this employee
    Then should return that the employee has been successfully deleted
