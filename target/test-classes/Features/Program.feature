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


Feature: GETAll, GetSingleProgramId, POST, PUT and DELETE Request

@GetAllPrograms
  Scenario: Verify the list of Programs as a Response
    Given Call {baseurl}/allPrograms endpoint
    When GET request is sent
    Then Status Code should be200 OK
    And The Response should fetch all the programs which includes Program Id, Program Name, Program Description,Program Status,Creation Time and Last Modified Time.
    
