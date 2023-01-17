#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Create Program details

Scenario Outline: Verify a Particular Program Id as a Response
    Given Call "baseurl" /saveprogram endpoint
    When  Post Program details from given sheetname "<SheetName>" and rownumber <RowNumber> and POST request is sent
    And The Created program details should be displayed in response 
    Then Status Code should be201 created

  Examples: 
      | SheetName     | RowNumber |
      | POST_PROGRAM  |         0 |
      | POST_PROGRAM  |         1 |
      | POST_PROGRAM  |         2 |
      | POST_PROGRAM  |         3 |
      | POST_PROGRAM  |         4 |