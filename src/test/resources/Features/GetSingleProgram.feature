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

Feature: GetSingleProgramId

 @GetSingleProgram
Scenario Outline: Verify a Particular Program Id as a Response
    Given Call "baseurl" /programs endpoint
    When  Program id from given sheetname "<SheetName>" and rownumber <RowNumber> and GET request is sent
    Then Status Code should be200 OK
    And The Response should fetch the detail of that Particular Program id. 

  Examples: 
      | SheetName     | RowNumber |
      | GET_PROGRAMID |         0 |
      | GET_PROGRAMID |         1 |
      | GET_PROGRAMID |         2 |