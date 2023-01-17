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
Feature: Update Program details by Id without header

Scenario Outline: Updating a Particular Program Id details without the header
    Given Call "baseurl" /putprogram/programId
    When  Update Program details from given sheetname "<SheetName>" and rownumber <RowNumber> and PUT request is sent
    Then Status Code should be415 unsupported media type
    And Validate  the updated programName

  Examples: 
      | SheetName      | RowNumber |
      | PUT_PROGRAMID  |         0 |
      | PUT_PROGRAMID  |         1 |
